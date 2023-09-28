package MilitaryElite_06_1;

// Should be inherited
public abstract class BaseSoldier {

    public static final int DEFAULT_SIZE = 5;

    private final int id;
    private final String firstName;
    private final String lastName;

    protected BaseSoldier(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d", this.getFirstName(), this.getLastName(), this.getId());
    }

}
