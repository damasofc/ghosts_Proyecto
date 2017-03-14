/*
 ************Esta Clase contiene las variables donde se almacenaran datos de los usuarios************************ 
 */
package ghosts_Proyecto;


public class Usuario{

    private String nombUsuario;//variable que guardara el nombre de usuario
    private String contra;//esta variable guardara la contrasena
    private int puntos;//esta variable guarda los puntos obtenidos
    private String reportes[] = new String[10];
 //**********este es el constructor para poder crear un usuario nuevo******************
    public Usuario(String nomb,String contra){
        this.nombUsuario = nomb;
        this.contra = contra;
        this.puntos = 0;

    }

    public String getReporte(int x) {
        return reportes[x];
    }

    public void setReporte(String reporte,int m) {
        this.reportes[m] = reporte;
    }
//*********esto viene aca son todos lo metodos getter y setters *************************
    public String getNombUsuario() {
        return nombUsuario;
    }

    public void setNombUsuario(String nombUsuario) {
        this.nombUsuario = nombUsuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }


    
}

