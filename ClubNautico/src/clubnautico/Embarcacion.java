package clubnautico;

import java.io.Serializable;

public class Embarcacion implements Serializable {

    private String matricula;
    private String nombreDeEmbarcacion;
    private String tipo;
    private String dimensiones;
    private Amarre amarre;
    private Zona zona;

    public Embarcacion(Zona zona, String matricula, String nombreDeEmbarcacion, String tipo, String dimensiones, Amarre amarre) {
        this.zona = zona;
        this.matricula = matricula;
        this.nombreDeEmbarcacion = nombreDeEmbarcacion;
        this.tipo = tipo;
        this.dimensiones = dimensiones;
        this.amarre = amarre;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombreDeEmbarcacion() {
        return nombreDeEmbarcacion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public Amarre getAmarre() {
        return amarre;
    }

    public void mostrarInformacion() {
        Consola.escribirLN("\t- Nombre de la embarcacion: " + nombreDeEmbarcacion);
        Consola.escribirLN("\t- Matricula: " + matricula);
        Consola.escribirLN("\t- Tipo de barco: " + tipo);
        Consola.escribirLN("\t- Dimensiones: " + dimensiones);
        Consola.escribirLN("\t- Amarre asignado: ");
        amarre.mostrarInformacion();
    }

    public void mostrarInformacionReducida() {
        amarre.mostrarInformacion();
    }

}
