package EJERCICIOS;

public class Presentacion {
    public static void main(String[] args) throws Exception {

        Persona Persona1 = new Persona("Ana", 25, "Mujer");
        Persona Persona2 = new Persona("Luis", 30, "Hombre");
        Persona Persona3 = new Persona("María", 28, "Mujer");

        System.out.println(Persona1);
        System.out.println(Persona2);
        System.out.println(Persona3);

        Persona1.setNombre("Pablo");
        Persona1.setSexo("Hombre");

        System.out.println(Persona1);

            }
        }


        