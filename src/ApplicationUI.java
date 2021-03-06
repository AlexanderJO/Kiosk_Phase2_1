import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 * <p>
 * In this ApplicationUI you can;
 * <p>
 * <ul>
 * <li>    Add book with title, publisher, author, edition and publish date   </li>
 * <li>    Add book with title, publisher, author, edition, publish date and series </li>
 * <li>    Add book to series </li>
 * <li>    Remove book by title   </li>
 * <li>    List and get all books    </li>
 * <li>    List and get all books by title </li>
 * <li>    List and get all books by author </li>
 * <li>    List and get all books by publisher </li>
 * <li>    List and get all books in series </li>
 * </ul>
 * <p>
 * <b> Important note: fillBookListWithDummies to be removed when released to customer.
 * Method used for debugging purposes.</b>
 *
 * @author Alexander J. Overvåg, Sondre Nerhus, Gustav S. Hagen
 * @version v2.0 (beta) 2019.03.06
 */
public class ApplicationUI
{
    // The menu that will be displayed. You can edit/alter the menu
    // to fit your application (i.e. replace "product" with "literature")
    // etc.
    private String[] mainMenu = {
            "1.  List all literature",
            "2.  Add new literature",
            "3.  Add book to series",
            "4.  Find literature by title",
            "5.  Remove a literature by title",
            "6.  Remove a book from series",
    };
    private String[] typeMenu = {
            "1.  Book",
            "2.  Book series",
            "3.  Newspaper",
            "4.  Magazine"
    };

    private Registry registry;

    private final static int TYPE_BOOK = 1;
    private final static int TYPE_SERIES = 2;
    private final static int TYPE_NEWSPAPER = 3;
    private final static int TYPE_MAGAZINE = 4;

