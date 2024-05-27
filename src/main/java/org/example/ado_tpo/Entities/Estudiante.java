package org.example.ado_tpo.Entities;

import java.util.List;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String dni;
    private String legajo;
    private HistorialAcademico historialAcademico;

    public Estudiante(String nombre, String apellido, String dni, String legajo, HistorialAcademico historialAcademico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.legajo = legajo;
        this.historialAcademico = historialAcademico;
    }

    public Carrera getCarrera() {
        return null;
    }

    // Getters y setters

    public String getLegajo() {
        return legajo;
    }

    public HistorialAcademico getHistorialAcademico() {
        return historialAcademico;
    }

}

