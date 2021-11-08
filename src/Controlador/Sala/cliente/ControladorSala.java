package Controlador.Sala.cliente;

import Controlador.Conexiones.cliente.Conexion;
import Controlador.Sala.Sala;
import Controlador.Sala.cliente.AccionesCliente.*;
import Controlador.Sala.server.AccionesServer.*;
import Timbiriche.estructuras.Jugador;
import java.util.Observable;
import java.util.Observer;

public class ControladorSala implements Observer{

    // ------------ Singleton ------------  
    private static ControladorSala instance = null;

    private ControladorSala() {
        conexion = new Conexion("localhost", 4008);
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
        try {
           conexion.Init();
        } catch (Exception e) {}
    }

    @Override
    public void update(Observable obs, Object msg) {
        
        if(msg instanceof enviarIDJugador ){
            setClienteID(((enviarIDJugador)msg).ID);
        }
    }
    
    private void setClienteID(String ID){
        this.ID = ID;
        if(jugador != null){
            jugador.setID(ID);
        }
    }
    
    
    // ------------ Sala Cliente ------------
    Sala sala = new Sala();
    public Jugador jugador;
    
   
    public void solicitarUnirseSala(Jugador jugador){
        initConexion();
        
        this.jugador = jugador;
        this.jugador.setID(this.ID);
        
        AccionCliente request = new SolicitarUnirse(jugador);
        conexion.SendObject(request);
    }
}
