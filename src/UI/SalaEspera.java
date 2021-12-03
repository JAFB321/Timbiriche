package UI;

import Controlador.Juego.cliente.ControladorJuego;
import Controlador.Membresia.ControladorMembresia;
import Controlador.Sala.cliente.ControladorSala;
import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;
import UI.eventos.sala.ISalaListener;
import javax.swing.DefaultListModel;

/**
 * Clase que representa la interfaz de la sala de espera.
 * @author Daniel Parra, Jesus Ramses, Jose Felix
 */
public class SalaEspera extends javax.swing.JFrame implements ISalaListener{

    ControladorSala sala = ControladorSala.getInstance();
    ControladorMembresia membresia = ControladorMembresia.getInstance();
    
    // Lista jugadores
    DefaultListModel modeloLista = new DefaultListModel();
    
    public SalaEspera() {
        initComponents();
        setLocationRelativeTo(null); 
        
        sala.listenSalaEvents(this);
        
        listaSalas.setModel(modeloLista);
        
//        grupoBotonesColor.add(radioAzul);
//        grupoBotonesColor.add(radioNegro);
//        grupoBotonesColor.add(radioRojo);
//        grupoBotonesColor.add(radioVerde);
        
        listarJugadores();
    }

    public void listarJugadores(){
        String host = sala.getSala().getHost().getUserName();
        txtHost.setText(host);
        txtUsuario.setText(membresia.jugador.getUserName());
        
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
        btnAbandonar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSalas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAbandonar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnAbandonar.setText("Abandonar");
        btnAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbandonar, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 373, 160, 59));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Nombre de Host:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 135, -1, 16));

        txtHost.setEditable(false);
        txtHost.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 169, 170, -1));

        txtUsuario.setEditable(false);
        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 90, 170, -1));

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
    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        MenuPrincipal form = new MenuPrincipal();
        this.dispose();
        form.setVisible(true);
    }//GEN-LAST:event_btnAbandonarActionPerformed


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
    private javax.swing.JButton btnAbandonar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup grupoBotonesColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaSalas;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtUsuario;
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
    public void on_IniciarJuego(Juego juego) {
        UI.Juego form = new UI.Juego(ControladorJuego.getInstance(), juego);
        this.dispose();
        form.setVisible(true);
    }
}
