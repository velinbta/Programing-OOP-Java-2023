package Animals_06_1;

import java.util.Objects;

// Single method to implement
public abstract class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public abstract String produceSound();

    private void setName(String name) {
        validateParameter(name);
        this.name = name;
    }

    private void setAge(int age) {
        validateParameter(age);
        this.age = age;
    }

    private void setGender(String gender) {
        validateParameter(gender);
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    private void validateParameter(String obj) {
        if (Objects.isNull(obj) || obj.isBlank())
            throw stateException();
    }

    private void validateParameter(Integer obj) {
        if (Objects.isNull(obj) || obj < 0)
            throw stateException();
    }

    private IllegalStateException stateException() {
        throw new IllegalStateException("Invalid input!");
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName() +
                System.lineSeparator() +
                String.format("%s %d %s", this.getName(), this.getAge(), this.getGender()) +
                System.lineSeparator() +
                this.produceSound().trim();

    }

}
