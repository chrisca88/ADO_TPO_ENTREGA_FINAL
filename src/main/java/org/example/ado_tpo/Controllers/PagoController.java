package org.example.ado_tpo.Controllers;

import java.util.ArrayList;
import java.util.List;
import org.example.ado_tpo.Entities.*;
import org.example.ado_tpo.Enums.EstadoCuota;
import org.example.ado_tpo.Interfaces.MetodoDePago;
import org.springframework.stereotype.Controller;

@Controller
public class PagoController {
    private static PagoController instancia;
    private List<Pago> pagos;

    private PagoController() {
        pagos = new ArrayList<>();
    }

    public static PagoController getInstancia() {
        if (instancia == null) {
            instancia = new PagoController();
        }
        return instancia;
    }

    public void registrarPago(Cuota cuota, MetodoDePago metodoDePago) {
        Pago pago = new Pago(cuota, metodoDePago);
        pagos.add(pago);
        cuota.setEstadoCuota(EstadoCuota.PAGO);
        cuota.setFechaPago(new java.util.Date());
        metodoDePago.pagarCuota(cuota.getMonto());
    }

    public List<Pago> getPagos() {
        return pagos;
    }

}
