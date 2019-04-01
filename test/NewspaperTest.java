import org.junit.Test;

import static org.junit.Assert.*;

public class NewspaperTest
{
    @Test
    public void testGetTitle()
    {
        Newspaper newspaper = new Newspaper("Hei", "Sondre", "BygdaBlog", 4);
        assertEquals("Hei", newspaper.getTitle());
    }

    @Test
    public void testGetPublisher()
    {
        Newspaper newspaper = new Newspaper("Hei", "Sondre", "BygdaBlog", 4);
        assertEquals("Sondre", newspaper.getPublisher());
    }

    @Test
    public void testGetAuthor()
    {
        Newspaper newspaper = new Newspaper("Hei", "Sondre", "BygdaBlog", 4);
        assertEquals("BygdaBlog", newspaper.getGenre());
    }

    @Test
    public void testGetEdition()
    {
        Newspaper newspaper = new Newspaper("Hei", "Sondre", "BygdaBlog", 4);
        assertEquals(4, newspaper.getReleases());
    }
}