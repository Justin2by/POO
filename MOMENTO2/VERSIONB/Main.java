package MOMENTO2.VERSIONB;

public class Main{
     public static void main(String[] args) {

     // Crear un producto y aplicar pruebas   
        Producto p1 = new Producto("B148", "Camiseta Nike Juset", 2, 150000);
        Producto p2 = new Producto("", "", -3, -10000);

        System.out.println("Producto válido: " + p1);
        System.out.println("Producto inválido: " + p2);

        p1.incrementarCantidad(3);
        p1.aplicarDescuento(20);
        double total = p1.calcularSubtotal();

        System.out.println("---Productos---");
        System.out.println(p1);
        System.out.println("Subtotal final: $" + total);
    }
}