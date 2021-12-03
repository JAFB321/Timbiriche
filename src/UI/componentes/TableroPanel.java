package UI.componentes;

import Controlador.Juego.IControladorJuego;
import Timbiriche.estructuras.Casilla;
import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.Linea;
import Timbiriche.estructuras.Punto;
import Timbiriche.estructuras.Tablero;
import UI.eventos.juego.IGameEventsListener;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.plaf.BorderUIResource;
import javax.swing.text.StyleConstants;

/**
 * Clase que representa un tablero para el juego.
 *
 * @author Daniel Parra, Jesus Ramses, Jose Felix
 */
public class TableroPanel extends javax.swing.JPanel implements IGameEventsListener{

    List<JPunto> puntos = new ArrayList<>();
    private Punto A = null;
    private Punto B = null;


    IControladorJuego controladorJuego;
    
    
    public TableroPanel(IControladorJuego controladorJuego, Tablero tablero) {
        initComponents();
        this.controladorJuego = controladorJuego;
        initTablero(tablero);
    }

    
    private void initTablero(Tablero tablero){
        
        int filas = tablero.getAlto();
        int columnas = tablero.getAncho();
        int espacio = this.getSize().width-10/columnas;
        // orden de los parametros: filas, columnas, espacio horizontal, espacio vertical
        // lo importante seria nomas cambiar las filas y las columnas dependiendo del tamaño del tablero
        GridLayout layout = new GridLayout(filas, columnas, espacio, espacio);
        
        // Establece GridLayout como el Layout del panel.
        this.setLayout(layout);
        // La orientacion es practicamente el como va a acomodar los elementos
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        // ejemplo de 10x10 se añaden 100 elementos
        // ya nomas para el de 20x20 serian pues 400 y asi
        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                
                final int _x = x;
                final int _y = y;
                
                JPunto punto = new JPunto(x, y);
                punto.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleTrazarLinea(_x, _y);
                    }
                });

                punto.setVisible(true);
                this.add(punto);
                puntos.add(punto);
                
            }
        }

        this.revalidate();
        
       
    }
    
    private void handleTrazarLinea(int x, int y){
        if(A == null){
            definirPuntoA(x, y);
        }
        else if(B == null){
            definirPuntoB(x, y);
            solicitarTrazarLinea();
        }
    }
    
    private void definirPuntoA(int x, int y){
        A = new Punto(x, y);
    }
    
    private void definirPuntoB(int x, int y){
        B = new Punto(x, y);
    }
    
    private void solicitarTrazarLinea(){
        controladorJuego.trazarLinea(A, B);
        
        A = null;
        B = null;
    }
    
    public void reDibujarLineas(Tablero tablero) {
        for (Linea linea : tablero.getLineas()) {
            JPunto[] jPuntos = getJPuntos(linea.getPuntoA(), linea.getPuntoB());
            
            JPunto ptA = jPuntos[0];
            JPunto ptB = jPuntos[1];
            
            int offset = ptA.getWidth()/2;
            
            addLine(ptA.getX()+offset, ptA.getY()+offset, ptB.getX()+offset, ptB.getY()+offset, this.getGraphics());
        }
    }
    
    public void redibujarCasillas(Tablero tablero){
        for (Casilla casilla : tablero.getCasillas()) {
            JPunto pA = getJPunto(casilla.getPuntoA());
            JPunto pB = getJPunto(casilla.getPuntoB());
            JPunto pC = getJPunto(casilla.getPuntoC());
            JPunto pD = getJPunto(casilla.getPuntoD());
            
            int x = pA.getX();
            
            if(pB.getX() < x)x = pB.getX();
            if(pC.getX() < x)x = pC.getX();
            if(pD.getX() < x)x = pD.getX();
            
            int y = pA.getY();
            
            if(pB.getY() < y)y = pB.getY();
            if(pC.getY() < y)y = pC.getY();
            if(pD.getY() < y)y = pD.getY();
            
            addCasilla(x+ pA.getWidth()/2, y+pA.getHeight()/2, pA.getWidth(), pA.getHeight(), this.getGraphics(), Color.LIGHT_GRAY);
        }
    }

   

    public void addLine(int x, int y, int x2, int y2, Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        super.paintComponents(g);
        g2d.setStroke(new BasicStroke(5)); 
        g2d.drawLine(x, y, x2, y2);
    }
    
    public void addCasilla(int x, int y, int width, int height, Graphics g, Color color) {
        Graphics2D g2d = (Graphics2D)g;
        
        super.paintComponents(g);
        g2d.setStroke(new BasicStroke(2)); 
        g2d.setColor(color);
        g2d.drawRect(x, y, width, height);
        g2d.fillRect(x, y, width, height);
    }
    
    /**
     * Obtener JPoint en x y
     */
    private JPunto[] getJPuntos(Punto l1, Punto l2){
        JPunto[] pts = new JPunto[2];
        
        for (JPunto punto : puntos) {
            if(l1.getX() == punto.x && l1.getY() == punto.y){
                pts[0] = punto;
            }
            
            if(l2.getX() == punto.x && l2.getY() == punto.y){
                pts[1] = punto;
            }
        }
        
        return pts;
    }
    
    private JPunto getJPunto(Punto l1){
       
        for (JPunto punto : puntos) {
           if(l1.getX() == punto.x && l1.getY() == punto.y){
               return punto;
           }
        }
        
        return null;
    }

    /**
     * Metodo que pinta el tablero del juego en la pantalla.
     *
     * @param g
     */
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//
//        //g.drawLine(0, 0, 100, 100);
//        // Ejemplo tablero 20x20
//        int alto = this.getSize().height;
//        int ancho = this.getSize().width;
//
//        int separacion = Math.floorDiv(alto, 10);
//
//        for (int x = 0; x < ancho; x += separacion) {
//
//            for (int y = 0; y < alto; y += separacion) {
//                g.drawOval(x, y, 5, 5);
//                g.fillOval(x, y, 5, 5);
//            }
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void on_Error(String msg) {
        
    }

    @Override
    public void on_LineaTrazada(Jugador jugador, Jugador turno, Tablero tableroActualizado) {
        redibujarCasillas(tableroActualizado);
        reDibujarLineas(tableroActualizado);
    }
}
