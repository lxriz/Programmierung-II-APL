package View;

import java.util.Scanner;

import Controller.Controller;
import Controller.ControllerLanguageMenu;

/**
 * The ViewLanguageMenu class handles the view for selecting a language in the simulation.
 */
public class ViewLanguageMenu extends View
{
	/**
	 * Instantiates a new ViewLanguageMenu.
	 *
	 * @param controller the controller associated with this view
	 */
	public ViewLanguageMenu(Controller controller)
	{
		super(controller);
	}
	
	/**
	 * Prints the language selection menu.
	 */
	@Override
	public void print()
	{
		PrintClearConsole();
		
		PrintLine();
		System.out.println(" " + controller.getTrans("LANGUAGE_MENU"));
		PrintLine();
		
		String[] languages = ((ControllerLanguageMenu) controller).getSupportedLanguages();
		for(int i = 0; i < languages.length; i++)
		{
			System.out.println(" " + Integer.toString(i+1) + "| " + languages[i]);
		}
		
		System.out.println();
		System.out.println(" 0| " + controller.getTrans("LANGUAGE_MENU_EXIT"));
		
		getInput();
	}
	
	/**
	 * Gets the user's input for the language selection.
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
		
		if(input >= 0 && input <= ((ControllerLanguageMenu) controller).getSupportedLanguages().length)
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

