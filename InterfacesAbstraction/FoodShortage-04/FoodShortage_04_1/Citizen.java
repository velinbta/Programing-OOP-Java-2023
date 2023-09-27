package FoodShortage_04_1;

// Open judge system forces to implement both Buyer and Person, even though only People interface necessary!
public class Citizen implements Buyer, Identifiable, Person {

    private final String name;
    private final int age;
    private final String id;
    private final String birthDate;

    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    public static Citizen parseCitizen(String[] data) {
        // Static parse method
        String name = data[0];
        int age = Integer.parseInt(data[1]);
        String id = data[2];
        String birthDate = data[3];

        return new Citizen(name, age, id, birthDate);
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getName() {
        return this.name;
    }

    // Dead code requested by the task:
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

}
