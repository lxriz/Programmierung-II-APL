package View;

import java.util.Scanner;

import Controller.Controller;
import Controller.ControllerSimulationEndMenu;
import Model.Simulation.Simulation;

/**
 * The ViewSimulationEndMenu class handles the view for the end of the simulation in the kiosk simulation.
 */
public class ViewSimulationEndMenu extends ViewSimulation
{
    /**
     * Instantiates a new ViewSimulationEndMenu.
     *
     * @param controller the controller associated with this view
     */
    public ViewSimulationEndMenu(Controller controller)
    {
        super(controller);
    }

    /**
     * Prints the end menu of the simulation, displaying the game over message, profit,
     * profit per day, and options to save the high score.
     */
    @Override
    public void print()
    {
        PrintClearConsole();
        PrintLine();
        System.out.println();
        System.out.println(" " + controller.getTrans("SIMULATION_END_GAME_GAME_OVER"));
        System.out.println();
        PrintLine();
        System.out.println("  " + controller.getTrans("SIMULATION_END_GAME_PROFIT") + ": " + formateDouble(((ControllerSimulationEndMenu) controller).getProfit()) + "€");
        PrintLineDotted();
        System.out.println("  " + controller.getTrans("SIMULATION_END_GAME_PROFIT_PER_DAY") + ": " + formateDouble(((ControllerSimulationEndMenu) controller).getProfitPerDay()) + "€");
        PrintLine();
        System.out.println();
        System.out.println("  " + controller.getTrans("SIMULATION_END_GAME_SAVE_HIGHSCORE"));
        PrintLine();
        System.out.println(" 1| " + controller.getTrans("SIMULATION_END_GAME_SAVE_HIGHSCORE_YES"));
        System.out.println(" 2| " + controller.getTrans("SIMULATION_END_GAME_SAVE_HIGHSCORE_NO"));
        
        getInput();
    }

    /**
     * Gets input from the user for the end menu, allowing the user to save the high score or not.
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
        
        if(input >= 1 && input <= 2)
        {
            if(input == 1)
            {
                ((ControllerSimulationEndMenu) controller).addScore();
            }
            controller.setInput(input);
        }
        else
        {
            PrintInvalidInput();
            controller.setInput(-1);
        } 
    }
}

