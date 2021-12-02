package Timbiriche.estructuras;

import java.io.Serializable;

public class Linea implements Serializable{
    private Punto puntoA;
    private Punto puntoB;
    private Jugador jugador;
    private int[] direccionAB; // [x, y]

    public Linea(){}
    
    public Linea(Punto A, Punto B, Jugador jugador){
        this.jugador = jugador;
        this.puntoA = A;
        this.puntoB = B;
        setDireccionAB(puntoA, puntoB);
    }
    
    public Linea(Punto A, Punto B){
        this.puntoA = A;
        this.puntoB = B;
        setDireccionAB(puntoA, puntoB);
    }

    public Linea(int x1, int y1, int x2, int y2, Jugador jugador){
        this.jugador = jugador;
        this.puntoA = new Punto(x1, y1);
        this.puntoB = new Punto(x2, y2);
        setDireccionAB(puntoA, puntoB);
    }
    
    private void setDireccionAB(Punto A, Punto B){
        direccionAB = new int[2];
        direccionAB[0] = B.getX()-A.getX();
        direccionAB[1] = B.getY()-A.getY();
    }

    // Getter y Setters
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Punto getPuntoA() {
        return puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public int[] getDireccionAB() {
        return direccionAB;
    }

    public boolean esIgual(Linea linea){
        int[] direccionThis = this.getDireccionAB();
        int[] direccionLinea = linea.getDireccionAB();
               
        if(direccionThis[0] == direccionLinea[0] && direccionThis[1] == direccionLinea[1]){
            if(this.puntoA.esIgual(linea.puntoA)) return true;
        }
        
        else if(direccionThis[0]*-1 == direccionLinea[0] && direccionThis[1]*-1 == direccionLinea[1]){
            if(this.puntoA.esIgual(linea.puntoB)) return true;
        }
        
        return false;
    }
}
