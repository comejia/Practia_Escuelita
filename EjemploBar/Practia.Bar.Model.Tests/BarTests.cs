using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Practia.Bar.Model.Tests
{
    [TestClass]
    public class BarTests
    {
        [TestMethod]
        public void Test_CrearBar_Ok()
        {
            List<Mesa> mesas = new List<Mesa>();
            mesas.Add(new Mesa(4));
 
            List<Mozo> mozos = new List<Mozo>();
            mozos.Add(new Mozo("Guille", "Filia", "26721601"));

            Bar bar = new Bar(mesas, mozos, "El Progreso");

            Assert.IsNotNull(bar);
            Assert.AreEqual("Bar El Progreso", bar.ToString());
        }

        [TestMethod]
        [ExpectedException(typeof(System.Exception))]
        public void Test_CrearBar_NoOK_sinMozos()
        {
            List<Mesa> mesas = new List<Mesa>();
            mesas.Add(new Mesa(4));

            List<Mozo> mozos = new List<Mozo>();

            Bar bar = new Bar(mesas, mozos, "El Progreso");
        }

        [TestMethod]
        [ExpectedException(typeof(System.Exception))]
        public void Test_CrearBar_NoOK_sinMesas()
        {
            List<Mesa> mesas = new List<Mesa>();

            List<Mozo> mozos = new List<Mozo>();
            mozos.Add(new Mozo("Guille", "Filia", "26721601"));

            Bar bar = new Bar(mesas, mozos, "El Progreso");
        }

        [TestMethod]
        [ExpectedException(typeof(System.Exception))]
        public void Test_CrearBar_NoOK_sinNombre()
        {
            List<Mesa> mesas = new List<Mesa>();
            mesas.Add(new Mesa(4));

            List<Mozo> mozos = new List<Mozo>();
            mozos.Add(new Mozo("Guille", "Filia", "26721601"));

            Bar bar = new Bar(mesas, mozos, "");
        }

        [TestMethod]
        public void Test_ContadorMesasIncrementa()
        {
            Mesa mesa = new Mesa(1);
            int mesaId = Int32.Parse(mesa.Descripcion.Split(new char[]{' '})[2]);

            mesa = new Mesa(2);
            Assert.AreEqual("Mesa número " + (mesaId+1), mesa.Descripcion);

        }

    }
}
