package org.example.ado_tpo.Controllers;


import java.util.ArrayList;
import java.util.List;

import org.example.ado_tpo.Entities.*;
import org.example.ado_tpo.Enums.Estado;
import org.example.ado_tpo.Enums.Turno;
import org.springframework.stereotype.Controller;

@Controller
public class CursoController {
    private static CursoController instancia;
    private List<Curso> cursos;

    private CursoController() {
        cursos = new ArrayList<>();
    }

    public static CursoController getInstancia() {
        if (instancia == null) {
            instancia = new CursoController();
        }
        return instancia;
    }

    public Curso crearCurso(int numero, int numeroAula, String horario, String dia, String codigoMateria, Turno turno) {
        Curso curso = new Curso();
        curso.setNumero(numero);
        curso.setNumeroAula(numeroAula);
        curso.setTurno(horario);
        curso.setDia(dia);
        curso.setCodigoMateria(codigoMateria);
        curso.setHorario(turno);
        cursos.add(curso);
        return curso;
    }

    public Curso obtenerCurso(int numero) {
        for (Curso curso : cursos) {
            if (curso.getNumero() == numero) {
                return curso;
            }
        }
        return null;
    }

    public List<Estudiante> obtenerInscriptosPorCurso() {
        List<Estudiante> estudiantesInscriptos = new ArrayList<>();
        for (Curso curso : cursos) {
            estudiantesInscriptos.addAll(curso.getEstudiantesInscriptos());
        }
        return estudiantesInscriptos;
    }

    public boolean validarInscripcionEstudianteACurso(int numeroCurso) {
        Curso curso = obtenerCurso(numeroCurso);
        if (curso != null) {
            return   curso.getCupos() >= 1;
        }
        return false;
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    // Método recursivo para verificar si todas las correlativas anteriores están finalizadas
    private boolean correlativasFinalizadas(Materia materia, List<Asignatura> asignaturas) {
        for (Materia correlativa : materia.getCorrelativasAnteriores()) {
            boolean encontrada = false;
            for (Asignatura asignatura : asignaturas) {
                if (asignatura.getMateria().equals(correlativa)) {
                    encontrada = true;
                    if (asignatura.getEstado() != Estado.FINALIZADO) {
                        return false;
                    }
                    // Llamada recursiva para verificar las correlativas de la correlativa
                    if (!correlativasFinalizadas(correlativa, asignaturas)) {
                        return false;
                    }
                }
            }
            // Si alguna correlativa no se encuentra en las asignaturas del estudiante, devuelve false
            if (!encontrada) {
                return false;
            }
        }
        return true;
    }
    // Método para validar la inscripción de un estudiante en un curso
    private boolean validadorDeInscripcicon(int codCurso, Estudiante estudiante) {
        HistorialAcademico ha = estudiante.getHistorialAcademico();
        List<Asignatura> asignaturas = ha.getAsignaturas();

        // Validar que no repita la materia
        for (Asignatura a : asignaturas) {
            Curso c = a.getCurso();
            if (c.getNumero() == codCurso && a.getEstado() == Estado.FINALIZADO || a.getEstado() == Estado.EN_CURSO) {
                return false;
            }
        }

        // Validar que todas las correlativas anteriores estén finalizadas
        Curso curso = obtenerCurso(codCurso);
        if (curso == null) {
            return false;
        }

        Materia materia = curso.getMateria();
        if (!correlativasFinalizadas(materia, asignaturas)) {
            return false;
        }

        return true;
    }

    public void inscribirEstudianteACurso(String legajo, int codCurso) {
        try {
            Estudiante estudiante = EstudianteController.getInstancia().getEstudianteByLegajo(legajo);
            Curso curso = this.obtenerCurso(codCurso);

            if (estudiante != null && curso != null && this.validadorDeInscripcicon(codCurso, estudiante)) {
                curso.inscribirEstudiante(estudiante);
                curso.setCupos();
                System.out.println("Estudiante inscrito correctamente en el curso.");
            } else {
                System.out.println("No se pudo inscribir el estudiante en el curso.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public void inscribirDocenteACurso(String legajo, int codCurso){
        try {

            Docente docente = DocenteController.getInstancia().getDocenteByLegajo(legajo);
            List<Disponibilidad> disponibilidad = docente.getDisponibilidad();


            Curso curso = this.obtenerCurso(codCurso);
            Disponibilidad disponibilidadCurso = new Disponibilidad(curso.getTurno(),curso.getDia());

            if (disponibilidad.contains(disponibilidadCurso)) {
                curso.agregarDocente(docente);
                docente.setCursosAsignados(curso);
                System.out.println("Docente inscrito correctamente en el curso.");
            }else {
                System.out.println("No se pudo inscribir el docente al curso");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Getters y setters para la lista de cursos
    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}

