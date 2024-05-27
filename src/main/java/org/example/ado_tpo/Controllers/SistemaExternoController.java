package org.example.ado_tpo.Controllers;

import org.springframework.stereotype.Controller;

@Controller
public class SistemaExternoController {
    private static SistemaExternoController instancia;

    private SistemaExternoController() {
        // Implementación del constructor
    }

    public static SistemaExternoController getInstancia() {
        if (instancia == null) {
            instancia = new SistemaExternoController();
        }
        return instancia;
    }

    public void importarDatos(String sistemaOrigen) {
        // Implementación del método para importar datos desde un sistema externo
    }

    public void exportarDatos(String sistemaDestino) {
        // Implementación del método para exportar datos hacia un sistema externo
    }
}
