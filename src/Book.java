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
 * @version     v1.0 (beta) 2019.02.13
 */

public class Book
{
    // Fields
    private final String title;
    private final String publisher;
    private final String author;
    private String edition;
    private String datePublished;
    private String series;
    
    /**
     * Constructor for object of class Book.
     */
    public Book(String title, String publisher, String author, String edition, String datePublished)
    {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this. edition = edition;
        this.datePublished = datePublished;
        this.series = null;
    }
    
    /**
     * Constructor for object of class Book.
     */
    public Book(String title, String publisher, String author, String edition, String datePublished, String series)
    {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this. edition = edition;
        this.datePublished = datePublished;
        this.series = series;
    }
    
    /**
     * Puts the book in a series.
     */
    public void setBookInSeries(String series)
    {
        this.series = series;
    }
    
    /**
     * Gets the title of the book.
     */
    public String getTitle()
    {
        return this.title;
    }
    
    /**
     * Gets the publisher of the book.
     */
    public String getPublisher()
    {
        return this.publisher;
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
    
    /**
     * Gets the series for the book.
     */
    public String getSeries()
    {
        return this.series;
    }
    
}
