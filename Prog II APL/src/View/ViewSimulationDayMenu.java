package View;

import Controller.Controller;
import Controller.ControllerSimulationDayMenu;


/**
 * The ViewSimulationDayMenu class handles the view for each simulation day in the kiosk simulation.
 */
public class ViewSimulationDayMenu extends ViewSimulation
{
    /**
     * Instantiates a new ViewSimulationDayMenu.
     *
     * @param controller the controller associated with this view
     */
    public ViewSimulationDayMenu(Controller controller)
    {
        super(controller);
    }


    /**
     * Helper method to get the customer response based on the response code.
     *
     * @param response the response code
     * @return the customer response text
     */
    private String PrintStartDayMenuHelper(int response)
    {
        switch(response)
        {
            case 0:
                return controller.getTrans("SIMULATION_START_DAY_CUSTOMER_RESPONSE_SOLD_OUT");

            case 1:
                return controller.getTrans("SIMULATION_START_DAY_CUSTOMER_RESPONSE_TOO_EXPENSIVE");

            case 2:
                return controller.getTrans("SIMULATION_START_DAY_CUSTOMER_RESPONSE_BOUGHT");
        }

        return "";
    }

    
	
    public void print()
    {
        // Get the response from the controller
        int[] response = ((ControllerSimulationDayMenu) controller).getResponse();

        // Clear the console and print the simulation header
        PrintClearConsole();
        PrintSimulationHeader();

        // Switch based on the response type
        switch(response[0])
        {
            case 1:
                // Print the customer response for cigarettes
                System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + " - " + controller.getTrans("PRODUCT_NAME_CIGARETTES") + ": " + PrintStartDayMenuHelper(response[1]));
                break;

            case 2:
                // Print the customer response for fries
                System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + " - " + controller.getTrans("PRODUCT_NAME_FRIES") + ": " + PrintStartDayMenuHelper(response[1]));
                break;

            case 3:
                // Print the customer response for gum
                System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + " - " + controller.getTrans("PRODUCT_NAME_GUM") + ": " + PrintStartDayMenuHelper(response[1]));
                break;

            case 4:
                // Print the customer response for ice cream
                System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + " - " + controller.getTrans("PRODUCT_NAME_ICE_CREAM") + ": " + PrintStartDayMenuHelper(response[1]));
                break;

            case 5:
                // Print the customer response for lemonade
                System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + " - " + controller.getTrans("PRODUCT_NAME_LEMONADE") + ": " + PrintStartDayMenuHelper(response[1]));
                break;

            case 6:
                // Print the customer response for newspaper
                System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + " - " + controller.getTrans("PRODUCT_NAME_NEWSPAPER") + ": " + PrintStartDayMenuHelper(response[1]));
                break;
        }

        PrintLine();

        try
        {
            Thread.sleep(400);
        }
        catch(Exception e)
        {
            
        }

        getInput();
    }


    @Override
    public void getInput()
    {
        controller.setInput(-1);
    }

}
