package Model.Simulation.Products;

/**
 * A class representing newspapers as a product.
 * Extends the Product class.
 */
public class Newspaper extends Product 
{

    /**
     * Constructs a new Newspaper object with default values.
     * Default values are set for name, expiration days, size, base price, base price variation, and price variation based on weather.
     */
    public Newspaper() 
    {
        this.name = "PRODUCT_NAME_NEWSPAPER";
        this.className = "Newspaper";
        this.expiresDays = 1;
        this.size = 2;
        this.basePrice = 0.90;
        this.basePriceVariation = 0.40;
        this.priceWeather = new double[]{0.2, 0, -0.2};
    }

    /**
     * Constructs a new Newspaper object with a specified buy price.
     *
     * @param buyPrice The buy price of the newspaper.
     */
    public Newspaper(double buyPrice) 
    {
        this.name = "PRODUCT_NAME_NEWSPAPER";
        this.className = "Newspaper";
        this.expiresDays = 1;
        this.size = 2;
        this.buyPrice = buyPrice;
    }
}


