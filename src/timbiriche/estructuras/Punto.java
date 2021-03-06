package Timbiriche.estructuras;

import java.io.Serializable;

public class Punto implements Serializable{
    private int x;
    private int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter y Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public boolean esIgual(Punto p){
        if(this.x == p.x && this.y == p.y) return true;
        else return false;
    }
}
