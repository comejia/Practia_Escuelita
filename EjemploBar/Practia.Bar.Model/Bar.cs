using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Practia.Bar.Model
{
    public class Bar
    {
        private List<Factura> _facturas;
        private List<Mesa> _mesas;
        private List<Mozo> _mozos;
        private string _nombreBar;
        public List<Reserva> _reservas;

        public Bar(List<Mesa> mesas, List<Mozo> mozos, string nombreDelBar)
        {
            this._facturas = new List<Factura> { };
            this._reservas = new List<Reserva> { };
            if (mesas != null && mesas.Count > 0)
                this._mesas = mesas;
            else
                throw new NoHayMesas();

            if (mozos != null && mozos.Count > 0)
                this._mozos = mozos;
            else
                throw new NoHayMozos();
            if (!String.IsNullOrEmpty(nombreDelBar))
                this._nombreBar = nombreDelBar;
            else
                throw new NoTieneNombre();
        }
                    

        public override string ToString()
        {
            return "Bar " + this._nombreBar;
        }

        public List<Mesa> Mesas
        {
            get { return _mesas; }
        }

        public List<Mozo> Mozos
        {
            get { return _mozos; }
        }
        public List<Factura> Facturas
        {
            get { return _facturas; }
        }


        public Reserva Reservar(int cubiertos, DateTime fecha, Cliente cliente)
        {
            Mesa mesaBuscada = ConseguirMesaDisponible(cubiertos, fecha);

            if (ExisteMesaDisponible(cubiertos,fecha))
            {
                Reserva reservaRealizada = new Reserva(cliente, fecha, mesaBuscada);
                mesaBuscada.CubiertosUtilizados = cubiertos;
                _reservas.Add(reservaRealizada);

                return reservaRealizada;
            }
            else
                throw new NoHayMesasDisponibles(cubiertos, fecha);
        }

        public Mesa ConseguirMesaDisponible(int cubiertos, DateTime fecha)
        {
            List<Mesa> mesasDeNCubiertos = MesasDeMinNCubiertos(cubiertos, _mesas);

            List<Mesa> mesasReservadasEnLaFecha = MesasReservadasEnUnaFecha(_reservas, fecha);
            List<Mesa> mesasDeNCubiertosReservadas = MesasDeMinNCubiertos(cubiertos, mesasReservadasEnLaFecha);

            return mesasDeNCubiertos.Find(mesa => !mesasDeNCubiertosReservadas.Contains(mesa));
        }

        public bool ExisteMesaDisponible(int cubiertos, DateTime fecha)
        {
            List<Mesa> mesasDeNCubiertos = MesasDeMinNCubiertos(cubiertos, _mesas);

            List<Mesa> mesasReservadasEnLaFecha = MesasReservadasEnUnaFecha(_reservas, fecha);
            List<Mesa> MesasDeNCubiertosReservadas = MesasDeMinNCubiertos(cubiertos, mesasReservadasEnLaFecha);

            return mesasDeNCubiertos.Count() > MesasDeNCubiertosReservadas.Count();
        }

        public void CancelarReserva(string nombreReserva, string dni, DateTime fecha)
        {
            throw new System.NotImplementedException();
        }

        public List<Mesa> MesasDeMinNCubiertos(int cantidadCubiertos, List<Mesa> Mesas)
        {
            return Mesas.FindAll(mesa => mesa.Cubiertos >= cantidadCubiertos);
        }

        public List<Mesa> MesasReservadasEnUnaFecha(List<Reserva> reservas, DateTime fecha)
        {
            List<Reserva> reservasDeLaFecha = reservas.FindAll(reserva => reserva.FechaYHora == fecha);
            return reservasDeLaFecha.ConvertAll<Mesa>(reserva => reserva.Mesa);
        }

        public Reserva BuscarReserva(Cliente cliente, DateTime fecha)
        {
            return _reservas.Find(reserva => reserva.Cliente == cliente && reserva.FechaYHora == fecha);
        }

        public Reserva ModificarReserva(Reserva reserva, DateTime nuevaFecha, int nuevosCubiertos)
        {
            Mesa mesaNueva = ConseguirMesaDisponible(nuevosCubiertos, nuevaFecha);
            mesaNueva.CubiertosUtilizados = nuevosCubiertos;
            reserva.modificarMesaYFecha(mesaNueva, nuevaFecha);

            return reserva;
        }

        // Ocupar - Cerrar - Facturar Mesa
        public Mesa OcuparMesa(Mesa mesa)
        {
            Mesa mesaBuscada = _mesas.Find(m => m == mesa);
            mesaBuscada.Ocupar();
            mesaBuscada.MozoAsignado = Mozos[0];
            return mesaBuscada;
        }

        public Mesa CerrarMesa(Mesa mesa)
        {
            Factura facturaGenerada = new Factura(DateTime.Now, mesa.MozoAsignado, mesa, mesa.MontoActual);
            _facturas.Add(facturaGenerada);
            mesa.EstadoMesa = EstadoMesa.PendienteFacturacion;
            return mesa;
        }

        public Mesa FacturarMesa(Mesa mesa)
        {
            mesa.Liberar();
            return mesa;
        }

        public Mesa OcuparReserva (Reserva reserva)
        {
            return OcuparMesa(reserva.Mesa);
        }

        // Eficiciencias

        public Double ObtenerEficienciaListaFacturas(List<Factura> facturas)
        {
            List<Double> eficicienciaHistorica = Facturas.ConvertAll<Double>(factura => factura.AnalizarEficiencia());
            Double res = 0;
            eficicienciaHistorica.ForEach(eficiciencia => res += eficiciencia);

            return res / eficicienciaHistorica.Count;
        }

        public Double ObtenerEficicienciaEnDia(DateTime fecha)
        {
            List<Factura> facturasDia = Facturas.FindAll(factura => factura.FechaFacturacion == new DateTime(2012));
            return ObtenerEficienciaListaFacturas(facturasDia);
        }

        public Double ObtenerEficicienciaHistorica()
        {
            return (ObtenerEficienciaListaFacturas(_facturas));
        }
    }
}
