/**
 * Represents a the Literature, holding information about the literature.
 * A literature can be Book or Periodical.
 * Periodical can be newspaper, magazine, journal, etc.
 *
 * In this literature class you can:
 * <ul>
 * <li> get name of literature </li>
 * <li> get publisher of book </li>
 *
 * @author      Alexander J. Overvåg, Sondre Nerhus, Gustav S. Hagen
 * @version     v1.0 (beta) 2019.03.13
 */
public class Literature
{
    // ---------------- Fields --------------------
    private String title;
    private String publisher;

    // ---------------- Constructor --------------------
    public Literature(String title, String publisher)
    {
        this.title = title;
        this.publisher = publisher;
    }

    // ---------------- Methods --------------------

    /**
     * Returns the title of the literature.
     * @return the title of the literature.
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Returns the publisher of the literature.
     * @return the publisher of the literature.
     */
    public String getPublisher()
    {
        return this.publisher;
    }
}