    /**
     * This is the constructor of the ApplicationUI class.
     * Creates an instance of the ApplicationUI
     * with a book registry.
     */
    public ApplicationUI()
    {
        this.registry = new Registry();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user to go in to the different commands(cases).
     */
    public void start()
    {
        this.init();

        boolean quit = false;

        while (!quit)
        {
            try
            {
                System.out.println("----- Main menu -----");
                this.showMenu(mainMenu);
                int menuSelection = this.menuInput(mainMenu); // Read input from user

                switch (menuSelection)
                {
                    case 1:
                        this.listAllLiterature();
                        break;

                    case 2:
                        this.addNewLiterature();
                        break;

                    case 3:
                        this.addBookToSeries();
                        break;

                    case 4:
                        this.findLiteratureByTitle();
                        break;

                    case 5:
                        this.removeLiteratureByTitle();
                        break;

                    case 6:
                        this.removeBookFromSeries();
                        break;

                    case 7:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;


                    default:
                }
            } catch (InputMismatchException ime)
            {
                printMenuError(mainMenu);
            }
        }

    }

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made private, since they are only used by the menu ---

    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here.
     */
    private void init()
    {
        this.registry.fillBookListWithDummies();
        System.out.println("Dummies was made for testing");
    }

    // --------- Mutator Methods -------------

    /**
     * Adds a new literature to the register
     * by choosing the type of literature.
     */
    private void addNewLiterature()
    {
        System.out.println("What type of literature do you want to make?");
        showMenu(typeMenu);
        try
        {
            int type = menuInput(typeMenu);
            switch (type)
            {
                case TYPE_BOOK:
                    addNewBook();
                    break;

                case TYPE_SERIES:
                    addNewBookSeries();
                    break;

                case TYPE_NEWSPAPER:
                    addNewPeriodical(TYPE_NEWSPAPER);
                    break;

                case TYPE_MAGAZINE:
                    addNewPeriodical(TYPE_MAGAZINE);
                    break;

                case 5:
                    System.out.println("Task was exited.");
            }
        }
        catch (InputMismatchException ime)
        {
            printMenuError(typeMenu);
        }
    }

    /**
     * Add a new book to the register by
     * putting in a title, publisher, author, edition,
     * date published and by choice a series.
     */
    private void addNewBook()
    {
        System.out.println("Please enter the title of the book: ");
        String title = scannerString();                       // Waits for the user to push enter.

        String publisher = "";
        if (!isStringEmpty(title))
        {
            System.out.println("Please enter the publisher of the book: ");
            publisher = scannerString();                       // Waits for the user to push enter.
        }

        String author = "";
        if (!isStringEmpty(publisher))
        {
            System.out.println("Please enter the author of the book: ");
            author = scannerString();                      // Waits for the user to push enter.
        }

        String edition = "";
        if (!isStringEmpty(author))
        {
            System.out.println("Please enter the edition of the book: ");
            edition = scannerString();                     // Waits for the user to push enter.
        }

        String datePublished = "";
        if (!isStringEmpty(edition))
        {
            System.out.println("Please enter the publishing date of the book: ");
            datePublished = scannerString();                     // Waits for the user to push enter.
        }

        if (!isStringEmpty(datePublished))
        {
            registry.addLiterature(new Book(title, publisher, author, edition, datePublished));
            System.out.println("The book " + title + " was added to the register");
        } else
        {
            System.out.println("Invalid book parameter, no book was made.");
        }
    }

    /**
     * Add a new book to the register by
     * putting in a title, publisher, author, edition,
     * date published and by choice a series.
     */
    private void addNewBookSeries()
    {
        System.out.println("Please enter the title of the series: ");
        String title = scannerString();                       // Waits for the user to push enter.

        String publisher = "";
        if (!isStringEmpty(title))
        {
            System.out.println("Please enter the publisher of the series: ");
            publisher = scannerString();                       // Waits for the user to push enter.
        }

        if (!isStringEmpty(publisher))
        {
            this.registry.addLiterature(new BookSeries(title, publisher));                    // Waits for the user to push enter.
        } else
        {
            System.out.println("Invalid series parameter, no series was made.");
        }
    }

    /**
     * Adds a book to series.
     * Asks for user input for title of book
     * and title of series.
     */
    private void addBookToSeries()
    {
        System.out.println("Please enter the title of the book: ");
        String titleBook = scannerString();

        if (!isStringEmpty(titleBook))
        {
            Book book = (Book) registry.getLiteratureByTitle(titleBook, TYPE_BOOK);
            if (book != null)
            {
                System.out.println("Please enter the title of the series: ");
                String titleSeries = scannerString();
                if (registry.addBookToSeries(titleSeries, book))
                {
                    System.out.println(titleBook + " was added to " + titleSeries);
                } else
                {
                    System.out.println("Book was not added");
                }
            }
        } else
        {
            System.out.println("Book was not added");
        }
    }

    private void removeBookFromSeries()
    {
        System.out.println("Please enter the title of the book: ");
        String titleBook = scannerString();

        if ( !isStringEmpty(titleBook))
        {
            Book book = (Book) registry.getLiteratureByTitle(titleBook, TYPE_BOOK);

            if ( book != null )
            {
                System.out.println("Please enter the title of the series: ");
                String titleSeries = scannerString();
                if ( registry.removeBookFromSeries(titleSeries, book))
                {
                    System.out.println(titleBook + " was removed from " + titleSeries);
                }
                else
                {
                    System.out.println("Book was not removed");
                }
            }

            else
            {
                System.out.println("Book was not removed");
            }
        }
        else
        {
            System.out.println("Book was not removed");
        }
    }

    private void addNewPeriodical(int type)
    {
        System.out.println("Please enter the title: ");
        String title = scannerString();                       // Waits for the user to push enter.

        String publisher = "";
        if (!isStringEmpty(title))
        {
            System.out.println("Please enter the publisher: ");
            publisher = scannerString();                       // Waits for the user to push enter.
        }

        String genre = "";
        if (!isStringEmpty(publisher))
        {
            System.out.println("Please enter the genre: ");
            genre = scannerString();                      // Waits for the user to push enter.
        }

        int releases = 0;
        if (!isStringEmpty(genre))
        {
            System.out.println("Please enter the number of releases: ");
            try
            {
                releases = scannerInt();
            }
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number greater then 0.\n");
            }
        }

        if (releases>0)
        {
            if(TYPE_NEWSPAPER == type)
            {
                registry.addLiterature(new Newspaper(title, publisher, genre, releases));
                System.out.println("The newspaper " + title + " was added to the register");
            }
            if(TYPE_MAGAZINE == type)
            {
                registry.addLiterature(new Magazine(title, publisher, genre, releases));
                System.out.println("The magazine " + title + " was added to the register");
            }
        }
        else
        {
            System.out.println("Invalid parameter, no periodical was made");
        }
    }

