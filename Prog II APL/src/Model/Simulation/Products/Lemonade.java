package Model.Simulation.Products;

/**
 * A class representing lemonade as a product.
 * Extends the Product class.
 */
public class Lemonade extends Product
{

    /**
     * Constructs a new Lemonade object with default values.
     * Default values are set for name, expiration days, size, base price, base price variation, and price variation based on weather.
     */
    public Lemonade()
    {
        this.name = "PRODUCT_NAME_LEMONADE";
        this.expiresDays = 3;
        this.size = 2;
        this.basePrice = 1.25;
        this.basePriceVariation = 0.24;
        this.priceWeather = new double[]{0.2, 0, -0.2};
    }

    /**
     * Constructs a new Lemonade object with a specified buy price.
     *
     * @param buyPrice The buy price of the lemonade.
     */
    public Lemonade(double buyPrice) 
    {
        this.name = "PRODUCT_NAME_LEMONADE";
        this.expiresDays = 3;
        this.size = 2;
        this.buyPrice = buyPrice;
    }
    
}


