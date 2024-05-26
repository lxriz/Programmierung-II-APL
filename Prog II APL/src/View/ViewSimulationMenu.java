package View;

import java.util.Scanner;

import Controller.*;


public class ViewSimulationMenu extends ViewSimulation
{
	public ViewSimulationMenu(Controller controller)
	{
		super(controller);
	}
		
	@Override
	public void print()
	{		
		PrintClearConsole();
		PrintSimulationHeader();
		
		System.out.println();
		
		System.out.println(" 1| " + controller.getTrans("SIMULATION_MENU_START_DAY"));
		System.out.println(" 2| " + controller.getTrans("SIMULATION_MENU_PRICES"));
		System.out.println(" 3| " + controller.getTrans("SIMULATION_MENU_STORAGE"));
		System.out.println(" 4| " + controller.getTrans("SIMULATION_MENU_GET_PRODUCTS"));

		System.out.println();
		
		System.out.println(" 0| " + controller.getTrans("SIMULATION_MENU_END_GAME"));

		System.out.println();

		getInput();
	}
	
	
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
	
		
		if(input >= 0 && input <= 4)
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
