package TRABAJO_FINAL;

import java.util.*;

/**
 * Clase que controla la logica del sistema de elevador
 * Implementa el algoritmo de control basado en el pseudocodigo del documento
 */
public class ControlElevador {
    private Elevador elevador;
    private List<Piso> pisos;
    private Queue<Integer> solicitudesExternas;

    /**
     * Constructor del controlador
     * @param numeroPisos Cantidad total de pisos del edificio
     */
    public ControlElevador(int numeroPisos) {
        this.elevador = new Elevador(numeroPisos);
        this.pisos = new ArrayList<>();
        this.solicitudesExternas = new LinkedList<>();

        // Crear los pisos del edificio
        for (int i = 1; i <= numeroPisos; i++) {
            boolean esPrimero = (i == 1);
            boolean esUltimo = (i == numeroPisos);
            pisos.add(new Piso(i, esPrimero, esUltimo));
        }
    }

    /**
     * Loop principal de control del elevador
     */
    public void loopControlElevador() {
        System.out.println();
        System.out.println("========================================================");
        System.out.println("         SISTEMA DE CONTROL DE ELEVADOR");
        System.out.println("========================================================");
        System.out.println();

        // Procesar solicitudes externas primero
        procesarSolicitudesExternas();

        // Mientras haya peticiones pendientes
        while (elevador.tienePeticiones()) {

            // Atender el piso actual si hay peticion            
            if (elevador.getPeticiones().contains(elevador.getPisoActual())) {
                elevador.atenderPisoActual();

                // Cancelar iluminacion de botones del piso
                Piso pisoActual = pisos.get(elevador.getPisoActual() - 1);
                pisoActual.cancelarIluminacion(elevador.getDireccion());
            }

            // Si todavia hay peticiones, determinar direccion y moverse
            if (elevador.tienePeticiones()) {
                elevador.determinarDireccion();

                // Si hay peticiones en la direccion actual, moverse
                if (elevador.hayPeticionesEnDireccion()) {
                    elevador.mover();
                } else {
                    // Si no hay peticiones en esta direccion, cambiar direccion                    
                    elevador.determinarDireccion();
                    if (elevador.getDireccion() != Direccion.DETENIDO) {
                        elevador.mover();
                    }
                }
            }
        }
        
        // Asegurar que el elevador se detiene al final
        if (elevador.getDireccion() != Direccion.DETENIDO) {
            elevador.parar();
        }

        System.out.println();
        System.out.println("========================================================");
        System.out.println("   Todas las peticiones atendidas");
        System.out.println("   Elevador en reposo en piso " + elevador.getPisoActual());
        System.out.println("========================================================");
        System.out.println();

    }

    private void procesarSolicitudesExternas() {
        while (!solicitudesExternas.isEmpty()) {
            Integer piso = solicitudesExternas.poll();
            elevador.agregarPeticion(piso);
        }
    }

    public void solicitarElevador(int numeroPiso, Direccion direccion) {
        if (numeroPiso < 1 || numeroPiso > pisos.size()) {
            System.out.println("[ERROR] Piso invalido: " + numeroPiso);
            return;
        }

        Piso piso = pisos.get(numeroPiso - 1);

        if (direccion == Direccion.SUBIENDO) {
            piso.presionarBotonSubir();
        } else if (direccion == Direccion.BAJANDO) {
            piso.presionarBotonBajar();
        }

        solicitudesExternas.add(numeroPiso);
    }

    public void presionarBotonInterno(int piso) {
        elevador.agregarPeticion(piso);
    }

    // Getters
    public Elevador getElevador() {
        return elevador;
    }

    public List<Piso> getPisos() {
        return pisos;
    }
}
