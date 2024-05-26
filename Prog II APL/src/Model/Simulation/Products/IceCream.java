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
        this.expiresDays = 2;
        this.size = 3;
        this.basePrice = 1.00;
        this.basePriceVariation = 0.12;
        this.priceWeather = new double[]{0.2, 0, -0.2};
    }

    /**
     * Constructs a new IceCream object with a specified buy price.
     * Default values are set for name, expiration days, size, base price, base price variation, and price variation based on weather.
     *
     * @param buyPrice The buy price of the ice cream.
     */
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

