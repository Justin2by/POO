package EJEMPLO_HERENCIA;

public class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public double calcularPago() {
        return salario;
    }

    public void info() {
        System.out.println(nombre + " gana $" + calcularPago());
    }
}
