package View;

import java.util.Scanner;

import Controller.*;


/**
 * The ViewSimulationMenu class handles the main simulation menu view in the kiosk simulation.
 */
public class ViewSimulationMenu extends ViewSimulation
{
    /**
     * Instantiates a new ViewSimulationMenu.
     *
     * @param controller the controller associated with this view
     */
    public ViewSimulationMenu(Controller controller)
    {
        super(controller);
    }

    /**
     * Prints the main simulation menu options.
     */
    @Override
    public void print()
    {        
        PrintClearConsole();
        PrintSimulationHeader();
        
        System.out.println();
        
        System.out.println(" 1| " + controller.getTrans("SIMULATION_MENU_START_DAY"));
        System.out.println(" 2| " + controller.getTrans("SIMULATION_MENU_PRICES"));
        System.out.println(" 3| " + controller.getTrans("SIMULATION_MENU_STORAGE"));
        System.out.println(" 4| " + controller.getTrans("SIMULATION_MENU_GET_PRODUCTS"));

        System.out.println();
        
        System.out.println(" 0| " + controller.getTrans("SIMULATION_MENU_END_GAME"));

        System.out.println();

        getInput();
    }

    /**
     * Prints the verification prompt when the user attempts to end the game.
     */
    private void printVerify()
    {
        PrintClearConsole();
        System.out.println(" " + controller.getTrans("SIMULATION_MENU_END_GAME_VERIFY"));
        System.out.println();

        System.out.println(" 1| " + controller.getTrans("SIMULATION_MENU_END_GAME_VERIFY_STAY"));
        System.out.println(" 2| " + controller.getTrans("SIMULATION_MENU_END_GAME_VERIFY_LEAVE"));
    }

    /**
     * Gets input from the user for the main simulation menu, including verification for ending the game.
     */
    @Override
    public void getInput()
    {    
        Scanner scan = new Scanner(System.in);
        
        int input = -1;
        try
        {    
            PrintInput();
            input = scan.nextInt();
        }
        catch(Exception e)
        {
            scan.nextLine();
        }
    
        if(input == 0)
        {
            input = -1;
            try
            {
                printVerify();
                PrintInput();
                input = scan.nextInt();
            }
            catch(Exception e)
            {
                // Handle exception
            }
            
            if(input == 1)
            {
                controller.setInput(-1);
            }
            else if(input == 2)
            {
                controller.setInput(0);
            }
            else
            {
                PrintInvalidInput();
                controller.setInput(-1);
            }
        }    
        else if(input >= 1 && input <= 4)
        {
            controller.setInput(input);
        }
        else
        {
            PrintInvalidInput();
            controller.setInput(-1);
        }    
    }
}

