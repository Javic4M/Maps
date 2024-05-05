
package com.mycompany.maps.main.clases;

import java.util.ArrayList;
import java.util.List;

public class InformacionRecorrido {
    
    // Datos Iniciales
    String origen;
    String destino;
    int tiempoVehiculo, tiempoPersona;
    int gastoVehiculo, gastoPersona;
    int distancia;
    // Datos Extras
    List<Trafico> horarios;

    public InformacionRecorrido(String origen, String destino, String tiempoVehiculo, String tiempoPersona, String gastoVehiculo, String gastoPersona, String distancia) {
        this.origen = origen;
        this.destino = destino;
        this.tiempoVehiculo = Integer.parseInt(tiempoVehiculo);
        this.tiempoPersona = Integer.parseInt(tiempoPersona);
        this.gastoVehiculo = Integer.parseInt(gastoVehiculo);
        this.gastoPersona = Integer.parseInt(gastoPersona);
        this.distancia = Integer.parseInt(distancia);
        horarios = new ArrayList<>();
    }

    public void guardarInformacionDelTrafico(String horaInicio, String horaFinal, String probabilidad) {
        horarios.add(new Trafico(Integer.parseInt(horaInicio), Integer.parseInt(horaFinal), Integer.parseInt(probabilidad)));
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getTiempoVehiculo() {
        return tiempoVehiculo;
    }

    public int getTiempoPersona() {
        return tiempoPersona;
    }
        
    public int getGastoVehiculo() {
        return gastoVehiculo;
    }

    public int getGastoPersona() {
        return gastoPersona;
    }

    public int getDistancia() {
        return distancia;
    }

    public List<Trafico> getHorarios() {
        return horarios;
    }
}
