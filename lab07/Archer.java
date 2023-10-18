public class Archer extends GameObject
// An Archer "is-a" GameObject !
{
    protected int numAttacks;     // Number of attacks done by the archer

    public Archer(String name, int initialHealth, int[] damage, int x, int y, int radius)
    {
        super(name, initialHealth, damage, x, y, radius);
    }
    public Archer(String name, int initialHealth, int[] damage, int radius, Point2D centre)
    {
        super(name, initialHealth, damage, radius, centre);
    }
    
    public void attack(GameObject obj)     
    // An Archer can attack any other GameObject
    // If we try to attack an object which is out of range, print "Out of Range"
    // The level of an Archer increases after every 2 attacks
    {
        if (this.withinRange(obj)){
            obj.takeDamage(this.getDamage());
            numAttacks += 1;
            if (numAttacks % 2 == 0){
                this.incLevel();
            }
        } else {
            System.out.println("Out of Range");
        }
    }
}
