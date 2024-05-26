package View;

import Controller.Controller;
import Controller.ControllerSimulationDayMenu;


/**
 * The ViewSimulationDayMenu class handles the view for each simulation day in the kiosk simulation.
 */
public class ViewSimulationDayMenu extends View
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
     * Formats a double value to a string with two decimal places.
     *
     * @param d the double value to format
     * @return the formatted string
     */
    public String formateDouble(double d)
    {
        return String.format("%.2f", d);
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

    /**
     * Prints the simulation animation based on the weather.
     *
     * @param weather the weather code
     */
    private void PrintSimulationAnimation(int weather)
    {
        switch(weather)
        {
            case 0:
                // RAINY
                System.out.println("\t\t/\t    /      /      /   / ");
                System.out.println("\t\t/\t / _____/___      /");
                System.out.println("\t/\t\t  /         \\       /   /");
                System.out.println("\t\t/\t  |   ___   |            /");
                System.out.println("\t\t/\t  |  |___|  | /        /");
                System.out.println("\t/\t\t/ |_________|       /");
                break;
            case 1:
                // CLOUDY
                System.out.println("\t\t\t               \t ooOoo");
                System.out.println("\t\t\t   _________   \toOOooOoOoo");
                System.out.println("\t\t\t  /         \\ \t ooOOooo");
                System.out.println("\t\t\t  |   ___   |");
                System.out.println("\t\t\t  |  |___|  |");
                System.out.println("\t\t\t  |_________|");
                break;
            case 2:
                // SUNNY
                System.out.println("\t\t\t               \t \\|/");
                System.out.println("\t\t\t   _________   \t-ooo-");
                System.out.println("\t\t\t  /         \\ \t /|\\");
                System.out.println("\t\t\t  |   ___   |");
                System.out.println("\t\t\t  |  |___|  |");
                System.out.println("\t\t\t  |_________|");
                break;
        }
    }

    /**
     * Prints the simulation header.
     */
    public void PrintSimulationHeader()
    {
        String weekday = "";
        String weatherText = "";

        // Lookup table weekday
        switch(((ControllerSimulationDayMenu) controller).getCurrentDay() % 7)
        {
            case 0:
                weekday = "DAY_7";
                break;
            case 1:
                weekday = "DAY_1";
                break;
            case 2:
                weekday = "DAY_2";
                break;
            case 3:
                weekday = "DAY_3";
                break;
            case 4:
                weekday = "DAY_4";
                break;
            case 5:
                weekday = "DAY_5";
                break;
            case 6:
                weekday = "DAY_6";
                break;
        }

        // Lookup table weather
        switch(((ControllerSimulationDayMenu) controller).getWeather())
        {
            case 0:
                weatherText = "WEATHER_RAINY";
                break;
            case 1:
                weatherText = "WEATHER_CLOUDY";
                break;
            case 2:
                weatherText = "WEATHER_SUNNY";
                break;
        }

        PrintSimulationAnimation(((ControllerSimulationDayMenu) controller).getWeather());

        System.out.println("  " + controller.getTrans(weatherText) + "\t\t\t\t" + "[" + ((ControllerSimulationDayMenu) controller).getOwnerName() + "'s Kiosk]");
        PrintLine();
        System.out.println("  | " + controller.getTrans(weekday) + " |\t\t\t" + controller.getTrans("SIMULATION_HEADER_WEATHER_1") + " " + ((ControllerSimulationDayMenu) controller).getCurrentDay() + " " + controller.getTrans("SIMULATION_HEADER_WEATHER_2") + " " + ((ControllerSimulationDayMenu) controller).getMaxDays());
        PrintLineDashed();
        System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_MONEY") + " |\t\t\t" + formateDouble(((ControllerSimulationDayMenu) controller).getCash()) + "€");
        PrintLineDashed();
        System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_STORAGE_1") + " |\t\t\t" + ((ControllerSimulationDayMenu) controller).getUsedStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_2") + " " + ((ControllerSimulationDayMenu) controller).getMaxStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_3"));
        PrintLine();

        System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_CIGARETTES") + " X " + controller.getTrans("PRODUCT_NAME_CIGARETTES"));
        PrintLineDashed();
        System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_FRIES") + " X " + controller.getTrans("PRODUCT_NAME_FRIES"));
        PrintLineDashed();
        System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_GUM") + " X " + controller.getTrans("PRODUCT_NAME_GUM"));
        PrintLineDashed();
        System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_ICE_CREAM") + " X " + controller.getTrans("PRODUCT_NAME_ICE_CREAM"));
        PrintLineDashed();
        System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_LEMONADE") + " X " + controller.getTrans("PRODUCT_NAME_LEMONADE"));
        PrintLineDashed();
        System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_NEWSPAPER") + " X " + controller.getTrans("PRODUCT_NAME_NEWSPAPER"));
        PrintLine();
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
