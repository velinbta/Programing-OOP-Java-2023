package HotelReservation_04_1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class PriceCalculator {

    private final double pricePerDay;
    private final int numberOfDays;
    private final String season;
    private final String discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, String season, String discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculate() {
        // Намира умножителите и пресмята резултата
        int seasonMultiplier = findSeason().getMultiplier();
        double discountValue = findDiscount().getMultiplier();

        return this.pricePerDay * this.numberOfDays * seasonMultiplier * discountValue;

    }

    private Season findSeason() {
        // Намира enum сезон
        return Arrays.stream(Season.values()).filter(s -> s.name().equalsIgnoreCase(this.season))
                .findFirst().orElseThrow(() -> exception("Unknown season " + this.season));

    }

    private DiscountType findDiscount() {
        // Намира enum отстъпка
        return Arrays.stream(DiscountType.values())
                .filter(d -> d.name().replaceAll("_", "").equalsIgnoreCase(this.discountType))
                .findFirst().orElseThrow(() -> exception("Unknown discount type " + this.discountType));

    }

    private NoSuchElementException exception(String message) {
        return new NoSuchElementException(message);
    }

}
