import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    /**
     * Tests that the user is able to set an existing book/object to a series.
     */
//    @Test
//    public void setBookInSeries()
//    {
//        BookRegistry bookRegistry = new BookRegistry();
//        bookRegistry.addBook("Hei", "Sondre", "Alex", "4", "12");
//        bookRegistry.addBookToSeries("Hei", "Kjekke dager");
//        assertEquals("Kjekke dager", bookRegistry.getBookByTitle("Hei").getSeries());
//    }

    /**
     * Tests that the user is successfully able to add a book with series when all parameters are met.
     */
//    @Test
//    public void testAddBookWithSeries()
//    {
//        BookRegistry bookRegistry = new BookRegistry();
//        bookRegistry.addBookWithSeries("Arne", "Publisher", "Author", "7", "2019.02.01", "Series");
//        assertEquals("Series", bookRegistry.getBookByTitle("Arne").getSeries());
//    }

    /**
     * Tests that the user is successfully able to add a book when all parameters are met.
     */
//    @Test
//    public void testAddBook()
//    {
//        BookRegistry bookRegistry = new BookRegistry();
//        bookRegistry.addBook("Arne", "Publisher", "Author", "7", "2019.02.01");
//        assertEquals("Arne", bookRegistry.getBookByTitle("Arne").getTitle());
//    }

    /**
     * Checks that a list is correctly returned as empty when containing no objects.
     */
//    @Test
//    public void testEmptyList()
//    {
//        BookRegistry bookRegistry = new BookRegistry();
//        assertEquals(null, bookRegistry.getBookByTitle("Arne"));
//    }

    /**
     * Tests that the user are  able to correctly remove a book.
     */
//    @Test
//    public void testRemoveBook()
//    {
//        boolean bookMade = false;
//        BookRegistry bookRegistry = new BookRegistry();
//        bookRegistry.addBook("Arne", "Publisher", "Author", "7", "2019.02.01");
//        if (bookRegistry.getBookByTitle("Arne") != null)
//        {
//            bookMade = true;
//        }
//        if (bookMade)
//        {
//            bookRegistry.removeBook("Arne");
//            assertNull(bookRegistry.getBookByTitle("Arne"));
//        }
//        assertTrue(bookMade);
//    }

    /**
     * Tests that the getBookByTitle method returns the expected title (correct object).
     */
//    @Test
//    public void testGetBookByTitleCorrectTitle()
//    {
//        BookRegistry bookRegistry = new BookRegistry();
//        bookRegistry.addBook("Arne", "Publisher", "Author", "7", "2019.02.01");
//        assertEquals("Arne", bookRegistry.getBookByTitle("Arne").getTitle());
//    }

    /**
     * We should for this test expect that a NullPointerException is returned
     * as the user tries to call an object through an incorrect title, and as
     * such calls "null".
     */
//    @Test
//    public void testGetBookByTitleWrongTitle()
//    {
//        BookRegistry bookRegistry = new BookRegistry();
//        bookRegistry.addBook("Arne", "Publisher", "Author", "7", "2019.02.01");
//        try
//        {
//            bookRegistry.getBookByTitle("arne").getTitle();
//            fail("should've thrown an exception");
//        } catch (Throwable NullPointerException) {
//                assertEquals(NullPointerException.class, NullPointerException.getClass());
//        }
//    }

    /**
     * Tests whether the iterator over the book works and the correct number of books are returned.
     */
//    @Test
//    public void testGetIterator()
//    {
//        BookRegistry bookRegistry = new BookRegistry();
//
//        for (int i = 1; i<11; i++)
//        {
//            bookRegistry.addBook("Book "+i, "Publisher "+i, "Author "+i, "Edition "+i, "2019.01."+i);
//        }
//
//        Iterator<Book> bookListIt = bookRegistry.getIterator();
//        boolean isBookListEmpty = bookListIt.hasNext();
//
//        int numberOfBooks = 0;
//        while (bookListIt.hasNext() && numberOfBooks<20)
//        {
//            bookListIt.next();
//            numberOfBooks++;
//        }
//        assertTrue(numberOfBooks==10 && isBookListEmpty);
//    }
}