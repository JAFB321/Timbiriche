package Timbiriche.estructuras;

import java.io.Serializable;


public class Jugador implements Serializable{
    private String ID = ""; 
    private String userName = ""; 
    private String color = ""; 
    private int avatar = 0; 

    public Jugador(String ID, String userName, String color, int avatar) {
        this.ID = ID;
        this.userName = userName;
        this.color = color;
        this.avatar = avatar;
    }

    public Jugador(){}    

    // Getter y Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getAvatar() {
        return avatar;
    }


}


