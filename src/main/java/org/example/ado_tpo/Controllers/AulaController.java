package org.example.ado_tpo.Controllers;

import org.example.ado_tpo.Entities.Aula;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AulaController {
    private static AulaController instancia;
    private List<Aula> aulas;

    private AulaController() {
        aulas = new ArrayList<>();
    }

    public static AulaController getInstancia() {
        if (instancia == null) {
            instancia = new AulaController();
        }
        return instancia;
    }

    public void nuevaAula(int capacidadMaxima, int numero) {
        Aula aula = new Aula(capacidadMaxima, numero);
        aulas.add(aula);
    }

    public Aula getAulaByNumero(int numero){
        for(Aula d: aulas){
            try {
                if(d.getNumero() == numero){
                    return d;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        throw new IllegalArgumentException("Aula " + numero + " no encontrada.");
    }
}

