package Controller;

import Model.Translation;
import Model.Simulation.Simulation;

/**
 * The ControllerSimulationPriceMenu class manages the interactions between the view and the simulation model
 * for the price menu in the kiosk simulation.
 */
public class ControllerSimulationPriceMenu extends ControllerSimulation
{
    /**
     * Instantiates a new ControllerSimulationPriceMenu.
     *
     * @param vm the ViewManager associated with this controller
     * @param trans the Translation object for language translation
     * @param sim the Simulation model associated with this controller
     */
    public ControllerSimulationPriceMenu(ViewManager vm, Translation trans, Simulation sim)
    {
        super(vm, trans, sim);
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
     * Sets a new price for a product by its ID.
     *
     * @param id the ID of the product
     * @param newPrice the new price to be set
     */
    public void setNewPrice(int id, double newPrice)
    {
        sim.setNewPrice(id, newPrice);
    }
}

