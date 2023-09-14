package SalaryIncrease_02_1;

import java.text.DecimalFormat;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public static Person parsePerson(String[] data) {
        // New instance of Person
        String firstName = data[0];
        String lastName = data[1];
        int age = Integer.parseInt(data[2]);
        double salary = Double.parseDouble(data[3]);

        return new Person(firstName, lastName, age, salary);
    }

    public void increaseSalary(double percent) {
        double multiplier = this.getMultiplier(percent);
        this.setSalary(this.getSalary() * multiplier);
    }

    private double getMultiplier(double bonus) {
        bonus = this.age < 30
                ? bonus / 2 : bonus;
        return (bonus + 100.00) / 100.00;
    }

    public double getSalary() {
        return this.salary;
    }

    // private Person setter
    private void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0##");
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, df.format(this.getSalary()));
    }

}
