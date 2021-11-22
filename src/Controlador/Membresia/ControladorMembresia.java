package Controlador.Membresia;

import Timbiriche.estructuras.Jugador;


public class ControladorMembresia {
    
    // ------------ Singleton ------------  
    private static ControladorMembresia instance = null;

    private ControladorMembresia() {
        jugador = new Jugador();
        jugador.setUserName("user");
    }

    public static ControladorMembresia getInstance() {
        if (instance == null) {
            instance = new ControladorMembresia();
        }
        return instance;
    }
    
    // ------------ Membresia ------------
    public Jugador jugador;
    
}
