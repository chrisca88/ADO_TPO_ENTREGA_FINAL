package org.example.ado_tpo.Entities;

import org.example.ado_tpo.Enums.Estado;

import java.util.List;

public class HistorialAcademico {
    private Estudiante estudiante;
    private List<Asignatura> asignaturas;
    private Estado estado;
    private Carrera carrera;

    public HistorialAcademico(Estudiante estudiante, List<Asignatura> asignaturas, Estado estado, Carrera carrera) {
        this.estudiante = estudiante;
        this.asignaturas = asignaturas;
        this.estado = estado;
        this.carrera = carrera;
    }

    // Getters y setters

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
