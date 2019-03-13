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
        private Mozo _mozo;
        private Decimal _montoActual;
        private int _cubiertosUtilizados;

        private const string MESA_DESCRIPTCION_TEMPLATE = "Mesa número ";

        // CONSTRUCTOR
        public Mesa(int cubiertos)
        {
            if (cubiertos < 10 && cubiertos > 0)
                _cubiertos = cubiertos;
            else
                throw new Exception("Cubiertos cannot be greater than 10 and less than 0!.");

            this._estadoMesa = EstadoMesa.Libre;

            contadorMesas = contadorMesas + 1;
            this._id = contadorMesas;
        }

        // GETTER AND SETTER
        public int Cubiertos
        {
            get { return _cubiertos; }
        }

        public EstadoMesa EstadoMesa
        {
            get { return _estadoMesa; }
            set { _estadoMesa = value; }
        }

        public int ID
        {
            get { return _id; }
        }

        public int CubiertosUtilizados
        {
            get { return _cubiertosUtilizados; }
            set { _cubiertosUtilizados = value; }
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
                if (this._mozo != null)
                    return this._mozo;
                else
                    //TODO: Es esta la forma mas piola de manejar al caso del mozo no asignado?
                    throw new NoHayMozoAsignado();
            }
            set
            {
                _mozo = value;
            }
        }

        public Decimal MontoActual
        {
            get { return _montoActual; }
            set { _montoActual = value; }
        }

        public void Ocupar()
        {
            EstadoMesa = EstadoMesa.Ocupado;
        }

        public void Cerrar()
        {
            EstadoMesa = EstadoMesa.PendienteFacturacion;
        }

        public void Liberar()
        {
            EstadoMesa = EstadoMesa.Libre;
            MozoAsignado = null;
            MontoActual = 0;
            CubiertosUtilizados = 0;
        }
        
    }
}
