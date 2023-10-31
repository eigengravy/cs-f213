public class UnderprivilegedKid extends Kid implements GetBooksInterface    // An UnderprivilegedKid "is-a" Kid and can get books
{
    // Need to implement the methods inherited from the Interface

    //  !!!!!   TODO    !!!!!

    @Override
    public void getFromNGO(NGO ngo, Book b) {
        if(ngo.canGetBook(this, b)){
            this.addBook(b);
        }
    }

    @Override
    public void getFromBookStore(BookStore bs, Book b) {
        return;
    }
    
    
}
