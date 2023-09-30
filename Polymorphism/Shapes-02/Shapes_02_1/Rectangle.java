package Shapes_02_1;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    protected Double calculatePerimeter() {
        return TWO * (this.height + this.width);
    }

    @Override
    protected Double calculateArea() {
        return this.height * this.width;
    }

    @Override
    public String toString() {
        return String.format("%s has height of %.2f and width of %.2f.", this.getClass().getSimpleName(),
                this.getHeight(), this.getWidth()) + System.lineSeparator() + super.toString();
    }

    // Dead code required
    public Double getHeight() {
        return this.height;
    }

    public Double getWidth() {
        return this.width;
    }

}
