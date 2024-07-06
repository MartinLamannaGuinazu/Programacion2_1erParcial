package clubnautico;

import java.util.Scanner;

public class Consola {

	private static Scanner input = new Scanner(System.in);

	private Consola(){}

	public static boolean leerBoolean(String mensaje) {
        return Consola.leer(mensaje + "[S/N]: ").equalsIgnoreCase("S");
    }

    public static void escribir(Object x) {
        System.out.print(x);
    }

    public static void escribirLN(Object x) {
        System.out.println(x);
    }

    public static String leer() {
        return input.nextLine();
    }

    public static String leer(String mensaje) {
        Consola.escribir(mensaje);
        return input.nextLine();
    }

    public static int leerEntero() {
        return Integer.parseInt(Consola.leer());
    }

    public static int leerEntero(String mensaje) {
        return Integer.parseInt(Consola.leer(mensaje));
    }

    public static double leerDouble() {
        return Double.parseDouble(Consola.leer());
    }

    public static double leerDouble(String mensaje) {
        return Double.parseDouble(Consola.leer(mensaje));
    }

    public static char leerCaracter() {
        return Consola.leer().charAt(0);
    }

    public static char leerCaracter(String mensaje) {
        return Consola.leer(mensaje).charAt(0);
    }

}