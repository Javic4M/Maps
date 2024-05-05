package com.mycompany.maps.main.clases;

import java.util.List;

public class Acciones {
    
    private DatoUno[] desgaste;
    private DatoUno[] distancia;
    private DatoDos[] desgasteYDistancia;
    private DatoDos[] rapidez;
    private int tiempo = 0;
    
    public void establecerCaminos(Lugar lugarOrigen, String nombreDestino, String union, List<String> caminos) {
        List<Lugar> lugaresCercanos = lugarOrigen.getLugaresCercanos();
             
        if (!lugaresCercanos.isEmpty()) {
            
            for (Lugar lugarCerca : lugaresCercanos) {    
                if (!lugarCerca.isPasado()) {
                    if (!verificarRecorrido(union, lugarCerca.getNombre())) {
                        if (lugarCerca.getNombre().equals(nombreDestino)) {
                            caminos.add(union + "," + lugarCerca.getNombre());
                        } else {
                            establecerCaminos(lugarCerca, nombreDestino, (union + "," + lugarCerca.getNombre()), caminos);
                        }
                    }
                }
            }
        }
    }
    
    private boolean verificarRecorrido(String union, String nombre) {
        String partes[] = union.split(",");

        for (String parte : partes) {
            if (parte.equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    /*
    public void establecerCaminos(Lugar lugarOrigen, String origen, String nombreDestino, String union, List<String> caminos) {
        List<Lugar> lugaresCercanos = lugarOrigen.getLugaresCercanos();
        
        if (!lugarOrigen.isVisitado()) {
            lugarOrigen.setVisitado(true);
            
            if (!lugaresCercanos.isEmpty()) {    
                for (Lugar lugarCerca : lugaresCercanos) {
                    
                    if (!lugarCerca.getNombre().equals(origen)) {
                        if (lugarCerca.getNombre().equals(nombreDestino)) {
                            caminos.add(union + "," + lugarCerca.getNombre());
                            System.out.println("Camino: " + union + "," + lugarCerca.getNombre());
                        } else {
                            establecerCaminos(lugarCerca, lugarOrigen.getNombre() ,nombreDestino, (union + "," + lugarCerca.getNombre()), caminos);
                            System.out.println("Recursividad");
                        }
                    }
                }
            }
        }
    }
    */
    public void marcarCaminos(List<Lugar> lugares, List<String> caminos) {
        desmarcarCaminos(lugares);    
        
        for (String camino : caminos) {
            String[] partes = camino.split(",");
            
            for (int i = 0; i < partes.length; i++) {
                for (Lugar lugar : lugares) {
                    if (lugar.getNombre().equals(partes[i])) {
                        lugar.marcarRuta();
                        break;
                    }
                }
            }
        }
        
        String[] partes = caminos.get(0).split(",");
        int contador = 0, indice = 0;
        
        while (contador != 2) {
            for (Lugar lugar : lugares) {
                if (lugar.getNombre().equals(partes[indice])) {
                    lugar.marcarOrigenODestino();
                    indice = (partes.length-1);
                    contador++;
                    break;
                }
            }
        }
    }
    
    public void desmarcarCaminos(List<Lugar> lugares) {
        for (Lugar lugar : lugares) {
            lugar.desmarcarOrigenODestino();
            lugar.desmarcarRuta();
        }
    }
    
    public void calcularCaminando(List<String> caminos, List<InformacionRecorrido> informaciones) {
        desgaste = new DatoUno[caminos.size()];
        distancia = new DatoUno[caminos.size()];
        desgasteYDistancia = new DatoDos[caminos.size()];
        rapidez = new DatoDos[caminos.size()];
        int indice = 0, sumaDesgaste = 0, sumaDistancia = 0, contador = 0;
        double sumaRapidez = 0.0;
        
        for (String camino : caminos) {
            String partes[] = camino.split(",");
            sumaDesgaste = 0; sumaDistancia = 0; sumaRapidez = 0; indice = 0;
            
            while (indice != (partes.length - 1)) {
                for (InformacionRecorrido informacion : informaciones) {
                    if ((informacion.getOrigen().equals(partes[indice]) && informacion.getDestino().equals(partes[indice + 1])) || (informacion.getOrigen().equals(partes[indice + 1]) && informacion.getDestino().equals(partes[indice]))) {
                        sumaDesgaste += informacion.getGastoPersona();
                        sumaDistancia += informacion.getDistancia();
                        
                        double distanciaDecimal = informacion.getDistancia();
                        double tiempoDecimal = (informacion.getTiempoPersona()/60.0);
                        
                        sumaRapidez += (distanciaDecimal / tiempoDecimal);                       
                        indice++;
                        break;
                    }
                }
            }
            desgaste[contador] = new DatoUno(camino, sumaDesgaste);
            distancia[contador] = new DatoUno(camino, sumaDistancia);
            desgasteYDistancia[contador] = new DatoDos(camino, (double) sumaDistancia / (double) sumaDesgaste);
            rapidez[contador] = new DatoDos(camino, sumaRapidez);
            contador++;
        }
        ordenarArreglosUno(desgaste);
        ordenarArreglosUno(distancia);
        ordenarArreglosDos(desgasteYDistancia);
        ordenarArreglosDos(rapidez);
    }
    
    public void calcularEnVehiculo(List<String> caminos, List<InformacionRecorrido> informaciones, int horaRecorrido) {
        desgaste = new DatoUno[caminos.size()];
        distancia = new DatoUno[caminos.size()];
        desgasteYDistancia = new DatoDos[caminos.size()];
        rapidez = new DatoDos[caminos.size()];
        int indice = 0, sumaDesgasteGasolina = 0, sumaDistancia = 0, contador = 0;
        double sumaRapidez = 0.0;
        
        for (String camino : caminos) {
            String caminoTrafico = camino;
            String partes[] = camino.split(",");
            sumaDesgasteGasolina = 0; sumaDistancia = 0; sumaRapidez = 0;
            indice = 0;
            
            while (indice != (partes.length - 1)) {
                for (InformacionRecorrido informacion : informaciones) {
                    if (informacion.getOrigen().equals(partes[indice]) && informacion.getDestino().equals(partes[indice + 1])) {
                        sumaDesgasteGasolina += informacion.getGastoVehiculo();
                        sumaDistancia += informacion.getDistancia();
                        double distanciaDecimal = informacion.getDistancia(), tiempoDecimal = informacion.getTiempoVehiculo()/60.0;
                        
                        List<Trafico> trafico = informacion.getHorarios();
                        boolean hayTrafico = false;
                        
                        if (!trafico.isEmpty()) {
                            for (Trafico horario : trafico) {
                                if (horaRecorrido >= horario.getHoraInicio() && horaRecorrido <= horario.getHoraFinal()) {
                                    caminoTrafico += " (CON TRÁFICO)";
                                    sumaRapidez += (distanciaDecimal / (tiempoDecimal * (1 + horario.getProbabilidad())));
                                    hayTrafico = true;
                                    break;
                                }
                            }

                            int minutosActuales = informacion.getTiempoVehiculo();

                            while (minutosActuales >= 60) {
                                minutosActuales -= 60;
                                horaRecorrido++;
                            }
                        
                        
                            if (!hayTrafico) {
                                for (Trafico horario : trafico) {
                                    if (horaRecorrido >= horario.getHoraInicio() && horaRecorrido <= horario.getHoraFinal()) {
                                        caminoTrafico += " (CON TRÁFICO)";
                                        sumaRapidez += (distanciaDecimal / (tiempoDecimal * (1 + horario.getProbabilidad())));
                                        hayTrafico = true;
                                        break;
                                    }
                                }
                            }
                        }
                        
                        if (!hayTrafico) {
                            sumaRapidez += (distanciaDecimal / tiempoDecimal);
                        }
                        
                        indice++;
                        break;  
                        // Toca verificar la hora
                    }
                }
            }
            desgaste[contador] = new DatoUno(camino, sumaDesgasteGasolina);
            distancia[contador] = new DatoUno(camino, sumaDistancia);
            desgasteYDistancia[contador] = new DatoDos(camino, (double) sumaDistancia / (double) sumaDesgasteGasolina);
            rapidez[contador] = new DatoDos(caminoTrafico, sumaRapidez);
            contador++;
        }
        ordenarArreglosUno(desgaste);
        ordenarArreglosUno(distancia);
        ordenarArreglosDos(desgasteYDistancia);
        ordenarArreglosDos(rapidez);
    }
    
    private void ordenarArreglosUno(DatoUno[] arreglo) {
        for (int i = 1; i <= arreglo.length - 1; i++) {   
            DatoUno datoAMover = arreglo[i];
            
            for (int j = i - 1; j >= 0; j--) {                
                if (arreglo[j].getCantidad() > datoAMover.getCantidad()) {
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = datoAMover;
                }
            }
        }
    }
    
    private void ordenarArreglosDos(DatoDos[] arreglo) {
        for (int i = 1; i <= arreglo.length - 1; i++) {   
            DatoDos datoAMover = arreglo[i];
            
            for (int j = i - 1; j >= 0; j--) {                
                if (arreglo[j].getCantidadDecimal()> datoAMover.getCantidadDecimal()) {
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = datoAMover;
                }
            }
        }
    }
        
    public DatoUno[] getDesgaste() {
        return desgaste;
    }
    
    public DatoUno[] getDistancia() {
        return distancia;
    }
    
    public DatoDos[] getDesgasteYDistancia() {
        return desgasteYDistancia;
    }
    
    public DatoDos[] getRapidez() {
        return rapidez;
    }
    
    public int getTiempo() {
        return tiempo;
    }
    
                            
                        /*
                        if (horaRecorrido >= informacion.getHoraInicio() && horaRecorrido <= informacion.getHoraFinal()) {
                            caminoTrafico += " (CON TRÁFICO)";
                            sumaRapidez += (distanciaDecimal / (tiempoDecimal * (1 + informacion.getProbabilidad())));
                        } else {
                            int minutosActuales = informacion.getTiempoVehiculo();
                            
                            while (minutosActuales >= 60) {
                                minutosActuales -= 60;
                                horaRecorrido++;
                            }
                            
                            if (horaRecorrido >= informacion.getHoraInicio() && horaRecorrido <= informacion.getHoraFinal()) {
                                caminoTrafico += " (CON TRÁFICO)";
                                sumaRapidez += (distanciaDecimal / (tiempoDecimal * (1 + (informacion.getProbabilidad()))));
                            } else {
                                sumaRapidez += (distanciaDecimal / tiempoDecimal);
                            }
                        }
                        indice++;
                        break;
                        */
}
