package Controller;

import Model.Translation;
import Model.Simulation.Simulation;

/**
 * The ControllerSimulationDayMenu class manages the interactions between the view and the simulation model
 * for the daily menu in the kiosk simulation.
 */
public class ControllerSimulationDayMenu extends ControllerSimulation
{
    private int countCustomers = 0;

    /**
     * Instantiates a new ControllerSimulationDayMenu.
     *
     * @param vm the ViewManager associated with this controller
     * @param trans the Translation object for language translation
     * @param sim the Simulation model associated with this controller
     */
    public ControllerSimulationDayMenu(ViewManager vm, Translation trans, Simulation sim)
    {
        super(vm, trans, sim);
        this.countCustomers = this.sim.getCountCustomers();
    }

    /**
     * Sets the user input in the view manager.
     *
     * @param input the input value to be set
     */
    @Override
    public void setInput(int input)
    {
        if(countCustomers > 0)
        {
            vm.setInput(-1);
        }
        else 
        {
            this.sim.nextDay();
            vm.setSimulation(sim);
            if(checkEnd())
            {
                vm.setInput(1);
            }
            else
            {
                vm.setInput(0);
            }
        }
    }

    /**
     * Checks if the simulation should end.
     *
     * @return true if the simulation should end, false otherwise
     */
    public boolean checkEnd()
    {
        return sim.checkEndGame();
    }

    /**
     * Gets the response from the simulation for the next customer.
     *
     * @return an array with the product id and transaction result
     */
    public int[] getResponse()
    {
        this.countCustomers--;
        return this.sim.getResponse();
    }

    /**
     * Gets the remaining number of customers for the day.
     *
     * @return the remaining number of customers
     */
    public int getRemainingCustomers()
    {
        return this.countCustomers;
    }
}

