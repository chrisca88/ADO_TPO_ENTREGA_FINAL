package org.example.ado_tpo.Entities;

import org.example.ado_tpo.Enums.Estado;


public class Asignatura {
    private Curso curso;
    private Materia materia;
    private Estado estado;
    private Cuota cuota;

    public Asignatura() {
    }

    public Asignatura(Curso curso, Materia materia, Estado estado, Cuota cuota) {
        this.curso = curso;
        this.materia = materia;
        this.estado = estado;
        this.cuota = cuota;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }


}