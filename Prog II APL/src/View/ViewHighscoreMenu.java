package View;

import java.util.Scanner;

import Controller.Controller;
import Controller.ControllerHighscoreMenu;

/**
 * The ViewHighscoreMenu class handles the view for displaying highscores in the simulation.
 */
public class ViewHighscoreMenu extends View
{
    /**
     * Instantiates a new ViewHighscoreMenu.
     *
     * @param controller the controller associated with this view
     */
    public ViewHighscoreMenu(Controller controller)
    {
        super(controller);
    }
    
    /**
     * Formats a double value to a string with two decimal places.
     *
     * @param d the double value to format
     * @return the formatted string
     */

    
    /**
     * Prints the highscore menu.
     */
    @Override
    public void print()
    {
        PrintClearConsole();
        
        PrintLine();
        System.out.println(" " + controller.getTrans("HIGHSCORE_MENU"));
        PrintLine();
    
        String[][] score = ((ControllerHighscoreMenu) controller).getScore();
        
        if(score == null)
        {
            System.out.println(" ERROR ");
        }
        else
        {
            int i = 1;
            for(String[] entry : score)
            {
                if(entry[0] == null)
                {
                    entry[0] = " - ";
                    entry[1] = " - ";
                }
                System.out.println(" " + i + ". | " + entry[1] + " : " + entry[0]);
                i++;
            }
        }
        
        
        System.out.println();
        System.out.println(" 0| " + controller.getTrans("HIGHSCORE_MENU_EXIT"));    
        
        
        getInput();
    }
    

    
    /**
     * Gets the user's input.
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
            controller.setInput(input);
        }
        else
        {
            PrintInvalidInput();
            controller.setInput(-1);
        } 
        
    }
}

