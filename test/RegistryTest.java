import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Test cases of Registry class.
 */
public class RegistryTest
{

//    @Test
//    public void testAddBookToSeries()
//    {
//        Registry registry = new Registry();
//        registry.addBook("Hei", "Sondre", "Alex", "4", "12");
//        registry.addBookToSeries("Hei", "Kjekke dager");
//        assertEquals("Kjekke dager", registry.getBookByTitle("Hei").getSeries());
//    }

    @Test
    public void testAddBook()
    {
        Registry registry = new Registry();
        registry.addBook("Arne", "Publisher", "Author", "7", "2019.02.01");
        assertEquals("Arne", registry.getBookByTitle("Arne").getTitle());
    }

//    @Test
//    public void testAddBookWithSeries()
//    {
//        Registry registry = new Registry();
//        registry.addBookWithSeries("Arne", "Publisher", "Author", "7", "2019.02.01", "Series");
//        assertEquals("Series", registry.getBookByTitle("Arne").getSeries());
//    }

    @Test
    public void testEmptyList()
    {
        Registry registry = new Registry();
        assertEquals(null, registry.getBookByTitle("Arne"));
    }

//    @Test
//    public void testRemoveBook()
//    {
//        boolean bookMade = false;
//        Registry registry = new Registry();
//        registry.addBook("Arne", "Publisher", "Author", "7", "2019.02.01");
//        if (registry.getBookByTitle("Arne") != null)
//        {
//            bookMade = true;
//        }
//        if (bookMade)
//        {
//            registry.removeBook("Arne");
//            assertNull(registry.getBookByTitle("Arne"));
//        }
//        assertTrue(bookMade);
//    }

    @Test
    public void testGetBookByTitleCorrectTitle()
    {
        Registry registry = new Registry();
        registry.addBook("Arne", "Publisher", "Author", "7", "2019.02.01");
        assertEquals("Arne", registry.getBookByTitle("Arne").getTitle());
    }

    @Test
    public void testGetBookByTitleWrongTitle()
    {
        Registry registry = new Registry();
        registry.addBook("Arne", "Publisher", "Author", "7", "2019.02.01");
        try
        {
            registry.getBookByTitle("arne").getTitle();
            fail("should've thrown an exception");
        } catch (Throwable NullPointerException) {
            assertEquals(NullPointerException.class, NullPointerException.getClass());
        }
    }

    @Test
    public void testGetIterator()
    {
        Registry registry = new Registry();

        for (int i = 1; i<11; i++)
        {
            registry.addBook("Book "+i, "Publisher "+i, "Author "+i, "Edition "+i, "2019.01."+i);
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