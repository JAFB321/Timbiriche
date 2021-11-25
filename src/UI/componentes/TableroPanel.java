package UI.componentes;

import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JRadioButton;

/**
 * Clase que representa un tablero para el juego.
 *
 * @author Daniel Parra, Jesus Ramses, Jose Felix
 */
public class TableroPanel extends javax.swing.JPanel {

    public TableroPanel() {
        initComponents();
        botones();
    }

    public void botones() {
        
        // orden de los parametros: filas, columnas, espacio horizontal, espacio vertical
        // lo importante seria nomas cambiar las filas y las columnas dependiendo del tamaño del tablero
        GridLayout layout = new GridLayout(10, 10, 10, 10);

        // ejemplo de 10x10 se añaden 100 elementos
        // ya nomas para el de 20x20 serian pues 400 y asi
        for (int x = 0; x < 100; x++) {

            JRadioButton boton = new JRadioButton();
            boton.setVisible(true);
            this.add(boton);
            this.buttonGroup1.add(boton);

        }
        
        this.setLayout(layout);

        this.revalidate();

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
    // End of variables declaration//GEN-END:variables
}
