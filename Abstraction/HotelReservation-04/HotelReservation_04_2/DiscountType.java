package HotelReservation_04_2;

import java.util.NoSuchElementException;

// Тип на отстъпката и умножител
public enum DiscountType {

    VIP(0.8),
    SECOND_VISIT(0.9),
    NONE(1.0);

    private final double priceReduction;

    DiscountType(double priceReduction) {
        this.priceReduction = priceReduction;
    }

    public double getPriceReduction() {
        return this.priceReduction;
    }

    public static DiscountType parse(String type) {

        switch (type) {

            case "VIP":

                return VIP;

            case "SecondVisit":

                return SECOND_VISIT;

            case "None":

                return NONE;

            default:

                throw new NoSuchElementException("Unknown discount type " + type);

        }

    }

}
