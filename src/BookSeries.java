import java.util.ArrayList;
import java.util.Iterator;

public class BookSeries extends Literature
{
    private ArrayList<Literature> bookSeries;

    public BookSeries(String title, String publisher)
    {
        setTitle(title);
        setPublisher(publisher);
        bookSeries = new ArrayList<Literature>();
    }

    public Iterator<Literature> getBookSeriesIterator()
    {
        return bookSeries.iterator();
    }

    public void addBookToSeries(Book book)
    {
        this.bookSeries.add(book);
    }

    public void removeBookFromSeries(Book book)
    {
        this.bookSeries.remove(book);
    }
}
