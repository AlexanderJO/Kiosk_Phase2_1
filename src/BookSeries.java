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
public class BookSeries
{
    // ------------------- Fields ----------------
//    private ArrayList<Book> books;
    private String seriesTitle;

    // ------------------- Constructor ----------------
    public BookSeries(String seriesTitle)
    {
        this.seriesTitle = seriesTitle;
//        this.books = new ArrayList<Book>();
    }

    // ------------------- Methods ----------------
    /**
     * Adds the book to a book series.
     * @param book Book to be added to book series.
     */
//    public void addBookToSeries(String, seriesTitle, Book book)
//    {
//        if ( this.books.contains(seriesTitle) )
//        {
//            this.books.
//            this.books.add(book);
//        }
//
//    }

    /**
     * Returns the series title of the books.
     * @return the series title of the books.
     */
    public String getSeriesTitle()
    {
        return this.seriesTitle;
    }

//    /**
//     * Returns the iterator of the books.
//     * @return the iterator of the books.
//     */
//    public Iterator<Book> getIterator()
//    {
//        return this.books.iterator();
//    }
}
