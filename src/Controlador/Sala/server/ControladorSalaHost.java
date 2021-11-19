package Controlador.Sala.server;

import Controlador.Conexiones.cliente.AccionCliente;
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
    HostPeticionesHandler requestHandler;

    @Override
    public void update(Observable sender, Object payload) {
        if (sender instanceof Server && payload instanceof Cliente) {
            Cliente cliente = (Cliente) payload;
            cliente.addObserver(this);
        }
        
        if(sender instanceof Cliente && payload instanceof AccionCliente) {
            requestHandler.handlePeticion((Cliente)sender, (AccionCliente)payload);
        }
    }

    // ------------ Sala Host ------------
    Sala sala = null;

    public void CrearSala(JugadorHost host) {
        try {
            server.Init();
            sala = new Sala(host);
            requestHandler = new HostPeticionesHandler(server, sala);
        } catch (Exception e) {
        }
    }
    
    
    
    // ------------ Acciones ------------


}
