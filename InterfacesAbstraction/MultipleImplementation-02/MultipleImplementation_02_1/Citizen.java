package MultipleImplementation_02_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Citizen implements Identifiable, Birthable, Person {

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

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @SuppressWarnings({"all"})
    public final String getClassInfo() {
        // Basic information
        Class<? extends Citizen> citizen = this.getClass();

        List<String> methodsSimpleNames = Arrays.stream(citizen.getDeclaredMethods())
                .map(String::valueOf).filter(m -> m.contains("()"))
                .map(m -> m.substring(m.lastIndexOf(".") + 1)).collect(Collectors.toList());

        StringBuilder info = new StringBuilder();

        info.append(String.format("This is %s class. It contains %d constructor/s. It has %d field/s.",
                citizen.getSimpleName(), citizen.getDeclaredConstructors().length,
                citizen.getDeclaredFields().length));

        info.append(System.lineSeparator());

        info.append(String.format("Also contains the following method/s: %s",
                String.join(", ", methodsSimpleNames)));

        return info.toString().trim();
    }

    @Override
    public String toString() {
        // No specific toString given in task
        return String.format("This is %s. Specific age: %d. Id: %s. Birthdate: %s",
                this.getName(), this.getAge(), this.getId(), this.getBirthDate());
    }

}
