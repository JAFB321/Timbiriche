package Main;

import Controlador.observer.TestObserver;
import Controlador.Conexiones.cliente.Conexion;
import Controlador.Conexiones.server.Server;
import UI.MenuPrincipal;
import Controlador.observer.TestObserver;

public class Main {

    public static void main(String[] args) {
        MenuPrincipal form = new MenuPrincipal();
        form.setVisible(true);
        
        
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
