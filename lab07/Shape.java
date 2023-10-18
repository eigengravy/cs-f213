public class Shape {
    // Each Shape "has-A" Point2D as the centre
    private Point2D centre; // Represents the geometric centre of the shape

    public Shape(int x, int y) {
        this(new Point2D(x, y));
    }

    public Shape(Point2D centre) {
        this.centre = centre;
    }

    public Point2D getCentre() {
        return this.centre;
    }

    // The following two methods will be overriden in the child classes, so just
    // return 0 in both of them
    public double getArea() {
        return 0.0;
    }

    public double getPerimeter() {
        return 0.0;
    }

    public void move(int x, int y)
    // Move the Shape to new location
    {
        this.move(new Point2D(x, y));
    }

    public void move(Point2D newCentre)
    // Move the Shape to newCentre
    {
        this.centre = newCentre;
    }
}
