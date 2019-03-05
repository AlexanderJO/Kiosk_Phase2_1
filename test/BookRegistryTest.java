import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
}