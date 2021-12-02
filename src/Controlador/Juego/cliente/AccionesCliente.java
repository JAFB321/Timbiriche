package Controlador.Juego.cliente;

import Controlador.Conexiones.cliente.AccionCliente;
import Timbiriche.estructuras.Linea;

public class AccionesCliente {
     public static class solicitar_TrazarLinea extends AccionCliente{
        public Linea linea;

        public solicitar_TrazarLinea(Linea linea) {
            this.linea = linea;
            this.isSync = true;
        }
    }
}
