package HotelReservation_04_2;

import java.util.NoSuchElementException;

// Сезон и неговия умножител
public enum Season {

    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private final int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return this.multiplier;
    }

    public static Season parse(String name) {
        // Парс от стринг
        try {

            return Season.valueOf(name.toUpperCase());

        } catch (IllegalArgumentException e) {

            throw new NoSuchElementException("Unknown season " + name);

        }

    }

}
