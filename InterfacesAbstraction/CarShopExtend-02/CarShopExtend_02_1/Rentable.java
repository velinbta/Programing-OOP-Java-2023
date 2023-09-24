package CarShopExtend_02_1;

public interface Rentable {

    Integer getMinRentDay();

    Double getPricePerDay();

    default Double getPriceForDays(Integer daysToRent) {
        // Default implementation for given days
        if (daysToRent < this.getMinRentDay()) {
            String message = String.format("Minimum days for renting are <%d>, but were <%d>",
                    this.getMinRentDay(), daysToRent);
            throw new IllegalStateException(message);
        }

        return daysToRent * this.getPricePerDay();
    }

}
