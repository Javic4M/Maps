
package com.mycompany.maps.main.arbol;

public class Arbol {
    
    NodoArbol raiz;
    int rango = 5;

    public Arbol() {
        raiz = new NodoArbol(rango);
    }

    public void analizarLugar(int llave, String contenido) {
        NodoArbol r = raiz;

        if (r.cantidadValoresGuardados == (rango-1)) { //4
            NodoArbol nuevo = new NodoArbol(rango);
            raiz = nuevo;
            nuevo.esUnaHoja = false;
            nuevo.cantidadValoresGuardados = 0;
            nuevo.hijos[0] = r;
            dividir(nuevo, 0, r);
            insertar(nuevo, llave, contenido);
        } else {
            insertar(r, llave, contenido);
        }
    }

    private void dividir(NodoArbol raiz, int i, NodoArbol anterior) {
        NodoArbol temporal = new NodoArbol(rango);
        temporal.esUnaHoja = anterior.esUnaHoja;
        temporal.cantidadValoresGuardados = ((rango/2)-1); //1
        
        int limite = rango/2+1;
        for (int j = 0; j < (rango/2); j++) { //2
            temporal.valores[j] = anterior.valores[(j + limite)]; //3
        }

        if (!anterior.esUnaHoja) {
            for (int k = 0; k < limite; k++) { //3
                temporal.hijos[k] = anterior.hijos[(k + limite)]; //3
            }
        }
        anterior.cantidadValoresGuardados = (rango/2); //2
        
        for (int j = raiz.cantidadValoresGuardados; j > i; j--) {
            raiz.hijos[(j + 1)] = raiz.hijos[j];
        }
        raiz.hijos[(i + 1)] = temporal;
        
        for (int j = raiz.cantidadValoresGuardados; j > i; j--) {
            raiz.valores[(j + 1)] = raiz.valores[j];
        }

        raiz.valores[i] = anterior.valores[(rango/2)]; //2
        raiz.cantidadValoresGuardados++;
    }

    private void insertar(NodoArbol x, int llave, String contenido) {

        if (x.esUnaHoja) {
            int i = x.cantidadValoresGuardados;
            
            while (i >= 1 && llave < x.valores[i - 1].getLlave()) {
                x.valores[i] = x.valores[i - 1];
                i--;
            }
            x.valores[i].setLlave(llave);
            x.valores[i].setContenido(contenido);
            x.cantidadValoresGuardados++;
        } else {
            int j = 0;
            
            while (j < x.cantidadValoresGuardados && llave > x.valores[j].getLlave()) {
                j++;
            }

            if (x.hijos[j].cantidadValoresGuardados == (rango-1)) { //4
                dividir(x, j, x.hijos[j]);

                if (llave > x.valores[j].getLlave()) {
                    j++;
                }
            }
            insertar(x.hijos[j], llave, contenido);
        }
    }

    public String imprimirArbol() {
        return imprimir(raiz, 0, 0);
    }

    private String imprimir(NodoArbol actual, int indice, int contador) {
        String contenido = actual.imprimirValores(indice) + "\n";
        
        if (!actual.esUnaHoja) {
            indice++;
            for (int j = 0; j <= actual.cantidadValoresGuardados; j++) {
                if (actual.hijos[j] != null) {
                    contenido += imprimir(actual.hijos[j], indice, (contador+1));
                    //contenido += "\t\"node" + contador + "\":f0 -> \"node" + (indice) + "\":f0;\n";
                    contenido += "\t\"node" + contador + "\":f"+ j + " -> \"node" + (indice) + "\":f0;\n";
                    indice++;
                }
            }
        }
        return contenido;
    }
}
