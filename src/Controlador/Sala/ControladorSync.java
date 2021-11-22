package Controlador.Sala;

import Controlador.Conexiones.SocketMensaje;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// Clase para permitir al controlador esperar respuesta del servidor de manera sincrona
public class ControladorSync {

    ArrayList<String> accionesEsperando = new ArrayList<>();
    ArrayList<String> accionesCanceladas = new ArrayList<>();
    
    // Bloquea el hilo actual para esperar la resolucion de una "accion" 
    // /(con la respuesta del servidor por ejemplo)
    public synchronized boolean esperarRespuesta(SocketMensaje accion) {
        this.accionesEsperando.add(accion.accionID());

        try {

            while (accionesEsperando.contains(accion.accionID())) {

                if (accionesCanceladas.contains("_x_" + accion.accionID())) {
                    liberarAccion("_x_" + accion.accionID(), false);
                    liberarAccion(accion.accionID(), false);
                    return false;
                }
                else cancelarAccion(20000, accion.accionID());

                System.out.println(accion.accionID());
                wait();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            liberarAccion(accion.accionID(), true);
            return false;
        }

        return true;
    }

    // Libera una accion para desbloquear un hilo
    public synchronized void liberarAccion(String id) {
        liberarAccion(id, true);
    }
    
    private synchronized void liberarAccion(String id, boolean notify) {
        
        for (int i = 0; i < accionesEsperando.size(); i++) {
            String lista_id = accionesEsperando.get(i);
            if (lista_id.equals(id)) {
                accionesEsperando.remove(i);
            }
        }
        
        for (int i = 0; i < accionesCanceladas.size(); i++) {
            String lista_id = accionesCanceladas.get(i);
            if (lista_id.equals(id)) {
                accionesCanceladas.remove(i);
            }
        }
        
        if (notify) {
            this.notifyAll();
        }
    }

    private synchronized void cancelarAccion(long delay, String id) {

        ControladorSync _this = this;

        Runnable runThread = new Runnable() {

            // run adds an element in the list and starts the loop
            @Override
            public void run() {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }

                for (int i = 0; i < accionesEsperando.size(); i++) {
                    String lista_id = accionesEsperando.get(i);
                    if (lista_id.equals(id)) {
                        accionesCanceladas.add(i, "_x_" + id);
                    }
                }

                synchronized (_this) {
                    _this.notifyAll();
                }

            }
        };

        Thread t1 = new Thread(runThread);
        t1.start();
    }
}
