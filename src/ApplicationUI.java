
import java.util.*;

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
    private String[] startMenuItems = {
            "1. List all books",
            "2. Add new book",
            "3. Add book to series",
            "4. Find a book by title",
            "5. Find a book by author",
            "6. Find books by series",
            "7. Remove a book by title"
    };

    private Registry literatureRegistry;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI()
    {
        // Nothing is done here.
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start()
    {
        this.init();

        this.literatureRegistry.fillRegistryListWithDummies();

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
                        this.findBooksByAuthor();
                        System.out.println("HAS TO BE UPDATED!");
                        break;

                    case 6:
                        //this.findBooksBySeries();
                        this.printsBooksInSeries();
                        System.out.println("HAS TO BE UPDATED!");
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
                System.out.println("\nERROR: Please provide a number between 1 and " + (this.startMenuItems.length + 1) + ".\n");
            }
        }

    }

    /**
     * Displays the menu to the user.
     */
    private void showMenu()
    {
        int maxMenuItemNumber = startMenuItems.length + 1;

        if ( startMenuItems.length > 0 )
        {
            System.out.println("\n**** Application v0.2 ****\n");
            // Display the menu
            for (String menuItem : startMenuItems)
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
    // ------ All these methods are made private, since they are only used by the menu ---

    /**
     * Initializes the application.
     * The registries are initialized here.
     */
    private void init()
    {
        this.literatureRegistry = new Registry();         // the book registry is created.
        System.out.println("init() was called");
    }

    // --------- Mutator Methods -------------

    /**
     * Add a new book to the register.
     * The user is asked for string input for title, publisher,
     * author, edition and date published.
     * User is not able to enter an empty string as title or
     * add a duplicate title.
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

        // Checks that the title title input from the user is unique.
        // Checks that the input is not empty and the title is not
        // already taken.
        while ( !uniqueTitle )
        {
            title = this.scannerString();     // Waits for the user to push enter.

            if ( this.isStringEmpty(title) )
            {
                this.errorMessageEmptyString();     // Prints an error message.

                this.initLineString();
                System.out.println("Please enter the title of the book: ");
            }

            else if ( this.literatureRegistry.bookSearch(title) != null )
            {
                errorMessageDuplicateTitle();       // Prints an error message.

                this.initLineString();
                System.out.println("Please enter the title of the book: ");
            }

            else
            {
                uniqueTitle = true;
            }
        }

        // Asks for the publisher of the book.
        this.initLineString();
        System.out.println("Please enter the publisher of the book: ");
        String publisher = this.scannerString();                       // Waits for the user to push enter.

        // Asks for the author of the book.
        this.initLineString();
        System.out.println("Please enter the author of the book: ");
        String author = this.scannerString();                      // Waits for the user to push enter.

        // Asks for the edition of the book.
        this.initLineString();
        System.out.println("Please enter the edition of the book: ");
        String edition = this.scannerString();                     // Waits for the user to push enter.

        // Asks for the publishing date of the book.
        this.initLineString();
        System.out.println("Please enter the publishing date of the book: ");
        String datePublished = this.scannerString();                     // Waits for the user to push enter.

//        this.initLineString();
//        this.seriesToBookQuestion();
//
//        boolean choiceTaken = false;
//
//        while ( !choiceTaken )
//        {
//            this.initLineString();
//            String yesNo = this.scannerString().toLowerCase();
//
//            // Checks if input is yes.
//            if ( yesNo.equals("yes"))
//            {
//                this.initLineString();
//                System.out.println("Please enter the series of the book: ");
//                String series = this.scannerString();
////                this.bookRegistry.addBookWithSeries(title, publisher, author, edition, datePublished, series);
//                choiceTaken = true;
//            }
//
//            // Checks if input is no.
//            else if ( yesNo.equals("no"))
//            {
//                this.literatureRegistry.addBook(title, publisher, author, edition, datePublished);
//                choiceTaken = true;
//            }
//
//            this.initLineString();
//            this.seriesToBookQuestion();
//        }

        this.literatureRegistry.addBook(title, publisher, author, edition, datePublished);
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

        Book book = this.literatureRegistry.bookSearch(title);

        if ( book != null )
        {
            this.literatureRegistry.addBookToSeries(book, series);
        }

        else
        {
            System.out.println("Book does not exist.");
        }
    }

    /**
     * Remove the book by title.
     * Takes in string input from user.
     */
    private void removeBookByTitle()
    {
        System.out.println("Please enter the title of the book that you want to remove: ");
        String title = this.scannerString();
        Book book = this.literatureRegistry.bookSearch(title);
        if ( book != null )
        {
            this.literatureRegistry.removeBook(title);
            System.out.println("You successfully removed " + book.getTitle() + ".");
        }

        else
        {
            System.out.println("No book with title" + title + ".");
        }
    }

    /**
     * Prints a list of books in series.
     * Asks for input from user for the title of the book series.
    /**
     * Asks the user for the author of the books.
     * Lists all book(-s) with this author if found.
     */
    private void printsBooksInSeries()
    {
        // Asks for user input.
        System.out.println("Please enter the title of the book series " +
                "\nwhere you want to return all books: ");
        String title = this.scannerString();

        int numberOfBooks = 0;                  // Counts the number of books in the list.
        HashMap<Book, String> bookSeriesList =  this.literatureRegistry.getBookSeriesList();

        System.out.println("Books in book series" + title + " :");

        for ( Book book : bookSeriesList.keySet() )
        {
            if ( bookSeriesList.containsValue(title) )
            {
                printBook(book);
//                book.getTitle();
                numberOfBooks++;
            }
        }

        if ( numberOfBooks == 0 )
        {
            System.out.println("No series with this title.");
        }

        else
        {
            System.out.println("The number of books found: " + numberOfBooks);
        }
    }

    // ---------------- Accessor Methods ---------------

    /**
     * Asks the user for the title of the book.
     * Lists the book with this title if found.
     */
    private void findBookByTitle()
    {
        System.out.println("Please enter title of the book you want to find: ");
        String title = this.scannerString();
        Book book = this.literatureRegistry.bookSearch(title);
        this.printBook(book);
    }

    /**
     * Asks the user for the author of the books.
     * Lists all book(-s) with this author if found.
     */
    private void findBooksByAuthor()
    {
        // Asks the user for an input.
        System.out.println("Please enter the author of the book you want to find: ");
        String author = this.scannerString();
        int numberOfBooks = 0;                  // Counts the number of books in the list.

        Iterator<Literature> literatureListIt = this.literatureRegistry.getIteratorLiteratureList();

        while ( literatureListIt.hasNext() )
        {
            Book book = this.literatureRegistry.bookSearch(author);
            if ( book.getAuthor() != null )
            {
                if ( book.getAuthor().equals(author) )
                {
                    printBook(book);
                    numberOfBooks++;
                }
            }
        }

        if ( numberOfBooks == 0 )
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


//
//        Iterator<Book> bookListIt = this.bookRegistry.getIteratorLiteratureList();
//
//        while (bookListIt.hasNext())
//        {
//            Book book = bookListIt.next();
//            if ( book.getSeries() != null )
//            {
//                if ( book.getSeries().equals(series) )
//                {
//                    printBook(book);
//                    numberOfBooks++;
//                }
//            }
//        }
//
//        if (numberOfBooks == 0)
//        {
//            System.out.println("No books found by this series.");
//        }
//
//        else
//        {
//            System.out.println("The number of books found: " + numberOfBooks);
//        }
    }

    /**
     * Lists all the books in the book registry.
     */
    private void listAllBooks()
    {
        Iterator<Literature> literatureListIt = this.literatureRegistry.getIteratorLiteratureList();

        this.initLineString();
        System.out.println("Do you want a detailed list over the books? [Yes/No]");
        String yesNo = this.scannerString().toLowerCase();

        // Checks if input is yes.
        if ( yesNo.equals("yes"))
        {
            this.printSectionLine();
            if ( !literatureListIt.hasNext() )
            {
                System.out.println("No books in registry.");
            }


            while (literatureListIt.hasNext())
            {
                Literature literature = literatureListIt.next();
                if ( this.literatureRegistry.isBook(literature) )
                {
                    Book book = (Book) literature;
                    this.printBookDetailed(book);
                    this.printSectionLine();
                }
            }
        }

        // Checks if input is no.
        else if ( yesNo.equals("no"))
        {
            if ( !literatureListIt.hasNext() )
            {
                System.out.println("No books in registry.");
            }

            this.printSectionLine();
            while (literatureListIt.hasNext())
            {
                Literature literature = literatureListIt.next();
                if ( this.literatureRegistry.isBook(literature) )
                {
                    Book book = (Book) literature;
                    this.printBook(book);
                }
            }
            this.printSectionLine();
        }
    }

    // ----------- Print Methods ---------------

    /**
     * Prints a single line string of information for book.
     * Prints either with or without series.
     * @param book takes in book of class Book.
     */
    private void printBook(Book book)
    {
        System.out.println("Title: " + book.getTitle() + ", Publisher: " + book.getPublisher()
                + ", Author: " + book.getAuthor() + ", Edition: " + book.getEdition()
                + ", Date published: " + book.getDatePublished());
//        if (book.getSeries() == null)
//        {
//            System.out.println("Title: " + book.getTitle() + ", Publisher: " + book.getPublisher()
//                    + ", Author: " + book.getAuthor() + ", Edition: " + book.getEdition()
//                    + ", Date published: " + book.getDatePublished());
//        }
//
//        else
//        {
//            System.out.println("Title: " + book.getTitle() + ", Publisher: " + book.getPublisher()
//                    + ", Author: " + book.getAuthor() + ", Edition: " + book.getEdition()
//                    + ", Date published: " + book.getDatePublished() + ", Series: " + book.getSeries());
//        }
    }

    /**
     * Prints a detailed list over several lines with information for book
     * Prints list with series field marked as "Not available" if
     * no series has been added to the book.
     * @param book takes in book of class Book.
     */
    private void printBookDetailed(Book book)
    {
        System.out.println("Title:              " + book.getTitle());
        System.out.println("Publisher:          " + book.getPublisher());
        System.out.println("Author:             " + book.getAuthor());
        System.out.println("Edition:            " + book.getEdition());
        System.out.println("Date published:     " + book.getDatePublished());
    }

    /**
     * The section line of each item.
     */
    private void printSectionLine()
    {
        System.out.println("----------------------------------------------------");
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
        int maxMenuItemNumber = startMenuItems.length + 1;
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
