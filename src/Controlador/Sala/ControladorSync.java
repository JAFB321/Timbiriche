package Controlador.Sala;

import Controlador.Conexiones.SocketMensaje;
import java.util.ArrayList;


// Clase para permitir al controlador esperar respuesta del servidor de manera sincrona
public class ControladorSync {
    
    ArrayList<String> accionesEsperando = new ArrayList<>();
    
    // Bloquea el hilo actual para esperar la resolucion de una "accion" 
    // /(con la respuesta del servidor por ejemplo)
    public synchronized boolean esperarRespuesta(SocketMensaje accion){
        this.accionesEsperando.add(accion.accionID());
        
        try {
            while(accionesEsperando.contains(accion.accionID())){
                wait();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }
    
    // Libera una accion para desbloquear un hilo
    public synchronized void liberarAccion(String id){
        accionesEsperando.remove(id);
        this.notifyAll();
    }
    
}
