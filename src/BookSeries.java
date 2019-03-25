import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents the series of books. List contains all books of a series.
 *
 * In this book series class you can:
 * <ul>
 * <li> get series title </li>
 * <li> get iterator of list </li>
 *
 * @author      Alexander J. Overvåg, Sondre Nerhus, Gustav S. Hagen
 * @version     v1.0 (beta) 2019.03.13
 */
public class BookSeries extends Literature
{
    // ------------------- Fields ----------------
    private ArrayList<Book> books;

    // ------------------- Constructor ----------------
    public BookSeries(String seriesTitle, String publisher)
    {
        super(seriesTitle, publisher);              // Inherits from super class Literature
        this.books = new ArrayList<Book>();         // Creates empty list of books.
    }

    // ------------------- Methods ----------------
    /**
     * Adds the book to a book series.
     * @param book Book to be added to book series.
     */
    public void addBookToSeries(Book book)
    {
        this.books.add(book);
    }

    /**
     * Returns the iterator of the books.
     * @return the iterator of the books.
     */
    public Iterator<Book> getIterator()
    {
        return this.books.iterator();
    }
}
