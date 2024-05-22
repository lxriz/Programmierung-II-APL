package Model.Simulation.Products;

public class IceCream extends Product
{
	public IceCream()
	{
		this.name = "PRODUCT_NAME_ICE_CREAM";

		this.expiresDays = 2;
		this.size = 3;
		
		this.basePrice = 1.00;
		this.basePriceVariation = 0.12;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
	
	public IceCream(double buyPrice)
	{
		this.name = "PRODUCT_NAME_ICE_CREAM";

		this.expiresDays = 2;
		this.size = 3;
		
		this.buyPrice = buyPrice;
		
		this.basePrice = 1.00;
		this.basePriceVariation = 0.12;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
	

}
