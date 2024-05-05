
package com.mycompany.maps.main.archivos;

import com.mycompany.maps.main.clases.InformacionRecorrido;
import com.mycompany.maps.main.clases.Lugar;
import java.util.List;

public class ImportarDestinosYTrafico {
    
    private List<Lugar> lugares;
    private List<Lugar> lugaresDobles;
    private List<InformacionRecorrido> informaciones;
    private ManipulacionArchivo manipulacion;
    
    public ImportarDestinosYTrafico(List<Lugar> lugares, List<Lugar> lugaresDobles, List<InformacionRecorrido> informaciones) {
        this.lugares = lugares;
        this.lugaresDobles = lugaresDobles;
        this.informaciones = informaciones;
        this.manipulacion = new ManipulacionArchivo();
    }
    
    public void cargarDestinos(String path) {
        List<String> lineas = manipulacion.leerArchivo(path);
        
        for (String linea : lineas) {
            String datos[] = manipulacion.obtenerDatos(linea);
            
            if (!lugaresRepetidos(datos[0], datos[1], 1)) {
                Lugar lugarOrigen = obtenerOCrearLugar(datos[0], 1);
                lugarOrigen.guardarDestinoCercano(obtenerOCrearLugar(datos[1], 1));
                informaciones.add(new InformacionRecorrido(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]));
            }
        }
    }
        
    public void cargarDestinosDobles(String path) {
        List<String> lineas = manipulacion.leerArchivo(path);
        
        for (String linea : lineas) {
            String datos[] = manipulacion.obtenerDatos(linea);
            
            if (!lugaresRepetidos(datos[0], datos[1], 2)) {
                Lugar origen = obtenerOCrearLugar(datos[0], 2);
                Lugar destino = obtenerOCrearLugar(datos[1], 2);
                origen.guardarDestinoCercano(destino);
                destino.guardarDestinoCercano(origen);
            }
        }
    }
    
    public void cargarTrafico(String path) {
        List<String> lineas = manipulacion.leerArchivo(path);
        
        for (String linea : lineas) {
            String datos[] = manipulacion.obtenerDatos(linea);    
            
            for (InformacionRecorrido informacion : informaciones) {
                if (informacion.getOrigen().equals(datos[0]) && informacion.getDestino().equals(datos[1])) {
                    informacion.guardarInformacionDelTrafico(datos[2], datos[3], datos[4]);
                }
            }
        }
    }
    
    private Lugar obtenerOCrearLugar(String destino, int numero) {
        List<Lugar> opciones;
                
        if (numero == 1) {
            opciones = lugares;
        } else {
            opciones = lugaresDobles;
        }
        
        for (Lugar lugar : opciones) {
            if (lugar.getNombre().equals(destino)) {
                return lugar;
            }
        }
        
        Lugar nuevoLugar = new Lugar(destino);
        opciones.add(nuevoLugar);
        return nuevoLugar;
    }
    
    private boolean lugaresRepetidos(String origen, String destino, int numero) {
        List<Lugar> opciones;
                
        if (numero == 1) {
            opciones = lugares;
        } else {
            opciones = lugaresDobles;
        }
        
        for (int i = 0; i < opciones.size(); i++) {
            if (opciones.get(i).getNombre().equals(origen)) {
                List<Lugar> lugaresCercanos = opciones.get(i).getLugaresCercanos();
                
                for (int j = 0; j < lugaresCercanos.size(); j++) {
                    if (lugaresCercanos.get(j).getNombre().equals(destino)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
