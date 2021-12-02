package Controlador.Juego;

import Timbiriche.estructuras.Casilla;
import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.Punto;


public interface IControladorJuego {
    public Juego getJuego();
    public Jugador getJugador();
    
    public boolean trazarLinea(Punto a, Punto b);
}
