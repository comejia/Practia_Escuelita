using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Practia.Bar;
using System.Collections.Generic;

namespace Practia.Bar.Model.Tests
{
    [TestClass]
    public class CasosUsoTests
    {

        private Bar _bar;
        private Cliente pablo;
        private Cliente german;
        private DateTime fechaReserva;

        [TestInitialize]
        public void InitializeTestsContext()
        {
            // creo a las mesas del bar
            List<Mesa> mesas = new List<Mesa>();
            mesas.Add(new Mesa(4));
            mesas.Add(new Mesa(4));
            mesas.Add(new Mesa(2));
            mesas.Add(new Mesa(8));
            mesas.Add(new Mesa(3));
            mesas.Add(new Mesa(2));
            mesas.Add(new Mesa(5));

            // creo a los mosos del bar
            List<Mozo> mozos = new List<Mozo>();
            mozos.Add(new Mozo("Guille", "Filia", "26721601"));
            mozos.Add(new Mozo("Ale", "Fraenkel", "28985070"));

            // creo cliente
            pablo = new Cliente("Pablo", "Romeo", "22333111");
            german = new Cliente("German", "Pereyra", "44222111");

            // creo fecha
            fechaReserva = new DateTime(2019, 03, 01, 20, 00, 00);

            // creo al bar
            this._bar = new Bar(mesas, mozos, "Bar El Progreso");

        }

        /// <summary>
        /// Creo 2 reservas de 4 cubiertos para el 2012 y una de 2 cubiertos para el 2013
        /// Verifico que se identifiquen 4 mesas con 4 cubiertos
        /// Verifico que se encuentre 1 reserva para el 2013
        /// Verifico que NO haya una mesa disponible con 9 cubiertos para la fecha 2012
        /// Agrego una mesa de 4 cubiertos
        /// Verifico que ahora si haya una mesa disponible para la reserva anterior con 4 cubiertos
        /// </summary>
        [TestMethod]
        public void Test_2_Mesas_Con_4_Cubiertos()
        {
            _bar._reservas.Add(new Reserva(pablo, new DateTime(2012), _bar.Mesas[0]));
            _bar._reservas.Add(new Reserva(german, new DateTime(2012), _bar.Mesas[1]));
            _bar._reservas.Add(new Reserva(german, new DateTime(2013), _bar.Mesas[2]));

            Assert.AreEqual(4, _bar.MesasDeMinNCubiertos(4, _bar.Mesas).Count);
            Assert.AreEqual(1, _bar.MesasReservadasEnUnaFecha(_bar._reservas, new DateTime(2013)).Count);
            Assert.IsFalse(_bar.ExisteMesaDisponible(9, new DateTime(2012)));
            
            _bar.Mesas.Add(new Mesa(9));
            Assert.IsTrue(_bar.ExisteMesaDisponible(9, new DateTime(2012)));
        }


        //Probar que tire error al tratar de reservar una mesa con 9 cubiertos, al no haber ninguna mesa con esa cantidad
        //Probar que tirre error al tratar de reservar una mesa con 5 cubiertos para la fecha 01/03/19 (fechaReserva)
        [TestMethod]
        [ExpectedException(typeof(NoHayMesasDisponibles))]
        public void Test_Error_No_Hay_Mesa_Disponible()
        {
            _bar.Reservar(9, new DateTime(2012),pablo);

            _bar._reservas.Add(new Reserva(pablo, fechaReserva, _bar.Mesas[3]));
            _bar._reservas.Add(new Reserva(german, fechaReserva, _bar.Mesas[6]));

            _bar.Reservar(5, new DateTime(2012), pablo);
        }

        /// <summary>
        /// Como cliente del bar quiero poder reservar una mesa para 4 personas el viernes a las 20hs de forma existosa
        /// y por resultado obtener una reserva con los detalles de la misma 
        /// </summary>

        [TestMethod]
        public void Test_ReservarMesa_Viernes20hs_4personas_ReservaOK()
        {
            DateTime fecha = new DateTime(2019, 03, 02, 20, 00, 00);
            int cubiertosSolicitados = 4;
            
            Reserva reservaRealizada = _bar.Reservar(cubiertosSolicitados, fecha, pablo);
            Reserva busquedaReserva = _bar.BuscarReserva(pablo, fecha);

            Assert.AreEqual(busquedaReserva.Detalle(), reservaRealizada.Detalle());
        }