    private void removeLiteratureByTitle()
    {
        System.out.println("Please enter the type of the literature that you want to remove: ");
        this.showMenu(typeMenu);
        int type = 0;
        try
        {
            type = scannerInt();
        }
        catch (InputMismatchException ime)
        {
            System.out.println("\nERROR: Please provide a number greater then 0.\n");
        }

        if ( type == typeMenu.length + 1)
        {
            System.out.println("You've exited the search.");
        }

        else
        {
            System.out.println("Please enter the title of the literature that you want to remove: ");
            String title = scannerString();

            Literature literature = this.registry.getLiteratureByTitle(title, type);
            if(literature != null)
            {
                this.registry.removeLiterature(literature);
                System.out.println(title+" was removed");
            }
            else
            {
                System.out.println("No book with this title.");
            }
        }
    }

    // ---------------- Accessor Methods ---------------

    /**
     * Find and display a literature based on title.
     */
    private void findLiteratureByTitle()
    {
        try
        {
            System.out.println("What literature type do you want to find search through?");
            this.showMenu(typeMenu);
            int typeSelection = this.menuInput(typeMenu); // Read input from user

            System.out.println("Please enter title of the literature you want to find: ");
            String title = scannerString();

            switch (typeSelection)
            {
                case TYPE_BOOK:
                    Book book = (Book) this.registry.getLiteratureByTitle(title, TYPE_BOOK);
                    if (book != null)
                    {
                        this.printLiterature(book);
                    }
                    else
                    {
                        printNoLiterature();
                    }
                    break;

                case TYPE_SERIES:
                    BookSeries bookSeries = (BookSeries) this.registry.getLiteratureByTitle(title, TYPE_SERIES);
                    if (bookSeries != null)
                    {
                        this.printLiterature(bookSeries);
                    }
                    else
                    {
                        printNoLiterature();
                    }
                    break;

                case TYPE_NEWSPAPER:
                    Periodical newspaper = (Periodical) this.registry.getLiteratureByTitle(title, TYPE_BOOK);
                    if (newspaper != null)
                    {
                        this.printLiterature(newspaper);
                    }
                    else
                    {
                        printNoLiterature();
                    }
                    break;

                case TYPE_MAGAZINE:
                    Periodical magazine = (Periodical) this.registry.getLiteratureByTitle(title, TYPE_BOOK);
                    if (magazine != null)
                    {
                        this.printLiterature(magazine);
                    }
                    else
                    {
                        printNoLiterature();
                    }
                    break;

                case 5:
                    System.out.println("Task was exited.");
                    break;
            }
        }
        catch (InputMismatchException ime)
        {
            printMenuError(typeMenu);
        }

    }

    // ---------------- Accessor Methods ---------------

