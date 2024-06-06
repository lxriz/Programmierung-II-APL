package Model.Simulation.Products;

/**
 * A class representing gum as a product.
 * Extends the Product class.
 */
public class Gum extends Product 
{

    /**
     * Constructs a new Gum object with default values.
     * Default values are set for name, expiration days, size, base price, base price variation, and price variation based on weather.
     */
    public Gum() 
    {
        this.name = "PRODUCT_NAME_GUM";
        this.className = "Gum";
        this.expiresDays = 7;
        this.size = 1;
        this.buyPrice = 0;
        this.basePrice = 0.40;
        this.basePriceVariation = 0.25;
        this.priceWeather = new double[]{0, 0, 0};
    }

    /**
     * Constructs a new Gum object with a specified buy price.
     *
     * @param buyPrice The buy price of the gum.
     */
    public Gum(double buyPrice) 
    {
        this.name = "PRODUCT_NAME_GUM";
        this.className = "Gum";
        this.expiresDays = 7;
        this.size = 1;
        this.buyPrice = buyPrice;
    }
}


