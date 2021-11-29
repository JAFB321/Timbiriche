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
     * Retorna una casilla si la linea completo las 4 lineas de la casilla
     * Retorna null si no
     */
    public Casilla dibujarLinea(Linea linea){
        lineas.add(linea);
        
        return null;
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
}
