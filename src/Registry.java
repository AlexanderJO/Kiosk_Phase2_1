import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Stores a registry of all books and periodicals.
 *
 * Important note: Set fillRegistryListWithDummies to
 * private when released to customer.
 */
public class Registry
{
    // ------------------- Fields ----------------
    private ArrayList<Literature> literatureList;

    // ------------------- Constructor ----------------
    public Registry()
    {
        this.literatureList = new ArrayList<Literature>();
    }

    // ------------------- Mutator Methods ----------------

    /**
     * Add book.
     * @param title         Title of the book.
     * @param publisher     Publisher of the book.
     * @param author        Author of the book.
     * @param edition       Edition of the book (Ex. Sixth Edition or 6th. Edition)
     * @param datePublished Publish date of the book.
     */
    public void addBook(String title, String publisher, String author, String edition, String datePublished)
    {
        this.literatureList.add(new Book(title, publisher, author, edition, datePublished));
    }

    /**
     * Add book to  series.
     */
    public boolean addBookToSeries(String title, Book book)
    {
        Boolean found = false;

        Iterator<Literature> literatureIt = this.literatureList.iterator();

        while ( literatureIt.hasNext() )
        {
            Literature literature = literatureIt.next();

            if ( literature instanceof  BookSeries )
            {
                BookSeries bookSeries = (BookSeries) literature;

                if ( bookSeries.getTitle().equals(title) )
                {
                    bookSeries.addBookToSeries(book);
                    found = true;
                }
            }
        }

        return found;
    }

    /**
     * Removes the book by using the title.
     *
     * @param title     Title of the book to be removed.
     */
    public void removeBook(String title)
    {
        boolean found = false;
        int index = 0;

        while ( ( index < this.literatureList.size() ) && !found )
        {
            Literature literature = this.literatureList.get(index);

            if ( literature instanceof Book)
            {
                if ( literature.getTitle().equals(title) )
                {
                    this.literatureList.remove(literature);
                    found = true;
                }
                index++;
            }
        }
    }

    /**
     * Add book.
     * @param title         Title of the periodical.
     * @param publisher     Publisher of the periodical.
     * @param datePublished Publish date of the periodical.
     * @param genre         Genre of the periodical.
     * @param type          Type of the periodical (Newspaper, Magazine, Journal)
     * @param datePublished Publish date of the periodical.
     */
    public void addPeriodical(String title, String publisher, String datePublished, String genre, String type)
    {
        this.literatureList.add(new Periodical(title, publisher, datePublished, genre, type));
    }

    /**
     * Returns the iterator of the literature.
     * @return the iterator of the literature.
     */
    public Iterator<Literature> getIteratorLiteratureList()
    {
        return this.literatureList.iterator();
    }

    // ------------------- Accessor Methods ----------------

    /**
     * Checks if the string is the same as either the title or
     * author of the book.
     * Returns true if the title or author is found,
     * false otherwise.
     * @param string The string that contains either the name of
     *               the book or name of author.
     * @param book The object Book.
     * @return true if the title or author is found,
     * false otherwise.
     */
    public boolean checkBookCompliance(String string, Book book)
    {
        boolean found = false;

        if ( book.getTitle().equals(string) )
        {
            found = true;
        }

        if ( book.getAuthor().equals(string) )
        {
            found = true;
        }

        return found;
    }

    /**
     * Checks if string is equal to parameters of the book.
     * Returns the book if found, otherwise returns null.
     *
     * @param string String to be checked.
     * @return Return book.
     */
    public Book bookSearch(String string)
    {
        Book bookReturn = null;
        boolean found = false;
        int index = 0;

        while ( index < this.literatureList.size() && !found )
        {
            Literature literature = literatureList.get(index);

            if ( literature instanceof Book )
            {
                Book bookSearch = (Book) literature;
                if ( checkBookCompliance(string, bookSearch) )
                {
                    bookReturn = (Book) literature;           // Casting the book.

                    found = true;
                }
            }

            index++;
        }

        return bookReturn;
    }

    /**
     * Checks if the literature is book.
     * Returns true if book, false otherwise.
     * @return true if book, false otherwise.
     */
    public boolean isBook(Literature literature)
    {
        boolean isBook = false;

        if ( literature instanceof Book )
        {
            isBook = true;
        }

        return isBook;
    }

    /**
     * Checks if the literature is periodical.
     * Returns true if periodical, false otherwise.
     * @return true if periodical, false otherwise.
     */
    public boolean isPeriodical(Literature literature)
    {
        boolean isPeriodical = false;

        if ( literature instanceof Periodical )
        {
            isPeriodical = true;
        }

        return isPeriodical;
    }

    /**
     * Fills the registry with dummies.
     * Important note: Set to private when released to customer.
     */
    public void fillRegistryListWithDummies()
    {
        Book book1 = new Book("Book 1", "Publisher 1", "Author 1", "First Edition", "2019.01.01");
        Book book2 = new Book("Book 2", "Publisher 1", "Author 1", "Second Edition", "2019.01.02");
        Book book3 = new Book("Book 3", "Publisher 2", "Author 1", "First Edition", "2019.01.01");
        this.literatureList.add(book1);
        this.literatureList.add(book2);
        this.literatureList.add(book3);
        this.literatureList.add(new Book("Book 4", "Publisher 3", "Author 2", "First Edition", "2019.01.01"));
        this.literatureList.add(new Book("Book 5", "Publisher 1", "Author 2", "First Edition", "2019.01.01"));

        this.literatureList.add(new Book("Book 6", "Publisher 1", "Author 1", "First Edition", "2019.01.01"));
        this.literatureList.add(new Book("Book 7", "Publisher 1", "Author 5", "Second Edition", "2019.01.02"));
        this.literatureList.add(new Book("Book 8", "Publisher 2", "Author 1", "First Edition", "2019.01.05"));
        this.literatureList.add(new Book("Book 9", "Publisher 3", "Author 2", "Third Edition", "2019.01.05"));
        this.literatureList.add(new Book("Book 10", "Publisher 1", "Author 2", "First Edition", "2019.01.06"));

        this.addBookToSeries("Serie av styr", book1);
        this.addBookToSeries("Serie av styr", book2);
        this.addBookToSeries("Serie av styr", book3);

        this.literatureList.add(new Periodical("Periodical 1", "Publisher 1", "2019.01.06", "Woman stuff", "Magazine"));
    }
}
