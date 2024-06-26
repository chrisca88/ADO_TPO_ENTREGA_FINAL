package org.example.ado_tpo.Controllers;

import org.example.ado_tpo.Entities.Asignatura;
import org.example.ado_tpo.Entities.Curso;
import org.example.ado_tpo.Entities.Materia;
import org.example.ado_tpo.Enums.Estado;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AsignaturaController {
    private static AsignaturaController instancia;
    private List<Asignatura> asignaturas;

    private AsignaturaController() {
        asignaturas = new ArrayList<>();
    }

    public static AsignaturaController getInstancia() {
        if (instancia == null) {
            instancia = new AsignaturaController();
        }
        return instancia;
    }

    public Asignatura crearAsignatura(Curso curso, Materia materia, Estado estado) {
        Asignatura asignatura = new Asignatura(curso, materia, estado, null);
        asignaturas.add(asignatura);
        return asignatura;
    }

}
