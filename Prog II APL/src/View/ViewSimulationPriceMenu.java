package View;

import java.util.Locale;
import java.util.Scanner;

import Controller.ControllerSimulationPriceMenu;
import Controller.Controller;

public class ViewSimulationPriceMenu extends ViewSimulation
{
	public ViewSimulationPriceMenu(Controller controller)
	{
		super(controller);
	}
	
	
	@Override
	public void print()
	{
		
		PrintClearConsole();
		PrintSimulationHeader();
		
		PrintLine();
		System.out.println(" " + controller.getTrans("SIMULATION_PRICES_MENU"));
		PrintLine();
		System.out.println("    " + controller.getTrans("SIMULATION_MARKET_MENU_HEADER_NAME") + "\t\t\t\t\t" + controller.getTrans("SIMULATION_MARKET_MENU_HEADER_PRICE"));
		PrintLineDashed();
		System.out.println(" 1| " + controller.getTrans("PRODUCT_NAME_CIGARETTES") + "\t\t\t\t\t" + formateDouble(((ControllerSimulationPriceMenu) controller).getPrice(1)) + "€");
		PrintLineDotted();
		System.out.println(" 2| " + controller.getTrans("PRODUCT_NAME_FRIES") + "\t\t\t\t\t" + formateDouble(((ControllerSimulationPriceMenu) controller).getPrice(2)) + "€");
		PrintLineDotted();
		System.out.println(" 3| " + controller.getTrans("PRODUCT_NAME_GUM") + "\t\t\t\t\t" + formateDouble(((ControllerSimulationPriceMenu) controller).getPrice(3)) + "€");
		PrintLineDotted();
		System.out.println(" 4| " + controller.getTrans("PRODUCT_NAME_ICE_CREAM") + "\t\t\t\t\t" + formateDouble(((ControllerSimulationPriceMenu) controller).getPrice(4)) + "€");
		PrintLineDotted();
		System.out.println(" 5| " + controller.getTrans("PRODUCT_NAME_LEMONADE") + "\t\t\t\t\t" + formateDouble(((ControllerSimulationPriceMenu) controller).getPrice(5)) + "€");
		PrintLineDotted();
		System.out.println(" 6| " + controller.getTrans("PRODUCT_NAME_NEWSPAPER") + "\t\t\t\t\t" + formateDouble(((ControllerSimulationPriceMenu) controller).getPrice(6)) + "€");
		PrintLineDotted();
		System.out.println();
		System.out.println(" 0| " + controller.getTrans("SIMULATION_PRICES_MENU_BACK"));
		
		getInput();
	}
	
	
	private void printChangePrice()
	{
		PrintLineDashed();
		System.out.println(" " + controller.getTrans("SIMULATION_PRICES_MENU_QUESTION"));
	}
	
	
	private void PrintPriceError()
	{
		PrintLineDotted();
		System.out.println(" " + controller.getTrans("SIMULATION_PRICE_MENU_ERROR_PRICE"));
		PrintLineDotted();
		
		try
		{
			Thread.sleep(800);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	
	@Override 
	public void getInput()
	{
		Scanner scan = new Scanner(System.in).useLocale(Locale.US);
		
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
		else if(input >= 1 && input <= 6)
		{	
			double newPrice = -1;
			try
			{	
				printChangePrice();
				newPrice = scan.nextDouble();
			}
			catch(Exception e)
			{
				scan.nextLine();
			}
			
			
			if(newPrice < 0)
			{
				PrintPriceError();
			}
			else
			{
				((ControllerSimulationPriceMenu) controller).setNewPrice(input, newPrice);
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
