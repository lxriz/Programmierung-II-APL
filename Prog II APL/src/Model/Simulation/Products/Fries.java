package Model.Simulation.Products;

public class Fries extends Product 
{

	public Fries()
	{
		this.name = "PRODUCT_NAME_FRIES";

		this.expiresDays = 4;
		this.size = 5;
		
		this.basePrice = 2.50;
		this.basePriceVariation = 0.24;
		this.priceWeather = new double[]{0.2, 0, -0.2};
		this.buyPrice = 0;
	}
	
	
	public Fries(double buyPrice)
	{
		this.name = "PRODUCT_NAME_FRIES";

		this.expiresDays = 4;
		this.size = 5;
		
		this.basePrice = 2.50;
		this.basePriceVariation = 0.24;
		this.priceWeather = new double[]{0.2, 0, -0.2};
		this.buyPrice = buyPrice;
	}
}
