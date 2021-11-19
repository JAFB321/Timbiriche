package Controlador.Conexiones;

import Controlador.utils.Tools;
import java.io.Serializable;

public class SocketMensaje implements Serializable{
     String accionID = Tools.RandomUUID();
     public boolean isSync = false;

     public String accionID(){
         return accionID;
     }
     
}
