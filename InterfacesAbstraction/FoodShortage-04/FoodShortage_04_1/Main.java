package FoodShortage_04_1;

import java.util.*;

public class Main {

    public static final int IS_CITIZEN = 4;
    public static final int IS_REBEL = 3;
    public static final String END_COMMAND = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Person[] people = new Person[lines];

        for (int i = 0; i < lines; i++) {

            String[] data = scanner.nextLine().split("\\s+");

            Person person = getPerson(data); // <- parse
            people[i] = person;

        }

        Collection<String> buyersNames = readBuyers(scanner);

        buyersNames.forEach(buyer -> Arrays.stream(people).filter(p -> p.getName().equals(buyer))
                .findFirst().ifPresent(Person::buyFood)); // <- Buy if name is valid

        int totalFoodCount = Arrays.stream(people).mapToInt(Person::getFood).sum();
        System.out.println(totalFoodCount);

    }

    private static Person getPerson(String[] data) {
        // returns a new Person, argument number based
        int arguments = data.length;

        switch (arguments) {

            case IS_CITIZEN:
                return Citizen.parseCitizen(data);
            case IS_REBEL:
                return Rebel.parseRebel(data);
            default:
                throw new IllegalArgumentException("Invalid number of arguments " + arguments);

        }

    }

    private static Collection<String> readBuyers(Scanner scanner) {
        // collection of buyers names
        Collection<String> buyers = new ArrayList<>();

        String buyerName = scanner.nextLine();

        while (!buyerName.equals(END_COMMAND)) {
            buyers.add(buyerName);
            buyerName = scanner.nextLine();
        }

        return buyers;
    }

}
