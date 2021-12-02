package Timbiriche.estructuras;

import java.io.Serializable;
import java.util.ArrayList;

public class Tablero implements Serializable{
    
    private int alto = 10;
    private int ancho = 10;
    private ArrayList<Linea> lineas = new ArrayList<Linea>();
    private ArrayList<Casilla> casillas = new ArrayList<>();

    public Tablero(){}

    public Tablero(int alto, int ancho){
        this.alto = alto;
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * Retorna un arreglo con las casillas que se formen al agregar esta nueva linea
     * Retorna arreglo vacio si no se forma ninguna
     */
    public Casilla[] dibujarLinea(Linea linea){
        lineas.add(linea); // validar
        
        Casilla[] casillasFormadas = checkCasillaFormada(linea);
        
        for (Casilla c : casillasFormadas) {
            casillas.add(c);
        }
        
        return casillasFormadas;
    }
    
    private Casilla[] checkCasillaFormada(Linea linea){
        
        Punto ptA = linea.getPuntoA();
        Punto ptB = linea.getPuntoB();
        
        int[] direccion = linea.getDireccionAB();
        int xDif = direccion[0], yDif = direccion[1];
        
        // Posibles formaciones de casillas
        // Formacion 1
        Punto ptA_adyacente1 = new Punto(ptA.getX() + yDif, ptA.getY() + xDif);
        Punto ptB_adyacente1 = new Punto(ptB.getX() + yDif, ptB.getY() + xDif);
        
        // Formacion 2
        Punto ptA_adyacente2 = new Punto(ptA.getX() - yDif, ptA.getY() - xDif);
        Punto ptB_adyacente2 = new Punto(ptB.getX() - yDif, ptB.getY() - xDif);
        
        // Comprobar casillas validas
        ArrayList<Casilla> casillasFormadas = new ArrayList<>();
        
        if(hayLinea(ptA, ptA_adyacente1) && hayLinea(ptA_adyacente1, ptB_adyacente1) && hayLinea(ptB_adyacente1, ptB)){
            Casilla casilla = new Casilla(linea.getJugador(), ptA, ptA_adyacente1, ptB_adyacente1, ptB);
            casillasFormadas.add(casilla);
        }
        
        if(hayLinea(ptA, ptA_adyacente2) && hayLinea(ptA_adyacente2, ptB_adyacente2) && hayLinea(ptB_adyacente2, ptB)){
            Casilla casilla = new Casilla(linea.getJugador(), ptA, ptA_adyacente2, ptB_adyacente2, ptB);
            casillasFormadas.add(casilla);
        }
        
        return casillasFormadas.toArray(new Casilla[0]);
    }
   
    private boolean hayLinea(Punto a, Punto b) {
        for (Linea linea : lineas) {
            if (linea.esIgual(new Linea(a, b))) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hayLinea(Linea linea) {
        return hayLinea(linea.getPuntoA(), linea.getPuntoB());
    }

    public Linea[] getLineas() {
        return lineas.toArray(new Linea[0]);
    }
    
    public boolean estaDisponible(Linea linea){
        for (Linea l : lineas) {
            if(l.esIgual(linea)) return false;
        }
        
        return true;
    }
    
    public Casilla formarCasilla(Jugador jugador, Punto puntoA, Punto puntoB, Punto puntoC, Punto puntoD){
        Casilla casilla = new Casilla(jugador, puntoA, puntoB, puntoC, puntoD);
        this.casillas.add(casilla);
        
        return casilla;
    }
    
    public Casilla[] getCasillas() {
        return casillas.toArray(new Casilla[0]);
    }
    
    public int getCasillas(Jugador jugador){
        int nCasillas = 0;
        for (Casilla casilla : casillas) {
            if(casilla.getJugador().getID().equals(jugador.getID())){
                nCasillas++;
            }
        }
        
        return nCasillas;
    }
}
