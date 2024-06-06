package Model.Simulation;

import java.util.Random;

import java.util.Random;

/**
 * A class representing a customer.
 */
public class Customer
{

    /** The age of the customer. */
    public int age;
    
    /** The demand probabilities for different products. */
    private static double[] demand;
    
    /** The random object for generating random numbers. */
    private static Random r = new Random();
                    
    /**
     * Constructs a new Customer object with a random age based on the given weather.
     *
     * @param weather The weather condition: 0 for rainy, 1 for cloudy, and 2 for sunny.
     */
    public Customer(int weather) 
    {
        this.age = r.nextInt(18, 81);
        
        // The array hold the probabilities of a customer choosing a product
        // The sum must be 1
        // Cigarettes
        // Fries
        // Gum
        // IceCream
        // Lemonade
        // Newspaper
        switch (weather) {
            case 0:     // Rainy
                demand = new double[]{0.20, 0.10, 0.10, 0.05, 0.10, 0.45};
                break;
            case 1:     // Cloudy
                demand = new double[]{0.15, 0.15, 0.10, 0.10, 0.15, 0.35};
                break;
            case 2:     // Sunny
                demand = new double[]{0.10, 0.10, 0.10, 0.30, 0.25, 0.15};
                break;
        }
    }
    
    /**
     * Chooses a product based on demand probabilities.
     *
     * @return The index of the chosen product.
     */
    public int chooseProcduct() 
    {
        double choice = r.nextDouble();
        
        double cumulative = 0;
        for (int i = 0; i < demand.length; i++) {
            if (choice < cumulative + demand[i]) {
                return i;
            } else {
                cumulative += demand[i];
            }
        }
        
        return -1;
    }
    
    /**
     * Calculates the price acceptance of the customer.
     *
     * @param x The market price.
     * @return The price acceptance.
     */
    private double priceAcceptance(double x) 
    {
        return -0.001086*x*x+0.095371*x-0.264914;
    }
    
    /**
     * Determines if the customer will buy a product based on market price and kiosk price.
     *
     * @param marketPrice The market price of the product.
     * @param kioskPrice The price offered by the kiosk.
     * @return True if the customer is willing to buy, false otherwise.
     */
    public boolean willBuy(double marketPrice, double kioskPrice) {
        double willingToPay = marketPrice * priceAcceptance(this.age);
        
        return willingToPay >= kioskPrice;
    }
}

