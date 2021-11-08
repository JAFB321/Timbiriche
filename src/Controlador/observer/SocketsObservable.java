package Controlador.observer;

import java.util.Observable;


public class SocketsObservable extends Observable{
    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }
}
