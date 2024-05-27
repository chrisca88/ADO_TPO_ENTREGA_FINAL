package org.example.ado_tpo.Controllers;

import java.util.ArrayList;
import java.util.List;
import org.example.ado_tpo.Entities.*;
import org.example.ado_tpo.Enums.*;
import org.springframework.stereotype.Controller;

@Controller
public class EstudianteController {
    private static EstudianteController instancia;
    private List<Estudiante> estudiantes;

    private EstudianteController() {
        estudiantes = new ArrayList<>();
    }

    public static EstudianteController getInstancia() {
        if (instancia == null) {
            instancia = new EstudianteController();
        }
        return instancia;
    }

    public Estudiante nuevoEstudiante(String nombre, String apellido, String dni, String legajo, Carrera carrera) {
        Estudiante estudiante = new Estudiante(nombre, apellido, dni, legajo, new HistorialAcademico(null, new ArrayList<>(), Estado.POR_HACER, carrera));
        estudiantes.add(estudiante);
        return estudiante;
    }


    // Getters y setters para la lista de estudiantes
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public Estudiante getEstudianteByLegajo(String legajo){
        for(Estudiante e: estudiantes){
            try {
                if(e.getLegajo().equals(legajo)){
                    return e;
                }
            } catch (Exception ex) {
                throw new RuntimeException("Error al obtener el legajo "+legajo,ex);
            }
        }
        throw new IllegalArgumentException("Estudiante con legajo " + legajo + " no encontrado.");
    }

}
