import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Test cases of Registry class.
 */
public class RegistryTest
{

    @Test
    public void testAddBookToSeries()
    {
        BookSeries bookSeries = new BookSeries("ADA", "Bjarne");
        Registry registry = new Registry();
        registry.addLiterature(bookSeries);
        registry.addBookToSeries("ADA", new Book("Arne", "Bjarne", "Tore","123", "21"));
        assertEquals(1, bookSeries.getSize());
    }

    @Test
    public void testRemoveLiterature()
    {
        Literature literature = new Book("Bok1", "Publisher1", "Author1", "23", "234");
        boolean bookMade = false;
        Registry registry = new Registry();
        registry.addLiterature(literature);
        if (registry.getLiteratureByTitle("Arne",1 ) != null)
        {
            bookMade = true;
        }
        if (bookMade)
        {
            registry.removeLiterature(literature);
        }
        assertNull(registry.getLiteratureByTitle("Arne",1));
    }

    @Test
    public void testRemoveBookFromSeries()
    {
        boolean found = false;
        Registry registry = new Registry();
        Book book = new Book("Per", "Pål", "Trond", "123", "12");
        BookSeries bookSeries = new BookSeries("Arne", "Bjarne");
        registry.addLiterature(bookSeries);
        registry.addBookToSeries("Arne", book);
        Iterator<Literature> bookIt = bookSeries.getBookSeriesIterator();
        if(bookIt.hasNext())
        {
            found = registry.removeBookFromSeries("Arne", book);
        }
        assertTrue(found);
    }


    @Test
    public void testGetIterator()
    {
        Literature literature = new Book("Bok1", "Publisher1", "Author1", "2", "24");
        Registry registry = new Registry();

        for (int i = 1; i<11; i++)
        {
            registry.addLiterature(literature);
        }

        Iterator<Literature> bookListIt = registry.getIterator();
        boolean isBookListEmpty = bookListIt.hasNext();

        int numberOfBooks = 0;
        while (bookListIt.hasNext() && numberOfBooks<20)
        {
            bookListIt.next();
            numberOfBooks++;
        }
        assertTrue(numberOfBooks==10 && isBookListEmpty);
    }

}