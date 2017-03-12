
package ghosts_Proyecto;

import com.sun.javafx.geom.AreaOp;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseMotionListener;
import javax.swing.*;



public class JuegoTablero extends javax.swing.JFrame {
    public int cantGhosts = 8;
/*
    esta arreglo llamado sumaGhosts, es el que almacenara la cantidad de fantasmas malos y buenos que tendra
    cada uno de los player, entonces en la posicion [0][0], el valor que se almacenara sera la cantidad de fantasmas buenos
    que tiene el player 1, en la posicion [0][1] se almacenaran la cantidad de fantasmas malos que tiene el player 1
    y asi de la misma forma sera para el player 2, solo que en la posicion [1]
    */    
    public int sumaGhosts [][] = new int[2][2];
    public JLabel ghosts[][] = new JLabel[2][cantGhosts];//esta variable almacenara todos los fantasmas de los 2 jugadores, en la fila 0 estaran los del primer player y en la fila 1 estaran los del 2do platyer
    public static JPanel Tablero[][] = new JPanel[6][6];
    public JPanel cuadrosPlayer1[][] = new JPanel[2][4];//arreglo bidimensional que almacenara todos los jlabel del lado del jugador 1
    public JPanel cuadrosPlayer2[][] = new JPanel[2][4];//arreglo bidimensional que almacenara todos los jlabel del lado del jugador 2
    public int contadorbuenos = 0;
    public int contadorMalos = 0;
    public int contador = 0;
    public static int playerTurno = 1;//esta variable estara cambiando constantemente para evaluar el turno de quien va  
    /*
    esta variable de tipo String almacenara el ultimo fantasmita al cual se le clickeo, esto servira para quitar el borde
    cuando se seleccione otro fantasmita
    */
    public static String lastGhost = " ";
    

