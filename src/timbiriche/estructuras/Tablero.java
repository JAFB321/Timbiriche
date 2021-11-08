package Timbiriche.estructuras;

import java.io.Serializable;
import java.util.ArrayList;

public class Tablero implements Serializable{
    
    private int alto = 10;
    private int ancho = 10;
    private ArrayList<Linea> lineas = new ArrayList<Linea>();

    public Tablero(){}

    public Tablero(int alto, int ancho){
        this.alto = alto;
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void dibujarLinea(Linea linea){
        lineas.add(linea);
    }

    public Linea[] getLineas() {
        return lineas.toArray(new Linea[0]);
    }
}
