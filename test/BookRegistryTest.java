import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Test cases of BookRegistry class.
 */
public class BookRegistryTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testAddBook()
    {
        BookRegistry bookRegistry = new BookRegistry();
        bookRegistry.addBook("Arne", "Publisher", "Author", "7", "2019.02.01");
        assertEquals("Arne", bookRegistry.getBookByTitle("Arne").getTitle());
    }

    @Test
    public void testEmptyList()
    {
        BookRegistry bookRegistry = new BookRegistry();
        assertEquals(null, bookRegistry.getBookByTitle("Arne"));
    }

    @Test
    public void testRemoveBook()
    {
        boolean bookMade = false;
        BookRegistry bookRegistry = new BookRegistry();
        bookRegistry.addBook("Arne", "Publisher", "Author", "7", "2019.02.01");
        if (bookRegistry.getBookByTitle("Arne") != null)
        {
            bookMade = true;
        }
        if (bookMade)
        {
            bookRegistry.removeBook("Arne");
            assertEquals( null, bookRegistry.getBookByTitle("Arne"));
        }
        assertTrue(bookMade);

    }

    @Test
    public void testGetIterator()
    {
        BookRegistry bookRegistry = new BookRegistry();

        for (int i = 1; i<11; i++)
        {
            bookRegistry.addBook("Book "+i, "Publisher "+i, "Author "+i, "Edition "+i, "2019.01."+i);
        }

        Iterator<Book> bookListIt = bookRegistry.getIterator();
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