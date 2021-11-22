package Controlador.Sala.cliente;

import Controlador.Conexiones.cliente.Conexion;
import Controlador.Conexiones.server.AccionServer;
import Controlador.Sala.ControladorSync;
import Controlador.Sala.server.AccionesServer.*;
import Controlador.Sala.Sala;

public class ClientePeticionesHandler {

    Conexion conexion;
    Sala sala;
    
    // Para poder liberar acciones emitidas una vez recibida la respuesta
    ControladorSync controladorSync;

    public ClientePeticionesHandler(Conexion conexion, Sala sala, ControladorSync controladorSync) {
        this.conexion = conexion;
        this.sala = sala;
        this.controladorSync = controladorSync;
    }

    public void handlePeticion(AccionServer accion) {

//        if (accion instanceof SolicitarUnirse) {
//            añadirJugadorSala(cliente, (SolicitarUnirse) accion);
//        }

    }
}
