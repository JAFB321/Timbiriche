package Controlador.Juego.cliente;

import Controlador.Conexiones.cliente.AccionCliente;
import Controlador.Conexiones.cliente.Conexion;
import Controlador.Conexiones.server.AccionServer;
import Controlador.Juego.IControladorJuego;
import Controlador.Juego.cliente.AccionesCliente.solicitar_TrazarLinea;
import Controlador.Juego.eventosUI.JuegoEvents;
import Controlador.Sala.ControladorSync;
import Timbiriche.estructuras.Casilla;
import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.Linea;
import Timbiriche.estructuras.Punto;
import UI.eventos.juego.IGameEventsListener;
import java.util.Observable;
import java.util.Observer;


public class ControladorJuego extends ControladorSync implements Observer, IControladorJuego{
    
    // ------------ Singleton ------------  
    private static ControladorJuego instance = null;

    private ControladorJuego() {

    }

    public static ControladorJuego getInstance() {
        if (instance == null) {
            instance = new ControladorJuego();
        }
        return instance;
    }
    
    // ------------ Conexion Servidor ------------
    Conexion conexion;
    String ID = "";
    
    ClientePeticionesHandler requestHandler;
    
    @Override
    public void update(Observable obs, Object msg) {

        if (msg instanceof AccionServer) {
            requestHandler.handlePeticion((AccionServer) msg);
        }
    }
    
     // ------------ Notificador Eventos UI ------------
    JuegoEvents eventosJuego = new JuegoEvents();
    
    public void listenSalaEvents(IGameEventsListener listener){
        eventosJuego.listeners.add(listener);
    }
    
    // ------------ Juego Cliente ------------
    public Jugador jugador;
    Juego juego;
    
    @Override
    public Juego getJuego(){
        return this.juego;
    }
    
    @Override
    public Jugador getJugador(){
        return this.jugador;
    }

    public boolean IniciarJuego(Conexion conexion, Juego juego, Jugador jugador){
        this.conexion = conexion;
        conexion.addObserver(this);
        
        this.ID = jugador.getID();
        this.juego = juego;
        this.jugador = jugador;
        
        this.requestHandler = new ClientePeticionesHandler(conexion, juego, jugador, eventosJuego, this );
        
        return true;
    }

    // Acciones
    
    @Override
    public boolean trazarLinea(Punto a, Punto b) {
        // enviar petiticon
        Linea linea = new Linea(a, b, jugador);
        
        AccionCliente request = new solicitar_TrazarLinea(linea);
        conexion.SendObject(request);
        
        if(esperarRespuesta(request)){
            
        }
        
        return false;
    }
    
}
