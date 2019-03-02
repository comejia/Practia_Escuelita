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

            // creo al bar
            this._bar = new Bar(mesas, mozos, "Bar El Progreso");

        }

        /// <summary>
        /// Creo 2 reservas de 4 cubiertos para el 2012 y una de 2 cubiertos para el 2013
        /// Verifico que se identifiquen 2 mesas con 4 cubiertos
        /// Verifico que se encuentre 1 reserva para el 2013
        /// Verifico que NO haya una mesa disponible con 4 cubiertos para la fecha 2012
        /// Agrego una mesa de 4 cubiertos
        /// Verifico que ahora si haya una mesa disponible para la reserva anterior con 4 cubiertos
        /// </summary>
        [TestMethod]
        public void Test_2_Mesas_Con_4_Cubiertos()
        {
            Mesa mesa_1_4Cubiertos = _bar.Mesas[0];
            Mesa mesa_2_4Cubiertos = _bar.Mesas[1];

            _bar._reservas.Add(new Reserva("pablito", new DateTime(2012), mesa_1_4Cubiertos));
            _bar._reservas.Add(new Reserva("german", new DateTime(2012), mesa_2_4Cubiertos));
            _bar._reservas.Add(new Reserva("german", new DateTime(2013), _bar.Mesas[2]));

            Assert.AreEqual(2, _bar.MesasDeNCubiertos(4, _bar.Mesas).Count);
            Assert.AreEqual(1, _bar.MesasReservadasEnUnaFecha(_bar._reservas, new DateTime(2013)).Count);
            Assert.IsFalse(_bar.existeMesaDisponible(4, new DateTime(2012)));

            _bar.Mesas.Add(new Mesa(4));
            Assert.IsTrue(_bar.existeMesaDisponible(4, new DateTime(2012)));
        }


        /// <summary>
        /// Como cliente del bar quiero poder reservar una mesa para 4 personas el viernes a las 20hs de forma existosa
        /// y por resultado obtener una reserva con los detalles de la misma 
        /// </summary>

        [TestMethod]
        public void Test_ReservarMesa_Viernes20hs_4personas_ReservaOK()
        {
            //                           (año, mes, dia, hora, minuto, segundo)
            DateTime fecha = new DateTime(2019, 03, 02, 20, 00, 00);
            int cubiertosSolicitados = 4;

            Reserva reservaRealizada = _bar.Reservar(cubiertosSolicitados, fecha, "pablito", "22333111");

            Reserva busquedaReserva = _bar._reservas.Find(reserva => reserva.NombreReserva == "pablito" &&
            reserva.FechaYHora == fecha && reserva.Mesa.Cubiertos == cubiertosSolicitados);
            Assert.AreEqual(busquedaReserva.Detalle(), reservaRealizada.Detalle());
        }

        /// <summary>
        /// Como cliente del bar quiero poder cancelar una reservar realizada previamente y reagendarla para 1 hora mas tarde 
        /// y 3 personas mas que las de la reserva original 
        /// </summary>
        [TestMethod]
        public void Test_ReAgendarReserva_OK()
        {
            Assert.Fail("Test no implementado");
            /*         Cliente pablito = new Cliente("Pablito", "Perez", "378123643");
                       DateTime fecha = new DateTime(2019, 03, 02, 20, 00, 00);
                       _bar.Reservar(4, fecha, pablito);
                       Reserva reservaVieja = new Reserva(pablito, fecha);
           */
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
            Assert.Fail("Test no implementado");
        }

        /// <summary>
        /// Como cliente del bar quiero poder ocupar una reserva que fue previamente reservada para 4 personas en un dia y hora especifico,
        /// cenar, pedir la cuenta y que me den la factura irme.
        /// </summary>
        [TestMethod]
        public void Test_OcuparMesaReservada_OK()
        {
            Assert.Fail("Test no implementado");
        }

        /// <summary>
        /// Como cliente del bar quiero poder ocupar una reserva con un amigo sin haber realizado previamente una reserva,
        /// tomar un cafe y luego de pedir la cuenta y que me den la factura irme.
        /// </summary>
        [TestMethod]
        public void Test_OcuparMesaSinReserva_OK()
        {
            Assert.Fail("Test no implementado");
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
            Assert.Fail("Test no implementado");
        }
    }
}
