package TRABAJO_FINAL;

public class Piso {
    private int numero;
    private Boton botonSubir;
    private Boton botonBajar;

    public Piso (int numero, boolean esPrimerPiso, boolean esUltimoPiso) {
        this.numero = numero;

        if (esPrimerPiso) {
            this.botonSubir = new Boton(numero, Direccion.SUBIENDO);
            this.botonBajar = null;
        }

        else if (esUltimoPiso) {
            this.botonSubir = null;
            this.botonBajar = new Boton(numero, Direccion.BAJANDO);
        }

        else {
            this.botonSubir = new Boton(numero, Direccion.SUBIENDO);
            this.botonBajar = new Boton(numero, Direccion.BAJANDO);
        }
    }
    
    public void presionarBotonSubir() {
        if (botonSubir != null) {
            botonSubir.presionar();
        }
    }
}
