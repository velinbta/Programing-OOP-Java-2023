package WildFarm_04_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static final String END_COMMAND = "End";
    public static final String MOUSE_COMMAND = "Mouse";
    public static final String ZEBRA_COMMAND = "Zebra";
    public static final String CAT_COMMAND = "Cat";
    public static final String TIGER_COMMAND = "Tiger";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        // Polymorphism hierarchy
        Collection<Mammal> mammals = new ArrayList<>();

        while (!input.equals(END_COMMAND)) {

            String[] mammalData = readArray(input);
            String[] foodData = readArray(scanner.nextLine());

            Mammal mammal = getMammal(mammalData);
            Food food = getFood(foodData);

            mammals.add(mammal); // <- add mammal to collection

            System.out.println(mammal.makeSound());

            if (!mammal.eat(food)) { // <- if animal doesn't eat that food
                System.out.println(mammal.rejectFood());
            }

            input = scanner.nextLine();
        }

        mammals.forEach(System.out::println); // <- all added mammals data

    }

    public static Food getFood(String[] foodData) {
        // returns new Food derived, depending on name
        String name = foodData[0];
        Integer quantity = Integer.parseInt(foodData[1]);

        if (Food.FoodType.isVegetable(name))
            return new Vegetable(quantity);

        if (Food.FoodType.isMeat(name))
            return new Meat(quantity);

        throw new IllegalArgumentException("Unknown food " + name);
    }

    public static Mammal getMammal(String[] data) {
        // returns new Mammal derived, depending on type
        String animalType = data[0];
        String name = data[1];
        Double weight = Double.parseDouble(data[2]);
        String livingRegion = data[3];

        switch (animalType) {

            case MOUSE_COMMAND:
                return new Mouse(name, animalType, weight, livingRegion);
            case ZEBRA_COMMAND:
                return new Zebra(name, animalType, weight, livingRegion);
            case CAT_COMMAND:
                String breed = data[4];
                return new Cat(name, animalType, weight, livingRegion, breed);
            case TIGER_COMMAND:
                return new Tiger(name, animalType, weight, livingRegion);
            default:
                throw new IllegalArgumentException("Unknown Animal type " + animalType);
        }

    }

    private static String[] readArray(String input) {
        return input.split("\\s+");
    }

}
