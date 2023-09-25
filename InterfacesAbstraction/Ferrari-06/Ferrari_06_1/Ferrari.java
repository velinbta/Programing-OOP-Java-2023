package Ferrari_06_1;

public class Ferrari implements Car {

    private final String driverName;
    private final String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = "488-Spider";
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {

        String delimiter = "/";

        return this.model.concat(delimiter).concat(this.brakes()).concat(delimiter)
                .concat(this.gas()).concat(this.driverName);

    }

}
