package TRABAJO_FINAL;

public class Main {
    
    public static void main(String[] args) {

        int numeroPisos = 10;
        ControlElevador control = new ControlElevador(numeroPisos);

        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println("========================================================");
        System.out.println();

        System.out.println();
        System.out.println("--- ESCENARIO 1: Uso basico del elevador ---");
        System.out.println();
        escenario1(control);
        
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

    private static void escenario1(ControlElevador control) {
        System.out.println();
        control.solicitarElevador(1, Direccion.SUBIENDO);
        
        System.out.println();
        control.presionarBotonInterno(5);

        control.loopControlElevador();
    }
}
