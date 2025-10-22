package CLASE_13;

public class Main {
    public static void main(String[] args) {
        Motor objMotor = new Motor("FE3456", "Mercedez");
        Conductor objConductor = new Conductor(90876, "Lio Messi");

        System.out.println(objMotor);
        System.out.println(objConductor);

        Vehiculo objVehiculo = new Vehiculo("POM321", objMotor);

        System.out.println(objVehiculo);
        objVehiculo.asignarConductor(objConductor);

    }
}
