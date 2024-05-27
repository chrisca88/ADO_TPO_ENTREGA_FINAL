package org.example.ado_tpo.Entities;

import org.example.ado_tpo.Enums.Turno;

import java.util.Objects;

public class Disponibilidad {
    private Turno turno;
    private String dia;

    public Disponibilidad() {
    }

    public Disponibilidad(Turno turno, String dia) {
        this.turno = turno;
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disponibilidad that = (Disponibilidad) o;
        return turno == that.turno && Objects.equals(dia, that.dia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(turno, dia);
    }
}
