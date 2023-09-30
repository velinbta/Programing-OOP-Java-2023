package Shapes_02_1;

// Shape should be an interface
// Left abstract class, because of Open judge system requirements
public abstract class Shape {

    public static final Integer TWO = 2;

    // Dead Fields required
    private Double perimeter;
    private Double area;

    protected Shape() {
        // Let only child classes have an instance
    }

    protected abstract Double calculatePerimeter();

    protected abstract Double calculateArea();

    public Double getPerimeter() {
        return this.calculatePerimeter();
    }

    public Double getArea() {
        return this.calculateArea();
    }

    @Override
    public String toString() {
        return String.format("%s perimeter is %.2f.", this.getClass().getSimpleName(), this.getPerimeter())
                + System.lineSeparator() +
                String.format("%s area is %.2f.", this.getClass().getSimpleName(), this.getArea());
    }

}
