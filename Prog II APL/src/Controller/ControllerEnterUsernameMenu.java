package Controller;

import Model.Translation;
import Model.Simulation.*;

/**
 * A controller for managing username input in the application menu.
 * Extends the Controller class.
 */
public class ControllerEnterUsernameMenu extends Controller 
{
    
    /** The Kiosk object associated with the username. */
    Kiosk kiosk;
    
    /** The Simulation object associated with the username. */
    Simulation sim;

    /**
     * Instantiates a new ControllerEnterUsernameMenu.
     *
     * @param vm The ViewManager object.
     * @param trans The Translation object.
     */
    public ControllerEnterUsernameMenu(ViewManager vm, Translation trans)
    {
        super(vm, trans);
    }

    /**
     * Sets the input based on the selected option.
     *
     * @param input The selected input.
     */
    @Override
    public void setInput(int input) 
    {
        vm.setInput(input);
    }

    /**
     * Sets the username and initializes associated Kiosk and Simulation objects.
     *
     * @param name The username to set.
     */
    public void setUserName(String name) 
    {
        this.kiosk = new Kiosk(name);
        this.sim = new Simulation(kiosk);
        
        vm.setSimulation(sim);
    }
}

