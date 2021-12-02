package Timbiriche.estructuras;

import java.io.Serializable;
import java.util.ArrayList;

public class Juego implements Serializable{

    protected JugadorHost host;
    protected Tablero tablero;
    public ArrayList<Jugador> jugadores;
    
    //Estado
    protected Jugador turno;

    public Juego(JugadorHost host, Tablero tablero, Jugador[] jugadores ){
        this.host = host;
        this.tablero = tablero;
        this.jugadores = new ArrayList<Jugador>();
        
        this.jugadores.add(host);
        for (Jugador j : jugadores) {
            this.jugadores.add(j);
        }
        
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

    public Jugador getJugadorTurno() {
        return turno;
    }
    
    public void actualizarJuego(Juego juego){
        this.host = juego.host;
        this.jugadores = (ArrayList<Jugador>)juego.jugadores.clone();
        this.tablero = juego.tablero; 
        this.turno = juego.turno;
    }
}   
