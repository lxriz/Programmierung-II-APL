package View;

import java.util.Scanner;
import Controller.*;

/**
 * The ViewEnterUsernameMenu class handles the view for entering a username in the simulation.
 */
public class ViewEnterUsernameMenu extends View
{
	/**
	 * Instantiates a new ViewEnterUsernameMenu.
	 *
	 * @param controller the controller associated with this view
	 */
	public ViewEnterUsernameMenu(Controller controller)
	{
		super(controller);
	}
	
	/**
	 * Prints the enter username menu.
	 */
	@Override
	public void print()
	{
		PrintClearConsole();
		System.out.println(" " + controller.getTrans("SIMULATION_ENTER_NAME_MENU"));		
		
		getInput();
	}
	
	/**
	 * Gets the user's input for the username.
	 */
	@Override 
	public void getInput()
	{
		Scanner scan = new Scanner(System.in);
		
		String input = "";
		try
		{	
			PrintInput();
			input = scan.nextLine();
		}
		catch(Exception e)
		{
			scan.nextLine();
		}
		
		if(!(input.length() >= 2 && input.length() <= 15))
		{
			PrintInvalidInput();
			controller.setInput(-1);
		}
		else if(!(input.matches("[A-Za-z]+")))
		{
			PrintInvalidInput();
			controller.setInput(-1);
		}
		else
		{
			((ControllerEnterUsernameMenu) controller).setUserName(input);
			controller.setInput(0);
		}
	}
}

