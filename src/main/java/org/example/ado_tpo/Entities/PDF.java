package org.example.ado_tpo.Entities;


import org.example.ado_tpo.Controllers.DocenteController;
import org.example.ado_tpo.Interfaces.Reporte;

import java.util.List;

public class PDF implements Reporte {


    public void generarReporte(String legajo) {
        Docente docente = DocenteController.getInstancia().getDocenteByLegajo(legajo);
        System.out.println("Generando reporte en PDF para el docente: " + docente.getNombre() +" " + docente.getApellido());
        List<Curso> cursos = docente.getCursosAsignados();
        List<Curso> cursosDocente = cursos.stream().filter(curso -> curso.getDocentesAsignados().contains(docente)).toList();
        for (Curso curso : cursosDocente) {
            System.out.println(curso.getMateria().getNombre()+ " "+curso.getDia()+ " "+curso.getHorario()+" Aula: "+curso.getNumeroAula() + " Cantidad de alumnos inscriptos: "+curso.getEstudiantesInscriptos().size());
        }
    }
}

