package Shapes_02_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(3.55);
        Rectangle rectangle = new Rectangle(3.22, 4.55);

        // Polymorphism
        Collection<Shape> shapes = new ArrayList<>(List.of(circle, rectangle));
        shapes.forEach(System.out::println);

    }

}
