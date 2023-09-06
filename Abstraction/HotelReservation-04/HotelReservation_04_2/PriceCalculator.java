package HotelReservation_04_2;

public class PriceCalculator {

    private PriceCalculator() {
        // Don't let anyone instantiate an instance of this class
    }

    public static double calculatePrice(double pricePerDay, int numberOfDays,
                                        Season season, DiscountType discountType) {

        // Пресмята крайния резултат
        return pricePerDay * numberOfDays * season.getMultiplier() * discountType.getPriceReduction();

    }

}