    public void almacenarPaneles(){
        for(int i = 0 ; i < Tablero.length; i++){
            for(int m = 0; m< 6; m++){
                if( i == 0 || i == 1){
                    if(m > 0 && m < 5){
                            cuadrosPlayer1[i][m-1] = Tablero[i][m];
                    }
                }
                else if( i == 4){
                    if(m > 0 && m < 5){
                            cuadrosPlayer2[1][m-1] = Tablero[i][m];
                    }
                
                }
                else if(i == 5){
                    if(m > 0 && m < 5)
                    cuadrosPlayer2[0][m-1] = Tablero[i][m];
                }
            }
        }
        
    }
    //este metodo guardara todos los fantasmas del player que se leindique, si se le ingresa 0 seran los del plater 1 en el arreglo ghost 
    //y todos los de la fila 0 son del player 1.
    public void guardarFantasmas(int player){
        for(int i = 0 ; i < ghosts.length; i++){
            if( i != player){
            continue;
        }
            for(int m = 0; m < cantGhosts; m++){
                int num =MainProyecto.randomio(2);//si es 1 es un fantasma malo, y si es 2 es un fantasma bueno
                int x = cantGhosts/2 ;
                if(contadorbuenos >= x){
                    num = 1;
                }
                
                if (contadorMalos >= x){
                    num = 2;
                }
                Ghosts tmp = new Ghosts(num, "Objeto"+ contador);
                if( num == 1){
                    contadorMalos += 1;
                }
                else if(num == 2){
                    contadorbuenos += 1;
                }
                if(player == 1){
                    tmp.setIcon(new ImageIcon(getClass().getResource("/ghosts_Proyecto/res/ghostnegro.jpg")));
                }
                contador += 1;
                ghosts[player][m] = tmp;
        
            }
        }
        contadorMalos = 0;
        contadorbuenos = 0;
    }
//****este metodo coloca todos los fantasmas en el tablero    
    public void cargarFantasmas(int player){
        JPanel[][] x = player == 0?cuadrosPlayer1:cuadrosPlayer2;
        int r = 0;
        int y = cantGhosts/2;
        for(int i = 0; i < x.length; i++){
            if(cantGhosts < 5){
                y = cantGhosts;
                if(i == 1){
                    break;
                }
            }
            for(int m = 0; m<y;m++){
//este if lo que hace es que si solo se colocaran 2 fantasmas, entonces ponerlos en medio para iniciar con el juego.
                if(cantGhosts == 2){
                    x[i][m+1].add(ghosts[player][r]);
                }
                else{
                x[i][m].add(ghosts[player][r]);
                }
                r++;
            }
        }
    }
    public JuegoTablero() {
        initComponents();
        almacenarPaneles();
        guardarFantasmas(0);
        guardarFantasmas(1);
        cargarFantasmas(0);
        cargarFantasmas(1);
        sumaGhosts[0][0] = cantGhosts/2;//suma de fantasmas buenos del player 1
        sumaGhosts[0][1] = cantGhosts/2;//suma de fantasmas malos del player 1
        sumaGhosts[1][0] = cantGhosts/2;//suma de fantasmas buenos del player 2
        sumaGhosts[1][1] = cantGhosts/2;//suma de fantasmas malos del player 1
        jLabel2.setText("Turno de " + Menu_InicioSesion.UsuarioActivo.getNombUsuario());
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/ghosts_Proyecto/res/ghost.png")));
        jlb_fantsBuenos.setText("Fantasmas Buenos de " + Menu_InicioSesion.UsuarioActivo.getNombUsuario() + " " + sumaGhosts[0][0]);
        jlb_fantsMalos.setText("Fantasmas Malos de " + Menu_InicioSesion.UsuarioActivo.getNombUsuario() + " " + sumaGhosts[0][1]);
        this.pack();
        
        
    }
//estas variables almacenan la posicion de fila y columna del fantasma que se va a comer, usando el metodo comerPieza
    //estas variables significan
 // fil = fila ; Fan = fantasma ; Com = comer
    int filFanCom;
    int colFanCom;
    //este metodo comprobara si en la posicion que se eligio mover, hay algun fantasma rival
    //SHF significa: Si Hay Fantasma
    public boolean comprobarSHF_rival(){
        int playerRival = playerTurno % 2 == 0?0:1;
        Ghosts fant = (Ghosts) fantasma;//esta variable almacena toda la informacion del fantasmita que se encuentre en esa posicion
        for(int i = 0 ; i < cantGhosts; i ++){
            String nombregh = ghosts[playerRival][i].getName();
            String nombFantEsta = fant.getName();
            if(nombregh.equals(nombFantEsta)){
                filFanCom = playerRival;
                colFanCom = i;
                return true;
            }
        }
       return false;
    }
/*
    Este meetodo como lo dice su Nombre: Determinar Si Hay Ganador, cada vez despues de un movimiento de piezas, o despues de comer,
    va a estar viendo si ya hay algun ganador o no
    */    
    public void determinarSHGanador(){
        String py1 = Menu_InicioSesion.UsuarioActivo.getNombUsuario();
        String py2 = Player_2.usuarioActivo2;
        if(sumaGhosts[0][0] != 0 && sumaGhosts[0][1] == 0){
            JOptionPane.showMessageDialog(null,py1+ " ha ganado, porque "+py2+" le capturo todos sus fantasmas malos","Ganador",JOptionPane.INFORMATION_MESSAGE);
            Menu_InicioSesion.UsuarioActivo.setPuntos(Menu_InicioSesion.UsuarioActivo.getPuntos() + 3);
            this.dispose();
            Menu_InicioSesion.mp.setVisible(true);//aca llamo a la ventana Menu_inicio sesion
        }
        else if(sumaGhosts[0][0] == 0 && sumaGhosts[0][1] != 0){
            JOptionPane.showMessageDialog(null,py2+ " ha ganado, porque capturo todos los fantasmas buenos de " +py1,"Ganador",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Menu_InicioSesion.mp.setVisible(true);//aca llamo a la ventana Menu_inicio sesion
        }
        else if(sumaGhosts[1][0] == 0 && sumaGhosts[1][1] != 0){
            JOptionPane.showMessageDialog(null,py1+ " ha ganado, porque capturo todos los fantasmas buenos de " +py2,"Ganador",JOptionPane.INFORMATION_MESSAGE);
            Menu_InicioSesion.UsuarioActivo.setPuntos(Menu_InicioSesion.UsuarioActivo.getPuntos() + 3);
            this.dispose();
            Menu_InicioSesion.mp.setVisible(true);//aca llamo a la ventana Menu_inicio sesion
        }
        else if(sumaGhosts[1][0] != 0 && sumaGhosts[1][1] == 0){
            JOptionPane.showMessageDialog(null,py2+ " ha ganado, porque "+py1+" le capturo todos sus fantasmas malos","Ganador",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Menu_InicioSesion.mp.setVisible(true);//aca llamo a la ventana Menu_inicio sesion
        }
        
    }
    public void comerPieza(int x, int y){
        int numComp = Tablero[posFila][posColum].getComponentCount();
        for(int i = 0; i < numComp;i++){
            Component comp = Tablero[posFila][posColum].getComponent(i);
            int tamNombre;
            try {
                tamNombre = comp.getName().length();
            } catch (Exception e) {
                continue;
            }
            if(tamNombre >= 7 || tamNombre <= 8){
                Tablero[posFila][posColum].remove(i);
                Ghosts ns = (Ghosts)  comp;
                String tipoft = ns.getTipFantas();
                if(playerTurno % 2 == 0){
                    if(tipoft == "Bueno"){
                        sumaGhosts[0][0] -= 1;
                    }
                    else{
                        sumaGhosts[0][1] -= 1;
                    }
                }
                else{
                    if(tipoft == "Bueno"){
                        sumaGhosts[1][0] -= 1;
                    }
                    else{
                        sumaGhosts[1][1] -= 1;
                    }
                }
                String Rival = playerTurno%2 == 0?Menu_InicioSesion.UsuarioActivo.getNombUsuario():Player_2.usuarioActivo2;
                JOptionPane.showMessageDialog(null,"Se ha comido un fantasma rival, " + tipoft+" de "+ Rival ,"Bien",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        this.pack();
        
    }
//estas variables seran usadas en el metodo comprobarEC para ser utilizadas en el metodo moverPieza y son la posicion
// en donde se le da click y seran la posicion en el tablero en cual esta
    int posFila;
    int posColum;

//*****este metodo servira para comprobar que la posicion que elija el player, sea una posicion accesible que no sea donde no puede mover********
// EC = ESPACIO CORRECTO 
    public boolean comprobarEC(){
        if(Ghosts.paso == true){
                this.pack();
                int x = Ghosts.posicionFila;
                int y = Ghosts.posicionColumna;
            for(int i =0; i < Tablero.length; i ++){
                // este if evalua que no se eleija una posicion fuera del area de juego, recordando que las columnas
                    // de afuera son solo para las salidas del castillo.
                if(Tablero[i][0].getMousePosition()!= null || Tablero[i][5].getMousePosition() != null){
                        JOptionPane.showMessageDialog(null,"No puede mover aca","Error",JOptionPane.ERROR_MESSAGE);
                        posFila = 0;
                        posColum = 0;
                        return false;
                    }
                for(int m = 0; m< 6; m++){
                    if(Tablero[i][m].getMousePosition() != null){
    //esta variable ii la creo porque cuando es el player 1 en el if que sigue debe ser x+1 y cuando es player2 se resta.
                            int ii =  (playerTurno % 2) != 0? x+1: x-1;    
//este if es el que comprueba que no se vaya a mover el fantasmita mas de una posicion o que no se mueva hacia atras.
// se suman un numero cuando es un movimiento del player 1, pero en caso que sea el player 2 se debe restar.
                                if((i == (ii) && y == m) || (i == x && ((m == y+1) || (m == y-1))) ){
                                    posFila = i;
                                    posColum = m;
                                    return true;
                                }
                        }

                }
            }
            JOptionPane.showMessageDialog(null,"No se puede mover mas de 1 espacio, porfavor solo mueva o a los lados o hacia adelante","Error",JOptionPane.ERROR_MESSAGE);
            posFila = 0;
            posColum = 0;
        }    
        else if(Ghosts.paso == false){
                return false;
            }
        return false;
    }
//en esta variable se almacenara el fantasma si se comprueba que hay a la posicion donde se desea mover
    Component fantasma;
/************este metodo servira para comprobar si hay algun fantasmita ya ocupando el espacio donde se desea mover
 SHF SIGNIFICA: SI HAY FANTASMA**********/    
    public boolean comprobarSHF(){
        if(Ghosts.paso == true){
                this.pack();
                int x = Ghosts.posicionFila;
                int y = Ghosts.posicionColumna;
            for(int i =0; i < Tablero.length; i ++){
                for(int m = 0; m< 6; m++){
                    if(Tablero[i][m].getMousePosition() != null){
                        int cantidad = Tablero[i][m].getComponentCount();
                        if(cantidad == 0){
                            return false;
                        }
                        for(int p = 0; p < cantidad;p++){
                            Component comp = Tablero[i][m].getComponent(p);
                            try {
                                Ghosts nm = (Ghosts) comp;
                                
                            } catch (Exception e) {
                                continue;
                            }
                            
                            fantasma = comp;
                            return true;
                        }
                        return false;
                    }

                }
            }
        }    
        return false;
    }
    public void moverPieza(int filT, int colT){
            //estas 2 variables almacenan el dato de la fila y columna donde se encuentra el fantasmista al cual se le dio click para mover    
            int filGH = Ghosts.posicionFila;
            int colGH = Ghosts.posicionColumna;
            int cantidad = Tablero[filGH][colGH].getComponentCount();
            Component comp = Tablero[filGH][colGH].getComponent(cantidad == 1?0:1);
            comp.setLocation(Tablero[filT][colT].getLocation());
            Ghosts compon = (Ghosts) comp;
            compon.setBorder(null);
            this.pack();
            Tablero[filT][colT].add(comp);
            Tablero[filGH][colGH].remove(comp);
// este JOption pane es el que lanza el mensaje para saber que tipo de fantasma se movio, pero lo comentare, para que no aparezca            
            //JOptionPane.showMessageDialog(null,"se ha movido un fantasma " + compon.getTipFantas(),"Info.",JOptionPane.INFORMATION_MESSAGE);
            Ghosts.paso = false;//esta es la variable que declare en la clase ghost.
            playerTurno += 1;
            if(playerTurno % 2 == 0){
                jLabel2.setText("Turno de  " + Player_2.usuarioActivo2);
                jLabel1.setIcon(new ImageIcon(getClass().getResource("/ghosts_Proyecto/res/ghostnegro.jpg")));
                jlb_fantsBuenos.setText("Fantasmas Buenos de " + Player_2.usuarioActivo2 + " " + sumaGhosts[1][0]);
                jlb_fantsMalos.setText("Fantasmas Malos de " + Player_2.usuarioActivo2 + " " + sumaGhosts[1][1]);
            }
            else{
                jLabel2.setText("Turno de  "+ Menu_InicioSesion.UsuarioActivo.getNombUsuario());
                jLabel1.setIcon(new ImageIcon(getClass().getResource("/ghosts_Proyecto/res/ghost.png")));
                jlb_fantsBuenos.setText("Fantasmas Buenos de " + Menu_InicioSesion.UsuarioActivo.getNombUsuario() + " " + sumaGhosts[0][0]);
                jlb_fantsMalos.setText("Fantasmas Malos de " + Menu_InicioSesion.UsuarioActivo.getNombUsuario() + " " + sumaGhosts[0][1]);
            }
    this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableroPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlb_fantsBuenos = new javax.swing.JLabel();
        jlb_fantsMalos = new javax.swing.JLabel();
        jBt_Retirarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(916, 630));
        setResizable(false);
        setSize(new java.awt.Dimension(840, 750));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableroPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tableroPanelComponentAdded(evt);
            }
        });
        tableroPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tableroPanelPropertyChange(evt);
            }
        });
        tableroPanel.setLayout(new java.awt.GridLayout(6, 6));

        jPanel1.setBackground(new java.awt.Color(204, 204, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[0][0] = jPanel1;

        tableroPanel.add(jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jPanel4);

        Tablero[0][1] = jPanel3;

        tableroPanel.add(jPanel3);

        jPanel5.setBackground(new java.awt.Color(204, 204, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[0][2] = jPanel5;

        tableroPanel.add(jPanel5);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(jPanel8);

        Tablero[0][3] = jPanel7;

        tableroPanel.add(jPanel7);

        jPanel9.setBackground(new java.awt.Color(204, 204, 0));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[0][4] = jPanel9;

        tableroPanel.add(jPanel9);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.add(jPanel12);

        Tablero[0][5] = jPanel11;

        tableroPanel.add(jPanel11);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.add(jPanel14);

        Tablero[1][0] = jPanel13;

        tableroPanel.add(jPanel13);

        jPanel15.setBackground(new java.awt.Color(204, 204, 0));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[1][1] = jPanel15;

        tableroPanel.add(jPanel15);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.add(jPanel18);

        Tablero[1][2] = jPanel17;

        tableroPanel.add(jPanel17);

        jPanel19.setBackground(new java.awt.Color(204, 204, 0));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[1][3] = jPanel19;

        tableroPanel.add(jPanel19);

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel21.add(jPanel22);

        Tablero[1][4] = jPanel21;

        tableroPanel.add(jPanel21);

        jPanel23.setBackground(new java.awt.Color(204, 204, 0));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[1][5] = jPanel23;

        tableroPanel.add(jPanel23);

        jPanel25.setBackground(new java.awt.Color(204, 204, 0));
        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[2][0] = jPanel25;

        tableroPanel.add(jPanel25);

        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel27.add(jPanel28);

        Tablero[2][1] = jPanel27;

        tableroPanel.add(jPanel27);

        jPanel29.setBackground(new java.awt.Color(204, 204, 0));
        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[2][2] = jPanel29;

        tableroPanel.add(jPanel29);

        jPanel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel31.add(jPanel32);

        Tablero[2][3] = jPanel31;

        tableroPanel.add(jPanel31);

        jPanel33.setBackground(new java.awt.Color(204, 204, 0));
        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[2][4] = jPanel33;

        tableroPanel.add(jPanel33);

        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel35.add(jPanel36);

        Tablero[2][5] = jPanel35;

        tableroPanel.add(jPanel35);

        jPanel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel37.add(jPanel38);

        Tablero[3][0] = jPanel37;

        tableroPanel.add(jPanel37);

        jPanel39.setBackground(new java.awt.Color(204, 204, 0));
        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[3][1] = jPanel39;

        tableroPanel.add(jPanel39);

        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel41.add(jPanel42);

        Tablero[3][2] = jPanel41;

        tableroPanel.add(jPanel41);

        jPanel43.setBackground(new java.awt.Color(204, 204, 0));
        jPanel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[3][3] = jPanel43;

        tableroPanel.add(jPanel43);

        jPanel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel45.add(jPanel46);

        Tablero[3][4] = jPanel45;

        tableroPanel.add(jPanel45);

        jPanel47.setBackground(new java.awt.Color(204, 204, 0));
        jPanel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[3][5] = jPanel47;

        tableroPanel.add(jPanel47);

        jPanel49.setBackground(new java.awt.Color(204, 204, 0));
        jPanel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[4][0] = jPanel49;

        tableroPanel.add(jPanel49);

        jPanel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel51.add(jPanel52);

        Tablero[4][1] = jPanel51;

        tableroPanel.add(jPanel51);

        jPanel53.setBackground(new java.awt.Color(204, 204, 0));
        jPanel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[4][2] = jPanel53;

        tableroPanel.add(jPanel53);

        jPanel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel55.add(jPanel56);

        Tablero[4][3] = jPanel55;

        tableroPanel.add(jPanel55);

        jPanel57.setBackground(new java.awt.Color(204, 204, 0));
        jPanel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[4][4] = jPanel57;

        tableroPanel.add(jPanel57);

        jPanel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel59.add(jPanel60);

        Tablero[4][5] = jPanel59;

        tableroPanel.add(jPanel59);

        jPanel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel61.add(jPanel62);

        Tablero[5][0] = jPanel61;

        tableroPanel.add(jPanel61);

        jPanel63.setBackground(new java.awt.Color(204, 204, 0));
        jPanel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[5][1] = jPanel63;

        tableroPanel.add(jPanel63);

        jPanel65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel65.add(jPanel66);

        Tablero[5][2] = jPanel65;

        tableroPanel.add(jPanel65);

        jPanel67.setBackground(new java.awt.Color(204, 204, 0));
        jPanel67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[5][3] = jPanel67;

        tableroPanel.add(jPanel67);

        jPanel69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel69.add(jPanel70);

        Tablero[5][4] = jPanel69;

        tableroPanel.add(jPanel69);

        jPanel71.setBackground(new java.awt.Color(204, 204, 0));
        jPanel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tablero[5][5] = jPanel71;

        tableroPanel.add(jPanel71);

        getContentPane().add(tableroPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 600, 500));
        tableroPanel.setEnabled(false);

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jlb_fantsBuenos.setText("jLabel3");
        jPanel6.add(jlb_fantsBuenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jlb_fantsMalos.setText("jLabel4");
        jPanel6.add(jlb_fantsMalos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 260, 280));

        jBt_Retirarse.setText("Retirarse");
        jBt_Retirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBt_RetirarseActionPerformed(evt);
            }
        });
        getContentPane().add(jBt_Retirarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(comprobarEC() == true ){
            if(comprobarSHF() == false){
                moverPieza(posFila,posColum);
            }
            else{
                if(comprobarSHF_rival() == true){
                    comerPieza(filFanCom,colFanCom);
                    moverPieza(posFila, posColum);
                    determinarSHGanador();

                }
                else{
                    JOptionPane.showMessageDialog(null,"Donde desea mover, ya esta ocupado ","Error.",JOptionPane.ERROR_MESSAGE);
                }
            }
        } 
    }//GEN-LAST:event_formMouseClicked

    private void tableroPanelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tableroPanelPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tableroPanelPropertyChange

    private void tableroPanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tableroPanelComponentAdded

    }//GEN-LAST:event_tableroPanelComponentAdded

    private void jBt_RetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBt_RetirarseActionPerformed
        if(playerTurno % 2 == 0){
            JOptionPane.showMessageDialog(null, Player_2.usuarioActivo2+" se ha retirado","Retirado",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Menu_InicioSesion.mp.setVisible(true);//aca llamo a la ventana Menu_inicio sesion
        }
        else{
            JOptionPane.showMessageDialog(null,Menu_InicioSesion.UsuarioActivo.getNombUsuario()+" se ha retirado","Retirado",JOptionPane.INFORMATION_MESSAGE);
            Menu_InicioSesion.mp.setVisible(true);//aca llamo a la ventana Menu_inicio sesion
        }
        this.dispose();
    }//GEN-LAST:event_jBt_RetirarseActionPerformed


    public static void main(String args[]) {;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                   new JuegoTablero().setVisible(true);
                   
                   

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBt_Retirarse;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jlb_fantsBuenos;
    private javax.swing.JLabel jlb_fantsMalos;
    public javax.swing.JPanel tableroPanel;
    // End of variables declaration//GEN-END:variables
}
