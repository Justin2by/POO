package TRABAJO_FINAL;

/**
 * Clase que representa un botón del sistema de ascensor
 * Puede ser un botón dentro del elevador o en los pisos
 */
public class Boton {
    private int numeroPiso;
    private boolean ilumado;
    private boolean esBoton; // true si está en el piso, false si está dentro del elevador
    private Direccion direccionSolicitada; // Solo aplica para botones de piso

    /**
     * Constructor para botones dentro del elevador
     * 
     * @param numeroPiso El número de piso que representa este botón
     */
    public Boton(int numeroPiso) {
        this.numeroPiso = numeroPiso;
        this.iluminado = false;
        this.esBotonPiso = false;
        this.direccionSolicitada = null;
    }

    /**
     * Constructor para botones en los pisos
     * 
     * @param numeroPiso El número de piso donde está ubicado el botón
     * @param direccion  La dirección solicitada (SUBIENDO o BAJANDO)
     */
    public Boton(int numeroPiso, Direccion direccion) {
        this.numeroPiso = numeroPiso;
        this.iluminado = false;
        this.esBotonPiso = true;
        this.direccionSolicitada = direccion;
    }

    /**
     * Ilumina el botón cuando es presionado
     */
    public void iluminar() {
        this.iluminado = true;
        System.out.println(
                "[ILUMINADO] Boton del piso " + numeroPiso + (esBotonPiso ? " (" + direccionSolicitada + ")" : ""));
    }

    /**
     * Cancela la iluminación del botón
     */
    public void cancelarIluminacion() {
        this.iluminado = false;
        System.out.println(
                "[APAGADO] Boton del piso " + numeroPiso + (esBotonPiso ? " (" + direccionSolicitada + ")" : ""));
    }

    /**
     * Presiona el botón
     * 
     * @return true si el botón fue presionado exitosamente
     */
    public boolean presionar() {
        if (!iluminado) {
            iluminar();
            return true;
        }
        return false;
    }

    // Getters
    public int getNumeroPiso() {
        return numeroPiso;
    }

    public boolean isIluminado() {
        return iluminado;
    }

    public boolean isBotonPiso() {
        return esBotonPiso;
    }

    public Direccion getDireccionSolicitada() {
        return direccionSolicitada;
    }
}    