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


        /*
        public Mesa Reservar(int cubiertos, DateTime fecha, Cliente cliente)
        {
            Mesa mesaDisponible = _mesas.Find
                (mesa => mesa.Cubiertos == cubiertos &&
                         mesa.estaDisponible(fecha)
               );
            Reserva resultadoReserva = new Reserva(cliente, fecha);
            mesaDisponible.Reserva = resultadoReserva;
            _listaReservas.Add(resultadoReserva);
            return mesaDisponible;
        }*/

        public Reserva Reservar(int cubiertos, DateTime fecha, string nombreCliente, string dni)
        {
            if (existeMesaDisponible(cubiertos, fecha))
            {
                List<Mesa> mesasDeNCubiertos = MesasDeNCubiertos(cubiertos, _mesas);

                List<Mesa> mesasReservadasEnLaFecha = MesasReservadasEnUnaFecha(_reservas, fecha);
                List<Mesa> mesasDeNCubiertosReservadas = MesasDeNCubiertos(cubiertos, mesasReservadasEnLaFecha);

                Mesa mesaBuscada = mesasDeNCubiertos.Find(mesa => !mesasDeNCubiertosReservadas.Contains(mesa));

                Reserva reservaRealizada = new Reserva(nombreCliente, fecha, mesaBuscada);
                _reservas.Add(reservaRealizada);
                return reservaRealizada;
            }
            else
            {
                throw new System.Exception("No hay una mesa disponible con " + cubiertos.ToString() + " para esta fecha");
            }

        }

        public bool existeMesaDisponible(int cubiertos, DateTime fecha)
        {
            List<Mesa> mesasDeNCubiertos = MesasDeNCubiertos(cubiertos, _mesas);

            List<Mesa> mesasReservadasEnLaFecha = MesasReservadasEnUnaFecha(_reservas, fecha);
            List<Mesa> MesasDeNCubiertosReservadas = MesasDeNCubiertos(cubiertos, mesasReservadasEnLaFecha);

            return mesasDeNCubiertos.Count() > MesasDeNCubiertosReservadas.Count();
        }

        public void CancelarReserva(string nombreReserva, string dni, DateTime fecha)
        {
            throw new System.NotImplementedException();
        }

        public List<Mesa> MesasDeNCubiertos(int cantidadCubiertos, List<Mesa> Mesas)
        {
            return Mesas.FindAll(mesa => mesa.Cubiertos == cantidadCubiertos);
        }

        public List<Mesa> MesasReservadasEnUnaFecha(List<Reserva> reservas, DateTime fecha)
        {
            List<Reserva> reservasDeLaFecha = reservas.FindAll(reserva => reserva.FechaYHora == fecha);
            return reservasDeLaFecha.ConvertAll<Mesa>(reserva => reserva.Mesa);
        }

    }
}
