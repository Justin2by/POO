package EJEMPLO_HERENCIA;

public class Vendedor extends Empleado {
    private double ventas;

    public Vendedor(String nombre, double salario, double ventas) {
        super(nombre, salario);
        this.ventas = ventas;
    }

    @Override
    public double calcularPago() {
        return salario + (ventas * 0.10);
    }

    @Override
    public void info() {
        System.out.println("El Vendedor " + nombre + " gana $" + calcularPago());
    }
}
