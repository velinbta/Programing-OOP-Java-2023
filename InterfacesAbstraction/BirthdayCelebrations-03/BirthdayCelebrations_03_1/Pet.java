package BirthdayCelebrations_03_1;

public class Pet implements Birthable, Nameable {

    private final String name;
    private final String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public static Pet parsePet(String[] data) {
        // Static parse method
        String name = data[1];
        String birthDate = data[2];

        return new Pet(name, birthDate);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

}
