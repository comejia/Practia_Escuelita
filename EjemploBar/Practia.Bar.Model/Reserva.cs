using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Practia.Bar.Model
{
    public class Reserva
    {
        private DateTime _fechaYHora;

        public DateTime FechaYHora
        {
            get { return _fechaYHora; }
            set { _fechaYHora = value; }
        }
        private Cliente _cliente;

        public Cliente Cliente
        {
            get { return _cliente; }
            set { _cliente = value; }
        }

        public int NombreReserva
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
            }
        }
  
     
    }
}
