package DefineAnInterfacePerson_01_1;

// Simple data holder, but OJS doesn't accept records
public class Citizen implements Person {

    private final String name;
    private final int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

}
