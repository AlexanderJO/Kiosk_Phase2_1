import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApplicationUITest
{
    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * HOLD! Blir dette korrekt?
     */
    @Test
    public void testStart()
    {
        ApplicationUI app = new ApplicationUI();
        app.start();
    }
}