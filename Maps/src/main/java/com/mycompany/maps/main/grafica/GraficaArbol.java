package com.mycompany.maps.main.grafica;

import com.mycompany.maps.main.arbol.Arbol;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GraficaArbol {
    
    private List<String> caminos;
    
    public GraficaArbol(List<String> caminos) {
        this.caminos = caminos;
    }
    
    public void generarImagen() {
        
        try {
            generarDocumentoDOC(crearContenidoDelDocumento());
            ProcessBuilder process = new ProcessBuilder("dot", "-Tpng", "-o", "ImagenArbolB.png", "ImagenArbolB.dot");
            process.redirectErrorStream(true);
            process.start();
        } catch (IOException ex) {
            System.out.println("Error al Intentar generar la Imagen");
        }
    }
        
    private void generarDocumentoDOC(String contenido) {
        File file = new File("ImagenArbolB.dot");

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
    
    private String crearContenidoDelDocumento() {
        String contenido = "digraph G {\n"
                + "\tnode [style=filled, fillcolor=lightblue];\n";
        
        Arbol arbol = new Arbol();
        
        if (!caminos.isEmpty()) {
            for (int i = 0; i < caminos.size(); i++) {
                arbol.analizarLugar(i + 1, caminos.get(i));
            }
        }
        contenido += arbol.imprimirArbol();
        contenido += "}";
        return contenido;
    }
    
}
