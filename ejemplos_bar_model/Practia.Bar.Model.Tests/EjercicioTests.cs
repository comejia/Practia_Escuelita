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
        public void Test_AnalizarEficienciaUsoSalon_Historica()
        {
            Mozo mozoTest = _bar.Mozos[0];
            Mesa mesaTest1 = _bar.Mesas[0];
            mesaTest1.CubiertosUtilizados = 4;
            Mesa mesaTest2 = _bar.Mesas[1];
            mesaTest2.CubiertosUtilizados = 3;
            Mesa mesaTest3 = _bar.Mesas[2];
            mesaTest3.CubiertosUtilizados = 2;
            _bar.Facturas.Add(new Factura(new DateTime(2016), mozoTest, mesaTest1, 10));
            _bar.Facturas.Add(new Factura(new DateTime(2012), mozoTest, mesaTest2, 10));
            _bar.Facturas.Add(new Factura(new DateTime(2013), mozoTest, mesaTest3, 10));

            Assert.AreEqual(2.75/3, _bar.ObtenerEficicienciaHistorica());
        }

    }
}
