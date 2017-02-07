/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghosts_Proyecto;

/**
 *
 * @author damasofc
 */
public class jugador {
    String nombUsuario;//variable que guardara el nombre de usuario
    private String contra;//esta variable guardara la contrasena
    //getter: esto obtiene la cantidad de puntos del jugador
    public String[] usuarios = new String[15];//crea un arreglo donde se guardaran todos los nombres de usuario
    public String[] contras = new String[15];//crea un arreglo donde se guardaran todas las contrasenas.

//*****este metodo hace que se agregue un jugador***********
    public boolean agregarJugador(String nombUsuario, String contra){
        int y = 0;
        int x;
        for(x = 0; x <= 15; x++){
            if(usuarios[x] == null){
                y = x;
                break;
      }  
        }
        usuarios[y] = nombUsuario;
        contras[y] = contra; 
        return true;
    }
    
    
}
