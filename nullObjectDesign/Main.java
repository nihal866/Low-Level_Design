package nullObjectDesign;

public class Main {
    public static void main(String args[]){
        Vehicle vehicle = VehicleFactory.getVehicle("Car");
        printVehicle(vehicle);
    }

    private static void printVehicle(Vehicle vehicle){
        System.out.println("Vehicle capacity is: " + vehicle.getSeatCapacity());
    }
}
