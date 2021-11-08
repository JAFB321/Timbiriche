package Timbiriche.estructuras;

import java.io.Serializable;


public class JugadorHost extends Jugador implements Serializable{
    
    public JugadorHost() {
        super();
    }

    public JugadorHost(String ID, String userName, String color, String avatar) {
        super(ID, userName, color, avatar);
    }

}
