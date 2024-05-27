package org.example.ado_tpo.Entities;

import org.example.ado_tpo.Enums.Turno;
import org.example.ado_tpo.Interfaces.Reporte;

import java.util.ArrayList;
import java.util.List;

public class Docente {

    private String nombre;
    private String apellido;
    private String dni;
    private String legajo;
    private List<Curso> cursosAsignados;
    private List<Disponibilidad> disponibilidad;

    public Docente() {
    }

    public Docente(String nombre, String apellido, String dni, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.legajo = legajo;
        this.cursosAsignados = new ArrayList<>();
        this.disponibilidad = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getLegajo() {
        return legajo;
    }

    public List<Curso> getCursosAsignados() {
        return this.cursosAsignados;
    }

    public void setCursosAsignados(Curso curso) {
        this.cursosAsignados.add(curso);
    }

    public List<Disponibilidad> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Turno turno, String dia) {
        Disponibilidad disponibilidad = new Disponibilidad(turno, dia);
        this.disponibilidad.add(disponibilidad);
    }

    public void generarReporte(String legajo,Reporte reporte ){
        reporte.generarReporte(legajo);
    }
}
