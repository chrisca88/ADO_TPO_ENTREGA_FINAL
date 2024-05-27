package org.example.ado_tpo.Entities;


import org.example.ado_tpo.Interfaces.MetodoDePago;

public class Pago {
    private Cuota cuota;
    private MetodoDePago metodoDePago;

    public Pago() {
    }

    public Pago(Cuota cuota, MetodoDePago metodoDePago) {
        this.cuota = cuota;
        this.metodoDePago = metodoDePago;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

}
