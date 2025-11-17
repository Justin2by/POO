package TRABAJO_FINAL;

public class Elevador {
    private int pisoActual;
    private Direccion direccion;
    private Puerta puerta;
    private List <Boton> botonesInternos;
    private int pisoMinimo;
    private int pisoMaximo;
    private List<Integer> peticiones;

    public Elevador (int numeroPisos) {
        this.pisoMinimo = 1;
        this.pisoMaximo = numeroPisos;
        this.pisoActual = 1;
    }
}
