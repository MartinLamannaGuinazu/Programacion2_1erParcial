package clubnautico;

import java.io.IOException;
import java.util.ArrayList;

public class Socio extends Usuario {

    private String DNI;
    private String direccion;
    private String telefono;
    private String fechaDeIngreso;

    public Socio(String DNI, String direccion, String telefono, String fechaDeIngreso, String contrasena, String nombreCompleto) {
        super(contrasena, nombreCompleto);
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    @Override
    public Boolean proceder(SistemaGestion sistema) throws IOException {
        Boolean seguir = false;
        char opc;
        do {
            this.mostrarMenu();
            opc = Consola.leerCaracter();
            switch (opc) {
                case '1':
                    String matricula = Consola.leer("Ingrese la matricula: ");
                    sistema.mostrarEmbarcacion(matricula);
                    break;
            }
        } while (opc != '2');
        return seguir;
    }

    @Override
    public void mostrarMenu() {
        Consola.escribirLN(" -- MENU DE OPCIONES PARA SOCIO -- ");
        Consola.escribirLN("[1] Buscar embarcacion\n"
                + "[2] Salir del sistema");
    }

}
