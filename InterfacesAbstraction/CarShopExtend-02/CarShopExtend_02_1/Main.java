package CarShopExtend_02_1;

public class Main {
    public static void main(String[] args) {

        // Refactored sample code given
        Sellable seat = new Seat("Leon", "Gray", 110,
                "Spain", 11111.1);
        Rentable audi = new Audi("A4", "Gray", 110, "Germany",
                3, 99.9);

        // Typo in task given input - <have> must be <has>
        // Typo in task given input - <horse power> should be <horsepower>
        System.out.println(seat);
        System.out.println(audi);

    }

}
