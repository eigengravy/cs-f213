public class Book implements Comparable // !!!!! Something changes on this Line !!!!!
// A Book is Comparable
{
    private String title; // Fields
    private int cost;
    private String author;

    public Book(String title, int cost, String author) // Constructor
    {
        this.title = title;
        this.cost = cost;
        this.author = author;
    }

    public String getTitle() // Methods
    {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getCost() {
        return this.cost;
    }

    public String toString() {
        return this.getTitle() + " | " + this.getAuthor() + " | " + this.getCost();
    }

    public boolean equals(Object obj) // Checks if the object is equal to this book ie the title and author are same
                                      // (Cost may be different)
    {
        if (obj instanceof Book) {
            if (((Book) obj).getAuthor() == this.getAuthor() && ((Book) obj).getTitle() == this.getTitle()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Book) {
            if (this.getCost() > ((Book) obj).getCost()) {
                return 1;
            } else if (this.getCost() < ((Book) obj).getCost()) {
                return -1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    /*
     * Comparable Interface is defined within Java as :
     * 
     * public interface Comparable
     * {
     * int compareTo(Object other);
     * }
     * 
     */
    // Need to define a method here
    // Compares on the basis of the cost of the books
    // Returns 1 if cost of this book is more than the other
    // Returns 0 if both are equal
    // Returns -1 if other book has more cost
    // It is GUARANTEED that other "is-a" Book

    // !!!!! TODO !!!!!

}