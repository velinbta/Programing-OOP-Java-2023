package SortByNameAndAge_01_1;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static Person parse(String[] data) {
        // Създава нова инстанция на Person
        String firstName = data[0];
        String lastName = data[1];
        int age = Integer.parseInt(data[2]);

        return new Person(firstName, lastName, age);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", this.getFirstName(), this.getLastName(), this.getAge());
    }

}
