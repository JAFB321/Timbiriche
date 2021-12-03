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
        
        boolean isHost = false;
        for (Jugador j : jugadores) {
            this.jugadores.add(j);
            if(j instanceof JugadorHost) isHost=true;
        }
        if(!isHost)this.jugadores.add(host);
    }

    public Juego(Juego juego) {
        this.host = juego.host;
        this.jugadores = (ArrayList<Jugador>)juego.jugadores.clone();
        this.tablero = new Tablero().actualizarTablero(juego.tablero);
        this.turno = juego.turno;
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
    
    public Juego actualizarJuego(Juego juego){
        this.host = juego.host;
        this.jugadores = (ArrayList<Jugador>)juego.jugadores.clone();
        this.tablero = new Tablero().actualizarTablero(juego.tablero);
        this.turno = juego.turno;
        
        return this;
    }
}   
