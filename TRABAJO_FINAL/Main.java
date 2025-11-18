package TRABAJO_FINAL;

/**
 * Clase principal para demostrar el funcionamiento del sistema de elevador
 */
public class Main {

    public static void main(String[] args) {

        // Crear un edificio de 10 pisos
        int numeroPisos = 10;
        ControlElevador control = new ControlElevador(numeroPisos);

        System.out.println();
        System.out.println("========================================================");
        System.out.println("     SISTEMA DE ASCENSOR - EDIFICIO 10 PISOS");
        System.out.println("========================================================");
        System.out.println();

        // Escenario 1: Simulación básica
        System.out.println();
        System.out.println("--- ESCENARIO 1: Uso basico del elevador ---");
        System.out.println();
        escenario1(control);

        // Reiniciar el sistema para el siguiente escenario
        control = new ControlElevador(numeroPisos);

        System.out.println();
        System.out.println("--- ESCENARIO 2: Multiples solicitudes ---");
        System.out.println();
        escenario2(control);

        System.out.println();
        System.out.println("========================================================");
        System.out.println("           SIMULACION COMPLETADA CON EXITO");
        System.out.println("========================================================");
        System.out.println();
    }

    /**
     * Escenario 1: Uso básico del elevador
     * Un pasajero en el piso 1 quiere ir al piso 5
     */
    private static void escenario1(ControlElevador control) {
        System.out.println();
        control.solicitarElevador(1, Direccion.SUBIENDO);

        System.out.println();
        control.presionarBotonInterno(5);

        // Ejecutar el control del elevador
        control.loopControlElevador();
    }

    /**
     * Escenario 2: Múltiples solicitudes
     * Varios pasajeros en diferentes pisos
     */
    private static void escenario2(ControlElevador control) {
        System.out.println("[INFO] Pasajero en piso 3 solicita elevador para SUBIR");
        control.solicitarElevador(3, Direccion.SUBIENDO);

        System.out.println("[INFO] Pasajero en piso 7 solicita elevador para BAJAR");
        control.solicitarElevador(7, Direccion.BAJANDO);

        System.out.println("[INFO] Pasajero en piso 2 solicita elevador para SUBIR");
        control.solicitarElevador(2, Direccion.SUBIENDO);

        // Simular que los pasajeros presionan botones internos
        System.out.println();
        System.out.println("[INFO] Pasajeros abordan y presionan sus destinos:");
        control.presionarBotonInterno(8); // Pasajero del piso 3 va a piso 8
        control.presionarBotonInterno(1); // Pasajero del piso 7 va a piso 1
        control.presionarBotonInterno(6); // Pasajero del piso 2 va a piso 6

        // Ejecutar el control del elevador
        control.loopControlElevador();
    }

}