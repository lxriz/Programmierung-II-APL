package Controller;

import Model.Translation;
import Model.Simulation.Simulation;
import Model.Simulation.Simulation.BuyProductResponse;

/**
 * The ControllerSimulationMarketMenu class manages the interactions between the view and the simulation model
 * for the market menu in the kiosk simulation.
 */
public class ControllerSimulationMarketMenu extends ControllerSimulation
{
    /**
     * Instantiates a new ControllerSimulationMarketMenu.
     *
     * @param vm the ViewManager associated with this controller
     * @param trans the Translation object for language translation
     * @param sim the Simulation model associated with this controller
     */
    public ControllerSimulationMarketMenu(ViewManager vm, Translation trans, Simulation sim)
    {
        super(vm, trans, sim);
        this.sim = sim;
    }

    /**
     * Sets the user input in the view manager.
     *
     * @param input the input value to be set
     */
    @Override
    public void setInput(int input)
    {    
        vm.setSimulation(sim);
        vm.setInput(input);
    }

    /**
     * Buys a product by its ID and amount.
     *
     * @param id the ID of the product
     * @param amount the amount of the product to buy
     * @return the response of the purchase attempt
     */
    public BuyProductResponse buyProduct(int id, int amount)
    {
        switch(id)
        {
            case 1:
                return this.sim.buyCigarettes(amount);
            case 2:
                return this.sim.buyFries(amount);
            case 3:
                return this.sim.buyGum(amount);
            case 4:
                return this.sim.buyIceCream(amount);
            case 5:
                return this.sim.buyLemonade(amount);
            case 6:
                return this.sim.buyNewspaper(amount);
        }
        
        return BuyProductResponse.NotEnoughMoney;
    }

    /**
     * Buys a specified amount of cigarettes.
     *
     * @param amount the amount of cigarettes to buy
     * @return the response of the purchase attempt
     */
    public BuyProductResponse buyCigarettes(int amount)
    {
        return this.sim.buyCigarettes(amount);
    }

    /**
     * Buys a specified amount of fries.
     *
     * @param amount the amount of fries to buy
     * @return the response of the purchase attempt
     */
    public BuyProductResponse buyFries(int amount)
    {
        return this.sim.buyFries(amount);
    }

    /**
     * Buys a specified amount of newspapers.
     *
     * @param amount the amount of newspapers to buy
     * @return the response of the purchase attempt
     */
    public BuyProductResponse buyNewspaper(int amount)
    {
        return this.sim.buyNewspaper(amount);
    }

    /**
     * Buys a specified amount of gum.
     *
     * @param amount the amount of gum to buy
     * @return the response of the purchase attempt
     */
    public BuyProductResponse buyGum(int amount)
    {
        return this.sim.buyGum(amount);
    }

    /**
     * Buys a specified amount of ice cream.
     *
     * @param amount the amount of ice cream to buy
     * @return the response of the purchase attempt
     */
    public BuyProductResponse buyIceCream(int amount)
    {
        return this.sim.buyIceCream(amount);
    }

    /**
     * Buys a specified amount of lemonade.
     *
     * @param amount the amount of lemonade to buy
     * @return the response of the purchase attempt
     */
    public BuyProductResponse buyLemonade(int amount)
    {
        return this.sim.buyLemonade(amount);
    }

    /**
     * Gets the price of a product by its ID.
     *
     * @param id the ID of the product
     * @return the price of the product
     */
    public double getPrice(int id)
    {
        return sim.getPrice(id);
    }

    /**
     * Gets the size of gum.
     *
     * @return the size of gum
     */
    public int getGumSize()
    {
        return sim.getGumSize();
    }

    /**
     * Gets the size of fries.
     *
     * @return the size of fries
     */
    public int getFriesSize()
    {
        return sim.getFriesSize();
    }

    /**
     * Gets the size of newspapers.
     *
     * @return the size of newspapers
     */
    public int getNewspaperSize()
    {
        return sim.getNewspaperSize();
    }

    /**
     * Gets the size of lemonade.
     *
     * @return the size of lemonade
     */
    public int getLemonadeSize()
    {
        return sim.getLemonadeSize();
    }

    /**
     * Gets the size of cigarettes.
     *
     * @return the size of cigarettes
     */
    public int getCigarettesSize()
    {
        return sim.getCigarettesSize();
    }

    /**
     * Gets the size of ice cream.
     *
     * @return the size of ice cream
     */
    public int getIceCreamSize()
    {
        return sim.getIceCreamSize();
    }

    /**
     * Gets the expiration days of ice cream.
     *
     * @return the expiration days of ice cream
     */
    public int getIceCreamExpiresDays()
    {
        return sim.getIceCreamExpiresDays();
    }

    /**
     * Gets the expiration days of gum.
     *
     * @return the expiration days of gum
     */
    public int getGumExpiresDays()
    {
        return sim.getGumExpiresDays();
    }

    /**
     * Gets the expiration days of fries.
     *
     * @return the expiration days of fries
     */
    public int getFriesExpiresDays()
    {
        return sim.getFriesExpiresDays();
    }

    /**
     * Gets the expiration days of newspapers.
     *
     * @return the expiration days of newspapers
     */
    public int getNewspaperExpiresDays()
    {
        return sim.getNewspaperExpiresDays();
    }

    /**
     * Gets the expiration days of lemonade.
     *
     * @return the expiration days of lemonade
     */
    public int getLemonadeExpiresDays()
    {
        return sim.getLemonadeExpiresDays();
    }

    /**
     * Gets the expiration days of cigarettes.
     *
     * @return the expiration days of cigarettes
     */
    public int getCigarettesExpiresDays()
    {
        return sim.getCigarettesExpiresDays();
    }

    /**
     * Gets the market price of fries.
     *
     * @return the market price of fries
     */
    public double getFriesMarketPrice()
    {
        return sim.getFriesMarketPrice();
    }

    /**
     * Gets the market price of ice cream.
     *
     * @return the market price of ice cream
     */
    public double getIceCreamMarketPrice()
    {
        return sim.getIceCreamMarketPrice();
    }

    /**
     * Gets the market price of gum.
     *
     * @return the market price of gum
     */
    public double getGumMarketPrice()
    {
        return sim.getGumMarketPrice();
    }

    /**
     * Gets the market price of newspapers.
     *
     * @return the market price of newspapers
     */
    public double getNewspaperMarketPrice()
    {
        return sim.getNewspaperMarketPrice();
    }

    /**
     * Gets the market price of lemonade.
     *
     * @return the market price of lemonade
     */
    public double getLemonadeMarketPrice()
    {
        return sim.getLemonadeMarketPrice();
    }

    /**
     * Gets the market price of cigarettes.
     *
     * @return the market price of cigarettes
     */
    public double getCigarettesMarketPrice()
    {
        return sim.getCigarettesMarketPrice();
    }
}

