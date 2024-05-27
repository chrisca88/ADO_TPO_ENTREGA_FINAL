package org.example.ado_tpo.Controllers;

import org.example.ado_tpo.Entities.Carrera;
import org.example.ado_tpo.Entities.Materia;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarreraController {

    private static CarreraController instance;
    private List<Carrera> carreras;

    private CarreraController() {
        carreras = new ArrayList<>();
    }

    public static CarreraController getInstance() {
        if (instance == null) {
            instance = new CarreraController();
        }
        return instance;
    }

    public Carrera buscarCarreraPorCodigo(String codigo) {
        for (Carrera c : carreras) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public boolean agregarMateriaACarrera(String codigoCarrera, String codMateria) {
        MateriaController matController = MateriaController.getInstancia();
        Materia materia = matController.buscarMateriaPorCodigo(codMateria);

        Carrera carrera = this.buscarCarreraPorCodigo(codigoCarrera);
        if (carrera != null && materia != null) {
            int prev = carrera.getMaterias().size();
            carrera.agregarMateria(materia);
            int after = carrera.getMaterias().size();
            return prev != after;
        }

        return false;
    }

    public Carrera crearCarrera(String codigo, String nombre, int cargaHorariaMaxima) {
        Carrera carrera = new Carrera(codigo, nombre, cargaHorariaMaxima);
        carreras.add(carrera);
        return carrera;
    }
}
