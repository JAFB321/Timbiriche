package Main;

import Controlador.Sala.cliente.ControladorSala;
import Controlador.Sala.server.ControladorSalaHost;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.JugadorHost;

public class Test {
    
    public static void main(String[] args) {
        System.out.println("Prueba controladores");
        
        ControladorSala sala = ControladorSala.getInstance();
        ControladorSalaHost salaHost = ControladorSalaHost.getInstance();
        
        // Host
        //JugadorHost jhost = new JugadorHost("123", "JAFB321", "#FFF", "CAT");
        //salaHost.CrearSala(jhost);
        
        
        // Cliente
        //Jugador jcliente = new Jugador("000", "player", "#fff", "rino");
        //sala.solicitarUnirseSala(jcliente, "localhost");
        
        
        
//        System.out.println("Conexion:");
//        try {
//           Server server = new Server(4008);
//           server.Init();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        
//        try {
//            Conexion cliente = new Conexion("localhost", 4008);
//            
//            TestObserver a = new TestObserver();
//            cliente.addObserver(a);
//            
//            cliente.Init();
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
    
}
