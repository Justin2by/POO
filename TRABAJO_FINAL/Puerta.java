package TRABAJO_FINAL;

/**
 * Clase que representa la puerta del elevador
 */
public class Puerta {
    private EstadoPuerta estado;

    /**
     * Constructor por defecto - la puerta inicia cerrada
     */
    public Puerta() {
        this.estado = EstadoPuerta.CERRADA;
    }

    /**
     * Abre la puerta del elevador
     */
    public void abrir() {
        if (estado == EstadoPuerta.CERRADA) {
            estado = EstadoPuerta.ABIERTA;
            System.out.println("[PUERTA] Abierta");
        }
    }

    /**
     * Cierra la puerta del elevador
     */
    public void cerrar() {
        if (estado == EstadoPuerta.ABIERTA) {
            estado = EstadoPuerta.CERRADA;
            System.out.println("[PUERTA] Cerrada");
        }
    }

    // Getter
    public EstadoPuerta getEstado() {
        return estado;
    }
}