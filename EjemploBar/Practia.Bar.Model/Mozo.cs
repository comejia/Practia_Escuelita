using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Practia.Bar.Model
{
    public class Mozo : Persona
    {

        public Mozo(string nombre, string apellido, string dni):base(nombre, apellido, dni)
        {
        }

        public override string GetDescripcion()
        {
            return "Mozo: " + this._nombre + " " + this._apellido;
        }
    }
}
