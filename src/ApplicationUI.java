
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 *
 * In this registry you can;
 * <p>
 *  <ul>
 *  <li>    Add book with title, publisher, author, edition and publish date   </li>
 *  <li>    Add book with title, publisher, author, edition, publish date and series </li>
 *  <li>    Add book to series </li>
 *  <li>    Remove book    </li>
 *  <li>    List and get all books    </li>
 *  <li>    List and get all books by title </li>
 *  <li>    List and get all books by author </li>
 *  <li>    List and get all books by publisher </li>
 *  <li>    List and get all books in series </li>
 *  </ul>
 *  <p>
 *  <b> Important note: fillBookListWithDummies to be made private when released to customer.
 *                      Method used for debugging purposes.</b>
 *
 *  @author     Alexander J. Overvåg, Sondre Nerhus, Gustav S. Hagen
 *  @version    v1.0 (beta) 2019.02.13
 */
public class ApplicationUI
{


    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = {
            "1. List all books",
            "2. Add new book",
            "3. Add book to series",
            "4. Find a book by title",
            "5. Find a book by author",
            "6. Find books by series",
            "7. Remove a book by title"
    };

    private BookRegistry bookRegistry;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI()
    {
        this.bookRegistry = new BookRegistry();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start()
    {
        this.init();

        this.bookRegistry.fillBookListWithDummies();

        boolean quit = false;

        while (!quit)
        {
            try
            {
                this.showMenu();
                int menuSelection = this.menuInput(); // Read input from user

                switch (menuSelection)
                {
                    case 1:
                        this.listAllBooks();
                        break;

                    case 2:
                        this.addNewBook();
                        break;

                    case 3:
                        this.addBookToSeries();
                        break;

                    case 4:
                        this.findBookByTitle();
                        break;

                    case 5:
                        this.findBookByAuthor();
                        break;

                    case 6:
                        this.findBooksBySeries();
                        break;

                    case 7:
                        this.removeBookByTitle();
                        break;

                    case 8:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            } catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + (this.menuItems.length + 1) + ".\n");
            }
        }

    }

    /**
     * Displays the menu to the user.
     */
    private void showMenu()
    {
        int maxMenuItemNumber = menuItems.length + 1;

        if ( menuItems.length > 0 )
        {
            System.out.println("\n**** Application v0.2 ****\n");
            // Display the menu
            for (String menuItem : menuItems)
            {
                System.out.println(menuItem);
            }
            // Add the "Exit"-choice to the menu
            System.out.println(maxMenuItemNumber + ". Exit\n");
            this.initLineString();
            System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        }
    }

    /**
     * Reads the input from the user.
     */

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made privat, since they are only used by the menu ---

    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here
     */
    private void init()
    {
        System.out.println("init() was called");
    }

    // --------- Mutator Methods -------------

    /**
     * Add a new product/literature to the register.
     * In this method you have to add code to ask the
     * user for the necessary information you need to
     * create an instance of the product, which you
     * then send as a parameter to the addNewspaper()-
     * method of the register.
     * Remember to also handle invalid input from the
     * user!!
     */
    private void addNewBook()
    {
        // Brukeren har nå valgt å legge til en bok
        this.initLineString();
        System.out.println("Please enter the title of the book: ");

        // HOLD! Er dette rett måte å løse det på?
        // Checks if title input is empty or if title already exists.
        String title = "";
        boolean uniqueTitle = false;
        while ( !uniqueTitle )
        {
            title = this.scannerString();     // Waits for the user to push enter.
            //this.isStringEmpty(title = scannerString()) || this.bookRegistry.getBookByTitle(title) != null
            if ( this.isStringEmpty(title) )
            {
                this.errorMessageEmptyString();

                this.initLineString();
                System.out.println("Please enter the title of the book: ");
            }

            else if ( this.bookRegistry.getBookByTitle(title) != null )
            {
                errorMessageDuplicateTitle();

                this.initLineString();
                System.out.println("Please enter the title of the book: ");
            }

            else
            {
                uniqueTitle = true;
            }
        }

        this.initLineString();
        System.out.println("Please enter the publisher of the book: ");
        String publisher = this.scannerString();                       // Waits for the user to push enter.

        this.initLineString();
        System.out.println("Please enter the author of the book: ");
        String author = this.scannerString();                      // Waits for the user to push enter.

        this.initLineString();
        System.out.println("Please enter the edition of the book: ");
        String edition = this.scannerString();                     // Waits for the user to push enter.

        this.initLineString();
        System.out.println("Please enter the publishing date of the book: ");
        String datePublished = this.scannerString();                     // Waits for the user to push enter.

        this.initLineString();
        this.seriesToBookQuestion();

        boolean choiceTaken = false;

        while ( !choiceTaken )
        {
            this.initLineString();
            String yesNo = this.scannerString().toLowerCase();

            // Checks if input is yes.
            if ( yesNo.equals("yes"))
            {
                this.initLineString();
                System.out.println("Please enter the series of the book: ");
                String series = this.scannerString();
                this.bookRegistry.addBookWithSeries(title, publisher, author, edition, datePublished, series);
                choiceTaken = true;
            }

            // Checks if input is no.
            else if ( yesNo.equals("no"))
            {
                this.bookRegistry.addBook(title, publisher, author, edition, datePublished);
                choiceTaken = true;
            }

            this.initLineString();
            this.seriesToBookQuestion();
        }
    }

