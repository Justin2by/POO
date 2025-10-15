package EJERCICIOS;

public class Persona {

    String Nombre;
    int Edad;
    String Sexo;

    public Persona(String Nombre, int Edad, String Sexo){
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Sexo = Sexo;
        }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;    
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;    
    }
    public String getSexo() {
        return Sexo;
    }   
    public String toString(){
        return "Hola, me llamo " + Nombre + ", tengo " + Edad + " años y soy " + Sexo + "";
    }   
    }