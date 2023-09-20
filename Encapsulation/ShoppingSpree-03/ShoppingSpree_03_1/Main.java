package ShoppingSpree_03_1;

import java.util.*;
import java.util.function.Function;

public class Main {

    public static final String COMMAND = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleInfo = new LinkedHashMap<>();
        Map<String, Product> productsInfo = new HashMap<>();

        String[] peopleAsArray = scanner.nextLine().split(";", -1);
        String[] productsAsArray = scanner.nextLine().split(";", -1);

        for (String people : peopleAsArray) {
            // If invalid prints the message and returns
            Optional<?> optional = getOptionalOrCatchException("Person").apply(people);
            if (optional.isEmpty()) {
                return;
            }
            Person person = (Person) optional.get();
            peopleInfo.putIfAbsent(person.getName(), person);

        }

        for (String p : productsAsArray) {
            // If invalid prints the message and returns
            Optional<?> optional = getOptionalOrCatchException("Product").apply(p);
            if (optional.isEmpty()) {
                return;
            }
            Product product = (Product) optional.get();
            productsInfo.putIfAbsent(product.getName(), product);

        }

        String input = scanner.nextLine();

        while (!input.equals(COMMAND)) {

            String[] data = input.split("\\s+");
            String personName = data[0];
            String productName = data[1];

            Person person = peopleInfo.get(personName);
            Product product = productsInfo.get(productName);

            if (Objects.isNull(person) || Objects.isNull(product)) { // <- Ignore if invalid
                input = scanner.nextLine();
                continue;
            }

            tryToBuy(person, product);

            input = scanner.nextLine();

        }

        peopleInfo.values().forEach(System.out::println);

    }

    private static Function<String, Optional<?>> getOptionalOrCatchException(String optionalParameter) {

        // Function to return Optional<?> depending on given parameter
        return s -> {

            String[] data = s.split("=", -1);
            String name = data[0];
            double money = Double.parseDouble(data[1]);

            Optional<?> optional = Optional.empty();

            try {

                switch (optionalParameter) {

                    case "Person":
                        optional = Optional.of(new Person(name, money));
                        break;

                    case "Product":
                        optional = Optional.of(new Product(name, money));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid parameter " + optionalParameter);
                }

            } catch (IllegalStateException exception) {
                System.out.println(exception.getMessage());
            }

            return optional;
        };
    }

    private static void tryToBuy(Person person, Product product) {
        // Buys if money is enough or catches the exception
        try {

            person.buyProduct(product);
            System.out.printf("%s bought %s\n", person.getName(), product);

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }

}