    /**
     * Adds the book object to a series.
     * Assignes "series" field of book to input.
     */
    private void addBookToSeries()
    {
        this.initLineString();
        System.out.println("Please enter title of the book that you want to a series: ");
        String title = this.scannerString();                       // Waits for the user to push enter.

        this.initLineString();
        System.out.println("Please enter the name of the series: ");
        String series = this.scannerString();                       // Waits for the user to push enter.

        this.bookRegistry.addBookToSeries(title, series);
    }

    /**
     * Remove the book by title.
     * Takes in string input from user.
     */
    private void removeBookByTitle()
    {
        System.out.println("Please enter the title of the book that you want to remove: ");
        String title = this.scannerString();
        Book book = this.bookRegistry.getBookByTitle(title);
        if ( book != null )
        {
            this.bookRegistry.removeBook(title);
            System.out.println("You successfully removed " + book.getTitle() + ".");
        }

        else
        {
            System.out.println("No book with this title.");
        }

    }

    // ---------------- Accessor Methods ---------------

    /**
     * Find and display a product based om name (title).
     * As with the addNewProduct()-method, you have to
     * ask the user for the string (name/title/publisher)
     * to search for, and then use this string as input-
     * parameter to the method in the register-object.
     * Then, upon return from the register, you need
     * to print the details of the found item.
     */
    private void findBookByTitle()
    {
        System.out.println("Please enter title of the book you want to find: ");
        String title = this.scannerString();
        Book book = this.bookRegistry.getBookByTitle(title);
        this.printBook(book);
    }

    /**
     * List all books by author.
     * Takes in String input from user.
     */
    private void findBookByAuthor()
    {
        System.out.println("Please enter the author of the book you want to find: ");
        String author = this.scannerString();
        int numberOfBooks = 0;

        Iterator<Book> bookListIt = this.bookRegistry.getIterator();

        while (bookListIt.hasNext())
        {
            Book book = bookListIt.next();
            if ( book.getAuthor() != null )
            {
                if ( book.getAuthor().equals(author) )
                {
                    printBook(book);
                    numberOfBooks++;
                }
            }
        }

        if (numberOfBooks == 0)
        {
            System.out.println("No books found by this author.");
        }

        else
        {
            System.out.println("The number of books found: " + numberOfBooks);
        }
    }

    /**
     * Lists all books in a series.
     * Takes in String input from user.
     */
    private void findBooksBySeries()
    {
        System.out.println("Please enter the series for the book(-s) you want to find: ");
        String series = this.scannerString();
        int numberOfBooks = 0;

        Iterator<Book> bookListIt = this.bookRegistry.getIterator();

        while (bookListIt.hasNext())
        {
            Book book = bookListIt.next();
            if ( book.getSeries() != null )
            {
                if ( book.getSeries().equals(series) )
                {
                    printBook(book);
                    numberOfBooks++;
                }
            }
        }

        if (numberOfBooks == 0)
        {
            System.out.println("No books found by this series.");
        }

        else
        {
            System.out.println("The number of books found: " + numberOfBooks);
        }
    }

