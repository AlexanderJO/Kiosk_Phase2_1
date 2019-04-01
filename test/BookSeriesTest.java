import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BookSeriesTest
{
    @Test
    public void addBookToSeries()
    {
        BookSeries bookSeries = new BookSeries("Ringenes Herre", "Bokklubben");
        bookSeries.addBookToSeries(new Book("The fellowship of the ring", "Bokklubben", "Mannen", "3", "654"));
        bookSeries.addBookToSeries(new Book("Two towers", "Bokklubben", "Mannen", "3", "654"));
        bookSeries.addBookToSeries(new Book("The return of the king", "Bokklubben", "Mannen", "3", "654"));
        Book bookResult = null;
        Iterator<Book> bookSeriesIt = bookSeries.getBookSeriesIterator();
        while (bookSeriesIt.hasNext())
        {
            Book book = bookSeriesIt.next();
            if(book.getTitle().equals("Two towers"))
            {
                bookResult = book;
            }

        }
        assertEquals("Two towers", bookResult.getTitle());
    }

    @Test
    public void removeBookFromSeries()
    {BookSeries bookSeries = new BookSeries("Ringenes Herre", "Bokklubben");
        bookSeries.addBookToSeries(new Book("The fellowship of the ring", "Bokklubben", "Mannen", "3", "654"));
        bookSeries.addBookToSeries(new Book("Two towers", "Bokklubben", "Mannen", "3", "654"));
        bookSeries.addBookToSeries(new Book("The return of the king", "Bokklubben", "Mannen", "3", "654"));
        Book bookResults = null;
        Iterator<Book> bookSeriesIt1 = bookSeries.getBookSeriesIterator();
        while (bookSeriesIt1.hasNext())
        {
            Book book = bookSeriesIt1.next();
            if(book.getTitle().equals("Two towers"))
            {
                bookSeries.removeBookFromSeries(book);
            }
        }
        Iterator<Book> bookSeriesIt2 = bookSeries.getBookSeriesIterator();
        while (bookSeriesIt2.hasNext())
        {
            Book book = bookSeriesIt2.next();
            if(book.getTitle().equals("Two towers"))
            {
                bookResults = book;
            }
        }
        assertNull(bookResults);
    }
}
