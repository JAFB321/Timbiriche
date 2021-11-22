package Controlador.Sala.server;

import Controlador.Conexiones.cliente.AccionCliente;
import Controlador.Conexiones.server.Cliente;
import Controlador.Conexiones.server.Server;
import Controlador.Sala.ControladorSync;
import Controlador.Sala.Sala;
import Timbiriche.estructuras.JugadorHost;
import java.util.Observable;
import java.util.Observer;

public class ControladorSalaHost extends ControladorSync implements Observer {

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
    
    public Sala getSala(){
        return sala;
    }

    public boolean CrearSala(String nombre, int nJugadores, int tamañoTablero, JugadorHost host) {
        try {
            server.Init();
            host.setID("host");
            sala = new Sala(nombre, nJugadores, tamañoTablero, host);
            requestHandler = new HostPeticionesHandler(server, sala);
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    
    // ------------ Acciones ------------


}
