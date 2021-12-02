package Controlador.Sala.cliente;

import Controlador.Conexiones.cliente.AccionCliente;
import Controlador.Conexiones.cliente.Conexion;
import Controlador.Conexiones.server.AccionServer;
import Controlador.Juego.cliente.ControladorJuego;
import Controlador.Sala.ControladorSync;
import Controlador.Sala.Sala;
import Controlador.Sala.cliente.AccionesCliente.*;
import Controlador.Sala.eventosUI.SalaEvents;
import Controlador.Sala.eventosUI.SalaHostEvents;
import Controlador.Sala.server.AccionesServer.*;
import Timbiriche.estructuras.Jugador;
import UI.eventos.sala.ISalaListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ControladorSala extends ControladorSync implements Observer{

    // ------------ Singleton ------------  
    private static ControladorSala instance = null;

    private ControladorSala() {

    }

    public static ControladorSala getInstance() {
        if (instance == null) {
            instance = new ControladorSala();
        }
        return instance;
    }
    
    // ------------ Conexion Servidor ------------
    Conexion conexion;
    String ID = "";
    
    ClientePeticionesHandler requestHandler;
    
    private void initConexion(String IP){
        try {
           conexion = new Conexion(IP, 4008);
           conexion.addObserver(this);
           requestHandler = new ClientePeticionesHandler(conexion, sala, eventosSala, this);
           conexion.Init();
        } catch (Exception e) {}
    }

    @Override
    public void update(Observable obs, Object msg) {
        
        if(msg instanceof AceptarUnirse ){
            AceptarUnirse accion = (AceptarUnirse)msg;
            
            this.sala.actualizarSala(accion.sala);
            
            setClienteID(accion.jugadorID);
            liberarAccion(accion.solicitudID);
        }
        
        if (msg instanceof IniciarJuego) {
            IniciarJuego accion = (IniciarJuego) msg;
            ControladorJuego controladorJuego = ControladorJuego.getInstance();
            
            eventosSala.IniciarJuego(accion.juego);
            controladorJuego.IniciarJuego(conexion, accion.juego, this.jugador);
        }
        
        if(msg instanceof AccionServer) requestHandler.handlePeticion((AccionServer)msg);
    }
    
    private void setClienteID(String ID){
        this.ID = ID;
        if(jugador != null){
            jugador.setID(ID);
        }
    }
    
    // ------------ Notificador Eventos UI ------------
    SalaEvents eventosSala = new SalaEvents();
    
    public void listenSalaEvents(ISalaListener listener){
        eventosSala.listeners.add(listener);
    }
    
    
    // ------------ Sala Cliente ------------
    Sala sala = new Sala();
    public Jugador jugador;
    
    public Sala getSala(){
        return sala;
    }
    
    // Acciones
    public boolean solicitarUnirseSala(Jugador jugador, String salaIP){
        initConexion(salaIP);
        
        this.jugador = jugador;
        
        AccionCliente request = new SolicitarUnirse(jugador);
        conexion.SendObject(request);
        
        if(esperarRespuesta(request)){
            return true;
        }else{
            return false;
        }
    }
}

// Cliente - servidor = sockets
// Sockets - controladores = observer
// controladores -> UI = eventos
// UI -> controladores = depedencia