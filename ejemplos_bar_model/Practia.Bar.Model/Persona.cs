using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practia.Bar.Model
{
    public abstract class Persona
    {
        protected string _nombre;
        protected string _apellido;
        protected string _dni;

        public Persona(string nombre, string apellido, string dni)
        {
            if (!String.IsNullOrEmpty(nombre))
                this._nombre = nombre;
            else
                throw new Exception("Una persona sin nombre no es una persona...");

            if (!String.IsNullOrEmpty(apellido))
                this._apellido = apellido;
            else
                throw new Exception("Una persona sin apellido dificilmente sea una persona...");

            if (!String.IsNullOrEmpty(dni))
                this._dni = dni;
            else
                throw new Exception("Una persona sin dni, en argentina... no existe...");

        }

        public abstract string GetDescripcion();

        public string Nombre
        {
            get { return _nombre; }
            set { _nombre = value; }
        }

        public string Apellido
        {
            get { return _apellido; }
            set { _apellido = value; }
        }

        public string DNI
        {
            get { return _dni; }
            set { _dni = value; }
        }

        public bool EstaVivo()
        {
            return true;
        }
    }
}
