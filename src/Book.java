/**
 * Represents a book, holding information about the book.
 * Book class inherits data from Literature class.
 *
 * In this book class you can:
 * <ul>
 * <li> get author of book </li>
 * <li> get edition of book </li>
 * <li> get publish date of book </li>
 * 
 * @author      Alexander J. Overvåg, Sondre Nerhus, Gustav S. Hagen
 * @version     v1.0 (beta) 2019.02.13
 */

public class Book extends Literature
{
    // ------------------- Fields ----------------
    private final String author;
    private String edition;
    private String datePublished;

    // ------------------- Constructor ----------------
    /**
     * Constructor for object of class Book.
     */
    public Book(String title, String publisher, String author, String edition, String datePublished)
    {
        super(title, publisher);
        this.author = author;
        this.edition = edition;
        this.datePublished = datePublished;
    }

    // ------------------- Methods ----------------
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
