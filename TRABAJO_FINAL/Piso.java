package TRABAJO_FINAL;

/**
 * Clase que representa un piso del edificio
 */
public class Piso {
    private int numero;
    private Boton botonSubir;
    private Boton botonBajar;

    /**
     * Constructor para el piso
     * @param numero Número del piso
     * @param esPrimerPiso true si es el primer piso
     * @param esUltimoPiso true si es el último piso
     */
    public Piso(int numero, boolean esPrimerPiso, boolean esUltimoPiso) {
        this.numero = numero;

        // Primer piso solo tiene botón de subir
        if (esPrimerPiso) {
            this.botonSubir = new Boton(numero, Direccion.SUBIENDO);
            this.botonBajar = null;
        }
        // Último piso solo tiene botón de bajar
        else if (esUltimoPiso) {
            this.botonSubir = null;
            this.botonBajar = new Boton(numero, Direccion.BAJANDO);
        }
        // Pisos intermedios tienen ambos botones
        else {
            this.botonSubir = new Boton(numero, Direccion.SUBIENDO);
            this.botonBajar = new Boton(numero, Direccion.BAJANDO);
        }
    }

    /**
     * Presiona el botón de subir
     */
    public void presionarBotonSubir() {
        if (botonSubir != null) {
            botonSubir.presionar();
        }
    }

    /**
     * Presiona el botón de bajar
     */
    public void presionarBotonBajar() {
        if (botonBajar != null) {
            botonBajar.presionar();
        }
    }

    /**
     * Cancela la iluminación de los botones según la dirección del elevador
     * @param direccion La dirección en la que se mueve el elevador
     */
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

    public boolean tieneBotonBajarIluminado() {
        return botonBajar != null && botonBajar.isIluminado();
    }
}