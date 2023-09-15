package FirstAndReserveTeam_04_1;

import java.text.DecimalFormat;
import java.util.Optional;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public static Optional<Person> parsePerson(String[] data) {
        // New optional instance of Person
        String firstName = data[0];
        String lastName = data[1];
        int age = Integer.parseInt(data[2]);
        double salary = Double.parseDouble(data[3]);

        return Optional.of(new Person(firstName, lastName, age, salary));
    }

    // Dead code required by Open Judge System:
    public void increaseSalary(double percent) {
        if (percent < 0)
            throw stateException("Bonus can't be less than zero");

        double multiplier = this.getMultiplier(percent);
        this.setSalary(this.getSalary() * multiplier);
    }

    private double getMultiplier(double bonus) {
        bonus = this.age < 30    // <- Half bonus if age < 30
                ? bonus / 2 : bonus;
        return (bonus + 100.00) / 100.00;
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

    public double getSalary() {
        return this.salary;
    }

    // Setters set to public because of requirements by Open Judge System
    public void setSalary(double salary) {
        if (salary < 460.00)
            throw stateException("Salary cannot be less than 460 leva");
        this.salary = salary;
    }

    public void setFirstName(String name) {
        ensureNameLength(name, "First");
        this.firstName = name;
    }

    public void setLastName(String name) {
        ensureNameLength(name, "Last");
        this.lastName = name;
    }

    public void setAge(int age) {
        if (age < 1)
            throw stateException("Age cannot be zero or negative integer");
        this.age = age;
    }

    private void ensureNameLength(String name, String prefix) {
        if (name.length() < 3)
            throw stateException(String.format("%s name cannot be less than 3 symbols", prefix));
    }

    private IllegalStateException stateException(String message) {
        throw new IllegalStateException(message);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0##"); // <- if after coma has none -> .0
        return String.format("%s %s gets %s leva", this.getFirstName(), this.getLastName(),
                df.format(this.getSalary()));
    }

}

