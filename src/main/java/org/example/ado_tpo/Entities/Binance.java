package org.example.ado_tpo.Entities;


import org.example.ado_tpo.Interfaces.MetodoDePago;

public class Binance implements MetodoDePago {
    public void pagarCuota(double monto){
        System.out.println("Procesando pago con Binance: $" + monto);
    }
}
