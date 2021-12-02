package Controlador.Juego.server;

import Controlador.Conexiones.cliente.AccionCliente;
import Controlador.Conexiones.server.Cliente;
import Controlador.Conexiones.server.Server;
import Controlador.Juego.IControladorJuego;
import Controlador.Juego.eventosUI.JuegoEvents;
import Timbiriche.Timbiriche;
import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.JugadorHost;
import Timbiriche.estructuras.Punto;
import Timbiriche.estructuras.Tablero;
import UI.eventos.juego.IGameEventsListener;
import java.util.Observable;
import java.util.Observer;


public class ControladorJuegoHost implements Observer, IControladorJuego{
     // ------------ Singleton ------------  
    private static ControladorJuegoHost instance = null;

    private ControladorJuegoHost() {

    }

    public static ControladorJuegoHost getInstance() {
        if (instance == null) {
            instance = new ControladorJuegoHost();
        }
        return instance;
    }
    
    // ------------ Servidor ------------
    Server server;
    HostPeticionesHandler requestHandler;

    @Override
    public void update(Observable sender, Object payload) {
        
        if(sender instanceof Cliente && payload instanceof AccionCliente) {
            requestHandler.handlePeticion((Cliente)sender, (AccionCliente)payload);
        }
        
    }
    
    // ------------ Notificador Eventos UI ------------
    JuegoEvents eventosJuego = new JuegoEvents();
    
    public void listenSalaEvents(IGameEventsListener listener){
        eventosJuego.listeners.add(listener);
    }
    
    
    // ------------ Juego Host ------------
    Timbiriche juego;
    
    @Override
    public Juego getJuego(){
        return juego;
    }
    
    @Override
    public Jugador getJugador() {
        return this.juego.getHost();
    }

    public boolean CrearJuego(Server server, JugadorHost host, Jugador[] jugadores, int tamañoTablero ) {
        try {
            this.server = server;
            server.addObserver(this);
            
            for (Cliente cliente : server.getClientes()) {
                cliente.addObserver(this);
            }
            
            Tablero tablero = new Tablero(tamañoTablero, tamañoTablero);
            this.juego = new Timbiriche(host, tablero, jugadores);
            
            this.requestHandler = new HostPeticionesHandler(server, juego, eventosJuego);
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean trazarLinea(Punto a, Punto b) {
        
        return false;
    }
    
}
