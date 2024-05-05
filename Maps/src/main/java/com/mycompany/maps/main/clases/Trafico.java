package com.mycompany.maps.main.clases;

public class Trafico {

    private int horaInicio;
    private int horaFinal;
    private int probabilidad;

    public Trafico(int horaInicio, int horaFinal, int probabilidad) {
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.probabilidad = probabilidad;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public int getProbabilidad() {
        return probabilidad;
    }
}
