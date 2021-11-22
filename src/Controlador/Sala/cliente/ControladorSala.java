package Controlador.Sala.cliente;

import Controlador.Conexiones.cliente.AccionCliente;
import Controlador.Conexiones.cliente.Conexion;
import Controlador.Conexiones.server.AccionServer;
import Controlador.Sala.ControladorSync;
import Controlador.Sala.Sala;
import Controlador.Sala.cliente.AccionesCliente.*;
import Controlador.Sala.server.AccionesServer.*;
import Timbiriche.estructuras.Jugador;
import java.util.Observable;
import java.util.Observer;

public class ControladorSala extends ControladorSync implements Observer{

    // ------------ Singleton ------------  
    private static ControladorSala instance = null;

    private ControladorSala() {
        conexion = new Conexion("localhost", 4008);
        conexion.addObserver(this);
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
    
    private void initConexion(){
    ClientePeticionesHandler requestHandler;
        try {
           conexion.Init();
        } catch (Exception e) {}
    }

    @Override
    public void update(Observable obs, Object msg) {
        
        if(msg instanceof AceptarUnirse ){
            AceptarUnirse accion = (AceptarUnirse)msg;
            
            setClienteID(accion.jugadorID);
            liberarAccion(accion.solicitudID);
        }
        
        if(msg instanceof AccionServer) requestHandler.handlePeticion((AccionServer)msg);
    }
    
    private void setClienteID(String ID){
        this.ID = ID;
        if(jugador != null){
            jugador.setID(ID);
        }
    }
    
    public String[] getSalasDisponibles(){
        return new String[]{"localhost"};
    }
    
    
    // ------------ Sala Cliente ------------
    Sala sala = new Sala();
    public Jugador jugador;
    
    public Sala getSala(){
        return sala;
    }
    
    // Acciones
    public boolean solicitarUnirseSala(Jugador jugador, String salaIP /*Implementar*/ ){
        initConexion();
        
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
