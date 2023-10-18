public class ArcherQueen extends Archer
// An ArcherQueen "is-a" Archer !
{
    public ArcherQueen(String name, int initialHealth, int[] damage, int x, int y, int radius)
    {
        super(name, initialHealth, damage, x, y, radius);
    }
    public ArcherQueen(String name, int initialHealth, int[] damage, int radius, Point2D centre)
    {
        super(name, initialHealth, damage, radius, centre);
    }

    public void attack(GameObject obj)   
    // An ArcherQueen does TWICE the damage as an Archer, rest all properties are same as an Archer
    // An Archer can attack any other GameObject
    // If we try to attack an object which is out of range, print "Out of Range"
    // The level of an ArcherQueen also increases after every 2 attacks
    {
        if (this.withinRange(obj)){
            obj.takeDamage(this.getDamage()*2);
            numAttacks += 1;
            if (numAttacks % 2 == 0){
                this.incLevel();
            }
        } else {
            System.out.println("Out of Range");
        }
    }
}
