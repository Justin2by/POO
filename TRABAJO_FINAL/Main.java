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

        // Escenario 1: simulación básica
        System.out.println();
        System.out.println("--- ESCENARIO 1: Una sola persona usa el elevador ---");
        System.out.println();
        escenario1(control);

        // Escenario extra: ascensor baja desde donde quedó hasta el piso 1
        System.out.println();
        System.out.println("--- ESCENARIO EXTRA: Ascensor baja del piso actual al piso 1 ---");
        System.out.println();
        escenarioExtra(control);

        System.out.println();
        System.out.println("========================================================");
        System.out.println("           SIMULACION COMPLETADA CON EXITO");
        System.out.println("========================================================");
        System.out.println();
    }

    /**
     * Escenario 1:
     * Un pasajero en el piso 1 solicita el elevador para SUBIR
     * y luego presiona el piso 5 dentro del elevador.
     */
    private static void escenario1(ControlElevador control) {

        System.out.println("[INFO] Pasajero en piso 1 solicita elevador para SUBIR");
        control.solicitarElevador(1, Direccion.SUBIENDO);

        System.out.println("[INFO] Pasajero aborda y presiona boton del piso 5");
        control.presionarBotonInterno(5);

        // Ejecutar el ciclo de control
        control.loopControlElevador();
    }

    /**
     * Escenario extra:
     * 1) Reutiliza el estado del elevador después del escenario 1
     * (por ejemplo, quedó en reposo en el piso 5).
     * 2) Un nuevo pasajero en el piso 1 llama al elevador para SUBIR.
     * 3) Cuando llega el elevador al piso 1, el pasajero presiona el piso 3.
     * 4) El elevador baja desde donde esté (ej: 5) hasta el piso 1 y luego sube al
     * 3.
     */
    private static void escenarioExtra(ControlElevador control) {

        // Paso 1: la persona llama al ascensor desde el piso 1
        System.out.println("[INFO] Nuevo pasajero en piso 1 solicita elevador para SUBIR");
        control.solicitarElevador(1, Direccion.SUBIENDO);

        // Paso 2: correr el loop para que el ascensor vaya desde donde esté (ej. 5)
        // hasta el 1
        control.loopControlElevador();

        // Paso 3: ahora el ascensor ya está en el piso 1; la persona se sube y presiona
        // piso 3
        System.out.println("[INFO] Pasajero ya dentro del ascensor presiona boton del piso 3");
        control.presionarBotonInterno(3);

        // Paso 4: correr el loop otra vez para ir del piso 1 al piso 3
        control.loopControlElevador();
    }

}
