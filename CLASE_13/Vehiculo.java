package CLASE_13;

public class Vehiculo {
    private String placa;
    private Motor motor;

    public Vehiculo(String placa, Motor motor) {
        this.placa = placa;
        this.motor = motor;
    }

    public void asignarConductor(Conductor conductor) {
        System.out.println("El conductor@: " + conductor + " fue asignad@ ");
    }

    public String toString() {
        return "Vahiculo { Placa: " + placa + " Motor: " + motor + " }";
    }
}
