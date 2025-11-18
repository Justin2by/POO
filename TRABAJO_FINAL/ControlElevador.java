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

    public void loopControlElevador() {
        System.out.println();
        System.out.println("========================================================");
        System.out.println("         SISTEMA DE CONTROL DE ELEVADOR");
        System.out.println("========================================================");
        System.out.println();

        procesarSolicitudesExternas();

        while (elevador.tienePeticiones()) {
            if (elevador.getPeticiones().contains(elevador.getPisoActual())) {
                elevador.atenderPisoActual();

                Piso pisoActual = pisos.get(elevador.getPisoActual() - 1);
                pisoActual.cancelarIluminacion(elevador.getDireccion());
            }

            if (elevador.tienePeticiones()) {
                elevador.determinarDireccion();

                if (elevador.hayPeticionesEnDireccion()) {
                    elevador.mover();
                } else {
                    elevador.determinarDireccion();
                    if (elevador.getDireccion() != Direccion.DETENIDO) {
                        elevador.mover();
                    }
                }
            }
        }

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

    Piso piso = pisos.get(numeroPiso -1);

    if (direccion == Direccion.SUBIENDO) {
        
    }
}

