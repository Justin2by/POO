package TRABAJO_FINAL;

import java.util.*;

public class ControlElevador {
    private Elevador elevador;
    private List<Piso> pisos;
    private Queue<Integer> solicitudesExternas;

    public ControlElevador(int numeroPisos) {
        this.elevador = new Elevador(numeroPisos);
        this.pisos = new ArrayList<>();
    }
}
