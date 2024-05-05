package com.mycompany.maps.main.arbol;

public class NodoArbol {
        
    int cantidadValoresGuardados;
    boolean esUnaHoja;
    Valor[] valores;
    NodoArbol[] hijos;

    //Constructores
    public NodoArbol(int t) {
        cantidadValoresGuardados = 0;
        esUnaHoja = true;
        valores = new Valor[t];
        hijos = new NodoArbol[(2 * t)];
        iniciarValores();
    }

    private void iniciarValores() {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = new Valor();
        }
    }
    
    public String imprimirValores(int indice) {
        int contador = 0;
        String contenido = "\tnode"+indice+" [label = \"";
        
        for (int i = 0; i < cantidadValoresGuardados; i++) {
            if (i < cantidadValoresGuardados - 1) {
                contenido += "<f" + contador + "> " + valores[i].getContenido() + " | ";
                contador++;
            } else {
                contenido += "<f" + contador + "> " + valores[i].getContenido() + "\" shape = \"record\"];";
            }
        }
        return contenido;
    }
}

