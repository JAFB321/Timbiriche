package UI.eventos.sala;

 // Interface implementada por la UI que escuche eventos del controlador de la sala 
import Timbiriche.estructuras.Jugador;


public interface ISalaListener {
   
    public void on_JugadorNuevo(Jugador jugador);
    public void on_JugadorAbandono(Jugador jugador);
    
}
