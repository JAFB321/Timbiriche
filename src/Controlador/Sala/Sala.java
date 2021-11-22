package Controlador.Sala;

import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.JugadorHost;
import java.io.Serializable;
import java.util.ArrayList;


public class Sala implements Serializable{
    String nombre;
    int nJugadores;
    int tamañoTablero;
    
    JugadorHost host;
    ArrayList<Jugador> jugadores = new ArrayList<>();
    
    public Sala(JugadorHost host){
        setHost(host);
    }

    public Sala(String nombre, int nJugadores, int tamañoTablero, JugadorHost host) {
        this.nombre = nombre;
        this.nJugadores = nJugadores;
        this.tamañoTablero = tamañoTablero;
        setHost(host);
    }
    
    
    
    public Sala(){}
    
    public JugadorHost getHost(){
        return host;
    }

    public void setHost(JugadorHost host) {
        if(this.host != null){
            removeJugador(host.getID());
        }
        
        //jugadores.add(host);
        this.host = host;
    }
    
    public Jugador[] getJugadores(){
        ArrayList<Jugador> newJugadores = (ArrayList<Jugador>)jugadores.clone();
        newJugadores.add(host);
        
        return newJugadores.toArray(new Jugador[0]);
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
            if(jugador.getID().equals(ID)){
                jugadores.remove(i);
                return;
            }
        }
    }
    
    public void removeJugadores(){
        jugadores.clear();
    }
    
    public void actualizarSala(Sala sala){
        this.host = sala.host;
        this.jugadores = (ArrayList<Jugador>) sala.jugadores.clone();
        this.nJugadores = sala.nJugadores;
        this.nombre = sala.nombre;
        this.tamañoTablero = sala.tamañoTablero;
    }
}