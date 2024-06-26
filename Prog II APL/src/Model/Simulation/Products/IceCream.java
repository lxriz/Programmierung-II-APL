package Model.Simulation.Products;

/**
 * A class representing ice cream as a product.
 * Extends the Product class.
 */
public class IceCream extends Product
{

    /**
     * Constructs a new IceCream object with default values.
     * Default values are set for name, expiration days, size, base price, base price variation, and price variation based on weather.
     */
    public IceCream()
    {
        this.name = "PRODUCT_NAME_ICE_CREAM";
        this.className = "IceCream";
        this.expiresDays = 2;
        this.size = 2;
        this.basePrice = 1.00;
        this.basePriceVariation = 0.12;
        this.priceWeather = new double[]{-0.3, -0.1, 0.25};
    }

    /**
     * Constructs a new IceCream object with a specified buy price.
     *
     * @param buyPrice The buy price of the ice cream.
     */
    public IceCream(double buyPrice)
    {
        this.name = "PRODUCT_NAME_ICE_CREAM";
        this.className = "IceCream";
        this.expiresDays = 2;
        this.size = 2;
        this.buyPrice = buyPrice;
    }
}


