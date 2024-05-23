package View;

import java.util.Scanner;
import Controller.*;

public class ViewEnterUsernameMenu extends View
{
	public ViewEnterUsernameMenu(Controller controller)
	{
		super(controller);
	}
	
	
	@Override
	public void print()
	{
		PrintClearConsole();
		System.out.println(" " + controller.getTrans("SIMULATION_ENTER_NAME_MENU"));		
		
		getInput();
	}
	

	
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
		
		
		if(input.length() > 2 && input.length() < 30)
		{
			((ControllerEnterUsernameMenu) controller).setUserName(input);
			controller.setInput(0);
		}
		else
		{
			PrintInvalidInput();
			print();
		}

	}
}
