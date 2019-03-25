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
    private String[] menuItems = {
            "1.  List all literature",
            "2.  Add new literature",
            "3.  Add book to series",
            "4.  Find literature by title",
            "5.  Remove a literature by title",
            "6.  Remove a book from series",
    };
    private String[] menuTypes = {
            "1.  Book",
            "2.  Book series",
            "3.  Periodical"
    };

    private Registry registry;

    private int typeBook;
    private int typeSeries;
    private int typePeriodical;

    /**
     * This is the constructor of the ApplicationUI class.
     * Creates an instance of the ApplicationUI
     * with a book registry.
     */
    public ApplicationUI()
    {
        this.registry = new Registry();

        typeBook = 0;
        typeSeries = 1;
        typePeriodical = 2;
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
                this.showMenu(menuItems);
                int menuSelection = this.menuInput(); // Read input from user

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
                        //this.removeBookFromSeries();
                        break;

                    case 7:
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
        showMenu(menuTypes);
        int type = 0;
        try
        {
            type = scannerInt();
        }
        catch (InputMismatchException ime)
        {
            System.out.println("\nERROR: Please provide a number greater then 0.\n");
        }
        switch (type)
        {
            case 1:
                addNewBook();
                break;

            case 2:
                addNewBookSeries();
                break;

            case 3:
                addNewPeriodical();
                break;
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
            registry.addBook(title, publisher, author, edition, datePublished);
            System.out.println("The book " + title + " was added to the register");
//            System.out.println("Do you want to add this book to a series? [Yes/No]");
//            String yesNo = scannerString().toLowerCase();                // Waits for the user to push enter.
//
//            if (yesNo.equals("yes"))
//            {
//                this.registry.addBook(title, publisher, author, edition, datePublished);
//                Book book =(Book) registry.getLiteratureByTitle(title, typeBook);
//
//                System.out.println("Please enter the series of the book: ");
//                String titleSeries = scannerString();
//                if(registry.addBookToSeries(titleSeries, book))
//                {
//                    System.out.println(title + " was added to "+ titleSeries);
//                    registry.removeBook(title);
//                }
//                else
//                {
//                    System.out.println("No series with that title found, do you want to make a new one? [Yes/No]");
//                    String yesNoNew = scannerString().toLowerCase();
//                    if (yesNoNew.equals("yes"))
//                    {
//                        addNewBookSeries();
//                    }
//                    if (yesNoNew.equals("no"))
//                    {
//                        System.out.println("The book "+title+" was added to the register");
//                    }
//                }
//            }
//
//            if (yesNo.equals("no"))
//            {
//                this.registry.addBook(title, publisher, author, edition, datePublished);
//                System.out.println("The book "+title+" was added to the register");
//            }
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
            this.registry.addBookSeries(title, publisher);                    // Waits for the user to push enter.
        } else
        {
            System.out.println("Invalid series parameter, no series was made.");
        }
    }


    private void addBookToSeries()
    {
        System.out.println("Please enter the title of the book: ");
        String titleBook = scannerString();

        if (!isStringEmpty(titleBook))
        {
            Book book = (Book) registry.getLiteratureByTitle(titleBook, typeBook);
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

    private void addNewPeriodical()
    {
        System.out.println("Please enter the title of the periodical: ");
        String title = scannerString();                       // Waits for the user to push enter.

        String publisher = "";
        if (!isStringEmpty(title))
        {
            System.out.println("Please enter the publisher of the periodical: ");
            publisher = scannerString();                       // Waits for the user to push enter.
        }

        String genre = "";
        if (!isStringEmpty(publisher))
        {
            System.out.println("Please enter the genre of the periodical: ");
            genre = scannerString();                      // Waits for the user to push enter.
        }

        String type = "";
        if (!isStringEmpty(genre))
        {
            System.out.println("Please enter the type of the periodical: ");
            type = scannerString();                     // Waits for the user to push enter.
        }

        int releases = 0;
        if (!isStringEmpty(type))
        {
            System.out.println("Please enter the number of releases of the periodical: ");
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
            registry.addPeriodical(title, publisher, genre, type, releases);
            System.out.println("The periodical " + title + " was added to the register");
        }
        else
        {
            System.out.println("Invalid periodical parameter, no periodical was made");
        }
    }

    /**
     * Remove the book by title.
     * Takes in string input from user.
     */
//    private void removeBookByTitle()
//    {
//        System.out.println("Please enter the title of the book that you want to remove: ");
//        String title = scannerString();
//        Book book = (Book) this.registry.getLiteratureByTitle(title, typeBook);
//        if (book != null)
//        {
//            //this.registry.removeBook(title);
//            System.out.println("You successfully removed " + book.getTitle() + ".");
//        } else
//        {
//            System.out.println("No book with this title.");
//        }
//
//    }

    private void removeLiteratureByTitle()
    {
        System.out.println("Please enter the title of the literature that you want to remove: ");
        String title = scannerString();
        System.out.println("Please enter the type of the literature that you want to remove: ");
        this.showMenu(menuTypes);
        int type = 0;
        try
        {
            type = scannerInt();
        }
        catch (InputMismatchException ime)
        {
            System.out.println("\nERROR: Please provide a number greater then 0.\n");
        }
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

    // ---------------- Accessor Methods ---------------

    /**
     * Find and display a literature based on title.
     */
    private void findLiteratureByTitle()
    {
        System.out.println("Please enter title of the literature you want to find: ");
        String title = scannerString();
        System.out.println("What literature do you want to find?");
        try
        {

            this.showMenu(menuTypes);
            int typeSelection = this.menuInput(); // Read input from user

            switch (typeSelection)
            {
                case 1:
                    Book book = (Book) this.registry.getLiteratureByTitle(title, typeBook);
                    if (book != null)
                    {
                        this.printLiterature(book);
                    }
                    else
                    {
                        printNoLiterature();
                    }
                    break;

                case 2:
                    BookSeries bookSeries = (BookSeries) this.registry.getLiteratureByTitle(title, typeBook);
                    if (bookSeries != null)
                    {
                        this.printLiterature(bookSeries);
                    }
                    else
                    {
                        printNoLiterature();
                    }
                    break;

                case 3:
                    Periodical periodical = (Periodical) this.registry.getLiteratureByTitle(title, typeBook);
                    if (periodical != null)
                    {
                        this.printLiterature(periodical);
                    }
                    else
                    {
                        printNoLiterature();
                    }
                    break;
            }
        }
        catch (InputMismatchException ime)
        {
            System.out.println("\nERROR: Please provide a number between 1 and " + (this.menuTypes.length + 1) + ".\n");
        }
    }

//    /**
//     * List all books by author.
//     * Takes in String input from user.
//     */
//    private void findBookByAuthor()
//    {
//        System.out.println("Please enter the author of the book you want to find: ");
//        String author = scannerString();
//        int numberOfBooks = 0;
//
//        Iterator<Literature> bookListIt = this.registry.getIterator();
//
//        while (bookListIt.hasNext())
//        {
//            Literature literature = bookListIt.next();
//            Book book = (Book)literature;
//            if ( book.getAuthor() != null )
//            {
//                if ( book.getAuthor().equals(author) )
//                {
//                    printLiterature(book);
//                    numberOfBooks++;
//                }
//            }
//        }
//
//        if (numberOfBooks == 0)
//        {
//            System.out.println("No books found by this author.");
//        }
//
//        else
//        {
//            System.out.println("The number of books found: " + numberOfBooks);
//        }
//    }

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
            if (literature instanceof Periodical)
            {
                printLiterature((Periodical) literature);
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

        }
    }

    // ----------- Print Methods ---------------

    /**
     * Displays the menu to the user.
     */
//    private void showMenu()
//    {
//        int maxMenuItemNumber = menuItems.length + 1;
//
//        if (menuItems.length > 0)
//        {
//            System.out.println("\n**** Application v0.2 ****\n");
//            // Display the menu
//            for (String menuItem : menuItems)
//            {
//                System.out.println(menuItem);
//            }
//            // Add the "Exit"-choice to the menu
//            System.out.println(maxMenuItemNumber + ". Exit\n");
//            System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
//        }
//    }

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
     * Prints out the book that is
     * given in the parameter.
     * It prints one version with and without series.
     *
     * @param book Gives the book you want to print the details for.
     */
    private void printLiterature(Periodical book)
    {
        System.out.println("Title: " + book.getTitle() + ", Publisher: " + book.getPublisher()
                + ", Genre: " + book.getGenre());
    }

    /**
     * Prints out the book that is
     * given in the parameter.
     * It prints one version with and without series.
     *
     * @param book Gives the book you want to print the details for.
     */
    private void printLiterature(BookSeries book)
    {
        System.out.println("Title: " + book.getTitle() + ", Publisher: " + book.getPublisher());
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
    private int menuInput() throws InputMismatchException
    {
        int maxMenuItemNumber = menuItems.length + 1;
        int menuSelection = scannerInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }


}