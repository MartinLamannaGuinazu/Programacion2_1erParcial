package clubnautico;

import java.io.IOException;

public class Control {

    public void ejecutar() throws IOException {
        SistemaGestion sistemaGestion = new SistemaGestion();
        boolean seguir;
        try {
            sistemaGestion = sistemaGestion.deSerializar("clubNautico.txt");
            seguir = Consola.leerBoolean("SISTEMA DEL CLUB NAUTICO\nDesea ingresar?");
        } catch (Exception e) {
            String contrasena = Consola.leer("Primer arranque del sistema.\n" + "Administrador, ingrese su contrasenia: ");
            if (contrasena.equals("")) {
                throw new NullPointerException("[ERROR] La contrasena no puede ser nula.");
            }
            String nombreCompleto = Consola.leer("Ingrese su nombre completo: ");
            Usuario u = new Administrador(contrasena, nombreCompleto);
            sistemaGestion.agregarUsuario(u);

            try {
                sistemaGestion.serializar("clubNautico.txt");
                Consola.escribirLN("El arranque ha sido exitoso, se debe reiniciar el sistema.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            seguir = false;
        }

        while (seguir) {
            String contrasena = Consola.leer("Ingrese su contrasena: ");
            String nombreCompleto = Consola.leer("Ingrese su nombre: ");
            Usuario u = sistemaGestion.buscarUsuario(contrasena, nombreCompleto);
            if (u == null) {
                Consola.escribirLN("[ERROR] No existe ningun Usuario con esa contrasena o nombre.");
            } else {
                seguir = u.proceder(sistemaGestion);
            }
        }
    }
}
