package Controlador.Juego.server;

import Controlador.Conexiones.server.AccionServer;
import Timbiriche.estructuras.Juego;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.Tablero;

public class AccionesServer {
    public static class notificar_Error extends AccionServer{
        public String msg;
        public String solicitudID;

        public notificar_Error(String msg, String solicitudID) {
            this.msg = msg;
            this.solicitudID = solicitudID;
            this.isSync = true;
        }
    }
    
    public static class aceptar_TrazarLinea extends AccionServer{
        public String solicitudID;

        public aceptar_TrazarLinea(String solicitudID) {
            this.solicitudID = solicitudID;
            this.isSync = true;
        }
    }
    
     public static class notificar_LineaTrazada extends AccionServer{
         public Jugador jugador;
         public Jugador turno;
         public Tablero tableroActualizado;

        public notificar_LineaTrazada(Jugador jugador, Jugador turno, Tablero tableroActualizado) {
            this.jugador = jugador;
            this.turno = turno;
            this.tableroActualizado = tableroActualizado;
        }
     }
}
