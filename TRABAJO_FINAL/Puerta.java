package TRABAJO_FINAL;

public class Puerta {
    private EstadoPuerta estado;

    public Puerta() {
        this.estado = EstadoPuerta.CERRADA;
    }

    public void abrir() {
        if (estado == EstadoPuerta.CERRADA) {
            estado = EstadoPuerta.ABIERTA;
            System.out.println("[PUERTA] Abierta");
        }
    }

    public void cerrar() {
        if (estado == EstadoPuerta.ABIERTA) {
            estado = EstadoPuerta.CERRADA;
            System.out.println("[PUERTA] Abierta");
        }
    }

    public boolean estaAbierta() {
        return estado == EstadoPuerta.ABIERTA;
    }

    public EstadoPuerta getEstado() {
        return estado;
    }
}
