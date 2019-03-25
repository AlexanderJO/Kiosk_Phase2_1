/**
 * Represents a book, holding information about the book.
 *
 * In this book class you can:
 * <ul>
 * <li> get name of book </li>
 * <li> get publisher of book </li>
 * <li> get author of book </li>
 * <li> get edition of book </li>
 * <li> get publish date of book </li>
 *
 * @author      Alexander J. Overvåg, Sondre Nerhus, Gustav S. Hagen
 * @version     v2.0 (beta) 2019.03.06
 */

public class Book extends Literature
{
    // Fields
    private final String author;
    private String edition;
    private String datePublished;
    
    /**
     * Constructor for object of class Book.
     */
    public Book(String title, String publisher, String author, String edition, String datePublished)
    {
        setTitle(title);
        setPublisher(publisher);
        this.author = author;
        this.edition = edition;
        this.datePublished = datePublished;
    }
    /**
     * Gets the author of the book.
     */
    public String getAuthor()
    {
        return this.author;
    }

    /**
     * Gets the edition of the book.
     */
    public String getEdition()
    {
        return this.edition;
    }

    /**
     * Gets the date published for the book.
     */
    public String getDatePublished()
    {
        return this.datePublished;
    }
}
