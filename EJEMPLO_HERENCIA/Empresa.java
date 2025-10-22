package EJEMPLO_HERENCIA;

public class Empresa {
    public static void main(String[] args) {
        Empleado e1 = new Vendedor("Justin Muñoz", 1200000, 5000000);
        Empleado e2 = new Gerente("Jhon Cano", 2000000, 800000);
        Empleado e3 = new Vendedor("Ana Perez", 1500000, 400000);
        e1.info();
        e2.info();
        e3.info();
    }
}
