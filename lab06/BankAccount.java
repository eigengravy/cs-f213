public class BankAccount {

    private Person owner; // Object of the Person Class as a field
    private int balance;
    private String logger; // This stores the last transaction in a String (Eg: "Transferred Rs. 100",
                           // "Deposited Rs. 1000")
    static final int MIN_BALANCE = 1000; // This is the minimum balance needed for making a transaction
    private static int num_of_banks; // Update the number of banks each time a bank is created

    public BankAccount(Person owner, int initialBal) {
        this.owner = owner;
        this.balance = initialBal;
        num_of_banks++;
        logger("[SUCCESS] Account created. Balance: "+this.balance);
    }

    public BankAccount(String ownerName, int ownerAge, int initialBal) {
        this(new Person(ownerName, ownerAge), initialBal);
    }

    public String getOwnerName() {
        return this.owner.getName();
    }

    public int getOwnerAge() {
        return this.owner.getAge();
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
        logger("[SUCCESS] Deposit: Rs "+amount+" Balance: "+this.balance);
    }

    public int withdraw(int amount) {
        if (this.balance - amount >= MIN_BALANCE) {
            this.balance -= amount;
            logger("[SUCCESS] Withdraw: Rs "+amount+" Balance: "+this.balance);
            return 0;
        } else {
            logger("[FAILURE] Withdraw: Rs "+amount+" Balance: "+this.balance);
            return -1;
        }
    }

    public int transfer(int amount, BankAccount other) {
         if (this.balance - amount >= MIN_BALANCE) {
            this.balance -= amount;
            other.balance += amount;
            logger("[SUCCESS] Transfer: Rs "+amount+" Balance: "+this.balance);
            return 0;
        } else {
            logger("[FAILURE] Transfer: Rs "+amount+" Balance: "+this.balance);
            return -1;
        }
    }

    private void logger(String lastAction) {
        System.out.println("[LOG ("+this.getOwnerName()+")]: "+lastAction);
        this.logger = lastAction;
    }

    public String toString() {
        return "Bank Account Summary\nName: "+this.getOwnerName()+"\nAge: "
        +this.getOwnerAge()+"\nBalance: "+this.getBalance()+"\nLast transaction: "+this.logger;
    }

    public static void aboutBank() {
        System.out.println("Hello I am the Bank.\n" + "I have " + num_of_banks + " bank(s) registered.\n\n"
                + "With an object of my type you can\n" + "   withdraw, deposit or transfer money.\n\n"
                + "Remember to keep minimum balance\n" + "   before making a transaction.");
    }
}
