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
        System.out.println("--- ESCENARIO 1: Una sola persona usa el elevador ---");
        System.out.println();
        escenario1(control);

        // Reiniciar el sistema para el siguiente escenario
        control = new ControlElevador(numeroPisos);

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
        System.out.println("[INFO] Pasajero en piso 1 solicita elevador para SUBIR");
        control.solicitarElevador(1, Direccion.SUBIENDO);

        System.out.println("[INFO] Pasajero aborda y presiona boton del piso 5");
        control.presionarBotonInterno(5);

        // Ejecutar el control del elevador
        control.loopControlElevador();
    }

}