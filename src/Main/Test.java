package Main;

import Controlador.Sala.server.ControladorSalaHost;
import Timbiriche.Timbiriche;
import Timbiriche.estructuras.Jugador;
import Timbiriche.estructuras.JugadorHost;
import Timbiriche.estructuras.Linea;
import Timbiriche.estructuras.Punto;
import Timbiriche.estructuras.Tablero;



public class Test {
    
    public static void main(String[] args) throws Exception {

        System.out.println("Test linea");
        
        Punto a = new Punto(1,1);
        Punto b = new Punto(1,0);
        
        Linea linea = new Linea(a, b);
        
        if(linea.esValida()){
            System.out.println("Es valida");
        }else System.out.println("Invalida");





//TEST JUEGO
//        System.out.println("Prueba Juego");
//        
//        JugadorHost host = new JugadorHost("999", "host", "red", 1);
//        Tablero tab = new Tablero(10,10);
//        
//        Jugador p1 = new Jugador("1", "jafb", "blue", 2);
//        Jugador p2 = new Jugador("2", "asd", "blue", 3);
//        Jugador p3 = new Jugador("3", "gfgf", "blue", 4);
//        
//        Jugador[] jugadores = new Jugador[]{p1, p2, p3};
//        
//        Timbiriche game = new Timbiriche(host, tab, jugadores);
//        
//        game.trazarLinea(host, new Linea(1, 1, 2, 1, host));
//        
//        game.trazarLinea(p1, new Linea(1, 1, 1, 2, p1));
//        game.trazarLinea(p2, new Linea(1, 2, 2, 2, p2));
//        game.trazarLinea(p3, new Linea(2, 2, 2, 1, p3));
//        
//        game.trazarLinea(host, new Linea(1, 1, 1, 0, host));
//        
//        game.trazarLinea(p1, new Linea(1, 0, 2, 0, p1));
//        game.trazarLinea(p2, new Linea(2, 0, 2, 1, p2));
//        //game.trazarLinea(p3, new Linea(2, 2, 2, 1, p1));
//        
//        Jugador ganador = game.checkGanador();
//        System.out.println(ganador.getUserName());
////        game.trazarLinea(host, new Linea(2, 1, 1, 1, p1));
////
////        game.trazarLinea(p1, new Linea(1, 1, 1, 2, p1));
////        game.trazarLinea(p2, new Linea(3, 3, 2, 3, p1));
////        game.trazarLinea(p3, new Linea(5, 5, 5, 4, p1));
////
////        game.trazarLinea(host, new Linea(1, 1, 1, 0, p1));
    }
    
}
