
package com.mycompany.maps.main.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManipulacionArchivo {
        
    public List<String> leerArchivo(String path) {
        File file = new File(path);
        BufferedReader entrada = null;
        List<String> contenido = new ArrayList<>();
        String linea;
        
        if (file.exists()) {            
            try {
                entrada = new BufferedReader(new FileReader(file));
                
                while ((linea = entrada.readLine()) != null) {
                    contenido.add(linea);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return contenido;
    }
        
    public String[] obtenerDatos(String linea) {
        String caracteres[] = linea.split("");
        String datos[] = new String[7];
        int indice = 0, contador = 0;
        
        while (indice < 7) {
            String dato = "";
            
            while (contador < caracteres.length) {
                if (!"|".equals(caracteres[contador])) {
                    dato += caracteres[contador];
                    contador++;
                } else {
                    break;
                }
            }
            contador++;
            datos[indice] = dato;
            dato = "";
            indice++;
        }
        return eliminarEspacios(datos);
    }

    private String[] eliminarEspacios(String datos[]) {
        String datoNuevo = "";
        
        for (int i = 0; i < datos.length; i++) {
            String caracteres[] = datos[i].split("");
            
            for (int j = 0; j < caracteres.length; j++) {
                if (!" ".equals(caracteres[j])) {
                    datoNuevo += caracteres[j];
                }
            }
            datos[i] = datoNuevo;
            datoNuevo = "";
        }
        return datos;
    }
}
