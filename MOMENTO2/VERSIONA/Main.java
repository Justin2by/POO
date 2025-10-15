package MOMENTO2.VERSIONA;

public class Main {
    public static void main(String[] args) {

// Crear una cuenta v lida e inv lida
        CuentaBancaria cuenta1 = new CuentaBancaria("Justin", "123456", 500);
        CuentaBancaria cuenta2 = new CuentaBancaria("", "123", -100);

        System.out.println("Cuenta válida: " + cuenta1);
        System.out.println("Cuenta inválida: " + cuenta2);
        
// Depositar, retirar y mostrar resultados
        cuenta1.depositar(200);
        cuenta1.retirar(100);

        cuenta2.depositar(50);
        cuenta2.retirar(20);

        System.out.println("---Cuentas---");
        System.out.println("Cuenta válida: " + cuenta1);
        System.out.println("Cuenta inválida: " + cuenta2);
    }
}