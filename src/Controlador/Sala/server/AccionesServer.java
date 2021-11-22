package Controlador.Sala.server;

import Controlador.Conexiones.server.AccionServer;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.JugadorHost;


public class AccionesServer {
   
    public static class notificarJugadorNuevo extends AccionServer{
        public Jugador[] jugadoresSala;
        public JugadorHost host;
        public Jugador nuevo;
        
        public notificarJugadorNuevo(Jugador[] nuevaSala, JugadorHost host, Jugador nuevo){
            this.jugadoresSala = nuevaSala;
            this.nuevo = nuevo;
            this.host = host;
        }
    }

    public static class AceptarUnirse extends AccionServer{
        public String jugadorID;
        public String solicitudID;
        
        public Jugador[] jugadores;
        public JugadorHost host;
        
        public AceptarUnirse(String ID, Jugador[] jugadores, JugadorHost host, String solicitudID){
            this.jugadorID = ID;
            this.jugadores = jugadores;
            this.host = host;
            this.solicitudID = solicitudID;
            this.isSync = true;
        }
    }
}
