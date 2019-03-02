using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Practia.Bar;
using System.Collections.Generic;

namespace Practia.Bar.Model.Tests
{
    [TestClass]
    public class EjercicioTests
    {

        private Bar _bar;

        [TestInitialize]
        public void InitializeTestsContext()
        {
            // creo a las mesas del bar
            List<Mesa> mesas = new List<Mesa>();
            mesas.Add(new Mesa(4));
            mesas.Add(new Mesa(4));
            mesas.Add(new Mesa(2));

            // creo a los mosos del bar
            List<Mozo> mozos = new List<Mozo>();
            mozos.Add(new Mozo("Guille", "Filia", "26721601"));
            mozos.Add(new Mozo("Ale", "Fraenkel", "28985070"));

            // creo al bar
            this._bar = new Bar(mesas, mozos, "Bar El Progreso");

        }


        [TestMethod]
        public void Test_AnalizarEficienciaUsoSalon_DiaEspecifico()
        {
            Assert.Fail("Test no implementado");
        }

        [TestMethod]
        public void Test_AnalizarEficienciaUsoSalon_Historica()
        {
            Assert.Fail("Test no implementado");
        }

    }
}
