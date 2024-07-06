package clubnautico;

import java.io.Serializable;

public class Amarre implements Serializable{
    private int numeroDeAmarre;
    private double contadorDeLuz;
    private double contadorDeAgua;
    private boolean mantenimiento;
    private String fechaDeCompra;

    public Amarre(int numeroDeAmarre, double contadorDeLuz, double contadorDeAgua, boolean mantenimiento, String fechaDeCompra) {
        this.numeroDeAmarre = numeroDeAmarre;
        this.contadorDeLuz = contadorDeLuz;
        this.contadorDeAgua = contadorDeAgua;
        this.mantenimiento = mantenimiento;
        this.fechaDeCompra = fechaDeCompra;
    }

    

    public int getNumeroDeAmarre() {
        return numeroDeAmarre;
    }

    public double getContadorDeLuz() {
        return contadorDeLuz;
    }

    public double getContadorDeAgua() {
        return contadorDeAgua;
    }

    public boolean isMantenimiento() {
        return mantenimiento;
    }

    public String getFechaDeCompra() {
        return fechaDeCompra;
    }
    
        public void mostrarInformacion() {
        Consola.escribirLN("\t- Numero de amarre: " + numeroDeAmarre);
        Consola.escribirLN("\t- Contador de luz: " + contadorDeLuz);
        Consola.escribirLN("\t- Contador de agua: " + contadorDeAgua);
        Consola.escribirLN("\t- Mantenimiento: " + (mantenimiento ? "Si":"No"));
        Consola.escribirLN("\t- Fecha de compra del amarre: " + fechaDeCompra);
    }
}
