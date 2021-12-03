package UI;

import Controlador.Juego.IControladorJuego;
import Timbiriche.estructuras.Casilla;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.Tablero;
import UI.componentes.TableroPanel;
import UI.eventos.juego.IGameEventsListener;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Esta clase representa el panel
 * @author Daniel Parra, Jesus Ramses, Jose Felix
 */
public class Juego extends javax.swing.JFrame implements IGameEventsListener{
    
    IControladorJuego controladorJuego;
    
    ArrayList<JLabel> jugadoresInfo = new ArrayList<>();
    
    public Juego(IControladorJuego controladorJuego, Timbiriche.estructuras.Juego juego) {
        initComponents();
        
        panelTablero.setVisible(false);
        TableroPanel tablero = new TableroPanel(controladorJuego, juego.getTablero());
        tablero.setBounds(0, 0, 530, 577);
        
        this.add(tablero);
        
        setLocationRelativeTo(null); 
        
        lblJugadorTemplate.setVisible(false);
        
        this.controladorJuego = controladorJuego;
        controladorJuego.listenJuegoEvents(this);
        controladorJuego.listenJuegoEvents(tablero);
        
        setJugadores(juego.getJugadores(), juego.getJugadorTurno(), new Casilla[0]);
    }

    public Juego() {
        
    }
    
    private void setJugadores(Jugador[] jugadores, Jugador turno, Casilla[] casillas){
        
        for (Component component : this.getComponents()) {
            
        }
        
        for (int i = 0; i < jugadores.length; i++) {
            Jugador jugador = jugadores[i];
            
            // Puntos
            int puntos = 0;
            for (Casilla casilla : casillas) {
                if(casilla.getJugador().getID().equals(jugador.getID())) puntos++;
            }
            
            JLabel label = new JLabel();
            label.setText(jugador.getUserName()+"   Puntos: "+puntos);
            label.setIcon(lblJugadorTemplate.getIcon());
            
            int newX = lblJugadorTemplate.getX();
            int newY = lblJugadorTemplate.getY()+50*(i);
            int newWidth = lblJugadorTemplate.getWidth();
            int newHeight = lblJugadorTemplate.getHeight();

            label.setBounds(newX, newY, newWidth, newHeight);
            
            
            if(jugador.getID().equals(turno.getID())){
                label.setBackground(Color.LIGHT_GRAY);
            }
            
            switch(jugador.getColor()){
                case "red": label.setForeground(Color.red);
                    break;
                    
                case "green": label.setForeground(Color.green);
                    break;
                 
                case "black": label.setForeground(Color.black);
                    break;
                    
                case "orange": label.setForeground(Color.orange);
                    break;
                    
                case "blue": label.setForeground(Color.blue);
                    break;
            }
            
            label.setToolTipText(jugador.getID());
            label.setVisible(true);
            this.add(label);
            this.jugadoresInfo.add(label);
        }
        

    }
    
    private void actualizarJugadores(Jugador[] jugadores, Jugador turno, Casilla[] casillas){
        
        for (int i = 0; i < jugadores.length; i++) {
            Jugador jugador = jugadores[i];
            
            JLabel label = null;
            
            for (JLabel labelPlayer : this.jugadoresInfo) {
                if (jugador.getID().equals(labelPlayer.getToolTipText())) {
                    label = labelPlayer;
                }

            }

            for (Component component : this.getComponents()) {
                if(component instanceof JLabel){
                    JLabel labelPlayer = (JLabel)component;
                    if(jugador.getID().equals(labelPlayer.getToolTipText())){
                        label = labelPlayer;
                    }
                }
            }
            
            if(label == null) continue;
            
            // Puntos
            int puntos = 0;
            for (Casilla casilla : casillas) {
                if(casilla.getJugador().getID().equals(jugador.getID())) puntos++;
            }
            
            label.setText(jugador.getUserName()+"   Puntos: "+puntos);         
            
            if(jugador.getID().equals(turno.getID())){
                label.setBackground(Color.DARK_GRAY);
            }
            
           
        }
        

    }
    
    
    private void dibujarTablero(){
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        panelTablero = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblJugadorTemplate = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setText("Abandonar partida");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel9.setText("Turno de: Jugador 1");

        lblJugadorTemplate.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblJugadorTemplate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Avatar_default.png.png"))); // NOI18N
        lblJugadorTemplate.setText("Jugador 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblJugadorTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 71, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(29, 29, 29)
                .addComponent(lblJugadorTemplate)
                .addGap(232, 232, 232)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 98, Short.MAX_VALUE))
            .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * El boton de abandonar nos regresa al menu principal.
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuPrincipal form = new MenuPrincipal();
        this.dispose();
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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblJugadorTemplate;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables

    @Override
    public void on_Error(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Ha ocurrido un error", 1);
    }

    @Override
    public void on_LineaTrazada(Jugador jugador, Jugador turno, Tablero tableroActualizado) {
        actualizarJugadores(controladorJuego.getJuego().getJugadores(), turno, tableroActualizado.getCasillas());
    }
}
