package UI;

import Controlador.Membresia.ControladorMembresia;
import Controlador.Sala.Sala;
import Controlador.Sala.cliente.ControladorSala;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Clase que representa la interfaz grafica para buscar una sala.
 *
 * @author Daniel Parra, Jesus Ramses, Jose Felix
 */
public class BuscarSala extends javax.swing.JFrame {

    ControladorSala sala = ControladorSala.getInstance();
    ControladorMembresia membresia = ControladorMembresia.getInstance();


    public BuscarSala() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnUnirme = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtIPSala = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("Nombre de usuario:");

        jTextField1.setText("user");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUnirme.setText("Unirme");
        btnUnirme.setOpaque(false);
        btnUnirme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnirmeActionPerformed(evt);
            }
        });
        jPanel1.add(btnUnirme, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 317, 107, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Ingrese IP de la sala:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.setOpaque(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 317, 107, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Buscar sala");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 21, 480, -1));

        txtIPSala.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtIPSala.setText("[IP de la sala]");
        jPanel1.add(txtIPSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 300, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nos regresa a la pantalla anterior. (Menu Principal)
     *
     * @param evt
     */
    private void btnUnirmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnirmeActionPerformed

        if (txtIPSala.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay salas disponible con la IP dada.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        boolean conectado = sala.solicitarUnirseSala(membresia.jugador, txtIPSala.getText());

        if (conectado) {
            SalaEspera form = new SalaEspera();
            this.dispose();
            form.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No has podido unirte a la sala", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnUnirmeActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuPrincipal form = new MenuPrincipal();
        this.dispose();
        form.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarSala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnUnirme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtIPSala;
    // End of variables declaration//GEN-END:variables
}
