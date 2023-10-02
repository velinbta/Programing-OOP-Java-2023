package Vehicles_01_2;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final String CAR_NAME = "Car";
    public static final String TRUCK_NAME = "Truck";
    public static final String DRIVE_COMMAND = "Drive";
    public static final String REFUEL_COMMAND = "Refuel";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = readArray(scanner);
        String[] truckData = readArray(scanner);

        Map<String, Vehicle> vehiclesByName = getMap(carData, truckData);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {

            String[] data = readArray(scanner);
            String command = data[0];
            String vehicleName = data[1];

            Vehicle vehicle = vehiclesByName.get(vehicleName); // <- avoids code repetition

            switch (command) {

                case DRIVE_COMMAND:

                    DecimalFormat df = new DecimalFormat("#.##"); // <- two digits, exclude trailing zeroes
                    double distance = Double.parseDouble(data[2]);

                    String result = vehicle.drive(distance) // <- if can drive
                            ? String.format("%s travelled %s km",
                            vehicle.getClass().getSimpleName(), df.format(distance))
                            : String.format("%s needs refueling", vehicle.getClass().getSimpleName());

                    System.out.println(result);

                    break;

                case REFUEL_COMMAND:

                    double liters = Double.parseDouble(data[2]);
                    vehicle.refuel(liters);

                    break;

                default:
                    throw new IllegalArgumentException("Unknown command " + command);
            }

        }

        vehiclesByName.values().forEach(System.out::println);

    }

    public static Map<String, Vehicle> getMap(String[] carData, String[] truckData) {
        // returns a new Map, consisting of Car and Truck
        Map<String, Vehicle> vehiclesByName = new LinkedHashMap<>();

        Vehicle car = getVehicle(carData);
        Vehicle truck = getVehicle(truckData);

        vehiclesByName.put(CAR_NAME, car);
        vehiclesByName.put(TRUCK_NAME, truck);

        return vehiclesByName;
    }

    private static Vehicle getVehicle(String[] data) {
        // parse Vehicle from String[] data
        String vehicleName = data[0];
        double fuelQuantity = Double.parseDouble(data[1]);
        double litersPerKm = Double.parseDouble(data[2]);

        switch (vehicleName) {
            case CAR_NAME:
                return new Car(fuelQuantity, litersPerKm);
            case TRUCK_NAME:
                return new Truck(fuelQuantity, litersPerKm);
            default:
                throw new IllegalArgumentException("Unknown vehicle " + vehicleName);
        }

    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

}
