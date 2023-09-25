package Ferrari_06_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String driverName = new Scanner(System.in).nextLine();

        Car car = new Ferrari(driverName);
        System.out.println(car);

    }

}
