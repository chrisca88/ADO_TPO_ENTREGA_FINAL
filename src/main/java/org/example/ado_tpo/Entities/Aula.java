package org.example.ado_tpo.Entities;


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

    public int getNumero() {
        return numero;
    }

}

