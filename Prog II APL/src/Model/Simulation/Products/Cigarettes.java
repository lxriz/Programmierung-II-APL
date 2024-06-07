package Model.Simulation.Products;

/**
 * A class representing cigarettes as a product.
 * Extends the Product class.
 */
public class Cigarettes extends Product
{

	/**
	 * Constructs a new Cigarettes object with default values.
	 * Default values are set for name, expiration days, size, base price, base price variation, and price variation based on weather.
	 */
	public Cigarettes() 
	{
	    this.name = "PRODUCT_NAME_CIGARETTES";
	    this.className = "Cigarettes";
	    this.expiresDays = 7;
	    this.size = 4;
	    this.basePrice = 6.50;
	    this.basePriceVariation = 0.08;
	    this.priceWeather = new double[]{0.12, 0.05, -0.1};
	}

	/**
	 * Constructor for creating a Cigarettes object.
	 *
	 * @param buyPrice the purchase price of the cigarettes
	 */
	public Cigarettes(double buyPrice)
	{
	    this.name = "PRODUCT_NAME_CIGARETTES";
	    this.className = "Cigarettes";
	    this.expiresDays = 7;
	    this.size = 4;
	    this.buyPrice = buyPrice;
	}


}

