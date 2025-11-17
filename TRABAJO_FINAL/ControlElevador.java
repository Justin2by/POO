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
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
