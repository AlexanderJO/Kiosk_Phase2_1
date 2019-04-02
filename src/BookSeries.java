import java.util.ArrayList;
import java.util.Iterator;

public class BookSeries extends Literature
{
    private ArrayList<Book> bookSeries;

    public BookSeries(String title, String publisher)
    {
        if(title == null) { title = "";}
        if(publisher == null) { publisher = "";}

        setTitle(title);
        setPublisher(publisher);
        bookSeries = new ArrayList<Book>();
    }

    public Iterator<Book> getBookSeriesIterator()
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

    /**
     * @return The size of the bookseries
     */
    public int getSize()
    {
        return this.bookSeries.size();
    }
}
