package Controller;

import Model.*;

/**
 * The ControllerMainMenu class handles the main menu interactions.
 */
public class ControllerMainMenu extends Controller 
{
    
    /**
     * Instantiates a new ControllerMainMenu.
     *
     * @param vm the ViewManager instance
     * @param trans the Translation instance
     */
    public ControllerMainMenu(ViewManager vm, Translation trans) 
    {
        super(vm, trans);
    }
    
    /**
     * Sets the input received from the view and updates the ViewManager accordingly.
     *
     * @param input the input value
     */
    @Override
    public void setInput(int input)
    {
        vm.setInput(input);
    }
}

