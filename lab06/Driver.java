public class Driver {
    public static void main(String[] args) {
        Person p1 = new Person("Adam", 25);
        System.out.println(p1 + "\n"); // What method of the Person is being used here?

        Person p2 = new Person("John", 20);
        p2.setAddress("BITS GOA");

        System.out.println("Number of People: " + Person.num_of_people + "\n");

        BankAccount.aboutBank();
        System.out.println();

        BankAccount b1 = new BankAccount(p1, 1000);
        System.out.println(b1);
        System.out.println();

        BankAccount b2 = new BankAccount("Eve", 106, 800);
        System.out.println(b2);
        System.out.println();

        b2.withdraw(100);
        b2.transfer(100, b1);
        b1.deposit(100);
        b1.withdraw(100);
        b2.deposit(500);
        b1.transfer(100, b2);
        b2.transfer(100, b1);
        System.out.println();

        System.out.println(b1);
        System.out.println();

        System.out.println(b2);
        System.out.println();

    }
}