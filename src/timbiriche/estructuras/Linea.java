package Timbiriche.estructuras;

import java.io.Serializable;

public class Linea implements Serializable{
    private Punto puntoA;
    private Punto puntoB;
    private Jugador jugador;

    public Linea(){}
    
    public Linea(Punto A, Punto B, Jugador jugador){
        this.jugador = jugador;
        this.puntoA = A;
        this.puntoB = B;
    }

    public Linea(int x1, int y1, int x2, int y2, Jugador jugador){
        this.jugador = jugador;
        this.puntoA = new Punto(x1, y1);
        this.puntoB = new Punto(x2, y2);
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

    public void setPuntoA(Punto puntoA) {
        this.puntoA = puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(Punto puntoB) {
        this.puntoB = puntoB;
    }
}
