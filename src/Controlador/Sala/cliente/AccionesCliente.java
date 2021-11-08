package Controlador.Sala.cliente;

import Timbiriche.estructuras.Jugador;
import java.io.Serializable;


public class AccionesCliente {
    public static class AccionCliente implements Serializable{}
    
    public static class SolicitarUnirse extends AccionCliente{
        public Jugador jugador;
        
        public SolicitarUnirse(Jugador jugador){
            this.jugador = jugador;
        }
    }
    
    public static class AbandonarSala extends AccionCliente{
        
    }
}
