package Controller;

import Model.Translation;
import Model.Simulation.Simulation;

/**
 * The ControllerSimulationMenu class manages the interactions between the view and the simulation model
 * for the main simulation menu in the kiosk simulation.
 */
public class ControllerSimulationMenu extends ControllerSimulation
{
    /**
     * Instantiates a new ControllerSimulationMenu.
     *
     * @param vm the ViewManager associated with this controller
     * @param trans the Translation object for language translation
     * @param sim the Simulation model associated with this controller
     */
    public ControllerSimulationMenu(ViewManager vm, Translation trans, Simulation sim)
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
        vm.setInput(input);
    }
}

