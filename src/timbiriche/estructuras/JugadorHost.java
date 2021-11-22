package Timbiriche.estructuras;

import java.io.Serializable;


public class JugadorHost extends Jugador implements Serializable{
    
    public JugadorHost() {
        super();
    }

    public JugadorHost(String ID, String userName, String color, int avatar) {
        super(ID, userName, color, avatar);
    }
    
    public JugadorHost(Jugador jugador){
        super(jugador.getID(), jugador.getUserName(), jugador.getColor(), jugador.getAvatar());
    }
}
