package TRABAJO_FINAL;

import java.util.*;

/**
 * Clase que representa el elevador fisico
 */
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
        if (piso < pisoMinimo || piso > pisoMaximo) {
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
            
            botonesInternos.get(pisoActual - 1).cancelarIluminacion();
            peticiones.remove(Integer.valueOf(pisoActual));

            System.out.println("[ATENCION] Pasajeros descendiendo/abordando en piso " + pisoActual);

            puerta.cerrar();
        }
    }

    public void determinarDireccion() {
        if (peticiones.isEmpty()) {
            direccion = Direccion.DETENIDO;
            return;
        }

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
}