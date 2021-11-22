package UI;

/**
 * Clase que representa la interfaz de la sala de espera.
 * @author Daniel Parra, Jesus Ramses, Jose Felix
 */
public class SalaEspera extends javax.swing.JFrame {

    public SalaEspera() {
        initComponents();
        setLocationRelativeTo(null); 
        
        
        grupoBotonesColor.add(radioAzul);
        grupoBotonesColor.add(radioNegro);
        grupoBotonesColor.add(radioRojo);
        grupoBotonesColor.add(radioVerde);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonesColor = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        radioAzul = new javax.swing.JRadioButton();
        radioNegro = new javax.swing.JRadioButton();
        radioVerde = new javax.swing.JRadioButton();
        radioRojo = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSalas = new javax.swing.JList<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 373, 160, 59));

        radioAzul.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioAzul.setForeground(new java.awt.Color(0, 51, 204));
        radioAzul.setText("Azul");
        radioAzul.setOpaque(false);
        jPanel1.add(radioAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 314, -1, -1));

        radioNegro.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioNegro.setText("Negro");
        radioNegro.setOpaque(false);
        jPanel1.add(radioNegro, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 314, -1, -1));

        radioVerde.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioVerde.setForeground(new java.awt.Color(0, 153, 0));
        radioVerde.setText("Verde");
        radioVerde.setOpaque(false);
        jPanel1.add(radioVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 250, -1, -1));

        radioRojo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioRojo.setForeground(new java.awt.Color(204, 0, 51));
        radioRojo.setText("Rojo");
        radioRojo.setOpaque(false);
        jPanel1.add(radioRojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Selecciona un color:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 208, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Nombre de Host:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 135, -1, 16));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField2.setText("user");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 169, 170, -1));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField1.setText("user");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 90, 170, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Nombre de usuario:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 60, -1, -1));

        listaSalas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(listaSalas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 118, 177, 190));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Jugadores");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sala de espera");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 6, 670, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 490));

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
     * Boton que nos manda directamente a la interfaz para empezar a jugar.
     * (Para el creador de la sala)
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Juego form = new Juego();
        this.setVisible(false);
        form.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


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
            java.util.logging.Logger.getLogger(SalaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalaEspera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup grupoBotonesColor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JList<String> listaSalas;
    private javax.swing.JRadioButton radioAzul;
    private javax.swing.JRadioButton radioNegro;
    private javax.swing.JRadioButton radioRojo;
    private javax.swing.JRadioButton radioVerde;
    // End of variables declaration//GEN-END:variables
}