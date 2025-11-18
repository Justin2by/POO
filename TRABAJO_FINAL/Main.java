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

        

    }
}
