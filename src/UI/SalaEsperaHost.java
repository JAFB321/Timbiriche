package UI;

import Controlador.Juego.cliente.ControladorJuego;
import Controlador.Juego.server.ControladorJuegoHost;
import Controlador.Membresia.ControladorMembresia;
import Controlador.Sala.server.ControladorSalaHost;
import Timbiriche.estructuras.Jugador;
import UI.eventos.sala.ISalaHostListener;
import UI.eventos.sala.ISalaListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Clase que representa la interfaz de la sala de espera.
 * @author Daniel Parra, Jesus Ramses, Jose Felix
 */
public class SalaEsperaHost extends javax.swing.JFrame implements ISalaHostListener, ISalaListener{

    ControladorSalaHost sala = ControladorSalaHost.getInstance();
    ControladorMembresia membresia = ControladorMembresia.getInstance();
    
    // Lista jugadores
    DefaultListModel modeloLista = new DefaultListModel();
    
    public SalaEsperaHost() {
        initComponents();
        setLocationRelativeTo(null); 
        
        sala.listenSalaEvents(this);
        sala.listenSalaHostEvents(this);
        
        listaSalas.setModel(modeloLista);
        
        grupoBotonesColor.add(radioAzul);
        grupoBotonesColor.add(radioNegro);
        grupoBotonesColor.add(radioRojo);
        grupoBotonesColor.add(radioVerde);
        
        listarJugadores();
    }

    public void listarJugadores(){
        String host = sala.getSala().getHost().getUserName();
        txtHost.setText(host);
        
        modeloLista.clear();
        for (Jugador a : sala.getSala().getJugadores()) {
            modeloLista.addElement(a.getUserName());
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonesColor = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnContinuar = new javax.swing.JButton();
        radioAzul = new javax.swing.JRadioButton();
        radioNegro = new javax.swing.JRadioButton();
        radioVerde = new javax.swing.JRadioButton();
        radioRojo = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSalas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnContinuar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 373, 160, 59));

        radioAzul.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioAzul.setForeground(new java.awt.Color(0, 51, 204));
        radioAzul.setText("Azul");
        radioAzul.setOpaque(false);
        jPanel1.add(radioAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        radioNegro.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioNegro.setText("Negro");
        radioNegro.setOpaque(false);
        jPanel1.add(radioNegro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        radioVerde.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioVerde.setForeground(new java.awt.Color(0, 153, 0));
        radioVerde.setText("Verde");
        radioVerde.setOpaque(false);
        jPanel1.add(radioVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        radioRojo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioRojo.setForeground(new java.awt.Color(204, 0, 51));
        radioRojo.setText("Rojo");
        radioRojo.setOpaque(false);
        jPanel1.add(radioRojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Selecciona un color:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Nombre de Host:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 16));

        txtHost.setEditable(false);
        txtHost.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 170, -1));

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
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        if(sala.IniciarJuego()){
            Juego form = new Juego(ControladorJuegoHost.getInstance());
            this.dispose();
            form.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(this, "No se ha podido iniciar el juego");
        }
    }//GEN-LAST:event_btnContinuarActionPerformed


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
            java.util.logging.Logger.getLogger(SalaEsperaHost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalaEsperaHost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalaEsperaHost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalaEsperaHost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalaEsperaHost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup grupoBotonesColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaSalas;
    private javax.swing.JRadioButton radioAzul;
    private javax.swing.JRadioButton radioNegro;
    private javax.swing.JRadioButton radioRojo;
    private javax.swing.JRadioButton radioVerde;
    private javax.swing.JTextField txtHost;
    // End of variables declaration//GEN-END:variables


    @Override
    public void on_JugadorNuevo(Jugador jugador) {
        listarJugadores();
    }

    @Override
    public void on_JugadorAbandono(Jugador jugador) {
        listarJugadores();
    }

    @Override
    public void on_IniciarJuego(Timbiriche.estructuras.Juego juego) {
        
    }
}