    /**
     * Lists all the products/literature in the register
     */
    private void listAllBooks()
    {
        Iterator<Book> bookListIt = this.bookRegistry.getIterator();


        this.initLineString();
        System.out.println("Do you want a detailed list over the books? [Yes/No]");
        String yesNo = this.scannerString().toLowerCase();

        // Checks if input is yes.
        if ( yesNo.equals("yes"))
        {
            if ( !bookListIt.hasNext() )
            {
                System.out.println("No books in registry.");
            }

            while (bookListIt.hasNext())
            {
                Book book = bookListIt.next();
                this.printBookDetailed(book);
            }
        }

        // Checks if input is no.
        else if ( yesNo.equals("no"))
        {
            if ( !bookListIt.hasNext() )
            {
                System.out.println("No books in registry.");
            }

            while (bookListIt.hasNext())
            {
                Book book = bookListIt.next();
                this.printBook(book);
            }
        }



//        if ( !bookListIt.hasNext() )
//        {
//            System.out.println("No books in registry.");
//        }
//
//        while (bookListIt.hasNext())
//        {
//            Book book = bookListIt.next();
//            printBook(book);
//        }
    }



    // ----------- Print Methods ---------------

    /**
     * Prints a single line string of information for book.
     * Prints either with or without series.
     * @param book takes in book of class Book.
     */
    private void printBook(Book book)
    {
        if (book.getSeries() == null)
        {
            System.out.println("Title: " + book.getTitle() + ", Publisher: " + book.getPublisher()
                    + ", Author: " + book.getAuthor() + ", Edition: " + book.getEdition()
                    + ", Date published: " + book.getDatePublished());
        }

        else
        {
            System.out.println("Title: " + book.getTitle() + ", Publisher: " + book.getPublisher()
                    + ", Author: " + book.getAuthor() + ", Edition: " + book.getEdition()
                    + ", Date published: " + book.getDatePublished() + ", Series: " + book.getSeries());
        }
    }

    /**
     * Prints a detailed list over several lines with information for book
     * Prints list with series field marked as "Not available" if
     * no series has been added to the book.
     * @param book takes in book of class Book.
     */
    private void printBookDetailed(Book book)
    {
        System.out.println("----------------------------------------------------");
        System.out.println("Title:              " + book.getTitle());
        System.out.println("Publisher:          " + book.getPublisher());
        System.out.println("Author:             " + book.getAuthor());
        System.out.println("Edition:            " + book.getEdition());
        System.out.println("Date published:     " + book.getDatePublished());
        if ( book.getSeries() == null )
        {
            System.out.println("Series:             Not available.");
        }
        else
        {
            System.out.println("Series:         " + book.getSeries());
        }
    }

    /**
     * The initial value in front of each command line and input.
     */
    private void initLineString()
    {

        System.out.print(">  ");
    }

    /**
     * Prints a message stating that user shoudl
     */
    private void seriesToBookQuestion()
    {
        System.out.println("Do you want to add this book to a series [Yes/No]?");
    }

    // ------------- Scanner and Menu Method ----------------

    /**
     * Takes in input from user.
     * Return the string input from user.
     * @return the string input from user.
     */
    private String scannerString()
    {
        this.initLineString();
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }

    /**
     * Takes in input from user.
     * Return the int input from user.
     * @return the int input from user.
     */
    private int scannerInt()
    {
        this.initLineString();
        Scanner reader = new Scanner(System.in);
        int input = reader.nextInt();
        return input;
    }

    /**
     * Checks if string is not empty nor null.
     */
    private boolean isStringEmpty(String input)
    {
        boolean isEmpty = true;
        if ( input.length() > 0 )
        {
            isEmpty = false;
        }

        return isEmpty;
    }

    /**
     * Waits for the users input. The user is expected to input an integer between
     * 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int menuInput() throws InputMismatchException
    {
        int maxMenuItemNumber = menuItems.length + 1;
        int menuSelection = this.scannerInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    // ------------------- Error Methods --------------

    /**
     * Prints an error message if expected string length is to short (0 characters).
     */
    private void errorMessageEmptyString()
    {
        this.initLineString();
        System.out.println("Text of min. 1 character is required.");
    }

    /**
     * Prints an error message if title is already taken.
     */
    private void errorMessageDuplicateTitle()
    {
        this.initLineString();
        System.out.println("Book with this title already exists. Please create an unique title.");
    }

}
