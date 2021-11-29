package Timbiriche;

import Timbiriche.estructuras.Casilla;
import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.JugadorHost;
import Timbiriche.estructuras.Linea;
import Timbiriche.estructuras.Tablero;

// Motor del juego
public class Timbiriche extends Juego{
    
    
    public Timbiriche(JugadorHost host, Tablero tablero, Jugador[] jugadores) {
        super(host, tablero, jugadores);
        this.turno = this.jugadores.get(0);
    }
    
    public Juego getState(){
        return this;
    }

    public boolean trazarLinea(Jugador jugador, Linea linea){
        
        if(!jugador.getID().equals(turno.getID())){
            return false;
        }
        
        if(!tablero.estaDisponible(linea)){
            return false;
        }
        
        Casilla casillaFormada = tablero.dibujarLinea(linea);
        
        if(casillaFormada != null){
            
        }
        
        nextJugador();
        return true;
    }
    
    public boolean checkGanador(){
        return true;
    }
    
    private void nextJugador(){
        int currentPos = jugadores.indexOf(turno);
        Jugador proximo = null;
        
        if(currentPos >= jugadores.size()) proximo = jugadores.get(0);
        proximo = jugadores.get(currentPos+1);
        
        this.turno = proximo;
    }
}
