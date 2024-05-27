package org.example.ado_tpo.Entities;



import org.example.ado_tpo.Enums.EstadoCuota;

import java.util.Date;

public class Cuota {
    private int numero;
    private Float monto;
    private EstadoCuota estadoCuota;
    private Date fechaEmision;
    private Date fechaPago;

    public Cuota() {
    }

    public Cuota(int numero, Float monto, EstadoCuota estadoCuota, Date fechaEmision, Date fechaPago) {
        this.numero = numero;
        this.monto = monto;
        this.estadoCuota = estadoCuota;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public EstadoCuota getEstadoCuota() {
        return estadoCuota;
    }

    public void setEstadoCuota(EstadoCuota estadoCuota) {
        this.estadoCuota = estadoCuota;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
