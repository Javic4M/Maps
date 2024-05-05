package com.mycompany.maps.main.fronted;

import com.mycompany.maps.main.archivos.ImportarDestinosYTrafico;
import com.mycompany.maps.main.clases.Acciones;
import com.mycompany.maps.main.clases.DatoDos;
import com.mycompany.maps.main.clases.DatoUno;
import com.mycompany.maps.main.clases.InformacionRecorrido;
import com.mycompany.maps.main.clases.Lugar;
import com.mycompany.maps.main.grafica.GraficaArbol;
import com.mycompany.maps.main.grafica.GraficaMapa;
import com.mycompany.maps.main.reloj.Reloj;
import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MapaFrame extends javax.swing.JFrame {

    private List<Lugar> lugares;
    private List<Lugar> lugaresDobles;
    private List<InformacionRecorrido> informaciones;
    private List<String> caminos;
    private DatoUno[] desgastes, distancias;
    private DatoDos[] desgasteYDistancia, rapidez;
    private boolean caminarSeleccionado = false, vehiculoSeleccionado = false, relojBloqueado = false;
    private Reloj reloj;
    private int horaComienzo = 0;
    private String origen = "";
    
    public MapaFrame() {
        initComponents();
        this.setTitle("Maps");
        this.setLocationRelativeTo(null);
        this.lugares = new ArrayList<>();
        this.lugaresDobles = new ArrayList<>();
        this.informaciones = new ArrayList<>();
        this.caminos = new ArrayList<>();
        //labelMapa.setPreferredSize(new Dimension(748, 405));
        botonCaminar.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/mycompany/maps/main/fronted/person.png")).getImage().getScaledInstance(-1, -1, java.awt.Image.SCALE_SMOOTH)));
        botonCarro.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/mycompany/maps/main/fronted/car.png")).getImage().getScaledInstance(-1, -1, java.awt.Image.SCALE_SMOOTH)));
        activarODesactivarControles(true, false);
        opciones.setEditable(false);
        activarReloj();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        botonCaminar = new javax.swing.JButton();
        botonCarro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        iniciarViaje = new javax.swing.JButton();
        comboOrigen = new javax.swing.JComboBox<>();
        comboDestino = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        opciones = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        botonSiguiente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        comboSiguiente = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        labelRelojMostrar = new javax.swing.JLabel();
        botonRestaurarHora = new javax.swing.JButton();
        botonEditarHora = new javax.swing.JButton();
        botonBloquearHora = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        labelMapa = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cargarDestinos = new javax.swing.JMenuItem();
        cargarTrafico = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        visualizar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuracion"));

        botonCaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCaminarActionPerformed(evt);
            }
        });

        botonCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCarroActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecciona el Origen:");

        jLabel2.setText("Selecciona el Destino:");

        jLabel3.setText("Seleccionar Desplazamiento:");

        iniciarViaje.setText("Iniciar Viaje");
        iniciarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarViajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(iniciarViaje))
                    .addComponent(comboOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(botonCaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonCarro, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(botonCaminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(iniciarViaje)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jScrollPane1.setViewportView(opciones);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar"));

        botonSiguiente.setText("Siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Seleccionar el camino a tomar:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(botonSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboSiguiente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonSiguiente)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora"));

        labelRelojMostrar.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N

        botonRestaurarHora.setText("Resturar");
        botonRestaurarHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestaurarHoraActionPerformed(evt);
            }
        });

        botonEditarHora.setText("Editar");
        botonEditarHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarHoraActionPerformed(evt);
            }
        });

        botonBloquearHora.setText("Bloquear");
        botonBloquearHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBloquearHoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRelojMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonEditarHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonBloquearHora, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(botonRestaurarHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRelojMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonRestaurarHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEditarHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBloquearHora, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane2.setBorder(null);
        jScrollPane2.setViewportView(labelMapa);

        jMenu1.setText("Cargar Archivos");

        cargarDestinos.setText("Cargar Destinos");
        cargarDestinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDestinosActionPerformed(evt);
            }
        });
        jMenu1.add(cargarDestinos);

        cargarTrafico.setText("Cargar Trafico");
        cargarTrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarTraficoActionPerformed(evt);
            }
        });
        jMenu1.add(cargarTrafico);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Arbol");

        visualizar.setText("Visualizar");
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });
        jMenu2.add(visualizar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarDestinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDestinosActionPerformed
        JFileChooser jFileChooser = new JFileChooser();

        int respuesta = jFileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            String path = jFileChooser.getSelectedFile().getPath();               
            ImportarDestinosYTrafico importar = new ImportarDestinosYTrafico(lugares, lugaresDobles, informaciones);
            importar.cargarDestinos(path);
            importar.cargarDestinosDobles(path);
            mostrarCombos();
            colocarImagen(1);
        } else {
            JOptionPane.showMessageDialog(this,"Debe seleccionar una Archivo a Leer","Archivo",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cargarDestinosActionPerformed

    private void botonCaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCaminarActionPerformed
        caminarSeleccionado = true; vehiculoSeleccionado = false;
        botonCaminar.setEnabled(false);
        botonCarro.setEnabled(true);
    }//GEN-LAST:event_botonCaminarActionPerformed

    private void botonCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCarroActionPerformed
        caminarSeleccionado = false; vehiculoSeleccionado = true;
        botonCarro.setEnabled(false);
        botonCaminar.setEnabled(true);
    }//GEN-LAST:event_botonCarroActionPerformed

    private void iniciarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarViajeActionPerformed
        if (!lugares.isEmpty()) {
            if (relojBloqueado) {
                if (!getNombreOrigen().equals(getNombreDestino())) {
                    if (caminarSeleccionado || vehiculoSeleccionado) {
                        boolean respuesta = recalcularDatos(getNombreOrigen());
                        
                        if (respuesta) {
                            activarODesactivarControles(false, true);
                            origen = getNombreOrigen();
                        }
                    } else { JOptionPane.showMessageDialog(this,"Elige un método de Viaje","Viaje",JOptionPane.ERROR_MESSAGE); }
                } else { JOptionPane.showMessageDialog(this,"No puedes seleccionar el mismo Lugar de Origen","Error",JOptionPane.ERROR_MESSAGE); }
            } else { JOptionPane.showMessageDialog(this,"Debes Bloquear el Reloj para establecer una Hora","Error",JOptionPane.ERROR_MESSAGE); }
        } else { JOptionPane.showMessageDialog(this,"Debes Cargar un Archivo para poder Seleccionar","Error",JOptionPane.ERROR_MESSAGE); }
    }//GEN-LAST:event_iniciarViajeActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        if (getNombreLugarEscogido().equals(getNombreDestino())) {
            JOptionPane.showMessageDialog(this,"Ha llegado a su Destino","Final",JOptionPane.INFORMATION_MESSAGE);
            actualizarHora();
            activarODesactivarControles(true, false);
            caminarSeleccionado = false; vehiculoSeleccionado = false; relojBloqueado = false;
            botonRestaurarHora.setEnabled(true); botonEditarHora.setEnabled(true); botonBloquearHora.setEnabled(true);
            Acciones accion = new Acciones();
            accion.desmarcarCaminos(lugares);
            comboSiguiente.removeAllItems();
            opciones.setText("");
            
            if (caminarSeleccionado) {
                for (Lugar lugarDoble : lugaresDobles) {
                    lugarDoble.setPasado(false);
                }
            } else {
                for (Lugar lugar : lugares) {
                    lugar.setPasado(false);
                }
            }
            
            colocarImagen(1);
        } else {
            if (caminarSeleccionado) {
                for (Lugar lugarDoble : lugaresDobles) {
                    if (lugarDoble.getNombre().equals(origen)) {
                        lugarDoble.setPasado(true);
                    }
                }   
            } else {
                for (Lugar lugar : lugares) {
                    if (lugar.getNombre().equals(origen)) {
                        lugar.setPasado(true);
                    }
                }
            }
            actualizarHora();
            recalcularDatos(getNombreLugarEscogido());
        }
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonRestaurarHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaurarHoraActionPerformed
        reloj.detener();
        activarReloj();
    }//GEN-LAST:event_botonRestaurarHoraActionPerformed

    private void botonEditarHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarHoraActionPerformed
        reloj.detener();
        EditarReloj editarReloj = new EditarReloj(this);
        editarReloj.setVisible(true);
        int horas = editarReloj.getHora();
        int minutos = editarReloj.getMinutos();
        reloj = new Reloj(labelRelojMostrar, horas, minutos);
        reloj.start();
    }//GEN-LAST:event_botonEditarHoraActionPerformed

    private void botonBloquearHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBloquearHoraActionPerformed
        String obtenerHora = labelRelojMostrar.getText();
        reloj.detener();
        String[] partesHora = obtenerHora.split(":");
        horaComienzo = Integer.parseInt(partesHora[0]);
        relojBloqueado = true;
        botonRestaurarHora.setEnabled(false); botonEditarHora.setEnabled(false); botonBloquearHora.setEnabled(false);
    }//GEN-LAST:event_botonBloquearHoraActionPerformed

    private void cargarTraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarTraficoActionPerformed
        JFileChooser jFileChooser = new JFileChooser();

        int respuesta = jFileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            String path = jFileChooser.getSelectedFile().getPath();               
            ImportarDestinosYTrafico importar = new ImportarDestinosYTrafico(lugares, lugaresDobles, informaciones);
            importar.cargarTrafico(path);
        } else {
            JOptionPane.showMessageDialog(this,"Debe seleccionar una Archivo a Leer","Archivo",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cargarTraficoActionPerformed

    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
        try {
            if (!caminos.isEmpty()) {
                GraficaArbol arbol = new GraficaArbol(caminos);
                arbol.generarImagen();
                Thread.sleep(2000);
                ArbolFrame frame = new ArbolFrame(this);
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this,"No hay rutas para mostrar","Error",JOptionPane.ERROR_MESSAGE);
            }
        } catch (InterruptedException ex) {
            System.out.println("Error al mostrar el Arbol de tipo: " + ex.getMessage());
        }
    }//GEN-LAST:event_visualizarActionPerformed
    
    private void actualizarHora() {
        for (InformacionRecorrido informacion : informaciones) {
            if ((informacion.getOrigen().equals(origen) &&  informacion.getDestino().equals(getNombreLugarEscogido())) || (informacion.getOrigen().equals(getNombreLugarEscogido()) &&  informacion.getDestino().equals(origen))) {
                String obtenerHora = labelRelojMostrar.getText();
                String[] partesHora = obtenerHora.split(":");
                String horaEscrita = "", minutoEscrito = "";
                int minutosASumar = 0;

                if (caminarSeleccionado) {
                    minutosASumar += informacion.getTiempoPersona();
                } else {
                    minutosASumar += informacion.getTiempoVehiculo();
                }
                int horasActuales = Integer.parseInt(partesHora[0]);  
                int minutosActuales = Integer.parseInt(partesHora[1]);  

                minutosActuales += minutosASumar;

                while (minutosActuales >= 60) {
                    minutosActuales -= 60;
                    horasActuales++;
                }

                int extra = 0;

                while (horasActuales > 24) {
                    horasActuales--;
                    extra++;
                }
                if (horasActuales == 24) {
                    horasActuales = extra;
                }

                if (horasActuales < 10) {
                    horaEscrita = "0"+horasActuales;
                } else {
                    horaEscrita = ""+horasActuales;
                }

                if (minutosActuales < 10) {
                    minutoEscrito = "0"+minutosActuales;
                } else {
                    minutoEscrito = ""+minutosActuales;
                }
                labelRelojMostrar.setText(horaEscrita + ":" + minutoEscrito);
                origen = getNombreLugarEscogido();
            }
        }
    }
    
    private boolean recalcularDatos(String origen) {
        Lugar lugarOrigen = null;
        List<Lugar> opciones;
                
        if (caminarSeleccionado) {
            opciones = lugaresDobles;
        } else {
            opciones = lugares;
        }
        
        for (Lugar lugar : opciones) {
            if (lugar.getNombre().equals(origen)) {
                lugarOrigen = lugar;
                break;
            }
        }
        caminos = new ArrayList<>();
        Acciones accion = new Acciones();     
        accion.establecerCaminos(lugarOrigen, getNombreDestino(), lugarOrigen.getNombre(), caminos);

        if (!caminos.isEmpty()) {
            
            for (Lugar lugar : opciones) {
                lugar.setVisitado(false);
            }

            accion.marcarCaminos(opciones, caminos);
            
            if (caminarSeleccionado) {
                colocarImagen(2);
            } else {
                colocarImagen(1);
            }
            
            
            if (caminarSeleccionado) {
                accion.calcularCaminando(caminos, informaciones);
            } else {
                accion.calcularEnVehiculo(caminos, informaciones, horaComienzo);
            }
            
            if (!caminos.isEmpty()) {
                desgastes = accion.getDesgaste();
                distancias = accion.getDistancia();
                desgasteYDistancia = accion.getDesgasteYDistancia();
                rapidez = accion.getRapidez();
                mostrarOpciones();
                mostrarSiguiente();
            }
            return true;
        } else {
            JOptionPane.showMessageDialog(this,"No hay conexión entre el Origen y el Desino","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void mostrarCombos() {
        comboOrigen.setEnabled(true); comboDestino.setEnabled(true);
        comboOrigen.removeAll(); comboDestino.removeAll();
        
        for (Lugar lugar : lugares) {
            comboOrigen.addItem(lugar.getNombre());
            comboDestino.addItem(lugar.getNombre());
        }
    }
    
    private void mostrarOpciones() {
        String contenido = "";
        contenido += "Mejores rutas por:\n";
        contenido += "\t1) Desgaste: " + desgastes[0].getRuta() + " -> " + desgastes[0].getCantidad() + " RPE\n";
        contenido += "\t2) Distancia: " + distancias[0].getRuta() + " -> " + distancias[0].getCantidad() + " km\n";
        contenido += "\t3) Desgaste y Distancia: " + desgasteYDistancia[desgasteYDistancia.length-1].getRuta() + " -> " + desgasteYDistancia[desgasteYDistancia.length-1].getCantidadDecimal()+ " km/RPE\n";
        contenido += "\t4) Rapidez: " + rapidez[rapidez.length-1].getRuta() + " -> " + rapidez[rapidez.length-1].getCantidadDecimal()+ " km/h\n";
        contenido += "\n";
        contenido += "Peores rutas por:\n";
        contenido += "\t1) Desgaste: " + desgastes[desgastes.length-1].getRuta() + " -> " + desgastes[desgastes.length-1].getCantidad() + " RPE\n";
        contenido += "\t2) Distancia: " + distancias[distancias.length-1].getRuta() + " -> " + distancias[distancias.length-1].getCantidad() + " km\n";
        contenido += "\t3) Desgaste y Distancia: " + desgasteYDistancia[0].getRuta() + " -> " + desgasteYDistancia[0].getCantidadDecimal()+ " km/RPE\n";
        contenido += "\t4) Rapidez: " + rapidez[0].getRuta() + " -> " + rapidez[0].getCantidadDecimal()+ " km/h";
        contenido += "\n";
        opciones.setText("");
        opciones.setText(contenido);
    }
    
    private void mostrarSiguiente() {
        List<String> siguientes = new ArrayList<>();
        comboSiguiente.removeAllItems();
        
        for (String camino : caminos) {
            String partes[] = camino.split(",");
            boolean pasar = true;
            
            for (String siguiente : siguientes) {
                if (siguiente.equals(partes[1])) {
                    pasar = false;
                    break;
                }
            }
            if (pasar) {
                comboSiguiente.addItem(partes[1]);
                siguientes.add(partes[1]);
            }
        }
    }
    
    private void activarODesactivarControles(boolean estado, boolean estado2) {
        comboOrigen.setEnabled(estado);
        comboDestino.setEnabled(estado);
        botonCaminar.setEnabled(estado);
        botonCarro.setEnabled(estado);
        iniciarViaje.setEnabled(estado);
        comboSiguiente.setEnabled(estado2);
        botonSiguiente.setEnabled(estado2);
    }
    
    private void colocarImagen(int numero) {
        try {
            File file = new File("ImagenMapa.png");
            file.delete();
            GraficaMapa grafica = new GraficaMapa(lugares, lugaresDobles);
            grafica.generarImagen(numero);  
            file = new File("ImagenMapa.png");

            while (true) {
                if (file.exists()) {
                    Thread.sleep(2000);  
                    labelMapa.setIcon(new ImageIcon(new ImageIcon("ImagenMapa.png").getImage().getScaledInstance(-1, -1, java.awt.Image.SCALE_SMOOTH)));
                    break;
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("Error durante la Espera de tipo: " + ex.getMessage());
        }
    }
    
    private void activarReloj() {
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm");
        String horaFormateada = horaActual.format(formateador);
        String partes[] = horaFormateada.split(":");
        reloj = new Reloj(labelRelojMostrar, Integer.parseInt(partes[0]), Integer.parseInt(partes[1]));
        reloj.start();
    }
    
    private String getNombreOrigen() {
        return (String) comboOrigen.getSelectedItem();
    }
    
    private String getNombreDestino() {
        return (String) comboDestino.getSelectedItem();
    }
    
    private String getNombreLugarEscogido() {
        return (String) comboSiguiente.getSelectedItem();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBloquearHora;
    private javax.swing.JButton botonCaminar;
    private javax.swing.JButton botonCarro;
    private javax.swing.JButton botonEditarHora;
    private javax.swing.JButton botonRestaurarHora;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JMenuItem cargarDestinos;
    private javax.swing.JMenuItem cargarTrafico;
    private javax.swing.JComboBox<String> comboDestino;
    private javax.swing.JComboBox<String> comboOrigen;
    private javax.swing.JComboBox<String> comboSiguiente;
    private javax.swing.JButton iniciarViaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelMapa;
    private javax.swing.JLabel labelRelojMostrar;
    private javax.swing.JTextPane opciones;
    private javax.swing.JMenuItem visualizar;
    // End of variables declaration//GEN-END:variables
}
