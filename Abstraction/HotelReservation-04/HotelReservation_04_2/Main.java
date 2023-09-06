package HotelReservation_04_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(data[0]);
        int numberOfDays = Integer.parseInt(data[1]);
        Season season = Season.parse(data[2]);
        DiscountType discountType = DiscountType.parse(data[3]);

        // Статичен клас PriceCalculator изчислява крайния резултат
        double result = PriceCalculator.calculatePrice(pricePerDay, numberOfDays, season, discountType);

        System.out.printf("%.2f\n", result);

    }

}
