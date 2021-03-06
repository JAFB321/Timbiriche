package Controlador.Sala.server;

import Controlador.Conexiones.cliente.AccionCliente;
import Controlador.Conexiones.server.AccionServer;
import Controlador.Conexiones.server.Cliente;
import Controlador.Conexiones.server.Server;
import Controlador.Juego.server.ControladorJuegoHost;
import Controlador.Sala.ControladorSync;
import Controlador.Sala.Sala;
import Controlador.Sala.cliente.ControladorSala;
import Controlador.Sala.eventosUI.SalaEvents;
import Controlador.Sala.eventosUI.SalaHostEvents;
import Timbiriche.estructuras.JugadorHost;
import UI.eventos.sala.ISalaHostListener;
import UI.eventos.sala.ISalaListener;
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
    
    // ------------ Notificador Eventos UI ------------
    SalaEvents eventosSala = new SalaEvents();
    SalaHostEvents eventosSalaHost = new SalaHostEvents();
    
    public void listenSalaEvents(ISalaListener listener){
        eventosSala.listeners.add(listener);
    }
    
    public void listenSalaHostEvents(ISalaHostListener listener){
        eventosSalaHost.hostListeners.add(listener);
    }
    
    
    // ------------ Sala Host ------------
    Sala sala;
    
    public Sala getSala(){
        return sala;
    }

    public boolean CrearSala(String nombre, int nJugadores, int tama??oTablero, JugadorHost host) {
        try {
            server.Init();
            host.setID("host");
            sala = new Sala(nombre, nJugadores, tama??oTablero, host);
            requestHandler = new HostPeticionesHandler(server, sala, eventosSala, eventosSalaHost);
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean IniciarJuego(){
        ControladorJuegoHost controladorJuego = ControladorJuegoHost.getInstance();
        
        String[] colores = {"red", "blue", "orange", "black", "green"};
        
        for (int i = 0; i < sala.getJugadores().length; i++) {
            sala.getJugadores()[i].setColor(colores[i]);
        }
        
        if(controladorJuego.CrearJuego(server, sala.getHost(), sala.getJugadores(), sala.getTama??oTablero())){
            
            AccionServer juegoCreado = new AccionesServer.IniciarJuego(controladorJuego.getJuego());
            
            for (int i = 0; i < sala.getJugadores().length; i++) {
                controladorJuego.getJuego().getJugadores()[i].setColor(colores[i]);
            }
            
            server.sendToClients(juegoCreado);
            
            return true;
        }
        
        return false;
    }
    
    // ------------ Acciones ------------


}
