using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Practia.Bar.Model
{
    public class Bar
    {
        private List<Factura> _facturas;
        private List<Mesa> _mesas;
        private List<Mozo> _mozos;
        private string _nombreBar;

        public Bar (List<Mesa> mesas, List<Mozo> mozos, string nombreDelBar)
        {
            if (mesas != null && mesas.Count > 0)
                this._mesas = mesas;
            else
                throw new System.Exception("Al menos debe existir una mesa en la lista de mesas para poder crear al bar, un bar sin mesas no es un bar...");

            if (mozos != null && mozos.Count > 0)
                this._mozos = mozos;
            else
                throw new System.Exception("Al menos debe existir un mozo en la lista de mozos para poder crear al bar, un bar sin mosos dudo que funcione...");

            if(!String.IsNullOrEmpty(nombreDelBar))
                this._nombreBar = nombreDelBar;
            else
                throw new System.Exception("Pensas que un bar sin nombre va a tener exito? Deberias definir un nombre para tu bar...");
        }

        public override string ToString()
        {
            return "Bar " + this._nombreBar;
        }

        public Reserva Reservar(int cubiertos, DateTime fecha, string nombreReserva, string dni)
        {
            throw new System.NotImplementedException();
        }

        public void CancelarReserva(string nombreReserva, string dni, DateTime fecha)
        {
            throw new System.NotImplementedException();
        }


    }
}
