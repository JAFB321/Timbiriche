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

    public Casilla[] trazarLinea(Jugador jugador, Linea linea) throws Exception{
        
        if(!jugador.getID().equals(turno.getID())){
            throw new Exception("No es tu turno");
        }
        
        if(!tablero.estaDisponible(linea)){
            throw new Exception("Ya hay una linea en ese lugar");
        }
        
        Casilla[] casillasFormadas = tablero.dibujarLinea(linea);
        //int nJugadores = jugadores.size();
        
        nextJugador();
        return casillasFormadas;
    }
    
    public Jugador checkGanador(){
        if(tablero.getCasillas().length >= (tablero.getAlto()-1)*(tablero.getAncho()-1)) {
            Jugador ganador = null;
            int nCasillas = 0;
            
            for (Jugador jugador : jugadores) {
                if(tablero.getCasillas(jugador) > nCasillas){
                    ganador = jugador;
                    nCasillas = tablero.getCasillas(jugador);
                }
            }
            
            return ganador;
        }
        
        return null;
    }
    
    private void nextJugador(){
        int nJugadores = jugadores.size();
        int currentPos = jugadores.indexOf(turno);
        Jugador proximo = null;

        if(currentPos >= (nJugadores-1)) {
            proximo = jugadores.get(0);
        }
        else{
            proximo = jugadores.get(currentPos+1);
        }
        
        this.turno = proximo;
    }
}
