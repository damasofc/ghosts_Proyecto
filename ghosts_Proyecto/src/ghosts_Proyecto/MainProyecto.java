/*
**************Este es el main de todo el programa aca cree los arreglos para guardar los nombres
de usuarios y las contraseñas y asi queden almacenadas hasta que el programa se cierre**************
 */
package ghosts_Proyecto;


public class MainProyecto {

    public static Usuario usuarios[];//el arreglo donde se almacenaran los nombres de usuarios
    private static int contador;// es un contador que se usa mas abajo.
/*esto que viene aca sera crear las variables para cad uno de los Jframes y asi poder accederlos desde una sola clase*/
    public static MenuCrearUsuario crear = new MenuCrearUsuario();//creo un objeto de la clase MenuCrearUusario
    public static Menu_inicio m = new Menu_inicio();// crea un objeto de la clase Menu_inicio
    public static Menu_InicioSesion mis = new Menu_InicioSesion();
    
    

    public static void main(String[] args) {
        usuarios = new Usuario[100];//aca instancio el arreglo que cree arriba y le asigno hasta cuantos usuarios podra almacenar
/******Este ciclo for hace que se creen 100 usuarios, pero con campos vacios sin nada almacenados
 esto lo hago para que a la hora de preguntar si hay algo almacenado en el arreglo me diga que si hay ya pero vacios.
 */
        for (int i = 0; i < 100; i++) {
            usuarios[i] = new Usuario("","");
        }
        
        contador = 0;//este es el contador que inicialize arriba, aca le asigno valor
        m.setVisible(true);//aca llamo para que sea visible el Menu de incio y aparezca.
    }
//**********Este es el metodo usado para poder crear un nuevo usuario*************
    public static void crearUsuario(String nombUsuario, String contra) {
        usuarios[contador].setNombUsuario(nombUsuario);//aca se hace uso del metodo set para agregar un nombre de usuario en la posicion que tenga de numero la variable contador
        usuarios[contador].setContra(contra);//aca se hace lo mismo que la de arriba solo que para la contraseña
        contador++;// se aumenta la variable contador para que luego que se ingrese otro usuario sea almacenado en otra posicion distinta
    }
        
//*******Este metodo sirve para comprobar si el nombre del usuario ya esta*************8
    public static boolean comprobarUsuario(String nombUsuario) {
        boolean k = false;
//este for itera en cada uno de los usuarios que esten almacenados en el arreglo Usuarios.
        for (int x = 0; x < 100; x++) {
            String a = usuarios[x].getNombUsuario();
            if (a.equals(nombUsuario)) {
                    return true;
            }
        }
        return k;

    }
    public static int comprobarPosicionUsuario(String nombUsuario) {
//este for itera en cada uno de los usuarios que esten almacenados en el arreglo Usuarios.
        for (int x = 0; x < 100; x++) {
            String a = usuarios[x].getNombUsuario();
            if (a.equals(nombUsuario)) {
                    return x;
            }
        }
        return -1;

    }
// este metodo es parecido al de comprobarUsuario, solo que aca se comprueba usuario y contraseña
    public static boolean comprobarUsuarioIni(String nombUsuario, String contra) {
        boolean k = false;
        for (int x = 0; x < 100; x++) {
            String a = usuarios[x].getNombUsuario();
            String b = usuarios[x].getContra();
            if (a.equals(nombUsuario) && b.equals(contra)) {
                    return true;
            }
        }
        return k;

    }
    public static int randomio(int max){
        int numAleatorio = (int) (Math.random() * max) + 1;
        return numAleatorio;
    }
}
