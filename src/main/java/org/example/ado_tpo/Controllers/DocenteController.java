package org.example.ado_tpo.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.example.ado_tpo.Entities.*;
import org.example.ado_tpo.Interfaces.Reporte;
import org.springframework.stereotype.Controller;


@Controller
public class DocenteController {
    private static DocenteController instancia;
    private List<Docente> docentes;

    private DocenteController() {
        docentes = new ArrayList<>();
    }

    public static DocenteController getInstancia() {
        if (instancia == null) {
            instancia = new DocenteController();
        }
        return instancia;
    }

    public Docente nuevoDocente(String nombre, String apellido, String dni, String legajo) {
        Docente docente = new Docente(nombre, apellido, dni, legajo);
        docentes.add(docente);
        return docente;
    }

    public Docente getDocenteByLegajo(String legajo){
        for(Docente d: docentes){
            try {
                if(d.getLegajo().equals(legajo)){
                    return d;
                }
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener el legajo "+legajo, e);
            }
        }
        throw new IllegalArgumentException("Docente con legajo " + legajo + " no encontrado.");
    }

    public void generarLiquidacion(String legajo) {
        Docente docente = getDocenteByLegajo(legajo);
        Reporte liquidacion = new Liquidacion();
        docente.generarReporte(legajo,liquidacion);

    }
}