        /// <summary>
        /// Como cliente del bar quiero poder cancelar una reservar realizada previamente y reagendarla para 1 hora mas tarde 
        /// y 3 personas mas que las de la reserva original 
        /// </summary>
        [TestMethod]
        public void Test_ReAgendarReserva_OK()
        {
            DateTime fecha = new DateTime(2019, 03, 02, 20, 00, 00);

            Reserva reservaRealizada = _bar.Reservar(2, fecha, pablo);
            Reserva reservaACambiar = _bar.BuscarReserva(pablo, fecha);

            _bar.ModificarReserva(reservaACambiar, reservaACambiar.FechaYHora.AddHours(1), reservaACambiar.Mesa.CubiertosUtilizados + 3);

            Assert.AreEqual(5, reservaACambiar.Mesa.CubiertosUtilizados);
            Assert.AreEqual(fecha.AddHours(1), reservaACambiar.FechaYHora);
        }
        /// <summary>
        /// Como cliente del bar quiero pedirle a un mozo que cierre mi mesa, que el mozo pida el cierre de la mesa al bar y 
        /// que luego de facturarme la mesa que el mozo cierre mi mesa.
        /// Repasar requerimiento de tener la historia de facturas para luego poder analizar eficiencia de los mozos para asignar 
        /// mesas
        /// </summary>
        [TestMethod]
        public void Test_CierreDeMesa_yFacturacion_OK()
        {
            _bar.Mesas[0].MozoAsignado = _bar.Mozos[0];
            Mesa mesaCerrada = _bar.CerrarMesa(_bar.Mesas[0]);
            Assert.AreEqual(EstadoMesa.PendienteFacturacion, mesaCerrada.EstadoMesa);

            Mesa mesaLiberada = _bar.FacturarMesa(mesaCerrada);
            Assert.AreEqual(EstadoMesa.Libre, mesaLiberada.EstadoMesa);
        }

        /// <summary>
        /// Como cliente del bar quiero poder ocupar una reserva que fue previamente reservada para 4 personas en un dia y hora especifico,
        /// cenar, pedir la cuenta y que me den la factura irme.
        /// </summary>
        [TestMethod]
        public void Test_OcuparMesaReservada_OK()
        {
            DateTime fecha = new DateTime(2019, 03, 02, 20, 00, 00);
            _bar.Reservar(2, fecha, pablo);

            Mesa mesaReservada = _bar.OcuparReserva(_bar.BuscarReserva(pablo, fecha));
            Assert.AreEqual(EstadoMesa.Ocupado, mesaReservada.EstadoMesa);

            _bar.FacturarMesa(mesaReservada);
            Assert.AreEqual(EstadoMesa.Libre, mesaReservada.EstadoMesa);
        }

        /// <summary>
        /// Como cliente del bar quiero poder ocupar una reserva con un amigo sin haber realizado previamente una reserva,
        /// tomar un cafe y luego de pedir la cuenta y que me den la factura irme.
        /// </summary>
        [TestMethod]
        public void Test_OcuparMesaSinReserva_OK()
        {
            Mesa mesaSolicitada = _bar.ConseguirMesaDisponible(2, DateTime.Now);
            _bar.OcuparMesa(mesaSolicitada);

            Assert.AreEqual(EstadoMesa.Ocupado, mesaSolicitada.EstadoMesa);

            _bar.FacturarMesa(mesaSolicitada);
            
            Assert.AreEqual(EstadoMesa.Libre, mesaSolicitada.EstadoMesa);

        }

        /// <summary>
        /// Como administrador del bar quiero poder analizar la eficiencia en la asignacion de mesas en un dia especifico
        /// por medio de una metrica que compare la cantidad de mesas asignadas completando el total de cubiertos de esa 
        /// mesa sobre la cantidad total de mesas que se facturaron ese dia
        /// eficiencia_diaria = mesas_asignadas_eficientemente_diaX / total_mesas_facturadas_diaX
        /// Sera necesario simular la atencion y cierre de varias mesas en un mismo dia para poder desarrollar el caso
        /// </summary>
        [TestMethod]
        public void Test_AnalizarEficienciaUsoSalon_DiaEspecifico()
        {
            DateTime fechaTest = new DateTime(2012);
            Mozo mozoTest = _bar.Mozos[0];
            Mesa mesaTest1 = _bar.Mesas[0];
            mesaTest1.CubiertosUtilizados = 4;
            Mesa mesaTest2 = _bar.Mesas[1];
            mesaTest2.CubiertosUtilizados = 3;
            Mesa mesaTest3 = _bar.Mesas[2];
            mesaTest3.CubiertosUtilizados = 2;
            _bar.Facturas.Add(new Factura(fechaTest, mozoTest, mesaTest1, 10));
            _bar.Facturas.Add(new Factura(fechaTest, mozoTest, mesaTest2, 10));
            _bar.Facturas.Add(new Factura(fechaTest, mozoTest, mesaTest3, 10));

            double eficienciaDia = _bar.ObtenerEficicienciaEnDia(fechaTest);
            Assert.AreEqual(2.75 / 3, eficienciaDia);
        }
    }
}
