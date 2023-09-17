package PizzaCalories_04_1;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static final String EXIT_COMMAND = "END";
    public static final String PIZZA_COMMAND = "Pizza";
    public static final String DOUGH_COMMAND = "Dough";
    public static final String TOPPING_COMMAND = "Topping";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Optional<Pizza> pizza = Optional.empty(); // <- Initial empty value

        String input = scanner.nextLine();

        while (!input.equals(EXIT_COMMAND)) {

            String[] data = input.split("\\s+");
            String command = data[0];

            // Try to get correct state or else print exception message and return
            switch (command) {

                case PIZZA_COMMAND: { // <- Set pizza state

                    String pizzaName = data[1];
                    int numberOfToppings = Integer.parseInt(data[2]);

                    try {

                        pizza = Optional.of(new Pizza(pizzaName, numberOfToppings));

                    } catch (IllegalStateException e) {

                        System.out.println(e.getMessage());
                        return;

                    }

                }
                break;

                case DOUGH_COMMAND: { // <- Set dough state

                    String flourType = data[1];
                    String bakingTechnique = data[2];
                    double weightInGrams = Double.parseDouble(data[3]);

                    try {

                        Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);
                        pizza.ifPresent(p -> p.setDough(dough));

                    } catch (IllegalStateException e) {

                        System.out.println(e.getMessage());
                        return;

                    }

                }
                break;

                case TOPPING_COMMAND: { // <- Adds toppings

                    String toppingType = data[1];
                    double weightInGrams = Double.parseDouble(data[2]);

                    try {

                        Topping topping = new Topping(toppingType, weightInGrams);
                        pizza.ifPresent(p -> p.addTopping(topping));

                    } catch (IllegalStateException e) {

                        System.out.println(e.getMessage());
                        return;

                    }

                }

                break;
            }

            input = scanner.nextLine();
        }

        pizza.ifPresent(System.out::println);

    }

}
