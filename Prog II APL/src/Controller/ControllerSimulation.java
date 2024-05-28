package Controller;

import Model.Translation;
import Model.Simulation.Simulation;

/**
 * The abstract ControllerSimulation class provides common functionality for all simulation controllers
 * in the kiosk simulation.
 */
public abstract class ControllerSimulation extends Controller
{
    protected Simulation sim;

    /**
     * Instantiates a new ControllerSimulation.
     *
     * @param vm the ViewManager associated with this controller
     * @param trans the Translation object for language translation
     * @param sim the Simulation model associated with this controller
     */
    public ControllerSimulation(ViewManager vm, Translation trans, Simulation sim)
    {
        super(vm, trans);
        this.sim = sim;
    }

    /**
     * Gets the weather of the current day.
     *
     * @return the weather as an integer
     */
    public int getWeather()
    {
        return sim.getWeather();
    }

    /**
     * Gets the owner's name of the kiosk.
     *
     * @return the owner's name
     */
    public String getOwnerName()
    {
        return sim.getOwnerName();
    }

    /**
     * Gets the current day in the simulation.
     *
     * @return the current day
     */
    public int getCurrentDay()
    {
        return sim.getCurrentDay();
    }

    /**
     * Gets the used storage size of the kiosk.
     *
     * @return the used storage size
     */
    public int getUsedStorageSize()
    {
        return sim.getUsedStorageSize();
    }

    /**
     * Gets the current cash of the kiosk.
     *
     * @return the current cash
     */
    public double getCash()
    {
        return sim.getCash();
    }

    /**
     * Counts the quantity of a specific product in the kiosk.
     *
     * @param product the name of the product
     * @return the quantity of the product
     */
    public int countProduct(String product)
    {
        return sim.countProduct(product);
    }

    /**
     * Gets the maximum storage size of the kiosk.
     *
     * @return the maximum storage size
     */
    public int getMaxStorageSize()
    {
        return sim.getMaxStorageSize();
    }

    /**
     * Gets the maximum number of days for the simulation.
     *
     * @return the maximum number of days
     */
    public int getMaxDays()
    {
        return sim.getMaxDays();
    }
}

