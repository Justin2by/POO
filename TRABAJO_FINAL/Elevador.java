package TRABAJO_FINAL;

import java.util.*;

/**
 * Clase que representa el elevador fisico
 */
public class Elevador {
    private int pisoActual;
    private Direccion direccion;
    private Puerta puerta;
    private List<Boton> botonesInternos;
    private int pisoMinimo;
    private int pisoMaximo;
    private List<Integer> peticiones;  // Lista de pisos solicitados

    /**
     * Constructor del elevador
     * 
     * @param numeroPisos Cantidad total de pisos del edificio
     */
    public Elevador(int numeroPisos) {
        this.pisoMinimo = 1;
        this.pisoMaximo = numeroPisos;
        this.pisoActual = 1; // Inicia en el primer piso
        this.direccion = Direccion.DETENIDO;
        this.puerta = new Puerta();
        this.botonesInternos = new ArrayList<>();
        this.peticiones = new ArrayList<>();

        // Crear botones internos para cada piso
        for (int i = pisoMinimo; i <= pisoMaximo; i++) {
            botonesInternos.add(new Boton(i));
        }
    }

    /**
     * Mueve el elevador un piso en la direccion actual
     */
    public void mover() {
        if (direccion == Direccion.SUBIENDO && pisoActual < pisoMaximo) {
            pisoActual++;
            System.out.println("[MOVIMIENTO] Elevador subiendo... Piso actual: " + pisoActual);

        } else if (direccion == Direccion.BAJANDO && pisoActual > pisoMinimo) {
            pisoActual--;
            System.out.println("[MOVIMIENTO] Elevador bajando... Piso actual: " + pisoActual);
        }
    }

    /**
     * Detiene el elevador
     */
    public void parar() {
        direccion = Direccion.DETENIDO;
        System.out.println("[DETENIDO] Elevador detenido en piso " + pisoActual);
    }

    /**
     * Agrega una peticion de piso
     * 
     * @param piso El piso solicitado
     * @return true si la peticion fue agregada exitosamente
     */
    public boolean agregarPeticion(int piso) {
        if (piso < pisoMinimo || piso > pisoMaximo) {
            System.out.println("[ERROR] Piso invalido: " + piso);
            return false;
        }

        if (!peticiones.contains(piso) ) {
            peticiones.add(piso);
            // Iluminar el boton correspondiente
            botonesInternos.get(piso - 1).iluminar();
            System.out.println("[OK] Peticion agregada para piso " + piso);
            return true;
        }
        return false;
    }

    /**
     * Atiende la peticion del piso actual
     */
    public void atenderPisoActual() {
        // Verificar si hay peticion para este piso
        if (peticiones.contains(pisoActual)) {
            parar();
            puerta.abrir();

            // Cancelar iluminacion del boton
            botonesInternos.get(pisoActual - 1).cancelarIluminacion();
            peticiones.remove(Integer.valueOf(pisoActual));

            System.out.println("[ATENCION] Pasajeros descendiendo/abordando en piso " + pisoActual);

            puerta.cerrar();
        }
    }

    /**
     * Determina la siguiente direccion basandose en las peticiones
     */
    public void determinarDireccion() {
        if (peticiones.isEmpty()) {
            direccion = Direccion.DETENIDO;
            return;
        }

        // Encontrar la siguiente peticion mas cercana
        int siguientePiso = peticiones.get(0);
        for (int piso : peticiones) {
            if (Math.abs(piso - pisoActual) < Math.abs(siguientePiso - pisoActual)) {
                siguientePiso = piso;
            }
        }

        if (siguientePiso > pisoActual) {
            direccion = Direccion.SUBIENDO;
        } else if (siguientePiso < pisoActual) {
            direccion = Direccion.BAJANDO;
        } else {
            direccion = Direccion.DETENIDO;
        }
    }

    /**
     * Verifica si hay peticiones en la direccion actual
     */
    public boolean hayPeticionesEnDireccion() {
        for (int piso : peticiones) {
            if (direccion == Direccion.SUBIENDO && piso > pisoActual) {
                return true;
            } else if (direccion == Direccion.BAJANDO && piso < pisoActual) {
                return true;
            }
        }
        return false;
    }

    // Getters
    public int getPisoActual() {
        return pisoActual;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public List<Integer> getPeticiones() {
        return new ArrayList<>(peticiones);
    }

    public boolean tienePeticiones() {
        return !peticiones.isEmpty();
    }

    public int getPisoMinimo() {
        return pisoMinimo;
    }

    public int getPisoMaximo() {
        return pisoMaximo;
    }
}