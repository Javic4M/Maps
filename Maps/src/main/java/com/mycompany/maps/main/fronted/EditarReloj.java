package com.mycompany.maps.main.fronted;

public class EditarReloj extends javax.swing.JDialog {

    public EditarReloj(java.awt.Frame parent) {
        super(parent, true);
        this.setTitle("Edición");
        this.setLocationRelativeTo(this);
        initComponents();
        mostrarValores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboHora = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboMinutos = new javax.swing.JComboBox<>();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Hora");

        jLabel2.setText("Seleccione una Hora:");

        jLabel3.setText("Seleccione los minutos:");

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboMinutos, 0, 150, Short.MAX_VALUE)
                            .addComponent(comboHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAceptar)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void mostrarValores() {
        // Hora
        comboHora.addItem("00"); comboHora.addItem("01"); comboHora.addItem("02"); comboHora.addItem("03"); comboHora.addItem("04"); comboHora.addItem("05"); comboHora.addItem("06"); comboHora.addItem("07"); comboHora.addItem("08"); comboHora.addItem("09");
        comboHora.addItem("10"); comboHora.addItem("11"); comboHora.addItem("12"); comboHora.addItem("13"); comboHora.addItem("14"); comboHora.addItem("15"); comboHora.addItem("16"); comboHora.addItem("17"); comboHora.addItem("18"); comboHora.addItem("19");
        comboHora.addItem("20"); comboHora.addItem("21"); comboHora.addItem("22"); comboHora.addItem("23");
        // Minutos
        comboMinutos.addItem("00"); comboMinutos.addItem("01"); comboMinutos.addItem("02"); comboMinutos.addItem("03"); comboMinutos.addItem("04"); comboMinutos.addItem("05"); comboMinutos.addItem("06"); comboMinutos.addItem("07"); comboMinutos.addItem("08"); comboMinutos.addItem("09");
        comboMinutos.addItem("10"); comboMinutos.addItem("11"); comboMinutos.addItem("12"); comboMinutos.addItem("13"); comboMinutos.addItem("14"); comboMinutos.addItem("15"); comboMinutos.addItem("16"); comboMinutos.addItem("17"); comboMinutos.addItem("18"); comboMinutos.addItem("19");
        comboMinutos.addItem("20"); comboMinutos.addItem("21"); comboMinutos.addItem("22"); comboMinutos.addItem("23"); comboMinutos.addItem("24"); comboMinutos.addItem("25"); comboMinutos.addItem("26"); comboMinutos.addItem("27"); comboMinutos.addItem("28"); comboMinutos.addItem("29");
        comboMinutos.addItem("30"); comboMinutos.addItem("31"); comboMinutos.addItem("32"); comboMinutos.addItem("33"); comboMinutos.addItem("34"); comboMinutos.addItem("35"); comboMinutos.addItem("36"); comboMinutos.addItem("37"); comboMinutos.addItem("38"); comboMinutos.addItem("39");
        comboMinutos.addItem("40"); comboMinutos.addItem("41"); comboMinutos.addItem("42"); comboMinutos.addItem("43"); comboMinutos.addItem("44"); comboMinutos.addItem("45"); comboMinutos.addItem("46"); comboMinutos.addItem("47"); comboMinutos.addItem("48"); comboMinutos.addItem("49");
        comboMinutos.addItem("50"); comboMinutos.addItem("51"); comboMinutos.addItem("52"); comboMinutos.addItem("53"); comboMinutos.addItem("54"); comboMinutos.addItem("55"); comboMinutos.addItem("56"); comboMinutos.addItem("57"); comboMinutos.addItem("58"); comboMinutos.addItem("59");
    }
    
    public int getHora() {
        String hora = (String) comboHora.getSelectedItem();
        return Integer.parseInt(hora);
    }
    
    public int getMinutos() {
        String minuto = (String) comboMinutos.getSelectedItem();
        return Integer.parseInt(minuto);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JComboBox<String> comboHora;
    private javax.swing.JComboBox<String> comboMinutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
