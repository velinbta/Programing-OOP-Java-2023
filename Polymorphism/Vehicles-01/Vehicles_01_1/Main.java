package Vehicles_01_1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static final String CAR_COMMAND = "Car";
    public static final String TRUCK_COMMAND = "Truck";
    public static final String DRIVE_COMMAND = "Drive";
    public static final String REFUEL_COMMAND = "Refuel";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = readArray(scanner);
        String[] truckData = readArray(scanner);

        // derived classes
        Vehicle car = createVehicle(carData);
        Vehicle truck = createVehicle(truckData);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {

            String[] data = readArray(scanner);
            String command = data[0];
            String vehicle = data[1];

            switch (vehicle) {

                case CAR_COMMAND:

                    switch (command) {

                        case DRIVE_COMMAND:

                            double distance = Double.parseDouble(data[2]);
                            String travel = getTravelDistanceInfo(car, distance);
                            System.out.println(travel);

                            break;

                        case REFUEL_COMMAND:

                            double liters = Double.parseDouble(data[2]);
                            car.refuel(liters);

                            break;

                        default:
                            throw argumentException("Unknown command " + command);
                    }

                    break;

                case TRUCK_COMMAND:

                    switch (command) {

                        case DRIVE_COMMAND:

                            double distance = Double.parseDouble(data[2]);
                            String travel = getTravelDistanceInfo(truck, distance);
                            System.out.println(travel);

                            break;

                        case REFUEL_COMMAND:

                            double liters = Double.parseDouble(data[2]);
                            truck.refuel(liters);

                            break;

                        default:
                            throw argumentException("Unknown command " + command);
                    }

                    break;

                default:
                    throw argumentException("Unknown vehicle " + vehicle);

            }

        }

        System.out.println(car);
        System.out.println(truck);

    }

    public static Vehicle createVehicle(String[] data) {
        // creates new derived from Vehicle
        String vehicle = data[0];
        double fuelQuantity = Double.parseDouble(data[1]);
        double litersPerKm = Double.parseDouble(data[2]);

        switch (vehicle) {
            case CAR_COMMAND:
                return new Car(fuelQuantity, litersPerKm);
            case TRUCK_COMMAND:
                return new Truck(fuelQuantity, litersPerKm);
            default:
                throw argumentException("Unknown vehicle " + vehicle);
        }

    }

    public static String getTravelDistanceInfo(Vehicle vehicle, double distance) {
        // get travelled distance info based on: boolean drive
        DecimalFormat twoDigitsFormat = new DecimalFormat("#.##");

        return vehicle.drive(distance)
                ? String.format("%s travelled %s km", vehicle.getClass().getSimpleName(), twoDigitsFormat.format(distance))
                : String.format("%s needs refueling", vehicle.getClass().getSimpleName());
    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static IllegalArgumentException argumentException(String message) {
        throw new IllegalArgumentException(message);
    }

}
