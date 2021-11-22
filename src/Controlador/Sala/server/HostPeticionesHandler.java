package Controlador.Sala.server;

import Controlador.Conexiones.server.Cliente;
import Controlador.Conexiones.server.Server;
import Controlador.Sala.Sala;
import Controlador.Sala.cliente.AccionesCliente.*;
import Controlador.Sala.server.AccionesServer.*;
import Controlador.Conexiones.cliente.AccionCliente;
import Controlador.Conexiones.server.AccionServer;
import Controlador.Sala.eventosUI.SalaEvents;
import Controlador.Sala.eventosUI.SalaHostEvents;
import Timbiriche.estructuras.Jugador;

public class HostPeticionesHandler {
 
    Server server;
    Sala sala;
    
    // Eventos UI
    SalaEvents eventosSala;
    SalaHostEvents eventosSalaHost;

    public HostPeticionesHandler(Server server, Sala sala, SalaEvents eventosSala, SalaHostEvents eventosSalaHost) {
        this.server = server;
        this.sala = sala;
        this.eventosSala = eventosSala;
        this.eventosSalaHost = eventosSalaHost;
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

        AccionServer res = new AceptarUnirse(jugador.getID(), sala, accion.accionID());
        server.sendToClients(res, cliente.ID);

        AccionServer res2 = new notificar_JugadorNuevo(sala, jugador);
        server.sendToClients(res2);
        
        eventosSala.notificar_JugadorNuevo(jugador);
    }


}
