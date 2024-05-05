
package com.mycompany.maps.main.clases;

import java.util.ArrayList;
import java.util.List;

public class Lugar {
    
    private String nombre;
    private List<Lugar> lugaresCercanos;
    private boolean parteDeLaRuta = false;
    private boolean origenODestino = false;
    private boolean visitado = false;
    private boolean pasado = false;
    
    public Lugar(String nombre) {
        this.nombre = nombre;
        this.lugaresCercanos = new ArrayList<>();
    }

    public void guardarDestinoCercano(Lugar destino) {
        lugaresCercanos.add(destino);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public List<Lugar> getLugaresCercanos() {
        return lugaresCercanos;
    }
    
    public void marcarRuta() {
        parteDeLaRuta = true;
    }
    
    public void desmarcarRuta() {
        parteDeLaRuta = false;
    }
    
    public boolean isParteDeLaRuta() {
        return parteDeLaRuta;
    }
    
    public void marcarOrigenODestino() {
        origenODestino = true;
    }
    
    public void desmarcarOrigenODestino() {
        origenODestino = false;
    }
    
    public boolean isOrigenODestino() {
        return origenODestino;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    public boolean isPasado() {
        return pasado;
    }

    public void setPasado(boolean pasado) {
        this.pasado = pasado;
    }
    
}
