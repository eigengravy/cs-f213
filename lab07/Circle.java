public class Circle extends Shape
// A Circle "is-a" Shape !
{
    private int radius;

    public Circle(int x, int y, int radius) {
        this(new Point2D(x, y), radius);
    }

    public Circle(Point2D centre, int radius) {
        super(centre);
        this.radius = radius;
    }

    public int getRadius()
    // Return the radius of the Circle
    {
        return this.radius;
    }

    public double getArea()
    // Override the inherited method, Return the Area of the Circle
    {
        return Math.PI * radius * radius;
    }

    public double getPerimeter()
    // Override the inherited method, Return the Perimeter of the Circle
    {
        return 2 * Math.PI * radius;
    }

    public boolean withinCircle(Point2D point)
    // Return true if the point lies within the Circle
    {
        return Math.sqrt(
                Math.pow((this.getCentre().getX() - point.getX()), 2)
                        + Math.pow((this.getCentre().getY() - point.getY()), 2)) <= this.radius;
    }

    public String toString() {
        return "Shape: Circle X: " + this.getCentre().getX() + " Y: " + this.getCentre().getY() + " Radius: "
                + this.radius + "\n";
    }
}
