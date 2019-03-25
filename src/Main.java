
/**
 * The Main-class of the application. This class only holds the main()-method
 * to start the application.
 *
 *  @author     Alexander J. Overvåg, Sondre Nerhus, Gustav S. Hagen
 *  @version    v2.0 (beta) 2019.03.06
 */
public class Main 
{
    /**
     * The main entry for the application.
     * @param args arguments provided during startup of the application
     */
    public static void main(String[] args)
    {
        ApplicationUI appUI = new ApplicationUI();
        appUI.start();
    }
}
