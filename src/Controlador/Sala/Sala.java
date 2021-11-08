package Controlador.Sala;

import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.JugadorHost;
import java.util.ArrayList;


public class Sala {
    JugadorHost host;
    ArrayList<Jugador> jugadores = new ArrayList<>();
    
    public Sala(JugadorHost host){
        this.host = host;
        jugadores.add(host);
    }
    
    public Sala(){}
    
    public JugadorHost getHost(){
        return host;
    }

    public void setHost(JugadorHost host) {
        this.host = host;
    }
    
    public Jugador[] getJugadores(){
        return jugadores.toArray(new Jugador[0]);
    }
    
    public Jugador getJugador(String ID){
        for (int i = 0; i < jugadores.size(); i++) {
            
            Jugador jugador = jugadores.get(i);
            if(jugador.getID().equals(ID)){
                return jugador;
            }
        }
        return null;
    }

    public void addJugador(Jugador newJ){
        this.jugadores.add(newJ);
    }
    
    public void removeJugador(String ID){
        for (int i = 0; i < jugadores.size(); i++) {
            
            Jugador jugador = jugadores.get(i);
            if(jugador.getID().equals(ID) && jugador != host){
                jugadores.remove(i);
                return;
            }
        }
    }
}