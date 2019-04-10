import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest
{
    @Test
    public void testGetTitle()
    {
        Book book = new Book("Hei", "Sondre", "Alex", "4", "12");
        assertEquals("Hei", book.getTitle());
    }

    @Test
    public void testGetPublisher()
    {
        Book book = new Book("Hei", "Sondre", "Alex", "4", "12");
        assertEquals("Sondre", book.getPublisher());
    }

    @Test
    public void testGetAuthor()
    {
        Book book = new Book("Hei", "Sondre", "Alex", "4", "12");
        assertEquals("Alex", book.getAuthor());
    }

    @Test
    public void testGetEdition()
    {
        Book book = new Book("Hei", "Sondre", "Alex", "4", "12");
        assertEquals("4", book.getEdition());
    }

    @Test
    public void testGetDatePublished()
    {
        Book book = new Book("Hei", "Sondre", "Alex", "4", "12");
        assertEquals("12", book.getDatePublished());
    }
}