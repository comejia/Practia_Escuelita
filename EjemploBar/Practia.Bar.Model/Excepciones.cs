using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practia.Bar.Model
{
    public class NoHayMesasDisponibles : System.Exception
    {
        public NoHayMesasDisponibles(int cubiertos, DateTime fecha)
            : base(String.Format("No hay una mesa disponible con " + cubiertos.ToString() + " para la fecha " +
                                            fecha + "."))
        {
        }
    }
    public class NoHayMesas : System.Exception
    {
        public NoHayMesas()
            : base(String.Format("Al menos debe existir una mesa en la lista de mesas para poder crear al bar, un bar sin mesas no es un bar..."))
        {
        }
    }

    public class NoHayMozos : System.Exception
    {
        public NoHayMozos()
            : base(String.Format("Al menos debe existir un mozo en la lista de mozos para poder crear al bar, un bar sin mosos dudo que funcione..."))
        {
        }
    }

    public class NoTieneNombre : System.Exception
    {
        public NoTieneNombre()
            : base(String.Format("Pensas que un bar sin nombre va a tener exito? Deberias definir un nombre para tu bar..."))
        {
        }

    }

    public class NoHayMozoAsignado : System.Exception
    {
        public NoHayMozoAsignado()
        : base(String.Format("Esta mesa no tiene un mozo asignado"))
        {
        }
    }
        
}
