package HotelReservation_04_1;

// Тип на отстъпката в проценти и умножител
public enum DiscountType {

    VIP(0.8, 20),
    SECOND_VISIT(0.9, 10),
    NONE(1D, 0);

    private final double multiplier;
    private final int percent;

    DiscountType(double multiplier, int percent) {
        this.multiplier = multiplier;
        this.percent = percent;
    }

    public double getMultiplier() {
        return this.multiplier;
    }

    public int getPercent() {
        return this.percent;
    }

}
