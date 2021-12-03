package Controlador.Juego.server;

import Controlador.Conexiones.cliente.AccionCliente;
import Controlador.Conexiones.server.AccionServer;
import Controlador.Conexiones.server.Cliente;
import Controlador.Conexiones.server.Server;
import Controlador.Juego.cliente.AccionesCliente.*;
import Controlador.Juego.eventosUI.JuegoEvents;
import Controlador.Juego.server.AccionesServer.*;
import Timbiriche.Timbiriche;
import Timbiriche.estructuras.Casilla;
import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.Tablero;

public class HostPeticionesHandler {

    Server server;
    Timbiriche juego;
    
    // Eventos UI
    JuegoEvents eventosJuego;

    public HostPeticionesHandler(Server server, Timbiriche juego, JuegoEvents eventosJuego) {
        this.server = server;
        this.juego = juego;
        this.eventosJuego = eventosJuego;
    }

    

    public void handlePeticion(Cliente cliente, AccionCliente accion) {

        if (accion instanceof solicitar_TrazarLinea) {
            solicitar_TrazarLinea(cliente, (solicitar_TrazarLinea) accion);
        }

    }
    
    public void solicitar_TrazarLinea(Cliente cliente, solicitar_TrazarLinea accion){
        
        try {
            Jugador jugador = accion.linea.getJugador();
            
            juego.trazarLinea(jugador, accion.linea);
            
            AccionServer respuesta = new aceptar_TrazarLinea(accion.accionID());
            server.sendToClients(respuesta, cliente.ID);
            
            AccionServer notificarJugadores = new notificar_LineaTrazada(jugador, juego.getJugadorTurno() , new Tablero().actualizarTablero(juego.getTablero()));
            server.sendToClients(notificarJugadores);
            
            eventosJuego.notificar_LineaTrazada(jugador, juego.getJugadorTurno() , new Tablero().actualizarTablero(juego.getTablero()));
            
        } catch (Exception e) {
            AccionServer respuesta = new notificar_Error(e.getMessage(), accion.accionID());
            server.sendToClients(respuesta, cliente.ID);
        }
        
        
    }

}
