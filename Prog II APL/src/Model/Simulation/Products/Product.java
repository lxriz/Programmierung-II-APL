package Model.Simulation.Products;

/**
 * An abstract class representing a product.
 * Provides attributes and methods common to all products.
 */
public abstract class Product 
{	
	/**
	 * Saves the class name
	 */
	public String className;
	
    /**
     * Saves the days until the product expires.
     * - expiresDays > 0: Good to sell.
     * - expiresDays == 0: Product has to be thrown away.
     */
    public int expiresDays;

    /**
     * Saves the size of the product for storage.
     * The value is simplified with no real measurement.
     */
    public int size;

    /**
     * The price at which the product was bought.
     */
    public double buyPrice;

    /**
     * Used as an anchor for price calculations.
     * Prices are in euro.
     */
    public double basePrice;

    /**
     * Used for random price variation on base price.
     * Maximum percent of variation on base price.
     */
    public double basePriceVariation;

    /**
     * Saves the weather price variation.
     */
    public double[] priceWeather;

    /**
     * The name of the product.
     */
    public String name;

    /**
     * Decrements the expiresDays of the product.
     * If expiresDays reaches 0, returns false indicating the product should be thrown away.
     *
     * @return True if the product is still good to sell, false if it has expired.
     */
    public boolean age()
    {
        this.expiresDays -= 1;
        if (this.expiresDays == 0) {
            return false;
        }

        return true;
    }
    
    
    /**
     * Converts the product data to a string format.
     *
     * @return A string representation of the product's data.
     */
    @Override
    public String toString() 
    {
        String priceWeather = "[";
        if(this.priceWeather != null)
	        {
	        for (int i = 0; i < this.priceWeather.length; i++) {
	            if (i != 0) {
	                priceWeather += ", ";
	            }
	            priceWeather += this.priceWeather[i];
	        }
        }
        priceWeather += "]";
        
        
        return 	this.className + 
        		"{" +
                "name='" + this.name + "'" + "," +
                "size=" + this.size + "," +
                "expiresDay=" + this.expiresDays + "," +
                "buyPrice=" + this.buyPrice + "," +
                "basePrice=" + this.basePrice + "," +
                "basePriceVaritaion=" + this.basePriceVariation + "," +
                "priceWeather=" + priceWeather +
                "}";
    }
}

