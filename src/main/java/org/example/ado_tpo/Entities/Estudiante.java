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


    public int verCargaHoraria() {
        return 0;
    }

    public Carrera getCarrera() {
        return null;
    }

    public List<Materia> getMateriasAprobadas() {
        return null;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public HistorialAcademico getHistorialAcademico() {
        return historialAcademico;
    }

    public void setHistorialAcademico(HistorialAcademico historialAcademico) {
        this.historialAcademico = historialAcademico;
    }
}

