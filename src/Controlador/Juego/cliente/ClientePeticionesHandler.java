package Controlador.Juego.cliente;

import Controlador.Conexiones.cliente.Conexion;
import Controlador.Conexiones.server.AccionServer;
import Controlador.Juego.eventosUI.JuegoEvents;
import Controlador.Juego.server.AccionesServer.*;
import Controlador.Sala.ControladorSync;
import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;


public class ClientePeticionesHandler {
    
    Conexion conexion;
    Juego juego;
    Jugador jugador;

    // Eventos UI
    JuegoEvents eventosJuego;
    
    // Para poder liberar acciones emitidas una vez recibida la respuesta
    ControladorSync controladorSync;

    public ClientePeticionesHandler(Conexion conexion, Juego juego, Jugador jugador, JuegoEvents eventosJuego, ControladorSync controladorSync) {
        this.conexion = conexion;
        this.juego = juego;
        this.jugador = jugador;
        this.eventosJuego = eventosJuego;
        this.controladorSync = controladorSync;
    }


    public void handlePeticion(AccionServer accion) {

        if (accion instanceof notificar_LineaTrazada) {
            notificar_LineaTrazada((notificar_LineaTrazada) accion);
        }
        
        if(accion instanceof notificar_Error){
            notificar_Error((notificar_Error) accion);
        }

    }
    
    public void notificar_LineaTrazada(notificar_LineaTrazada accion){
        // algo a la UI 
        eventosJuego.notificar_LineaTrazada(accion.jugador, accion.turno, accion.tableroActualizado);
    }
    
    public void aceptar_TrazarLinea(aceptar_TrazarLinea accion){
        
        if(accion.isSync){
            controladorSync.liberarAccion(accion.solicitudID);
        }
    }
    
    public void notificar_Error(notificar_Error accion){
        eventosJuego.notificar_Error(accion.msg);
        
        if(accion.isSync){
            controladorSync.liberarAccion(accion.solicitudID);
        }
    }
    
    
    
}
