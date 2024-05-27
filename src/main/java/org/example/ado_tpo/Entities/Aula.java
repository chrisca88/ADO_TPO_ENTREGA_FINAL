package org.example.ado_tpo.Entities;


import org.example.ado_tpo.Enums.Turno;

public class Aula {
    private int capacidadMaxima;
    private int numero;


    public Aula(int capacidadMaxima, int numero) {
        this.capacidadMaxima = capacidadMaxima;
        this.numero = numero;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

