package org.example.ado_tpo.Entities;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String codigo;
    private String nombre;
    private int cargaHorariaMaxima;
    private List<Materia> materias;

    public Carrera(String codigo, String nombre, int cargaHorariaMaxima){
        this.codigo = codigo;
        this.nombre = nombre;
        this.cargaHorariaMaxima = cargaHorariaMaxima;
        materias = new ArrayList<Materia>();
    }

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public int getCargaHorariaMaxima() {
        return cargaHorariaMaxima;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargaHorariaMaxima(int cargaHorariaMaxima) {
        this.cargaHorariaMaxima = cargaHorariaMaxima;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}

