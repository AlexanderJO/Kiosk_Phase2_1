import org.junit.Test;

import static org.junit.Assert.*;

public class MagazineTest
{
    @Test
    public void testGetTitle()
    {
        Magazine magazine = new Magazine("Hei", "Sondre", "BygdaBlog", 4);
        assertEquals("Hei", magazine.getTitle());
    }

    @Test
    public void testGetPublisher()
    {
        Magazine magazine = new Magazine("Hei", "Sondre", "BygdaBlog", 4);
        assertEquals("Sondre", magazine.getPublisher());
    }

    @Test
    public void testGetAuthor()
    {
        Magazine magazine = new Magazine("Hei", "Sondre", "BygdaBlog", 4);
        assertEquals("BygdaBlog", magazine.getGenre());
    }

    @Test
    public void testGetEdition()
    {
        Magazine magazine = new Magazine("Hei", "Sondre", "BygdaBlog", 4);
        assertEquals(4, magazine.getReleases());
    }
}