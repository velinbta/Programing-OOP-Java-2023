package VehiclesExtension_02_1;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final String CAR_NAME = "Car";
    public static final String TRUCK_NAME = "Truck";
    public static final String BUS_NAME = "Bus";

    public static final String DRIVE_COMMAND = "Drive";
    public static final String DRIVE_EMPTY_BUS_COMMAND = "DriveEmpty";
    public static final String REFUEL_COMMAND = "Refuel";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = readArray(scanner);
        String[] truckData = readArray(scanner);
        String[] busData = readArray(scanner);

        // Map of Vehicle by name [Car, Truck, Bus]
        Map<String, Vehicle> vehiclesByName = getMap(carData, truckData, busData);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {

            String[] data = readArray(scanner);
            String command = data[0];
            String vehicleName = data[1];

            if (!vehiclesByName.containsKey(vehicleName)) {
                continue;
            }

            Vehicle vehicle = vehiclesByName.get(vehicleName); // <- avoids code repetition

            switch (command) {

                case DRIVE_COMMAND: {

                    double distance = Double.parseDouble(data[2]);

                    String result = vehicle.driveWithAC(distance)
                            ? getTravelledDistanceMessage(vehicle, distance)
                            : getRefuelMessage(vehicle);

                    System.out.println(result);
                }
                break;

                case DRIVE_EMPTY_BUS_COMMAND:

                    double distance = Double.parseDouble(data[2]);

                    String result = vehicle.driveWithoutAC(distance)
                            ? getTravelledDistanceMessage(vehicle, distance)
                            : getRefuelMessage(vehicle);

                    System.out.println(result);

                    break;

                case REFUEL_COMMAND:

                    double liters = Double.parseDouble(data[2]);

                    try {
                        vehicle.refuel(liters);
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }

                    break;
                // Ignore default
            }

        }

        vehiclesByName.values().forEach(System.out::println);

    }

    public static Map<String, Vehicle> getMap(String[] carData, String[] truckData, String[] busData) {
        // returns a new Map, consisting of Car, Truck and a Bus
        Map<String, Vehicle> vehiclesByName = new LinkedHashMap<>();

        Vehicle car = getVehicle(carData);
        Vehicle truck = getVehicle(truckData);
        Vehicle bus = getVehicle(busData);

        vehiclesByName.put(CAR_NAME, car);
        vehiclesByName.put(TRUCK_NAME, truck);
        vehiclesByName.put(BUS_NAME, bus);

        return vehiclesByName;
    }

    private static Vehicle getVehicle(String[] data) {
        // parse Vehicle from String[] data
        String vehicleName = data[0];
        double fuelQuantity = Double.parseDouble(data[1]);
        double litersPerKm = Double.parseDouble(data[2]);
        double tankCapacity = Double.parseDouble(data[3]);

        switch (vehicleName) {
            case CAR_NAME:
                return new Car(fuelQuantity, litersPerKm, tankCapacity);
            case TRUCK_NAME:
                return new Truck(fuelQuantity, litersPerKm, tankCapacity);
            case BUS_NAME:
                return new Bus(fuelQuantity, litersPerKm, tankCapacity);
            default:
                throw new IllegalArgumentException("Unknown vehicle " + vehicleName);
        }

    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static String getTravelledDistanceMessage(Vehicle vehicle, double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s travelled %s km",
                vehicle.getClass().getSimpleName(), df.format(distance));
    }

    private static String getRefuelMessage(Vehicle vehicle) {
        return String.format("%s needs refueling", vehicle.getClass().getSimpleName());
    }

}
