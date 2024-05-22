package Products;

public abstract class Product 
{
	// Saves the days until the product expires
	// expiresDays > 0, good to sell
	// expiresDays == 0, product has to be thrown away
	public int expiresDays; 
	
		
	// Saves the size of the product for storage
	// The value is simplified with no real measurement
	public int size; 
	
	
	
	//
	public double buyPrice; 
	
	
	
	// Used as an anchor for price calculations
	// Prices in euro
	public double basePrice;
	
	// Used for random Price Variation on base price
	// Max percent of variation on base price
	public double basePriceVariation;
	
	// Saves the weather price variation  
	public double[] priceWeather;
	
	
	public String name;
	
	
	public boolean age()
	{
		this.expiresDays -= 1;
		if(this.expiresDays == 0)
		{
			return false;
		}
		
		return true;
	}
	
	
	public String dataToString()
	{
		String priceWeather = "[";
		for(int i = 0; i < this.priceWeather.length; i++)
		{
			if(i != 0)
			{
				priceWeather += ", ";
			}
			priceWeather += this.priceWeather[i];
		}
		
		
		return "{" + 
				"name='"+this.name+"'"+
				"size=" + this.size + 
				"expiresDay=" + this.expiresDays +
				"buyPrice=" + this.buyPrice +
				"basePrice=" + this.basePrice +
				"basePriceVaritaion=" + this.basePriceVariation +
				"priceWeather=" + priceWeather +
				"}";
				
	}
}
