import java.util.ArrayList;     //Imports the library to the ArrayList-class
import java.util.Iterator;      //Imports the library to the ArrayList-class

public class BookSeries extends Literature
{
    // Creates an ArrayList of the type Book.
    private ArrayList<Literature> bookSeries;

    public BookSeries(String title, String publisher)
    {
        // Checks if the title is null. If yes, the title is an empty string.
        if(title == null) { title = "";}
        // Checks if the publisher is null. If yes, the publisher is an empty string.
        if(publisher == null) { publisher = "";}

        // setTitle and setPublisher are inherited from the Literature-class
        setTitle(title);
        setPublisher(publisher);

        bookSeries = new ArrayList<>();
    }

    /**
     * Returns the bookseries-iterator.
     * @return The bookseries-iterator.
     */
    public Iterator<Literature> getBookSeriesIterator()
    {
        return bookSeries.iterator();
    }

    /**
     * Adds a book to a bookseries.
     * @param book The book beeing added.
     */
    public void addBookToSeries(Book book)
    {
        this.bookSeries.add(book);
    }

    /**
     * Removes a book from the bookseries-iterator.
     * @param book The book that beeing removed.
     */
    public void removeBookFromSeries(Book book)
    {
        this.bookSeries.remove(book);
    }

    /**
     * Returns the size of the bookseries-iterator.
     * @return The size of the bookseries-iterator.
     */
    public int getSize()
    {
        return this.bookSeries.size();
    }
}