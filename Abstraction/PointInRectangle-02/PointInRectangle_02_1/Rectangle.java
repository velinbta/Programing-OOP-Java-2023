package PointInRectangle_02_1;

public class Rectangle {

    private final Point bottomLeft;
    private final Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        // Дали дадената точка е в координатите на правоъгълника
        boolean isHorizontal = point.getX() >= this.bottomLeft.getX() && point.getX() <= this.topRight.getX();
        boolean isVertical = point.getY() >= this.bottomLeft.getY() && point.getY() <= this.topRight.getY();

        return isHorizontal && isVertical;

    }

}