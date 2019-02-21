using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Practia.Bar.Model
{
    public class Factura
    {
        private static int contadorFacturas = 0;

        private DateTime _fecha;
        private int _numeroFactura;
        private int _montoTotal;
        private Mesa _mesa;
        private Cliente _cliente;
        private Mozo _mozo;

        public Factura(DateTime fecha, Cliente cliente, Mozo mozo, Mesa mesa, int total)
        {
            if (cliente == null || mozo == null || mesa == null)
                throw new Exception("La factura debe tener definido un cliente, un mozo y una mesa");
            this._fecha = fecha;
            this._cliente = cliente;
            this._mozo = mozo;
            this._mesa = mesa;
            this._montoTotal = total;

            contadorFacturas = contadorFacturas + 1;
            this._numeroFactura = contadorFacturas;

        }

        public Mesa Mesa
        {
            get
            {
                return this._mesa;
            }
        }

        public DateTime FechaFacturacion { get { return this._fecha; } }

        public double AnalizarEficiencia()
        {
            throw new NotImplementedException();
        }
    }
}
