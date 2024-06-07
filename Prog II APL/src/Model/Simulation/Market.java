package Model.Simulation;

import java.util.Random;
import Model.Simulation.Products.*;

/**
 * The Market class simulates a market with various product prices influenced by weather conditions and random variations.
 */
public class Market 
{
    
	/** 
	 * The resulting prices for each product. 
	 */
	public final double cigarettesPrice; // The price of the Cigarettes product.
	public final double friesPrice;      // The price of the Fries product.
	public final double gumPrice;        // The price of the Gum product.
	public final double iceCreamPrice;   // The price of the IceCream product.
	public final double lemonadePrice;   // The price of the Lemonade product.
	public final double newspaperPrice;  // The price of the Newspaper product.

    
    /** 
     * Product objects representing the market's products. 
     */
    public Cigarettes cigarettes; // Represents the Cigarettes product.
    public Fries fries;           // Represents the Fries product.
    public Gum gum;               // Represents the Gum product.
    public IceCream iceCream;     // Represents the IceCream product.
    public Lemonade lemonade;     // Represents the Lemonade product.
    public Newspaper newspaper;   // Represents the Newspaper product.


    private Random r = new Random();

    /**
     * Calculates the price variation based on the base price and variation percentage.
     *
     * @param base the base price
     * @param variation the variation percentage
     * @return the price with applied variation
     */
    private double calculatePriceVariation(double base, double variation) 
    {
        return base + base * (variation * ((r.nextDouble() * 2) - 1));
    }

    /**
     * Calculates the price influenced by weather conditions.
     *
     * @param base the base price
     * @param variation the weather variation
     * @return the price adjusted for weather
     */
    public double calculatePriceWeather(double base, double variation) 
    {
        return base + base * variation;
    }

    /**
     * Instantiates a new Market with prices adjusted for weather conditions.
     *
     * @param weather the current weather condition (0 - Rainy, 1 - Cloudy, 2 - Sunny)
     */
    public Market(int weather) 
    {
        cigarettes = new Cigarettes();
        fries = new Fries();
        gum = new Gum();
        iceCream = new IceCream();
        lemonade = new Lemonade();
        newspaper = new Newspaper();
        
        // The price for each products is calculated here
        // Price has a random variation + variation based on weather
        cigarettesPrice = roundPrice(calculatePriceVariation(calculatePriceWeather(cigarettes.basePrice, cigarettes.priceWeather[weather]), cigarettes.basePriceVariation));
        friesPrice = roundPrice(calculatePriceVariation(calculatePriceWeather(fries.basePrice, fries.priceWeather[weather]), fries.basePriceVariation));
        gumPrice = roundPrice(calculatePriceVariation(calculatePriceWeather(gum.basePrice, gum.priceWeather[weather]), gum.basePriceVariation));
        iceCreamPrice = roundPrice(calculatePriceVariation(calculatePriceWeather(iceCream.basePrice, iceCream.priceWeather[weather]), iceCream.basePriceVariation));
        lemonadePrice = roundPrice(calculatePriceVariation(calculatePriceWeather(lemonade.basePrice, lemonade.priceWeather[weather]), lemonade.basePriceVariation));
        newspaperPrice = roundPrice(calculatePriceVariation(calculatePriceWeather(newspaper.basePrice, newspaper.priceWeather[weather]), newspaper.basePriceVariation));
    }

    /**
     * Rounds the price to two decimal places.
     *
     * @param price the price to be rounded
     * @return the rounded price
     */
    public double roundPrice(double price) 
    {
        return Math.round(price * 100) / 100.0;
    }

    /**
     * Gets the prices of all products in the market.
     *
     * @return an array of product prices
     */
    public double[] getPrices() 
    {
        double[] prices = {cigarettesPrice, friesPrice, gumPrice, iceCreamPrice, lemonadePrice, newspaperPrice};
        return prices;
    }
}

