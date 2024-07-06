package clubnautico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SistemaGestion implements Serializable {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Embarcacion> embarcaciones;
    private ArrayList<Zona> zonas;

    // CONST+RUCTOR
    public SistemaGestion() {
        this.usuarios = new ArrayList<>();
        this.embarcaciones = new ArrayList<>();
        this.zonas = new ArrayList<>();
    }

    // UTILIDADES
    private int elegirOpcion(int max) {
        int opc = Consola.leerEntero();
        while (opc < 1 || opc > max) {
            opc = Consola.leerEntero("[ERROR] Ingrese un valor disponible: ");
        }
        return (opc - 1);
    }

    // GESTION DE ARCHIVOS
    public void serializar(String arch) throws IOException {
        FileOutputStream file = new FileOutputStream(arch);
        ObjectOutputStream oi = new ObjectOutputStream(file);
        oi.writeObject(this);
        oi.close();
        file.close();
    }

    public SistemaGestion deSerializar(String arch) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(arch);
        ObjectInputStream oi = new ObjectInputStream(file);
        SistemaGestion sistema = (SistemaGestion) oi.readObject();
        oi.close();
        file.close();
        return sistema;
    }

    //EMBARCACION
    public Embarcacion buscarEmbarcacion(String matricula) {
        int i = 0;
        Embarcacion barco;
        while (i < embarcaciones.size() && !matricula.equals(embarcaciones.get(i).getMatricula())) {
            i++;
        }
        barco = i < embarcaciones.size() ? embarcaciones.get(i) : null;
        return barco;
    }

    public void mostrarEmbarcacion(String matricula) {
        if (existeEmbarcacion(matricula)) {
            buscarEmbarcacion(matricula).mostrarInformacion();
        } else {
            Consola.escribirLN("No hay una embarcacion con esa matricula en el club.");
        }
    }

    public Boolean existeEmbarcacion(String matricula) {
        return buscarEmbarcacion(matricula) != null;
    }

    public void agregarEmbarcacion(Embarcacion e) {
        if (buscarEmbarcacion(e.getMatricula()) == null) {
            this.embarcaciones.add(e);
        } else {
            Consola.escribirLN("Ya existe una matricula con la serie " + e.getMatricula());
        }
    }

    public void pedirDatosEmbarcacion() {
        Zona zona = null;
        String matricula = Consola.leer("Ingrese la matricula de la embarcacion: ");
        while (existeEmbarcacion(matricula)) {
            matricula = Consola.leer("[ERROR] Matricula ya existente, ingrese otra: ");
        }
        String nombreEmbarcacion = Consola.leer("Ingrese el nombre de la embarcacion: ");
        String tipo = Consola.leer("Ingrese el tipo de barco: ");
        String dimensiones = Consola.leer("Ingrese las dimensiones del barco: ");
        zona = elegirZonaDisponible();
        Embarcacion e = new Embarcacion(zona, matricula, nombreEmbarcacion, tipo, dimensiones, pedirDatosAmarre());

        agregarEmbarcacion(e);
        zona.agregarBarco(e);
    }

    public Amarre pedirDatosAmarre() {
        Amarre a;
        int numeroDeAmarre = Consola.leerEntero("Ingrese el numero de amarre: ");
        double contadorDeLuz = Consola.leerDouble("Ingrese el contador de luz: ");
        double contadorDeAgua = Consola.leerDouble("Ingrese el contador de agua: ");
        boolean mantenimiento = Consola.leerBoolean("Tiene mantenimiento ");
        String fechaDeCompra = Consola.leer("Ingrese la fecha de compra del amarre: ");
        a = new Amarre(numeroDeAmarre, contadorDeLuz, contadorDeAgua, mantenimiento, fechaDeCompra);
        return a;
    }

    //ZONA
    public void mostrarZonas() {
        for (Zona zona : zonas) {
            zona.mostrarInformacion();
        }
    }

    public Zona buscarZona(char letra) {
        int i = 0;
        Zona zona;
        while (i < zonas.size() && (letra != (zonas.get(i).getLetra()))) {
            i++;
        }
        zona = i < zonas.size() ? zonas.get(i) : null;
        return zona;
    }

    public Boolean existeZona(char letra) {
        return buscarZona(letra) != null;
    }

    public void agregarZona(Zona z) {
        if (buscarZona(z.getLetra()) == null) {
            this.zonas.add(z);
        } else {
            Consola.escribirLN("Ya existe una matricula con el numero: " + z.getLetra());
        }
    }

    public void pedirDatosZona() {
        char letra = Consola.leerCaracter("Ingrese la letra de la zona: ");
        while (existeZona(letra)) {
            letra = Consola.leerCaracter("[ERROR] Zona con esa letra ya existente, ingrese otra: ");
        }

        String tipoDeBarco = Consola.leer("Ingrese el tipo de barco de la zona: ");
        int cantidadBarcos = 0;
        double profundidad = Consola.leerDouble("Ingrese la profundidad de la zona: ");
        double anchoDeAmarre = Consola.leerDouble("Ingrese el ancho de los amarres de la zona: ");
        ArrayList<Embarcacion> embarcaciones = new ArrayList<>();

        agregarZona(new Zona(letra, tipoDeBarco, cantidadBarcos, profundidad, anchoDeAmarre, embarcaciones));
    }

    public Zona elegirZonaDisponible() {
        Consola.escribirLN("Opciones de zonas disponibles: ");
        for (Zona zona : zonas) {
            Consola.escribir("[" + (zonas.indexOf(zona) + 1) + "] ");
            zona.mostrarInformacion();
        }
        int opc = elegirOpcion(zonas.size());
        return zonas.get(opc);

    }

    //USUARIO
    public Usuario buscarUsuario(String contrasena, String nombreCompleto) {
        int i = 0;
        Usuario u;
        // Se mantiene en el while si el contador 'i' es menor a la cantidad de usuarios en el Array, y si el los datos ingresados (contrasena y nombre)
        // son distintos de los daots obtenidos en la posicion 'i' en el array de usuarios.
        while (i < usuarios.size() && (!contrasena.equals(usuarios.get(i).getContrasena()) || !nombreCompleto.equals(usuarios.get(i).getNombre()))) {
            i++;
        }
        u = i < usuarios.size() ? usuarios.get(i) : null;
        return u;
    }

    public void agregarUsuario(Usuario u) {
        if (!existeUsuario(u.getContrasena(), u.getNombre())) {
            this.usuarios.add(u);
        } else {
            Consola.escribirLN("Ya existe un usuario con esos datos " + u.getContrasena() + u.getNombre());
        }
    }

    public Boolean existeUsuario(String contrasena, String nombreCompleto) {
        return buscarUsuario(contrasena, nombreCompleto) != null;
    }

    public Boolean existeUsuario(Usuario u) {
        return usuarios.contains(u);
    }

    public void pedirDatos() {
        String nombreCompleto = Consola.leer("Ingrese su nombre completo: ");
        String contrasena = Consola.leer("Ingrese su contrasena: ");
        while (existeUsuario(contrasena, nombreCompleto)) {
            Consola.escribirLN("[ERROR] Datos ya existentes, ingrese otros");
            nombreCompleto = Consola.leer("Ingrese su nombre completo: ");
            contrasena = Consola.leer("Ingrese su contrasena: ");
        }

        Amarre amarre = null;
        Embarcacion embarcacion = null;
        Zona zona = null;

        Usuario u = null;
        char opc = Consola.leerCaracter("Que tipo de usuario desea ingresar?\n[1] Socio\t[2] Empleado\t[3] Administrador: ");
        while (opc != '1' && opc != '2' && opc != '3') {
            opc = Consola.leerCaracter("[ERROR] Ingrese un numero valido: ");
        }
        switch (opc) {
            case '1':
                String direccion = Consola.leer("Ingrese la direccion del socio: ");
                String fechaDeIngreso = Consola.leer("Ingrese la fecha de ingreso al club del socio: ");
                String DNI = Consola.leer("Ingrese el DNI del socio: ");
                String telefono = Consola.leer("Ingrese el telefono del socio: ");
                u = new Socio(DNI, direccion, telefono, fechaDeIngreso, contrasena, nombreCompleto);
                break;

            case '2':
                String especialidad = Consola.leer("Ingrese la especialidad del empleado: ");
                direccion = Consola.leer("Ingrese la direccion del socio: ");
                telefono = Consola.leer("Ingrese el telefono del socio: ");
                zona = elegirZonaDisponible();
                u = new Empleado(zona, telefono, direccion, especialidad, contrasena, nombreCompleto);
                break;

            case '3':
                u = new Administrador(contrasena, nombreCompleto);
                break;
        }
        this.usuarios.add(u);
    }
}
