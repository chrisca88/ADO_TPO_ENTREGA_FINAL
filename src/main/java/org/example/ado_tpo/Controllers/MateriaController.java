package org.example.ado_tpo.Controllers;

import org.example.ado_tpo.Entities.Materia;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MateriaController {

    private static MateriaController instance;
    private List<Materia> materias;

    private MateriaController() {
        materias = new ArrayList<>();
    }

    public static MateriaController getInstancia() {
        if (instance == null) {
            instance = new MateriaController();
        }
        return instance;
    }

    public Materia nuevaMateria(String codigo, String nombre, int cargaHoraria, float costo) {
        Materia materia = new Materia(codigo, nombre, cargaHoraria, costo);
        materias.add(materia);
        return materia;
    }

    public Materia buscarMateriaPorCodigo(String codigo) {
        for (Materia m : materias) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }
        return null;
    }

    public void agregarCorrelativaAnterior(String codigo, String codigoCorrelativa){
        Materia materia = buscarMateriaPorCodigo(codigo);
        Materia correlativa = buscarMateriaPorCodigo(codigoCorrelativa);
        if(materia != null && correlativa != null){
            materia.agregarCorrelativaAnterior(correlativa);
        }
    }

    public void agregarCorrelativaPosterior(String codigo, String codigoCorrelativa) {
        Materia materia = buscarMateriaPorCodigo(codigo);
        Materia correlativa = buscarMateriaPorCodigo(codigoCorrelativa);
        if (materia != null && correlativa != null) {
            materia.agregarCorrelativaPosterior(correlativa);
        }
    }
}
