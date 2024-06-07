package Model.Simulation.Products;

/**
 * Fries class represents a type of product that extends the Product class.
 * It encapsulates properties and behaviors specific to fries.
 */
public class Fries extends Product 
{

	/**
	 * Constructs a new Fries object with default values.
	 * Default values are set for name, expiration days, size, base price, base price variation, and price variation based on weather.
	 */
	public Fries()
	{
		this.name = "PRODUCT_NAME_FRIES";
		this.className = "Fries";
		this.expiresDays = 4;
		this.size = 5;
		this.basePrice = 2.50;
		this.basePriceVariation = 0.14;
		this.priceWeather = new double[]{0.2, 0.05, -0.15};
	}
	
	/**
	 * Constructs a new Fries object with a specified purchase price.
	 *
	 * @param buyPrice the purchase price of the fries
	 */
	public Fries(double buyPrice)
	{
		this.name = "PRODUCT_NAME_FRIES";
		this.className = "Fries";
		this.expiresDays = 4;
		this.size = 5;
		this.buyPrice = buyPrice;
	}
}

