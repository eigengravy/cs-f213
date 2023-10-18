public class Healer extends GameObject
// A Healer "is-a" GameObject !
{
    // For a healer, the damage array will have NEGATIVE values as we want to increase the health !

    private int numHeals;     // Number of heals done by the Healer

    public Healer(String name, int initialHealth, int[] damage, int x, int y, int radius)
    {
        super(name, initialHealth, damage, x, y, radius);
    }
    public Healer(String name, int initialHealth, int[] damage, int radius, Point2D centre)
    {
        super(name, initialHealth, damage, radius, centre);
    }

    public void heal(GameObject obj)     
    // A healer should heal only an Archer(Keep in mind that an ArcherQueen is also an Archer)
    // If we try to heal a Cannon or another Healer, you should print "Heal Failed".
    // If we try to heal an Archer that is out of range, you should print "Out of Range"
    // The level of a Healer should increase after every 3 heals
    {
        if (obj instanceof Archer) {
            if (this.withinRange(obj)) {
                obj.takeDamage(this.getDamage());
                numHeals += 1;
                if (numHeals % 3 == 0) {
                    this.incLevel();
                }
            } else {
                System.out.println("Out of Range");
            }
        } else {
            System.out.println("Heal Failed");
        }
    
    }
}
