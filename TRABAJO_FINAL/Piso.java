package TRABAJO_FINAL;

/**
 * Clase que representa un piso del edificio
 */
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

    public void cancelarIluminacion(Direccion direccion) {
        if (direccion == Direccion.SUBIENDO && botonSubir != null && botonSubir.isIluminado()) {
            botonSubir.cancelarIluminacion();
        } else if (direccion == Direccion.BAJANDO && botonBajar != null & botonBajar.isIluminado()) {
            botonBajar.cancelarIluminacion();
        }

    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public Boton getBotonSubir() {
        return botonSubir;
    }

    public Boton getBotonBajar() {
        return botonBajar;
    }
    
    public boolean tieneBotonSubirIluminado() {
        return botonSubir != null && botonSubir.isIluminado();
    }    
}
