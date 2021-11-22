package Controlador.Sala.server;

import Controlador.Conexiones.server.AccionServer;
import Controlador.Sala.Sala;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.JugadorHost;


public class AccionesServer {
   
    public static class notificar_JugadorNuevo extends AccionServer{
        public Sala sala;
        public Jugador nuevo;
        
        public notificar_JugadorNuevo(Sala sala, Jugador nuevo){
            this.sala = new Sala();
            this.sala.actualizarSala(sala);
            this.nuevo = nuevo;
        }
    }
    
    public static class notificar_JugadorAbandono extends AccionServer{
        public Sala sala;
        public Jugador abandono;

        public notificar_JugadorAbandono(Sala sala, Jugador abandono) {
            this.sala = new Sala();
            this.sala.actualizarSala(sala);
            this.abandono = abandono;
        }
    }

    public static class AceptarUnirse extends AccionServer{
        public String jugadorID;
        public String solicitudID;
        
        public Sala sala;
        
        public AceptarUnirse(String ID, Sala sala, String solicitudID){
            this.jugadorID = ID;
            this.sala = sala;
            this.solicitudID = solicitudID;
            this.isSync = true;
        }
    }
}
