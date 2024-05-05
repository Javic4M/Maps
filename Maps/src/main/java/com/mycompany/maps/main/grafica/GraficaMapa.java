package com.mycompany.maps.main.grafica;

import com.mycompany.maps.main.clases.Lugar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GraficaMapa {
    
    private List<Lugar> lugares;
    private List<Lugar> lugaresDobles;
    
    public GraficaMapa(List<Lugar> lugares, List<Lugar> lugaresDobles) {
        this.lugares = lugares;
        this.lugaresDobles = lugaresDobles;
    }
    
    public void generarImagen(int numero) {
        
        try {
            if (numero == 1) {
                // Carro
                generarDocumentoDOC(crearContenidoDelDocumento(1));
            } else {
                // Caminando
                generarDocumentoDOC(extraerYArmarMapa(crearContenidoDelDocumento(2)));
            }
            ProcessBuilder process = new ProcessBuilder("dot", "-Tpng", "-o", "ImagenMapa.png", "ImagenMapa.dot");
            process.redirectErrorStream(true);
            process.start();
        } catch (IOException ex) {
            System.out.println("Error al Intentar generar la Imagen");
        }
    }
    
    private void generarDocumentoDOC(String contenido) {
        File file = new File("ImagenMapa.dot");

        try {
            FileWriter writer = new FileWriter(file, false);

            try (PrintWriter printer = new PrintWriter(writer)) {
                printer.println(contenido);
                printer.close();
            }
        } catch (IOException e) {
            System.out.println("Error de tipo: " + e.getMessage());
        }
    }
    
    private String crearContenidoDelDocumento(int numero) {
        List<Lugar> opciones;
        String nodos = "", uniones = "";
        String contenido = "digraph G {\n"
                + "\tnode[shape = circle, style=filled, fillcolor=white]\n"
                + "\tgraph [rankdir = \"LR\"];\n";
        
        if (numero == 1){
            opciones = lugares;
        } else {
            opciones = lugaresDobles;
        }
        
        for (int i = 0; i < opciones.size(); i++) {
            if (opciones.get(i).isParteDeLaRuta()) {
                if (opciones.get(i).isOrigenODestino()) {
                    nodos += "\t" + i + "[label=\"" + opciones.get(i).getNombre() + "\"] [fillcolor=cyan] [shape=doublecircle];\n";
                } else {
                    nodos += "\t" + i + "[label=\"" + opciones.get(i).getNombre() + "\"] [fillcolor=cyan];\n";
                }
            } else {
                nodos += "\t" + i + "[label=\"" + opciones.get(i).getNombre() + "\"];\n";
            }
            List<Lugar> lugaresCercanos = opciones.get(i).getLugaresCercanos();
            
            for (Lugar lugarCercano : lugaresCercanos) {
                int numeroRama = getNumeroLugar(lugarCercano.getNombre());
                uniones += "\t" + i + "->" + numeroRama + "\n";
            }
        }
        
        contenido += nodos;
        contenido += uniones;
        contenido += "}";
        
        if (numero == 1){
            return contenido;
        } else {
            return nodos;
        }
    }
    
    private int getNumeroLugar(String nombreABuscar) {
        for (int i = 0; i < lugares.size(); i++) {
            if (lugares.get(i).getNombre().equals(nombreABuscar)) {
                return i;
            }
        }
        return -1;
    }
    
    private String extraerYArmarMapa(String nodos) {
        String uniones = "";
        String contenido = "graph G {\n"
                + "\tnode[shape = circle, style=filled, fillcolor=white]\n"
                + "\tgraph [rankdir = \"LR\"];\n";
        
        for (int i = 0; i < lugares.size(); i++) {
            List<Lugar> lugaresCercanos = lugares.get(i).getLugaresCercanos();
            
            for (Lugar lugarCercano : lugaresCercanos) {
                int numeroRama = getNumeroLugar(lugarCercano.getNombre());
                uniones += "\t" + i + "--" + numeroRama + "\n";
            }
        }
        contenido += nodos;
        contenido += uniones;
        contenido += "}";
        
        return contenido;
    }
}
