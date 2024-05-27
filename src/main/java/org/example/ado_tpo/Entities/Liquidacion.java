package org.example.ado_tpo.Entities;

import org.example.ado_tpo.Controllers.DocenteController;
import org.example.ado_tpo.Interfaces.Reporte;

import java.util.List;

public class Liquidacion implements Reporte {
    private String nombre;

    public void generarReporte(String legajo) {
        Docente docente = DocenteController.getInstancia().getDocenteByLegajo(legajo);
        System.out.println("Generando liquidacion del docente: " + docente.getNombre() +" " + docente.getApellido());
        List<Curso> cursos = docente.getCursosAsignados();
        List<Curso> cursosDocente = cursos.stream().filter(curso -> curso.getDocentesAsignados().contains(docente)).toList();
        int cargaHorarioa = 0;
        for (Curso curso : cursosDocente) {
            System.out.println(curso.getMateria().getNombre()+" Carga horaria por cuatrimestre: "+ curso.getMateria().getCargaHoraria());
            cargaHorarioa = (cargaHorarioa + curso.getMateria().getCargaHoraria());
        }
        System.out.println("La carga horaria mensual es de: " + cargaHorarioa/4);
    }
}
