using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Practia.Bar.Model
{
    public class Reserva
    {
        private DateTime _fechaYHora;
        private Cliente _cliente;
        private string _nombreReserva;
        private Mesa _mesa;
        
        // CONSTRUCTORES
        
        public Reserva(Cliente cliente, DateTime fecha, Mesa mesa)
        {
            Cliente = cliente;
            FechaYHora = fecha;
            Mesa = mesa;
        }

        // GETTERS AND SETTERS
        public DateTime FechaYHora
        {
            get { return _fechaYHora; }
            set { _fechaYHora = value; }
        }

        public Cliente Cliente
        {
            get { return _cliente; }
            set { _cliente = value; }
        }

        public string NombreReserva
        {
            get { return _nombreReserva; }
            set { _nombreReserva = value; }
        }

        public Mesa Mesa
        {
            get { return _mesa; }
            set { _mesa = value; }
        }

        public string Detalle()
        {
            return "Reserva a nombre de " + this.NombreReserva + " para la fecha de " + this.FechaYHora;
        }
        public void modificarMesaYFecha(Mesa mesa, DateTime fecha)
        {
            Mesa = mesa;
            FechaYHora = fecha;
        }

    }
}
