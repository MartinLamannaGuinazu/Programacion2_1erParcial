package clubnautico;

import java.io.Serializable;
import java.util.ArrayList;

public class Zona implements Serializable {

    private char letra;
    private String tipoDeBarco;
    private int cantidadBarcos;
    private double profundidad;
    private double anchoDeAmarre;
    private ArrayList<Embarcacion> embarcaciones;

    public Zona(char letra, String tipoDeBarco, int cantidadBarcos, double profundidad, double anchoDeAmarre, ArrayList<Embarcacion> embarcaciones) {
        this.letra = letra;
        this.tipoDeBarco = tipoDeBarco;
        this.cantidadBarcos = cantidadBarcos;
        this.profundidad = profundidad;
        this.anchoDeAmarre = anchoDeAmarre;
        this.embarcaciones = embarcaciones;
    }

    public char getLetra() {
        return letra;
    }

    public String getTipoDeBarco() {
        return tipoDeBarco;
    }

    public int getCantidadBarcos() {
        return cantidadBarcos;
    }

    public void agregarBarco(Embarcacion e) {
        embarcaciones.add(e);
        cantidadBarcos++;
    }

    public void setCantidadBarcos(int cantidadBarcos) {
        this.cantidadBarcos = cantidadBarcos;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public double getAnchoDeAmarre() {
        return anchoDeAmarre;
    }

    /*public ArrayList<Embarcacion> getEmbarcaciones() {
        return embarcaciones;
    }*/
    
    public void mostrarInformacion() {
        Consola.escribirLN("- Zona: " + letra);
        Consola.escribirLN("- Tipo de barco de la zona: " + tipoDeBarco);
        Consola.escribirLN("- Cantidad de barcos en la zona: " + cantidadBarcos);
        Consola.escribirLN("- Profundidad de la zona: " + profundidad);
        Consola.escribirLN("- Ancho de amarres de la zona: " + anchoDeAmarre);
        Consola.escribirLN("- Amarres de la zona: \n");
        for (Embarcacion embarcacion : embarcaciones) {
            embarcacion.mostrarInformacionReducida();
        }
    }
}
