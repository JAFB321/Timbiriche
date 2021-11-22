package UI;

import Controlador.Membresia.ControladorMembresia;
import Controlador.Sala.server.ControladorSalaHost;
import Timbiriche.estructuras.JugadorHost;

/**
 * Clase que reprsenta la interfaz para crear una sala.
 * @author Daniel Parra, Jesus Ramses, Jose Felix
 */
public class CrearSala extends javax.swing.JFrame {

    ControladorSalaHost salaHost = ControladorSalaHost.getInstance();
    ControladorMembresia membresia = ControladorMembresia.getInstance();
    
    public CrearSala() {
        initComponents();
        setLocationRelativeTo(null); 
        
        
        grupo_jugadores.add(nJugadores2);
        grupo_jugadores.add(nJugadores3);
        grupo_jugadores.add(nJugadores4);
        
        grupo_tamano.add(tamaño20);
        grupo_tamano.add(tamaño40);
        grupo_tamano.add(tamaño10);
        
        nJugadores2.setActionCommand("2");
        nJugadores3.setActionCommand("3");
        nJugadores4.setActionCommand("4");
        
        tamaño10.setActionCommand("10");
        tamaño20.setActionCommand("20");
        tamaño40.setActionCommand("40");
        
        nJugadores2.setSelected(true);
        tamaño10.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_jugadores = new javax.swing.ButtonGroup();
        grupo_tamano = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        txtNombreSala = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tamaño40 = new javax.swing.JRadioButton();
        tamaño10 = new javax.swing.JRadioButton();
        tamaño20 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        nJugadores4 = new javax.swing.JRadioButton();
        nJugadores3 = new javax.swing.JRadioButton();
        nJugadores2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 296, 218, 55));

        txtNombreSala.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreSala.setText("localhost");
        jPanel1.add(txtNombreSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 88, 219, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Nombre de la sala:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 58, -1, -1));

        tamaño40.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tamaño40.setText("40x40");
        tamaño40.setOpaque(false);
        tamaño40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamaño40ActionPerformed(evt);
            }
        });
        jPanel1.add(tamaño40, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 237, -1, -1));

        tamaño10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tamaño10.setText("10x10");
        tamaño10.setOpaque(false);
        tamaño10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamaño10ActionPerformed(evt);
            }
        });
        jPanel1.add(tamaño10, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 237, -1, -1));

        tamaño20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tamaño20.setText("20x20");
        tamaño20.setOpaque(false);
        tamaño20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamaño20ActionPerformed(evt);
            }
        });
        jPanel1.add(tamaño20, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 237, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Tamaño del tablero:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 201, -1, -1));

        grupo_jugadores.add(nJugadores4);
        nJugadores4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nJugadores4.setText("4");
        nJugadores4.setOpaque(false);
        nJugadores4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nJugadores4ActionPerformed(evt);
            }
        });
        jPanel1.add(nJugadores4, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 157, -1, -1));

        grupo_jugadores.add(nJugadores3);
        nJugadores3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nJugadores3.setText("3");
        nJugadores3.setOpaque(false);
        nJugadores3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nJugadores3ActionPerformed(evt);
            }
        });
        jPanel1.add(nJugadores3, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 157, -1, -1));

        grupo_jugadores.add(nJugadores2);
        nJugadores2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nJugadores2.setText("2");
        nJugadores2.setOpaque(false);
        jPanel1.add(nJugadores2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 157, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Numero de jugadores:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 127, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Crear sala");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 12, 186, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Fondo.jpg"))); // NOI18N
        jLabel5.setAutoscrolls(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nJugadores3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nJugadores3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nJugadores3ActionPerformed

    private void nJugadores4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nJugadores4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nJugadores4ActionPerformed

    private void tamaño20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamaño20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamaño20ActionPerformed

    private void tamaño40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamaño40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamaño40ActionPerformed

    private void tamaño10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamaño10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamaño10ActionPerformed

    /**
     * Nos lleva a la interfaz de sala de espera.
     * @param evt 
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        String sala = txtNombreSala.getText();
        int tamaño = Integer.parseInt(grupo_tamano.getSelection().getActionCommand());
        int nJugadores = Integer.parseInt(grupo_jugadores.getSelection().getActionCommand());
        
        salaHost.CrearSala(sala, nJugadores, tamaño, new JugadorHost(membresia.jugador));
        
        SalaEsperaHost form = new SalaEsperaHost();
        this.setVisible(false);
        form.setVisible(true);
    }//GEN-LAST:event_btnAceptarActionPerformed


    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearSala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup grupo_jugadores;
    private javax.swing.ButtonGroup grupo_tamano;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton nJugadores2;
    private javax.swing.JRadioButton nJugadores3;
    private javax.swing.JRadioButton nJugadores4;
    private javax.swing.JRadioButton tamaño10;
    private javax.swing.JRadioButton tamaño20;
    private javax.swing.JRadioButton tamaño40;
    private javax.swing.JTextField txtNombreSala;
    // End of variables declaration//GEN-END:variables
}
