package Shapes_02_1;

public class Circle extends Shape {

    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    protected Double calculatePerimeter() {
        return TWO * Math.PI * this.radius;
    }

    @Override
    protected Double calculateArea() {
        return Math.PI * Math.pow(this.radius, TWO);
    }

    @Override
    public String toString() {
        return String.format("%s has radius of %.2f.", this.getClass().getSimpleName(), this.getRadius()) +
                System.lineSeparator() + super.toString();
    }

    // Dead code + final modifier required
    public final Double getRadius() {
        return this.radius;
    }

}
