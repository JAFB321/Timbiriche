package Controlador.Sala.eventosUI;

// Observable que recibe los eventos desde el controlador y los notifica a la UI

import Timbiriche.estructuras.Jugador;
import UI.eventos.sala.ISalaListener;
import java.util.ArrayList;

public class SalaEvents {
    
    public ArrayList<ISalaListener> listeners = new ArrayList<>(); 
    
    public void notificar_JugadorNuevo(Jugador nuevo){
        listeners.forEach(listener -> listener.on_JugadorNuevo(nuevo));
    }
    
    public void notificar_JugadorAbandono(Jugador nuevo){
        listeners.forEach(listener -> listener.on_JugadorAbandono(nuevo));
    }
}
