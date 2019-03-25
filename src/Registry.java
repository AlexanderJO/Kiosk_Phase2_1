import java.util.Iterator;
import java.util.ArrayList;

/**
 * Represents a book registry, holding a collection of books. This book registry will be included in
 * a literature collection, either published, periodical or non-periodical.
 *
 * This registry can;
 *  * <p>
 *  *  <ul>
 *  *  <li>    Add book with title, publisher, author, edition and publish date   </li>
 *  *  <li>    Add book with title, publisher, author, edition, publish date and series </li>
 *  *  <li>    Add book to series </li>
 *  *  <li>    Remove book by title   </li>
 *  *  <li>    List and get all books    </li>
 *  *  <li>    List and get all books by title </li>
 *  *  <li>    List and get all books by author </li>
 *  *  <li>    List and get all books by publisher </li>
 *  *  <li>    List and get all books in series </li>
 *  *  </ul>
 *
 * The object Book contains the parameters Title, Author, Publisher, Date published, Edition and Series.
 *
 *  @author     Alexander J. Overvåg, Sondre Nerhus, Gustav S. Hagen
 *  @version    v2.0 (beta) 2019.03.06
 */
public class Registry
{
    // Instance variable for the class Registry.
    private ArrayList<Literature> literatureList;           // ArrayList collection of books.

    /**
     * Constructor for object of class Registry.
     * Makes the list for the Registry.
     */
    public Registry()
    {
        // Initialises the instance variables for class Book.
        this.literatureList = new ArrayList<Literature>();

    }

    /**
     * Create book to the literatureList.
     *
     * @param title         Title of the book.
     * @param publisher     Publisher of the book.
     * @param author        Author of the book.
     * @param edition       Edition of the book (Ex. Sixth Edition or 6th. Edition)
     * @param datePublished Publish date of the book.
     */
    public void addBook(String title, String publisher, String author,
                        String edition, String datePublished)
    {
        literatureList.add(new Book(title, publisher, author, edition, datePublished) );
    }

    public void addBookSeries(String title, String publisher)
    {
        literatureList.add(new BookSeries(title, publisher));
    }

    public void addPeriodical(String title, String publisher, String genre, String type, int releases)
    {
        literatureList.add(new Periodical(title, publisher, genre, type, releases));
    }

    /**
     * Removes the literature by using a given literature.
     *
     * @param literature    Literature to be removed.
     */
    public void removeLiterature(Literature literature)
    {
        literatureList.remove(literature);
    }

//    /**
//     * Adds a book to a series.
//     *
//     * @param title     Title of the book to be added.
//     * @param series    Series of the book to be added.
//     */
//    public void addBookToSeries(String title, String series)
//    {
//        boolean found = false;
//        int index = 0;
//        while ( ( index < this.literatureList.size() ) && !found )
//        {
//            Literature literature = this.literatureList.get(index);
//
//            if ( literature.getTitle().equals(title) )
//            {
//                BookSeries bookSeries = (BookSeries) literature;
//                bookSeries.addBookToSeries(new Book());
//                found = true;
//            }
//            index++;
//        }
//    }

    /**
     * Adds a book to a series chosen by title
     * @param title The title of the series
     * @param book The book you want to add to the series
     */
    public boolean addBookToSeries(String title, Book book)
    {
        Boolean found = false;
        Iterator<Literature> literatureIt = literatureList.iterator();
        while(literatureIt.hasNext())
        {
            Literature literature = literatureIt.next();
            if(literature instanceof BookSeries)
            {
                BookSeries bookSeries = (BookSeries) literature;
                if(bookSeries.getTitle().equals(title))
                {
                    bookSeries.addBookToSeries(book);
                    found = true;
                }
            }
        }
        return found;
    }

    /**
     * Return book by title. Title is assumed to be unique.
     *
     * @param title Title of the book.
     * @return Return book by title.
     */
    public Book getBookByTitle(String title)
    {
        Book book = null;

        boolean found = false;
        int index = 0;

        while ( index < this.literatureList.size() && !found )
        {
            if ( this.literatureList.get(index).getTitle().equals(title) )
            {

                Literature literature = this.literatureList.get(index);
                book = (Book) literature;

                found = true;
            }

            index++;
        }

        return book;
    }

    public Literature getLiteratureByTitle(String title, int type)
    {
        Iterator<Literature> literatureIt = literatureList.iterator();
        while(literatureIt.hasNext())
        {
            Literature literature = literatureIt.next();
            switch (type)
            {
                case 0:
                    if(literature instanceof Book)
                    {
                        if(literature.getTitle().equals(title))
                        {
                            return literature;
                        }
                    }
                    break;

                case 1:
                    if(literature instanceof BookSeries)
                    {
                        if(literature.getTitle().equals(title))
                        {
                            return literature;
                        }
                    }
                    break;

                case 2:
                    if(literature instanceof Periodical)
                    {
                        if(literature.getTitle().equals(title))
                        {
                            return literature;
                        }
                    }
                    break;
            }
        }
        return null;
    }

    /**
     * Returns the iterator over the literatureList.
     */
    public Iterator<Literature> getIterator()
    {
        return this.literatureList.iterator();
    }

    public void fillBookListWithDummies()
    {
        this.literatureList.add(new Book("Book 6", "Publisher 1", "Author 1", "First Edition", "2019.01.01"));
        this.literatureList.add(new Book("Book 7", "Publisher 1", "Author 5", "Second Edition", "2019.01.02"));
        this.literatureList.add(new Book("Book 8", "Publisher 2", "Author 1", "First Edition", "2019.01.05"));
        this.literatureList.add(new Book("Book 9", "Publisher 3", "Author 2", "Third Edition", "2019.01.05"));
        this.literatureList.add(new Book("Book 10", "Publisher 1", "Author 2", "First Edition", "2019.01.06"));

        BookSeries bookSeries = new BookSeries("BookSeries 10", "BOiiii");
        this.literatureList.add(bookSeries);
        bookSeries.addBookToSeries(new Book("Book 1", "Publisher 1", "Author 1", "First Edition", "2019.01.01"));
        bookSeries.addBookToSeries(new Book("Book 2", "Publisher 1", "Author 1", "First Edition", "2019.01.01"));
        bookSeries.addBookToSeries(new Book("Book 3", "Publisher 1", "Author 1", "First Edition", "2019.01.01"));
        bookSeries.addBookToSeries(new Book("Book 4", "Publisher 1", "Author 1", "First Edition", "2019.01.01"));
        bookSeries.addBookToSeries(new Book("Book 51", "Publisher 1", "Author 1", "First Edition", "2019.01.01"));

        this.literatureList.add(new Periodical("Mor Di", "Anibalus", "Sport", "Magazine", 100));
        this.literatureList.add(new Periodical("Dagens hete nytt", "VG", "Sladder", "Avise", 100));
    }
}