import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import Model.Translation;
import Model.Simulation.Kiosk;
import Model.Simulation.Market;
import Model.Simulation.Simulation;


public class JUnitTest 
{
	
	@Test
	public void testEnglishTranslation()
	{
		Translation trans = new Translation();
		String test = trans.getText("PROG_NAME");
		
		assertEquals(test, "Kiosk Game");
	}
	
	
	@Test
	public void testGermanTranslation()
	{
		Translation trans = new Translation("DE");
		String test = trans.getText("PROG_NAME");
		
		assertEquals(test, "Kiosk Spiel");
	}
	
	
	@Test
	public void testMarketRoundPrice()
	{
		Market market = new Market(0);
		Double test = market.roundPrice(5.599);
		
		assertEquals(5.60, test);
	}
	
	
	@Test
	public void testMarketPriceWeather()
	{
		Market market = new Market(0);
		Double test = market.calculatePriceWeather(5.00, 0.5);
		
		assertEquals(7.50, test);
	}
	
	
	@Test
	public void testKioskCanPay()
	{
		Kiosk kiosk = new Kiosk("Test");
		Boolean test = kiosk.canPay(1000);
		
		assertEquals(false, test);
	}
	
	
	@Test
	public void testKioskAddCash()
	{
		Kiosk kiosk = new Kiosk("Test");
		kiosk.addCash(100);
		double test = kiosk.getCash();
		
		assertEquals(kiosk.startCash+100, test);
	}
}
