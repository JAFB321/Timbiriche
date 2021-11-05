package Timbiriche.estructuras;

import java.util.ArrayList;

public class Juego {

    private JugadorHost host;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private Tablero tablero;

    public Juego(JugadorHost host, Tablero tablero){
        this.host = host;
        this.tablero = tablero;
    }

    public JugadorHost getHost() {
        return host;
    }

    public Jugador[] getJugadores() {
        return jugadores.toArray(new Jugador[0]);
    }

    public Tablero getTablero() {
        return tablero;
    }
}   
