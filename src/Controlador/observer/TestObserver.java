package Controlador.observer;


import java.util.Observable;
import java.util.Observer;


public class TestObserver implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
        
        System.out.println("/n /n ARG:");
        System.out.println(arg);
    }
    
}
