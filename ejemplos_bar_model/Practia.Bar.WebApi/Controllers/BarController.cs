using Practia.Bar.WebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Practia.Bar.WebApi.Controllers
{
    public class BarController : ApiController
    {
        List<Mesa> mesaAPI = new List<Mesa> {
                new Mesa { id = 1, Nombre = "Mesa 1" },
                new Mesa { id = 2, Nombre = "Mesa 2" } ,
                new Mesa { id = 4, Nombre = "Mesa 3" },
            };

        // GET: api/Bar
        public IEnumerable<Mesa> Get()
        {
            List <Mesa> mesaAPI = new List < Mesa > {
                new Mesa { id = 1, Nombre = "Mesa 1" },
                new Mesa { id = 2, Nombre = "Mesa 2" } ,
                new Mesa { id = 4, Nombre = "Mesa 3" },
            };
            return mesaAPI;
        }

        // GET: api/Bar/5
        public Mesa Get(int id)
        {
            List<Mesa> mesaAPI = new List<Mesa> {
                new Mesa { id = 1, Nombre = "Mesa 1" },
                new Mesa { id = 2, Nombre = "Mesa 2" } ,
                new Mesa { id = 4, Nombre = "Mesa 3" },
            };

            return mesaAPI[1];
         }
        // POST: api/Bar
        public List<Mesa> Post([FromBody]Mesa value)
        {
            
            mesaAPI.Add(value);
            var mesaModelo = new Practia.Bar.Model.Mesa(4);
            //mesaModelo.Descripcion = value.Nombre;


            return mesaAPI;
        }

        // PUT: api/Bar/5
        public string Put(int id, [FromBody]Mesa value)
        {
            return value.Nombre;
        }

        // DELETE: api/Bar/5
        public void Delete(int id)
        {
        }
    }
}
