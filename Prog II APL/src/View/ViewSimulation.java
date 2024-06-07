package View;
import java.util.Locale;

import Controller.Controller;
import Controller.ControllerSimulation;

/**
 * Abstract class representing a simulation view.
 * Extends the View class and provides methods to print simulation details and animations.
 */
public abstract class ViewSimulation extends View
{
    /**
     * Constructor for ViewSimulation.
     *
     * @param controller the controller instance associated with this view.
     */
    public ViewSimulation(Controller controller)
    {
        super(controller);
    }
    
    /**
     * Formats a double value to a string with two decimal places.
     *
     * @param d the double value to format.
     * @return a string representing the formatted double value.
     */
    public String formateDouble(double d)
    {
        return String.format(Locale.US, "%.2f", d);
    }
    
    /**
     * Prints the simulation animation based on the weather condition.
     *
     * @param weather the weather condition (0 for rainy, 1 for cloudy, 2 for sunny).
     */
    public void PrintSimulationAnimation(int weather)
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
     * Prints the header information of the simulation, including the current day, weather, and market details.
     */
    public void PrintSimulationHeader()
    {			
        String weekday = "";
        String weatherText = "";
        
        // Lookup table for weekday
        switch(((ControllerSimulation) controller).getCurrentDay() % 7)
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
        
        // Lookup table for weather
        switch(((ControllerSimulation) controller).getWeather())
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
        
        PrintSimulationAnimation(((ControllerSimulation) controller).getWeather());
        
        System.out.println("  " + controller.getTrans(weatherText) + "\t\t\t\t" + "[" + ((ControllerSimulation) controller).getOwnerName() + "'s Kiosk]");
        PrintLine();
        System.out.println("  | " + controller.getTrans(weekday) + " |\t\t\t" + controller.getTrans("SIMULATION_HEADER_WEATHER_1") + " " + ((ControllerSimulation) controller).getCurrentDay() + " " + controller.getTrans("SIMULATION_HEADER_WEATHER_2") + " " + ((ControllerSimulation) controller).getMaxDays());
        PrintLineDashed();		
        System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_MONEY") + " |\t\t\t" + formateDouble(((ControllerSimulation) controller).getCash()) + "€");
        PrintLineDashed();
        System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_STORAGE_1") + " |\t\t\t" + ((ControllerSimulation) controller).getUsedStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_2") + " " + ((ControllerSimulation) controller).getMaxStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_3"));
        PrintLine();
        
        System.out.println("    " + ((ControllerSimulation) controller).countProduct("PRODUCT_NAME_CIGARETTES") + " X " + controller.getTrans("PRODUCT_NAME_CIGARETTES"));
        PrintLineDashed();
        System.out.println("    " + ((ControllerSimulation) controller).countProduct("PRODUCT_NAME_FRIES") + " X " + controller.getTrans("PRODUCT_NAME_FRIES"));
        PrintLineDashed();		
        System.out.println("    " + ((ControllerSimulation) controller).countProduct("PRODUCT_NAME_GUM") + " X " + controller.getTrans("PRODUCT_NAME_GUM"));
        PrintLineDashed();
        System.out.println("    " + ((ControllerSimulation) controller).countProduct("PRODUCT_NAME_ICE_CREAM") + " X " + controller.getTrans("PRODUCT_NAME_ICE_CREAM"));
        PrintLineDashed();
        System.out.println("    " + ((ControllerSimulation) controller).countProduct("PRODUCT_NAME_LEMONADE") + " X " + controller.getTrans("PRODUCT_NAME_LEMONADE"));
        PrintLineDashed();
        System.out.println("    " + ((ControllerSimulation) controller).countProduct("PRODUCT_NAME_NEWSPAPER") + " X " + controller.getTrans("PRODUCT_NAME_NEWSPAPER"));
        PrintLine();
    }	
}

