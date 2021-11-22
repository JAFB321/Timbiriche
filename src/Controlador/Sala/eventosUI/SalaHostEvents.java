package Controlador.Sala.eventosUI;

// Observable que recibe los eventos desde el controlador y los notifica a la UI

import UI.eventos.sala.ISalaHostListener;
import java.util.ArrayList;

public class SalaHostEvents{
    
    ArrayList<ISalaHostListener> hostListeners = new ArrayList<>();
    
    
    
}
