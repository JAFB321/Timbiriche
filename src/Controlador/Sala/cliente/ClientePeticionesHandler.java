package Controlador.Sala.cliente;

import Controlador.Conexiones.cliente.Conexion;
import Controlador.Conexiones.server.AccionServer;
import Controlador.Sala.ControladorSync;
import Controlador.Sala.server.AccionesServer.*;
import Controlador.Sala.Sala;
import Controlador.Sala.eventosUI.SalaEvents;

public class ClientePeticionesHandler {

    Conexion conexion;
    Sala sala;
    
    // Eventos UI
    SalaEvents eventosSala;
    
    // Para poder liberar acciones emitidas una vez recibida la respuesta
    ControladorSync controladorSync;

    public ClientePeticionesHandler(Conexion conexion, Sala sala, SalaEvents eventosSala, ControladorSync controladorSync) {
        this.conexion = conexion;
        this.sala = sala;
        this.eventosSala = eventosSala;
        this.controladorSync = controladorSync;
    }

    public void handlePeticion(AccionServer accion) {

        if (accion instanceof notificar_JugadorNuevo) {
            añadirJugadorSala((notificar_JugadorNuevo) accion);
        }

    }
    
    private void añadirJugadorSala(notificar_JugadorNuevo accion){
        sala.actualizarSala(accion.sala);
        eventosSala.notificar_JugadorNuevo(accion.nuevo);
    }
}
