import java.util.Arrays;

public class NGO implements LibraryInterface {
    // Fields
    private Book[] items; // An array of Books that the library has, initally it has no books so the size
                          // of the array should be zero and increases or decreases as books are added or
                          // sold
    // The array should always be SORTED based on the prices of the books in
    // ascending order
    private int itemCount; // Number of books in the library
    private int budget; // Budget that the NGO has, used to add books to the NGO

    public NGO(int initialBudget) // Constructor
    {
        this.itemCount = 0;
        this.items = new Book[0];
        this.budget = initialBudget;
    }

    // Methods

    public Book[] getBooks() // Returns the Books in the NGO
    {
        return this.items;
    }

    public int getBudget() // Returns the budget of the NGO
    {
        return this.budget;
    }

    public int getItemCount() // Returns the number of items of the ngo
    {
        return this.itemCount;
    }

    public void receiveMoney(int amount) // Used by the NGO to recieve money
    {
        this.budget += amount;
    }

    // Need to implement the methods inherited from the interface
    // When we add a book to an NGO, it is done using the budget of the NGO and
    // should have enough budget for the book
    // An NGO issues books to UnderPrivileged Kids only !!!!

    // !!!!! TODO !!!!!

    @Override
    public void addBook(Book item) {
        if (this.budget >= item.getCost()) {
            this.itemCount += 1;
            this.items = Arrays.copyOf(this.items, this.itemCount);
            this.items[this.itemCount - 1] = item;
            Arrays.sort(this.items);
            this.budget -= item.getCost();
        }
    }

    public void removeBook(Book item) {
        this.itemCount -= 1;
        Book[] itemsCopy = new Book[this.itemCount];
        int counter = 0;
        for (Book book : items) {
            if (!(book.equals(item))) {
                itemsCopy[counter] = book;
                counter++;
            }
        }
        this.items = itemsCopy;
    }

    @Override
    public boolean canGetBook(Kid k, Book item) {
        boolean hasBook = false;
        for (Book book : items) {
            if (book.equals(item)) {
                hasBook = true;
                break;
            }
        }
        if ((k instanceof UnderprivilegedKid) && hasBook) {
            this.removeBook(item);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void displayItems() {
        for (Book book : items) {
            System.out.println(book);
        }
    }

}
