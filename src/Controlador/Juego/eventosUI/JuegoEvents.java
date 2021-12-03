package Controlador.Juego.eventosUI;

import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.Tablero;
import UI.eventos.juego.IGameEventsListener;
import java.util.ArrayList;


public class JuegoEvents {
    
    public ArrayList<IGameEventsListener> listeners = new ArrayList<>(); 
    
    public void notificar_Error(String msg){
        listeners.forEach(listener -> listener.on_Error(msg));
    }
    
    public void notificar_LineaTrazada(Jugador jugador, Jugador turno, Tablero tableroActualizado){
        listeners.forEach(listener -> listener.on_LineaTrazada(jugador, turno, tableroActualizado));
    }
}
