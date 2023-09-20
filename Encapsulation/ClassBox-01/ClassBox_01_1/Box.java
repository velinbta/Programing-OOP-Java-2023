package ClassBox_01_1;

public class Box {

    private static final double TWO = 2D;

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) { // > 0
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double calculateSurfaceArea() {
        return (TWO * this.length * this.width) + this.calculateLateralSurfaceArea();
    }

    public double calculateLateralSurfaceArea() {
        return (TWO * this.length * this.height) + (TWO * this.width * this.height);
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    private void ensurePositiveParameter(double parameter, String prefix) {
        if (parameter <= 0)
            throw new IllegalStateException(String.format("%s cannot be zero or negative.", prefix));
    }

    private void setLength(double length) {
        ensurePositiveParameter(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        ensurePositiveParameter(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        ensurePositiveParameter(height, "Height");
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f", this.calculateSurfaceArea()) +
                System.lineSeparator() +
                String.format("Lateral Surface Area - %.2f", this.calculateLateralSurfaceArea()) +
                System.lineSeparator() +
                String.format("Volume - %.2f", this.calculateVolume()).trim();
    }

}
