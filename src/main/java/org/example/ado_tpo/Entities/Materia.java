package org.example.ado_tpo.Entities;
import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private String codigo;
    private int cargaHoraria;
    private List<Materia> correlativasPosteriores;
    private List<Materia> correlativasAnteriores;
    private float costo;
    private List<Curso> cursos;


    public Materia(String codigo,String nombre, int cargaHoraria, float costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cargaHoraria = cargaHoraria;
        this.costo = costo;
        this.correlativasAnteriores = new ArrayList<>();
        this.correlativasPosteriores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public List<Curso> obtenerCursos() {
        return cursos;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public float getCosto() {
        return costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public List<Materia> getCorrelativasAnteriores() {
        return correlativasAnteriores;
    }

    public List<Materia> getCorrelativasPosteriores() {
        return correlativasPosteriores;
    }

    // Getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setCorrelativasPosteriores(List<Materia> correlativasPosteriores) {
        this.correlativasPosteriores = correlativasPosteriores;
    }

    public void setCorrelativasAnteriores(List<Materia> materia) {
        this.correlativasAnteriores = materia;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void agregarCorrelativaAnterior(Materia materia) {
        this.correlativasAnteriores.add(materia);
    }

    public void agregarCorrelativaPosterior(Materia materia) {
        this.correlativasPosteriores.add(materia);
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", costo=" + costo +
                '}';
    }
}
