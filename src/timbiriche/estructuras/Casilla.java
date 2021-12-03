
package Timbiriche.estructuras;

// Representa cuatro Lineas que forman una casilla valida de un jugador

import java.io.Serializable;

public class Casilla implements Serializable{
    Punto puntoA;
    Punto puntoB;
    Punto puntoC;
    Punto puntoD;
    
    Jugador jugador;
    
    public Casilla(Jugador jugador, Punto puntoA, Punto puntoB, Punto puntoC, Punto puntoD) {
        this.puntoA = puntoA;
        this.puntoB = puntoB;
        this.puntoC = puntoC;
        this.puntoD = puntoD;
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Punto getPuntoA() {
        return puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public Punto getPuntoC() {
        return puntoC;
    }

    public Punto getPuntoD() {
        return puntoD;
    }
    
    
       
}