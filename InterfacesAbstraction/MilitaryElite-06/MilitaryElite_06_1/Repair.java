package MilitaryElite_06_1;

public class Repair {

    private final String name;
    private final int hours;

    public Repair(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public String getName() {
        return this.name;
    }

    public int getHours() {
        return this.hours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getName(), this.getHours());
    }

}
