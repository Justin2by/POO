package TRABAJO_FINAL;

/**
 * Clase que representa un botón del sistema de ascensor
 * Puede ser un botón dentro del elevador o en los pisos
 */
public class Boton {
    private int numeroPiso;
    private boolean ilumado;
    private boolean esBoton;
    private Direccion direccionSolicitada;

    public Boton(int numeroPiso) {
        this.numeroPiso = numeroPiso;
        this.iluminado = false;
        this.esBotonPiso = false;
        this.direccionSolicitada = null;
    }

    public Boton(int numeroPiso, Direccion direccion){
        this.numeroPiso = numeroPiso;
        this.iluminado = false;
        this.esBotonPiso = true;
        this.direccionSolicitada = direccion;

    public void iluminar() {
        this.iluminado = true;
        System.out.println(
                "[ILUMINADO] Boton del piso " + numeroPiso + (esBotonPiso ? " (" + direccionSolicitada + ")" : ""));
    }

    public void cancelarIluminacion() {
        this.iluminado = false;
        System.out.println(
                "[APAGADO] Boton del piso " + numeroPiso + (esBotonPiso ? " (" + direccionSolicitada + ")" : ""));
    }

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