package clubnautico;

import java.io.IOException;
import java.io.Serializable;

public abstract class Usuario implements Serializable {

    private String contrasena;
    private String nombreCompleto;

    public Usuario(String contrasena, String nombreCompleto) {
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombre() {
        return this.nombreCompleto;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public abstract Boolean proceder(SistemaGestion sistema) throws IOException;

    public abstract void mostrarMenu();

    public void mostrarInformacion() {
        Consola.escribirLN("- Contrasena de usuario: " + contrasena);
        Consola.escribirLN("- Nombre completo: " + nombreCompleto);
    }

}
