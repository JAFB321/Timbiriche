package Controlador.Sala.cliente;

import Controlador.Conexiones.cliente.AccionCliente;
import Timbiriche.estructuras.Jugador;


public class AccionesCliente {  
    public static class SolicitarUnirse extends AccionCliente{
        public Jugador jugador;
        
        public SolicitarUnirse(Jugador jugador){
            this.jugador = jugador;
        }
    }
    
    public static class AbandonarSala extends AccionCliente{
        
    }
}
