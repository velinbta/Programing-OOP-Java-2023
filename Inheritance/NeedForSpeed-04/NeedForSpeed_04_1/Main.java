package NeedForSpeed_04_1;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // No specific task presented
        FamilyCar ford = new FamilyCar(100D, 75);
        SportCar toyotaSupra = new SportCar(77.3, 350);
        RaceMotorcycle kawasaki = new RaceMotorcycle(45D, 600);

        // Polymorphism
        driveVehicleMultipleTimes(ford, 1D, 100);
        driveVehicleMultipleTimes(toyotaSupra, 1D, 10);
        driveVehicleMultipleTimes(kawasaki, 1D, 10);

        // Specific class info
        System.out.println(ford);
        System.out.println(toyotaSupra);
        System.out.println(kawasaki);

    }

    public static void driveVehicleMultipleTimes(Vehicle vehicle, double kilometersToDrive, int countOfDrives) {
        // Can drive any vehicle
        IntStream.range(0, countOfDrives).forEach(n -> vehicle.drive(kilometersToDrive));
    }

}
