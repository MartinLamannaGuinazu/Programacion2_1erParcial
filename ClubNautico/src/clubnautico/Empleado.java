package clubnautico;

import java.io.IOException;
import java.util.ArrayList;

public class Empleado extends Usuario {

    private Zona zona;
    private String telefono;
    private String direccion;
    private String especialidad;

    public Empleado(Zona zona, String telefono, String direccion, String especialidad, String contrasena, String nombreCompleto) {
        super(contrasena, nombreCompleto);
        this.zona = zona;
        this.telefono = telefono;
        this.direccion = direccion;
        this.especialidad = especialidad;
    }

    @Override
    public Boolean proceder(SistemaGestion sistema) throws IOException {
        Boolean seguir = false;
        char opc, opc2;
        do {
            mostrarMenu();
            opc = Consola.leerCaracter();
            switch (opc) {
                case '1':
                    sistema.mostrarZonas();
                    break;
            }
            Consola.escribirLN("\n");
        } while (opc != '2');

        return seguir;
    }

    @Override
    public void mostrarMenu() {
        Consola.escribirLN(" -- MENU DE OPCIONES PARA EMPLEADOS -- ");
        Consola.escribirLN(
                "[1] Mostrar zonas\n"
                + "[2] Salir del sistema");
    }

}
