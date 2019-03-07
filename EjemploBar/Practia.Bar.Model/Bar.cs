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
        public List<Reserva> _reservas = new List<Reserva> { };

        public Bar(List<Mesa> mesas, List<Mozo> mozos, string nombreDelBar)
        {
            this._facturas = new List<Factura> { };
            if (mesas != null && mesas.Count > 0)
                this._mesas = mesas;
            else
                throw new System.Exception("Al menos debe existir una mesa en la lista de mesas para poder crear al bar, un bar sin mesas no es un bar...");

            if (mozos != null && mozos.Count > 0)
                this._mozos = mozos;
            else
                throw new System.Exception("Al menos debe existir un mozo en la lista de mozos para poder crear al bar, un bar sin mosos dudo que funcione...");

            if (!String.IsNullOrEmpty(nombreDelBar))
                this._nombreBar = nombreDelBar;
            else
                throw new System.Exception("Pensas que un bar sin nombre va a tener exito? Deberias definir un nombre para tu bar...");
        }

        public override string ToString()
        {
            return "Bar " + this._nombreBar;
        }

        public List<Mesa> Mesas
        {
            get { return _mesas; }
        }

        public List<Mozo> Mozo
        {
            get { return _mozos; }
        }
        public List<Factura> Facturas
        {
            get { return _facturas; }
        }


        public Reserva Reservar(int cubiertos, DateTime fecha, string nombreCliente, string dni)
        {
            Mesa mesaBuscada = ConseguirMesaDisponible(cubiertos, fecha);

            if (!mesaBuscada.Equals(null))
            {
                Reserva reservaRealizada = new Reserva(nombreCliente, fecha, mesaBuscada);
                mesaBuscada.CubiertosUtilizados = cubiertos;
                _reservas.Add(reservaRealizada);

                return reservaRealizada;
            }
            else
            {
                throw new System.Exception("No hay una mesa disponible con " + cubiertos.ToString() + " para la fecha " +
                                            fecha + ".");
            }

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

        public Reserva BuscarReserva(string nombreReserva, DateTime fecha)
        {
            return _reservas.Find(reserva => reserva.NombreReserva == nombreReserva &&
                                             reserva.FechaYHora == fecha);
        }

        public Factura GenerarFactura(Mesa mesa)
        {
            Factura facturaGenerada = new Factura(new DateTime().Date, mesa.MozoAsignado, mesa, mesa.MontoActual);
            _facturas.Add(facturaGenerada);
            mesa.EstadoMesa = EstadoMesa.Libre;
            return facturaGenerada;
        }

        public Mesa OcuparReserva (Mesa mesa)
        {
            Mesa mesaBuscada = _mesas.Find(m => m == mesa);
            mesaBuscada.Ocupar();
            return mesaBuscada;

        }

        public Reserva ModificarReserva(Reserva reserva, DateTime nuevaFecha, int nuevosCubiertos)
        {
            Mesa mesaNueva = ConseguirMesaDisponible(nuevosCubiertos, nuevaFecha);
            mesaNueva.CubiertosUtilizados = nuevosCubiertos;
            reserva.modificarMesaYFecha(mesaNueva, nuevaFecha);
            
            return reserva;
        }

    }
}
