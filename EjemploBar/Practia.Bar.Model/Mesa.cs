using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practia.Bar.Model
{
    public class Mesa
    {
        private static int contadorMesas = 0;

        private int _cubiertos;
        private int _id;
        private EstadoMesa _estadoMesa;
        private Reserva _reserva;
        private Mozo _mozo;

        private const string MESA_DESCRIPTCION_TEMPLATE = "Mesa número ";

        public Mesa(int cubiertos)
        {
            if (cubiertos < 10 && cubiertos > 0)
                _cubiertos = cubiertos;
            else
                throw new Exception("Cubiertos cannot be greater than 10 and less than 0!.");

            this._estadoMesa = EstadoMesa.Libre;

            contadorMesas=contadorMesas+1;
            this._id = contadorMesas;
        }

        public Reserva Reserva
        {
            get { return _reserva; }
        }

        public int Cubiertos
        {
            get 
            {
                return _cubiertos;
            }
        }

        public string Descripcion
        { 
            get
            {
                return MESA_DESCRIPTCION_TEMPLATE + this._id.ToString();
            }
        }

        public Mozo MozoAsignado
        {
            get
            {
                if(this._mozo != null)
                    return this._mozo;
                else
                    //TODO: Es esta la forma mas piola de manejar al caso del mozo no asignado?
                    throw new System.Exception("Esta mesa no tiene un mozo asignado");
            }
        }

        public Decimal Cerrar()
        {
            throw new System.NotImplementedException();
        }

        public void Ocupar()
        {
            throw new System.NotImplementedException();
        }
    }
}
