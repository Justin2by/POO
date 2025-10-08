public class Main {
    public static void main(String[] args) throws Exception {
        //Creación del Objeto
        Libro objLibro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 2000);
        Libro objLibro2 = new Libro("Ser Digital", "Nicolás Negroponte", 2005);
        Libro objLibro3 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943);
        
        //PRACTICAS

        //Impresión de los Objetos
        System.out.println("-------------Libros-------------");
        System.out.println(objLibro1);
        System.out.println(objLibro2);
        System.out.println(objLibro3);

        //Separador
        System.out.println("-------------Modificación de Atributos-------------");

        //Ejemplos de uso de los métodos set y get
 
        objLibro3.setAnioPublicacion(1845);
        System.out.println(objLibro3);

        objLibro2.setTitulo("Peppa Pig");
        System.out.println(objLibro2);
        System.out.println("Titulo: " + objLibro2.getTitulo());

        objLibro2.setAutor("Alan Kean");
        System.out.println("Autor: " + objLibro2.getAutor());

        objLibro2.setAnioPublicacion(2010);
        System.out.println("Año de Publicación: " + objLibro2.getAnioPublicacion());   


        }
    }
