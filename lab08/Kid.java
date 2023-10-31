import java.util.Arrays;

public class Kid {
    private Book[] books; // A Kid "has-a" array of Books, initially there are 0 books, so the size of
                          // array should be 0 initially and should increase with the number of books.

    public Kid() // Constructor
    {
        this.books = new Book[0];
    }

    // Methods

    public Book[] getBooks() // Returns the Books of the Kid
    {
        return this.books;
    }

    public void addBook(Book book) // Add the book to the kid's collection (Size of collection increases)
    {
        this.books = Arrays.copyOf(this.books, this.books.length + 1);
        this.books[this.books.length-1] = book;
    }

    public void displayBooks() // Print the books owned by the kid
    {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
