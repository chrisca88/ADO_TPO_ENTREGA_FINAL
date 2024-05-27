package org.example.ado_tpo.Entities;

import org.example.ado_tpo.Interfaces.MetodoDePago;

public class PagoMisCuentas implements MetodoDePago{

    public void pagarCuota(double monto){
        System.out.println("Procesando pago con Pago mis cuentas: $" + monto);
    }
}
