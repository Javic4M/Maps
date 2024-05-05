package com.mycompany.maps.main.clases;

public class DatoUno {
    
    private String ruta;
    private int cantidad;

    public DatoUno(String ruta, int cantidad) {
        this.ruta = ruta;
        this.cantidad = cantidad;
    }

    public String getRuta() {
        return ruta;
    }

    public int getCantidad() {
        return cantidad;
    }
}
