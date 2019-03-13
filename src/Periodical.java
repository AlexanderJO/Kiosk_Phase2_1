/**
 * Represents a periodical, holding information about the periodical.
 * Periodical can be newspaper, magazine, journal, etc.
 * Periodical class inherits data from Literature class.
 *
 * In this periodical class you can:
 * <ul>
 * <li> get date published of periodical </li>
 * <li> get genre of the periodical </li>
 * <li> get type of periodical (newspaper, magazine, etc.) </li>
 *
 * @author      Alexander J. Overvåg, Sondre Nerhus, Gustav S. Hagen
 * @version     v1.0 (beta) 2019.03.13
 */
public class Periodical extends Literature
{
    // ------------------- Fields ----------------
    private String datePublished;
    private String genre;
    private String type;

    // ------------------- Constructor ----------------
    public Periodical(String title, String publisher, String datePublished, String genre, String type)
    {
        super(title, publisher);
        this.datePublished = datePublished;
        this.genre = genre;
        this.type = type;
    }

    // ------------------- Methods ----------------

    /**
     * Returns the publishing date of the periodical.
     * @return the publishing date of the periodical.
     */
    public String getDatePublished()
    {
        return this.datePublished;
    }

    /**
     * Returns the genre of the periodical.
     * @return the genre of the periodical.
     */
    public String getGenre()
    {
        return this.genre;
    }

    /**
     * Returns the type of the periodical.
     * @return the type of the periodical.
     */
    public String getType()
    {
        return this.type;
    }
}
