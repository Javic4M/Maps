package com.mycompany.maps.main.arbol;

public class Valor {
    
    private String contenido;
    private int llave;

    public Valor() {
        this.contenido = "";
        this.llave = 0;
    }
    
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }
}
