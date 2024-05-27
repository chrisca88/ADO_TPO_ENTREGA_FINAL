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


    // Getters y setters

    public List<Materia> getMaterias() {
        return materias;
    }

    public String getCodigo() {
        return codigo;
    }

}

