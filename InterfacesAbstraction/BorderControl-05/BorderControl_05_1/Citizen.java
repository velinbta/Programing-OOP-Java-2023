package BorderControl_05_1;

public class Citizen implements Identifiable {

    private final String name;
    private final int age;
    private final String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public static Citizen parseCitizen(String[] data) {
        // Static parse method
        String name = data[0];
        int age = Integer.parseInt(data[1]);
        String id = data[2];

        return new Citizen(name, age, id);
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

}
