
package ghosts_Proyecto;

import com.sun.nio.zipfs.ZipPath;
import java.awt.Component;
import java.awt.MouseInfo;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ghosts extends JLabel implements MouseListener{
    int tipoFantasma;//esta variable guardara 1 o 2, si es 2 es un fantasma bueno, si es 1 es un fantasma malo
    String tipFantas;
    String name; //identificador del fantasma
    /** Posicion de imagen */
    private Point posicion = new Point(200,100);
    public Ghosts(int tipo, String Id){
        this.name = Id;
        this.setText("");
        this.setIcon(new ImageIcon(getClass().getResource("/ghosts_Proyecto/res/ghost.png")));//ghosts_Proyecto/src/ghosts_Proyecto/res/ghost.png
        this.tipoFantasma = tipo;
        if(tipoFantasma == 1){
            this.tipFantas = "Malo";
        }
        else if(tipoFantasma == 2){
            this.tipFantas = "Bueno";
        }
        this.setLocation(posicion);
        this.setVisible( true );
        this.addMouseListener(this);
        this.setOpaque(true);
        
        
        
    }

    public String getTipFantas() {
        return tipFantas;
    }

    public void setTipFantas(String tipFantas) {
        this.tipFantas = tipFantas;
    }

    public int getTipoFantasma() {
        return tipoFantasma;
    }

    public void setTipoFantasma(int tipoFantasma) {
        this.tipoFantasma = tipoFantasma;
    }

    public String getName() {
        return name;
    }

    public void setName(String id) {
        this.name = id;
    }

    public static int contador = 0; // contador para que al darle click la primera vez entonces se le ponga un borde, y al darle otra vez click, se quite ese borde.
    public static int  posicionFila; // almacenara el valor de la fila en donde esta el fantasmita en el arreglo tablero
    public static int  posicionColumna;// almacenara el valor de la columna en donde esta el fantasmita en el arreglo Tablero
    
    public void buscarPosicion(){
        posicionFila = 0;
        posicionColumna = 0;
        for(int i =0; i < JuegoTablero.Tablero.length; i ++){
            for(int m = 0; m< 6; m++){
                int cuantos = JuegoTablero.Tablero[i][m].getComponentCount();
                if(cuantos == 0){
                    continue;
                }
                else{
                    String nombre = JuegoTablero.Tablero[i][m].getComponent(cuantos == 1?0:1).getName();
                    if(this.name.equals(nombre)){
                        posicionFila = i;
                        posicionColumna = m;
                        break;
                    }
                    
                }
            }
        }
    }
    
    public static boolean paso = false;//esta variable la creo para que cuando se de click en cualquier espacio en el tablero
    // no haga nada hasta que esta variable haya sido cambiada a true.
    @Override
    public void mouseClicked(MouseEvent e) {
        boolean confirm = false;//esta variable la usare para comprobar que el fantasma que se seleccion, sea del player que le toca el turno.
        if(contador == 0){

            /*si en esta variable quienSigue se almacena el valor de 1, significa que es el turno del player 2, y en caso de ser 0
            va el player 1
            */
            //todo esto es para comprobar que el fantasma que se seleccione, sea del player que lleva el turno\
            // y en caso de no serlo, no se podra mover
            int quienSigue = JuegoTablero.playerTurno %2 == 0?1:0;
            for(int i = 0; i < Player_2.nm.ghosts[quienSigue].length;i++){
                String name = this.getName();
                if(name == Player_2.nm.ghosts[quienSigue][i].getName()){
                    confirm = true;
                }
            }
            if(confirm == true){
                this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 1));
/*
   **********Este codigo que empieza aca, servira para quitarle el borde rojo, al dar click en otro fantasmita, asi
                siempre estara marcado de rojo, solo el fantasmita que se va a mover, o el que desea mover************
                */                
                String ultimoGhost = JuegoTablero.lastGhost;
                if(ultimoGhost != " "){
                    if(ultimoGhost.equals(this.getName()) == false){
                        for(int i =0; i <JuegoTablero.Tablero.length; i++){
                            for(int m = 0; m <6;m++){
                                int count = JuegoTablero.Tablero[i][m].getComponentCount();
                                for(int s = 0; s < count ; s++){
                                    Component com = JuegoTablero.Tablero[i][m].getComponent(s);
                                    Ghosts xw;
                                    try {
                                        xw = (Ghosts) com;
                                    } catch (Exception em) {
                                        continue;
                                    }
                                    if(xw.getName().equals(JuegoTablero.lastGhost)){
                                        xw.setBorder(null);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
//***********Aca finaliza el codigo que explique arriba acerca del borde rojo************************                
                this.buscarPosicion();//este metodo almacena la fila y la columna del arreglo Tablero donde se ence=uentra el fantasmita que damos click.
                contador = 1;
                paso = true;
                JuegoTablero.lastGhost = this.getName();
                
            }
        }
        else if(contador == 1){
            this.setBorder(null);
            posicionFila = 0;
            posicionColumna = 0;
            contador = 0;
            paso = false;
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseDragged(MouseEvent e) {
                 
     }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        //this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 1)); 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
       // this.setBorder( null ); 
    }
   

    
}
