package View;

import java.util.Scanner;

import Controller.Controller;
import Controller.ControllerSimulationStorageMenu;
import Model.Simulation.Products.*;

public class ViewSimulationStorageMenu extends ViewSimulation
{
	
	public ViewSimulationStorageMenu(Controller controller)
	{
		super(controller);
	}
	
	@Override
	public void print()
	{
		PrintClearConsole();
		PrintSimulationHeader();
		PrintLine();
		System.out.println(" " + controller.getTrans("SIMULATION_STORAGE_MENU"));
		PrintLine();
		System.out.println("    " + controller.getTrans("SIMULATION_STORAGE_MENU_HEADER") + "\t\t" + controller.getTrans("SIMULATION_STORAGE_MENU_SIZE") + "\t" + controller.getTrans("SIMULATION_STORAGE_MENU_EXPIRES") + "\t" + controller.getTrans("SIMULATION_STORAGE_MENU_BUY_PRICE"));
		PrintLineDashed();
		
		for(Product product : ((ControllerSimulationStorageMenu) controller).getStorage())
		{
			System.out.println("    " + controller.getTrans(product.name) + "\t\t" + product.size + "\t" + product.expiresDays + " " + controller.getTrans("SIMULATION_STORAGE_MENU_DAY") + "\t\t" + formateDouble(product.buyPrice) + "€");
			PrintLineDotted();
		}
		
		PrintLine();
		System.out.println(" 1| " + controller.getTrans("SIMULATION_STORAGE_MENU_SORT_NAME"));
		System.out.println(" 2| " + controller.getTrans("SIMULATION_STORAGE_MENU_SORT_EXPIRES"));
		System.out.println();
		System.out.println(" 0| " + controller.getTrans("SIMULATION_STORAGE_MENU_BACK"));

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
		
		
		if(input == 0)
		{
			controller.setInput(input);
		}
		else if(input >= 1 && input <= 2)
		{
			switch(input)
			{
				case 1:
					((ControllerSimulationStorageMenu) controller).sortStorageName();
					break;
				case 2:
					((ControllerSimulationStorageMenu) controller).sortStorageExpired();
					break;
			}
			
			controller.setInput(-1);
		}
		else
		{
			PrintInvalidInput();
			controller.setInput(-1);
		} 
		
	}
}
