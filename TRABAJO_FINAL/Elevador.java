package TRABAJO_FINAL;

import java.util.ArrayList;
import java.util.List;

public class Elevador {
    private int pisoActual;
    private Direccion direccion;
    private Puerta puerta;
    private List <Boton> botonesInternos;
    private int pisoMinimo;
    private int pisoMaximo;
    private List<Integer> peticiones;

    public Elevador (int numeroPisos) {
        this.pisoMinimo = 1;
        this.pisoMaximo = numeroPisos;
        this.pisoActual = 1;
        this.direccion = Direccion.DETENIDO;
        this.puerta = new Puerta();
        this.botonesInternos = new ArrayList<>();
        this.peticiones = new ArrayList<>();

        for (int i = pisoMinimo; i <= pisoMaximo; i++) {
            botonesInternos.add(new Boton(i));
        }
    }

    public void mover() {
        if (direccion == Direccion.SUBIENDO && pisoActual < pisoMaximo) {
            pisoActual++;
            System.out.println("[MOVIMIENTO] Elevador subiendo... Piso actual: " + pisoActual);
        } else if (direccion == Direccion.BAJANDO && pisoActual > pisoMinimo) {
            System.out.println("[MOVIMIENTO] Elevador bajando... Piso actual: " + pisoActual);            
        }
    }

    public void parar() {
        direccion = Direccion.DETENIDO;
        System.out.println("[DETENIDO] Elevador detenido en piso " + pisoActual);
    }

    public boolean agregarPeticion (int piso) {
        if (piso < pisoMininmo || piso > pisoMaximo) {
            System.out.println("[ERROR] Piso invalido: " + piso);
            return false;
        }

        if (!peticiones.contains(piso) && piso != pisoActual) {
            peticiones.add(piso);
            botonesInternos.get(piso - 1).iluminar();
            System.out.println("[OK] Peticion agregada para piso " + piso);
            return true;
        }
        return false;        
    }

    public void atenderPisoActual() {
        if (peticiones.contains(pisoActual)) {
            parar();
            puerta.abrir();
            
        }
    }

}
