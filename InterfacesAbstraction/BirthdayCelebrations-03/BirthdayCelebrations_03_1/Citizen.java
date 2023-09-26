package BirthdayCelebrations_03_1;

public class Citizen implements Identifiable, Birthable, Nameable {

    private final String name;
    private final int age;
    private final String id;
    private final String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    public static Citizen parseCitizen(String[] data) {
        // Static parse method
        String name = data[1];
        int age = Integer.parseInt(data[2]);
        String id = data[3];
        String birthDate = data[4];

        return new Citizen(name, age, id, birthDate);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
