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
    // Getters y setters
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public float getCosto() {
        return costo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getCorrelativasAnteriores() {
        return correlativasAnteriores;
    }

    public String getCodigo() {
        return codigo;
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
