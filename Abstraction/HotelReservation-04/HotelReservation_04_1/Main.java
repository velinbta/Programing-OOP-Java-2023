package HotelReservation_04_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = readData(scanner);

        double pricePerDay = Double.parseDouble(data[0]);
        int numberOfDays = Integer.parseInt(data[1]);
        String season = data[2];
        String discountType = data[3];

        // Пресмята резултат по зададени критерии
        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);
        double result = priceCalculator.calculate();

        System.out.printf("%.2f\n", result);

    }

    private static String[] readData(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

}
