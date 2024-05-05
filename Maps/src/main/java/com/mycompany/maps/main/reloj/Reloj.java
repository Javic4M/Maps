package com.mycompany.maps.main.reloj;

import javax.swing.JLabel;

public class Reloj extends Thread {

    private JLabel labelReloj;
    private int hora, minutos;
    private boolean seguir = true;
    private String horaEscrita, minutoEscrito;
    
    public Reloj(JLabel labelReloj, int hora, int minutos) {
        this.labelReloj = labelReloj;
        this.hora = hora;
        this.minutos = minutos;
        analizarPrimeraVuelta();
    }
    
    @Override
    public void run() {
        
        while(seguir) {
            try {
                labelReloj.setText(horaEscrita+":"+minutoEscrito);
                Thread.sleep(60000);
                
                if (minutos == 59) {
                    minutos = 0;
                    minutoEscrito = "00";
                } else {
                    minutos++;
                    
                    if (minutos < 10) {
                        minutoEscrito = "0"+minutos;
                    } else {
                        minutoEscrito = ""+minutos;
                    }
                }
                
                if (minutos == 0) {
                    if (hora == 23) {
                        hora = 0;
                        horaEscrita = "00";
                    } else {
                        hora++;
                        
                        if (hora < 10) {
                            horaEscrita = "0"+hora;
                        } else {
                            horaEscrita = ""+hora;
                        }
                    }
                }
                
            } catch (InterruptedException ex) {
                System.out.println("Error en el Reloj de tipo: " + ex.getMessage());
            }
        }
    }
    
    private void analizarPrimeraVuelta() {
        if (minutos < 10) {
            minutoEscrito = "0"+minutos;
        } else {
            minutoEscrito = ""+minutos;
        }
        
        if (hora < 10) {
            horaEscrita = "0"+hora;
        } else {
            horaEscrita = ""+hora;
        }
    }
    
    public void detener() {
        seguir = false;
    }
    
    public int getHora() {
        return hora;
    }
}
