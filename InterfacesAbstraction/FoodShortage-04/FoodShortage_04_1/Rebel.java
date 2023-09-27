package FoodShortage_04_1;

// Open judge system forces to implement both Buyer and Person, even though only People interface necessary!
public class Rebel implements Buyer, Person {

    private final String name;
    private final int age;
    private final String group;

    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public static Rebel parseRebel(String[] data) {
        // Static parse method
        String name = data[0];
        int age = Integer.parseInt(data[1]);
        String group = data[2];

        return new Rebel(name, age, group);
    }

    @Override
    public void buyFood() {
        this.food += 5;
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
    public int getAge() {
        return this.age;
    }

    public String getGroup() {
        return this.group;
    }

}
