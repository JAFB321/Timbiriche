package Controlador.Sala.server;

import Controlador.Conexiones.server.Cliente;
import Controlador.Conexiones.server.Server;
import Controlador.Sala.Sala;
import Controlador.Sala.cliente.AccionesCliente.*;
import Controlador.Sala.server.AccionesServer.*;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.JugadorHost;
import java.util.Observable;
import java.util.Observer;

public class ControladorSalaHost implements Observer {

    // ------------ Singleton ------------  
    private static ControladorSalaHost instance = null;

    private ControladorSalaHost() {
        server = new Server(4008);
        server.addObserver(this);
    }

    public static ControladorSalaHost getInstance() {
        if (instance == null) {
            instance = new ControladorSalaHost();
        }
        return instance;
    }

    // ------------ Servidor ------------
    Server server;

    @Override
    public void update(Observable obs, Object msg) {
        if(obs instanceof Server && msg instanceof Cliente){
            Cliente cliente = (Cliente)msg;
            cliente.addObserver(this);
        }
        
        if(obs instanceof Cliente && msg instanceof SolicitarUnirse){
            SolicitarUnirse accion = (SolicitarUnirse)msg;
            Cliente cliente = (Cliente)obs;
            
            accion.jugador.setID(cliente.ID);
            añadirJugadorSala(accion.jugador);
        }
    }

    // ------------ Sala Host ------------
    Sala sala = null;

    public void CrearSala(JugadorHost host) {
        try {
            server.Init();
            sala = new Sala(host);
        } catch (Exception e) {
        }
    }
    
    private void añadirJugadorSala(Jugador jugador){
        sala.addJugador(jugador);
        
        AccionServer res = new enviarIDJugador(jugador.getID());
        server.sendToClients(res, jugador.getID());
        
        AccionServer res2 = new notificarJugadorNuevo(sala.getJugadores(), sala.getHost(), jugador);
        server.sendToClients(res2);
    }

}
