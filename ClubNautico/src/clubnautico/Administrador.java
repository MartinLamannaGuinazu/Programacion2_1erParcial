package clubnautico;

import java.io.IOException;

public class Administrador extends Usuario {

    public Administrador(String contrasena, String nombreCompleto) {
        super(contrasena, nombreCompleto);
    }

    @Override
    public Boolean proceder(SistemaGestion sistema) throws IOException {
        Boolean seguir = false;
        char opc = 0, opc2 = 0;
        do {
            mostrarMenu();
            opc = Consola.leerCaracter();
            switch (opc) {

                case '1':
                    do {
                        mostrarSubMenuRegistrar();
                        opc2 = Consola.leerCaracter();
                        switch (opc2) {
                            case '1':
                                sistema.pedirDatos();
                                break;

                            case '2':
                                sistema.pedirDatosEmbarcacion();
                                break;
                                
                            case '3':
                                sistema.pedirDatosZona();
                                break;
                        }
                    } while (opc2 == 4);
                    break;
            }
            sistema.serializar("clubNautico.txt");
            Consola.escribirLN("\n");
        } while (opc != '2');

        return seguir;
    }

    @Override
    public void mostrarMenu() {
        Consola.escribirLN(" -- MENU DE OPCIONES PARA ADMINISTRADOR -- ");
        Consola.escribirLN(
                "[1] Crear (Usuario | Embarcacion | Zona)\n"
                + "[2] Salir del sistema");
    }

    private void mostrarSubMenuRegistrar() {
        Consola.escribirLN(" -- SUBMENU DE OPCIONES PARA CREAR -- ");
        Consola.escribirLN(
                "[1] Crear un nuevo usuario\n"
                + "[2] Crear nueva embarcacion\n"
                + "[3] Crear nueva zona\n"
                + "[4] Salir de este submenu");
    }
}
