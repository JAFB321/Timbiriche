package Controlador.Sala.server;

import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.JugadorHost;
import java.io.Serializable;


public class AccionesServer {
    public static class AccionServer implements Serializable{}
    
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
    
    public static class enviarIDJugador extends AccionServer{
        public String ID;
        
        public enviarIDJugador(String ID){
            this.ID = ID;
        }
    }
}
