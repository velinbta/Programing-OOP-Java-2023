package CarShop_01_1;

public class Main {
    public static void main(String[] args) {

        // Refactored sample code given
        Car seat = new Seat("Leon", "gray", 110, "Spain");

        System.out.printf("%s is %s color and have %s horse power\n", seat.getModel(),
                seat.getColor(), seat.getHorsePower()); // <- Typo in "horse power"

        // Typo in task given input - <have> must be <has>
        // Typo in task given input - <horse power> should be <horsepower>
        System.out.println(seat);

    }

}
