package ShoppingSpree_03_1;

import java.util.*;

public class Main {

    public static final String COMMAND = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleInfo = addCorrectStatePeople(scanner);
        Map<String, Product> productsInfo = addCorrectStateProducts(scanner);

        String input = scanner.nextLine();

        while (!input.equals(COMMAND)) {

            String[] data = input.split("\\s+");
            String personName = data[0];
            String productName = data[1];

            Person person = peopleInfo.get(personName);
            Product product = productsInfo.get(productName);

            if (Objects.isNull(person) || Objects.isNull(product)) { // <- If are not correct, so not added
                input = scanner.nextLine();
                continue;
            }

            tryToBuy(person, product);

            input = scanner.nextLine();

        }

        peopleInfo.values().forEach(System.out::println);

    }

    private static Map<String, Person> addCorrectStatePeople(Scanner scanner) {

        Map<String, Person> peopleInfo = new LinkedHashMap<>();

        // Creates and adds only correct state peopleInfo
        Arrays.stream(scanner.nextLine().split("\\s*;\\s*")).map(person -> {
            String[] data = person.split("\\s*=\\s*");
            String name = data[0];
            double money = Double.parseDouble(data[1]);

            Optional<Person> optional = Optional.empty();

            try {
                optional = Optional.of(new Person(name, money));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            return optional;
        }).forEach(person -> person.ifPresent(p -> peopleInfo.putIfAbsent(p.getName(), p)));

        return peopleInfo;
    }

    private static Map<String, Product> addCorrectStateProducts(Scanner scanner) {

        Map<String, Product> productsInfo = new HashMap<>();

        // Creates and adds only correct state productsInfo
        Arrays.stream(scanner.nextLine().split("\\s*;\\s*")).map(product -> {
            String[] data = product.split("\\s*=\\s*");
            String name = data[0];
            double cost = Double.parseDouble(data[1]);

            Optional<Product> optional = Optional.empty();

            try {
                optional = Optional.of(new Product(name, cost));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            return optional;
        }).forEach(product -> product.ifPresent(p -> productsInfo.putIfAbsent(p.getName(), p)));

        return productsInfo;
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
