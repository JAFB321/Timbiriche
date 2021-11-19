package Controlador.Sala.server;

import Controlador.Conexiones.server.Cliente;
import Controlador.Conexiones.server.Server;
import Controlador.Sala.Sala;
import Controlador.Sala.cliente.AccionesCliente.*;
import Controlador.Sala.server.AccionesServer.*;
import Controlador.Conexiones.cliente.AccionCliente;
import Controlador.Conexiones.server.AccionServer;
import Timbiriche.estructuras.Jugador;

public class HostPeticionesHandler {

    Server server;
    Sala sala;

    public HostPeticionesHandler(Server server, Sala sala) {
        this.server = server;
        this.sala = sala;
    }

    
    public void handlePeticion(Cliente cliente, AccionCliente accion) {
        
        if(accion instanceof SolicitarUnirse)
            añadirJugadorSala(cliente, (SolicitarUnirse)accion);

        
    }

    private void añadirJugadorSala(Cliente cliente, SolicitarUnirse accion) {
        Jugador jugador = accion.jugador;
        
        jugador.setID(cliente.ID); 
    // ------------- Peticiones -------------
    
        sala.addJugador(jugador);

        AccionServer res = new enviarIDJugador(jugador.getID());
        server.sendToClients(res, jugador.getID());

        AccionServer res2 = new notificarJugadorNuevo(sala.getJugadores(), sala.getHost(), jugador);
        server.sendToClients(res2);
    }


}