    /**
     * Lists all the books in the register
     */
    private void listAllLiterature()
    {
        Iterator<Literature> bookListIt = this.registry.getIterator();

        if (!bookListIt.hasNext())
        {
            System.out.println("No books in registry.");
        }

        while (bookListIt.hasNext())
        {
            Literature literature = bookListIt.next();
            if (literature instanceof Book)
            {
                printLiterature((Book) literature);
            }
            if (literature instanceof BookSeries)
            {
                printLiterature((BookSeries) literature);
                Iterator<Book> bookSeriesIt = ((BookSeries) literature).getBookSeriesIterator();
                while (bookSeriesIt.hasNext())
                {
                    Book book = bookSeriesIt.next();
                    System.out.print("         ");
                    printLiterature(book);
                }
            }
            if (literature instanceof Newspaper)
            {
                printLiterature((Newspaper) literature);
            }
            if (literature instanceof Magazine)
            {
                printLiterature((Magazine) literature);
            }

        }
    }

    // ----------- Print Methods ---------------

    private void printMenuError(String[] menu)
    {
        System.out.println("\nERROR: Please provide a number between 1 and " + (menu.length + 1) + ".\n");
    }


    /**
     * Displays the menu to the user.
     */
    private void showMenu(String[] menu)
    {
        int maxMenuItemNumber = menu.length + 1;

        if (menu.length > 0)
        {

            // Display the menu
            for (String menuChoice : menu)
            {
                System.out.println(menuChoice);
            }
            System.out.println(maxMenuItemNumber + ". Exit\n");
            System.out.println("Please choose a number from (1-" + maxMenuItemNumber + "): ");
        }
    }

    /**
     * Prints out the book that is
     * given in the parameter.
     * It prints one version with and without series.
     *
     * @param book Gives the book you want to print the details for.
     */
    private void printLiterature(Book book)
    {
        System.out.println("Title: " + book.getTitle() + ", Publisher: " + book.getPublisher()
                + ", Author: " + book.getAuthor() + ", Edition: " + book.getEdition()
                + ", Date published: " + book.getDatePublished());
    }

    /**
     * Prints out the book in the bookseries that is
     * given in the parameter.
     * It prints one version with and without series.
     *
     * @param periodical Gives the periodical you want to print the details for.
     */
    private void printLiterature(Periodical periodical)
    {
//        if(periodical instanceof Magazine)
//        {
//            System.out.print("MAGAZINE: ");
//        }
//        if(periodical instanceof Newspaper)
//        {
//            System.out.print("NEWSPAPER: ");
//        }
        System.out.println("Title: " + periodical.getTitle() + ", Publisher: " + periodical.getPublisher()
                + ", Genre: " + periodical.getGenre() + ", Release number: " + periodical.getReleases());
    }

    /**
     * Prints out the newspaper that is
     * given in the parameter.
     *
     * @param bookSeries Gives the bookseries you want to print the details for.
     */
    private void printLiterature(BookSeries bookSeries)
    {
        System.out.println("Title: " + bookSeries.getTitle() + ", Publisher: " + bookSeries.getPublisher());
    }

    private void printNoLiterature()
    {
        System.out.println("Didn't find any literature matching your search");
    }

    // ------------- Iterator Method ----------------

    /**
     * Takes in input from user.
     * Return the string input from user.
     *
     * @return the string input from user.
     */
    private String scannerString()
    {
        boolean scanning = true;
        int scanCount = 0;
        String input = "";
        while (scanning && scanCount < 3)
        {
            Scanner reader = new Scanner(System.in);
            input = reader.nextLine();
            if (!isStringEmpty(input))
            {
                scanning = false;
            }
            scanCount++;
            if (scanning)
            {
                System.out.println("Try again.");
            }
        }
        return input.trim();
    }

    /**
     * Takes in input from user.
     * Return the int input from user.
     *
     * @return the int input from user.
     */
    private int scannerInt()
    {
        Scanner reader = new Scanner(System.in);
        int input = reader.nextInt();
        return input;
    }

    /**
     * Checks if string is empty or null.
     */
    private boolean isStringEmpty(String input)
    {
        boolean isStringEmpty = true;
        if (input.trim().length() > 0)
        {
            isStringEmpty = false;
        }

        return isStringEmpty;
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
    private int menuInput(String[] menu) throws InputMismatchException
    {
        int maxMenuItemNumber = menu.length + 1;
        int menuSelection = scannerInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
}
