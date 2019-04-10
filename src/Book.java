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
 */

public class Book extends Literature
{
    // Fields:
    // The author of the book.
    private final String author;
    // The edition of the book.
    private String edition;
    // The date the book is published.
    private String datePublished;

    /**
     * Constructor for object of class Book.
     */
    public Book(String title, String publisher, String author, String edition, String datePublished)
    {
        // Checks if the title is null. If yes, the title is an empty string.
        if(title == null) { title = ""; }
        // Checks if the publisher is null. If yes, the publisher is an empty string.
        if(publisher == null) { publisher = ""; }
        // Checks if the author is null. If yes, the author is an empty string.
        if(author == null) { author = ""; }
        // Checks if the edition is null. If yes, the edition is an empty string.
        if(edition == null) { edition = ""; }
        // Checks if the date published is null. If yes, the date published is an empty string.
        if(datePublished == null) { datePublished = ""; }

        // setTitle and setPublisher are inherited from the Literature-class
        setTitle(title);
        setPublisher(publisher);
        this.author = author;
        this.edition = edition;
        this.datePublished = datePublished;
    }
    /**
     * Returns the author of the book.
     * @return The author of the book.
     */
    public String getAuthor()
    {
        return this.author;
    }

    /**
     * Returns the edition of the book.
     * @return The edition of the book.
     */
    public String getEdition()
    {
        return this.edition;
    }

    /**
     * Returns the date the book is published.
     * @return The date the book is published.
     */
    public String getDatePublished()
    {
        return this.datePublished;
    }
}
