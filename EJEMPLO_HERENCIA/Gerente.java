package EJEMPLO_HERENCIA;

public class Gerente extends Empleado {
    private double bono;

    public Gerente(String nombre, double salario, double bono) {
        super(nombre, salario);
        this.bono = bono;
    }

    @Override
    public double calcularPago() {
        return salario + bono;
    }

    @Override
    public void info() {
        System.out.println("El Gerente " + nombre + " gana $" + calcularPago());
    }
}
