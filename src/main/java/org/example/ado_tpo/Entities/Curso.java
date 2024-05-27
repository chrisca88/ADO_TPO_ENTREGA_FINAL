package org.example.ado_tpo.Entities;


import org.example.ado_tpo.Controllers.AulaController;
import org.example.ado_tpo.Controllers.MateriaController;
import org.example.ado_tpo.Enums.Turno;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class Curso {
    private int numero;
    private int numeroAula;
    private String turno;
    private List<Docente> docentesAsignados;
    private String codigoMateria;
    private List<Estudiante> estudiantesInscriptos;
    private LocalDate fecha;
    private String dia;
    private int cupos;
    private Turno horario;


    public int calcularCapacidad() {
        return  cupos - estudiantesInscriptos.size();
    }

    public Curso(){
        estudiantesInscriptos = new ArrayList<>();
        docentesAsignados = new ArrayList<>();
    }

    public Materia getMateria() {
        MateriaController matController = MateriaController.getInstancia();
        Materia materia = matController.buscarMateriaPorCodigo(this.codigoMateria);
        return materia;
    }

    public String getHorario() {
        return turno;
    }

    public void agregarDocente(Docente docente) {
        this.docentesAsignados.add(docente);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    // Getters y setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        Aula aula = AulaController.getInstancia().getAulaByNumero(numeroAula);
        this.numeroAula = numeroAula;
        this.cupos = aula.getCapacidadMaxima();
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<Docente> getDocentesAsignados() {
        return docentesAsignados;
    }

    public void setDocentesAsignados(List<Docente> docentesAsignados) {
        this.docentesAsignados = docentesAsignados;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public List<Estudiante> getEstudiantesInscriptos() {
        return estudiantesInscriptos;
    }

    public void setEstudiantesInscriptos(List<Estudiante> estudiantesInscriptos) {
        this.estudiantesInscriptos = estudiantesInscriptos;
    }
    public void inscribirEstudiante(Estudiante e){



        this.estudiantesInscriptos.add(e);
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos() {
        this.cupos = cupos - 1;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }

    public void setHorario(Turno horario) {
        this.horario = horario;
    }

    public Turno getTurno() {
        return this.horario;
    }


}
