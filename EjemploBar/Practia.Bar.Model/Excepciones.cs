using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practia.Bar.Model
{
    public class NoHayMesasDisponibles : System.Exception
    {
        public  NoHayMesasDisponibles(int cubiertos, DateTime fecha)
            :base(String.Format("No hay una mesa disponible con " + cubiertos.ToString() + " para la fecha " +
                                            fecha + "."))
        {
        }
    }
}
