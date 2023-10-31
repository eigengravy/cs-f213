public class PrivilegedKid extends Kid implements GetBooksInterface // A PrivilegedKid "is-a" Kid and can get books
{
    private int money; // A PrivilegedKid has money

    public PrivilegedKid(int money) // Constructor
    {
        this.money = money;
    }

    // Methods
    public int getMoney() // Returns the current amount of money
    {
        return this.money;
    }

    public void deductMoney(int amount) // Deducts money by amount. Make sure that the money does not become negative
    {
        if (this.money >= amount) {
            this.money -= amount;
        }
        // this.money = Math.max(0, this.money - amount);
    }

    public void donateMoney(NGO ngo, int amount) // Donates amount to the ngo, make sure that the kid has enough money
                                                 // to donate
    {
        if (this.money >= amount) {
            this.deductMoney(amount);
            ngo.receiveMoney(amount);
        }
    }

    @Override
    public void getFromBookStore(BookStore bs, Book b) {
        if(bs.canGetBook(this, b)){
            this.deductMoney(b.getCost());
            this.addBook(b);
        }
    }

    @Override
    public void getFromNGO(NGO ngo, Book b) {
        return;
    }

    // Need to implement the methods inherited from the Interface

    // !!!!! TODO !!!!!

}
