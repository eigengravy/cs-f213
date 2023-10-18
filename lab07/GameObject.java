public class GameObject {
    private String name; // Name of the object, can be anything like "JOHN"
    private Circle range; // represents range of attack
    private int health; // Current health of the object
    private int[] damage; // An array of damage for each level
    private int level; // level is also 0-indexed, so initial level should be 0

    public GameObject(String name, int initialHealth, int[] damage, int x, int y, int radius) {
        this(name, initialHealth, damage, radius, new Point2D(x, y));
    }

    public GameObject(String name, int initialHealth, int[] damage, int radius, Point2D centre) {
        this.name = name;
        this.health = initialHealth;
        this.damage = damage;
        this.range = new Circle(centre, radius);
        this.level = 0;
    }

    public String getName()
    // Return the name of the object
    {
        return this.name;
    }

    public int getHealth()
    // Return the health of the object
    {
        return this.health;
    }

    public int getLevel()
    // Return the level of the object
    {
        return this.level;
    }

    public Circle getRange()
    // Return the range of the object
    {
        return this.range;
    }

    public void move(int x, int y)
    // Move the object to another location
    {
        this.range.move(x, y);
    }

    public void move(Point2D newLocation)
    // Move the object to another location
    {
        this.range.move(newLocation);
    }

    public void incLevel()
    // increases the level of the object by 1
    // make sure that the level does not pass the Max Level (Size of the array)
    {
        if (this.level < this.damage.length - 1) {
            this.level += 1;
        }
    }

    public boolean withinRange(GameObject obj)
    // Check if the object is within the range
    {
        return this.range.withinCircle(obj.range.getCentre());
    }

    public boolean isDead()
    // Return if the object is dead ie if its health is 0
    {
        return health == 0;
    }

    public int getDamage()
    // Return the damage the object does based on its level
    {
        return this.damage[this.level];
    }

    public void takeDamage(int damage)
    // Used when another object attacks this object
    // Make sure that the health does not become negative
    {
        if (this.health - damage >= 0){
            this.health -= damage;
        } else {
            this.health = 0;
        }
    }
}
