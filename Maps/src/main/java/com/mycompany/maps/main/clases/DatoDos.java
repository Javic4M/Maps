package com.mycompany.maps.main.clases;

public class DatoDos {
    
    private String ruta;
    private double cantidadDecimal;
    
    public DatoDos(String ruta, double cantidadDecimal) {
        this.ruta = ruta;
        this.cantidadDecimal = cantidadDecimal;
    }
    
    public String getRuta() {
        return ruta;
    }

    public double getCantidadDecimal() {
        String conversion = String.format("%." + 2 + "f", cantidadDecimal);
        return Double.parseDouble(conversion);
    }
}
