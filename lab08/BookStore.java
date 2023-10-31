import java.util.Arrays;

public class BookStore implements LibraryInterface {
    // Fields
    private Book[] items; // An array of Books that the library has, initally it has no books so the size
                          // of the array should be zero and increases or decreases as books are added or
                          // sold
    // The array should always be SORTED based on the prices of the books in
    // ascending order
    private int itemCount; // Number of books in the library
    private int income; // Money earned by the BookStore

    public BookStore() // Constructor
    {
        this.itemCount = 0;
        this.income = 0;
        this.items = new Book[0];
    }

    // Methods
    public Book[] getBooks() // Returns the Books in the BookStore
    {
        return this.items;
    }

    public int getItemCount() // Returns the number of items in the store
    {
        return this.itemCount;
    }

    public int getIncome() // Returns the store's income
    {
        return this.income;
    }

    // Need to implement the methods inherited from the interface
    // A BookStore sells books to Privileged Kids only !!!!
    // !!!!! TODO !!!!!

    @Override
    public void addBook(Book item) {
        this.itemCount += 1;
        this.items = Arrays.copyOf(this.items, this.itemCount);
        this.items[this.itemCount - 1] = item;
        Arrays.sort(this.items);
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
        this.income += item.getCost();
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
        if ((k instanceof PrivilegedKid) && hasBook && ((PrivilegedKid) k).getMoney() >= item.getCost()) {
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
