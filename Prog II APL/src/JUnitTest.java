import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import Model.Translation;
import Model.Simulation.Kiosk;
import Model.Simulation.Market;
import Model.Simulation.Simulation;


/**
 * JUnit tests for the Kiosk simulation.
 */
public class JUnitTest 
{
    /**
     * Tests the English translation for the program name.
     */
    @Test
    public void testEnglishTranslation()
    {
        Translation trans = new Translation();
        String test = trans.getText("PROG_NAME");
        assertEquals("Kiosk Game", test);
    }

    /**
     * Tests the German translation for the program name.
     */
    @Test
    public void testGermanTranslation()
    {
        Translation trans = new Translation("DE");
        String test = trans.getText("PROG_NAME");
        assertEquals("Kiosk Spiel", test);
    }

    /**
     * Tests the rounding of prices in the market.
     */
    @Test
    public void testMarketRoundPrice()
    {
        Market market = new Market(0);
        Double test = market.roundPrice(5.599);
        assertEquals(5.60, test); 
    }

    /**
     * Tests the calculation of prices based on weather in the market.
     */
    @Test
    public void testMarketPriceWeather()
    {
        Market market = new Market(0);
        Double test = market.calculatePriceWeather(5.00, 0.5);
        assertEquals(7.50, test); 
    }

    /**
     * Tests if the kiosk can pay a specified amount.
     */
    @Test
    public void testKioskCanPay()
    {
        Kiosk kiosk = new Kiosk("Test");
        Boolean test = kiosk.canPay(1000);
        assertEquals(test, false); 
    }

    /**
     * Tests adding cash to the kiosk.
     */
    @Test
    public void testKioskAddCash()
    {
        Kiosk kiosk = new Kiosk("Test");
        kiosk.addCash(100);
        double test = kiosk.getCash();
        assertEquals(kiosk.startCash + 100, test); 
    }
    
    @Test
    public void testCustomerGeneration()
    {
    	Kiosk kiosk = new Kiosk("Test");
    	Simulation sim = new Simulation(kiosk);
    	int customerCount = sim.getCountCustomers();
    	
    	boolean test1 = false;
    	boolean test2 = false;
    	
    	if(customerCount >= 20)
    	{
    		test1 = true;
    	}
    	
    	if(customerCount <= 60)
    	{
    		test2 = true;
    	}
    	
    	assertEquals(test1, true);
    	assertEquals(test2, true);
    }
}

