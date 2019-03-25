import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest
{

    @Test
    public void getTitle()
    {
        Book book = new Book("Hei", "Sondre", "Alex", "4", "12");
        assertEquals("Hei", book.getTitle());
    }

    @Test
    public void getPublisher()
    {
        Book book = new Book("Hei", "Sondre", "Alex", "4", "12");
        assertEquals("Sondre", book.getPublisher());
    }

    @Test
    public void getAuthor()
    {
        Book book = new Book("Hei", "Sondre", "Alex", "4", "12");
        assertEquals("Alex", book.getAuthor());
    }

    @Test
    public void getEdition()
    {
        Book book = new Book("Hei", "Sondre", "Alex", "4", "12");
        assertEquals("4", book.getEdition());
    }

    @Test
    public void getDatePublished()
    {
        Book book = new Book("Hei", "Sondre", "Alex", "4", "12");
        assertEquals("12", book.getDatePublished());
    }

//    @Test
//    public void getSeries()
//    {
//
//        Book book = new Book("Hei", "Sondre", "Alex", "4", "12", "Artige dager");
//        assertEquals("Artige dager", book.getSeries());
//    }
}