package MilitaryElite_06_1;

public class Spy extends Soldier {

    private final String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    @SuppressWarnings({"all"})
    public String toString() {

        StringBuilder spy = new StringBuilder();
        spy.append(super.toString());
        spy.append(System.lineSeparator());

        spy.append(String.format("Code Number: %s", this.codeNumber));

        return spy.toString().trim();
    }

}
