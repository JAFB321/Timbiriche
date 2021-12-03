package UI.eventos.juego;

import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.Tablero;


public interface IGameEventsListener{
    // Estos metodos seran implementados por la UI
    
    public void on_Error(String msg);
    public void on_LineaTrazada(Jugador jugador, Jugador turno, Tablero tableroActualizado);
}
