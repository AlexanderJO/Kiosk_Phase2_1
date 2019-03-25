import java.util.ArrayList;
import java.util.Iterator;

public class BookSeries extends Literature
{
    private ArrayList<Book> bookSeries;

    public BookSeries(String title, String publisher)
    {
        super(title, publisher);
        bookSeries = new ArrayList<Book>();
    }

    public Iterator<Book> getBookSeriesIterator()
    {
        return bookSeries.iterator();
    }

    public void addBookToSeries(Book book)
    {
        bookSeries.add(book);
    }
}