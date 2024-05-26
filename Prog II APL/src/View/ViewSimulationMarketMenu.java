package View;

import java.util.Scanner;
import Controller.Controller;
import Controller.ControllerSimulationMarketMenu;
import Model.Simulation.Simulation.BuyProductResponse;


public class ViewSimulationMarketMenu extends ViewSimulation
{	
	public ViewSimulationMarketMenu(Controller controller)
	{
		super(controller);
	}
	
	public String formateDouble(double d)
	{
		return String.format("%.2f", d);
	}
	
	
	@Override
	public void print()
	{
		PrintClearConsole();
		PrintSimulationHeader();
		PrintLine();
		System.out.println(" " + controller.getTrans("SIMULATION_MARKET_MENU"));
		PrintLine();
		System.out.println();
		System.out.println("    " + controller.getTrans("SIMULATION_MARKET_MENU_HEADER_NAME") + "\t\t" + controller.getTrans("SIMULATION_MARKET_MENU_HEADER_SIZE") + "\t" + controller.getTrans("SIMULATION_MARKET_MENU_HEADER_EXPIRES") + "\t" + controller.getTrans("SIMULATION_MARKET_MENU_HEADER_PRICE"));
		PrintLineDashed();
		System.out.println(" 1| " + controller.getTrans("PRODUCT_NAME_CIGARETTES") + "\t\t" + ((ControllerSimulationMarketMenu) controller).getCigarettesSize()  + "\t" + ((ControllerSimulationMarketMenu) controller).getCigarettesExpiresDays()  + " " + controller.getTrans("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(((ControllerSimulationMarketMenu) controller).getCigarettesMarketPrice() ) + "€");
		PrintLineDotted();
		System.out.println(" 2| " + controller.getTrans("PRODUCT_NAME_FRIES") + "\t\t" + ((ControllerSimulationMarketMenu) controller).getFriesSize() + "\t" + ((ControllerSimulationMarketMenu) controller).getFriesExpiresDays() + " " + controller.getTrans("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(((ControllerSimulationMarketMenu) controller).getFriesMarketPrice()) + "€");
		PrintLineDotted();
		System.out.println(" 3| " + controller.getTrans("PRODUCT_NAME_GUM") + "\t\t" + ((ControllerSimulationMarketMenu) controller).getGumSize() + "\t" + ((ControllerSimulationMarketMenu) controller).getGumExpiresDays() + " " + controller.getTrans("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(((ControllerSimulationMarketMenu) controller).getGumMarketPrice()) + "€");
		PrintLineDotted();
		System.out.println(" 4| " + controller.getTrans("PRODUCT_NAME_ICE_CREAM") + "\t\t" + ((ControllerSimulationMarketMenu) controller).getIceCreamSize() + "\t" + ((ControllerSimulationMarketMenu) controller).getIceCreamExpiresDays() + " " + controller.getTrans("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(((ControllerSimulationMarketMenu) controller).getIceCreamMarketPrice()) + "€");
		PrintLineDotted();
		System.out.println(" 5| " + controller.getTrans("PRODUCT_NAME_LEMONADE") + "\t\t" + ((ControllerSimulationMarketMenu) controller).getLemonadeSize() + "\t" + ((ControllerSimulationMarketMenu) controller).getLemonadeExpiresDays() + " " + controller.getTrans("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(((ControllerSimulationMarketMenu) controller).getLemonadeMarketPrice()) + "€");
		PrintLineDotted();
		System.out.println(" 6| " + controller.getTrans("PRODUCT_NAME_NEWSPAPER") + "\t\t" + ((ControllerSimulationMarketMenu) controller).getNewspaperSize() + "\t" + ((ControllerSimulationMarketMenu) controller).getNewspaperExpiresDays() + " " + controller.getTrans("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(((ControllerSimulationMarketMenu) controller).getNewspaperMarketPrice()) + "€");
		PrintLine();
		
		System.out.println(" 0| " + controller.getTrans("SIMULATION_MARKET_MENU_BACK"));
		System.out.println();
		System.out.println(" " + controller.getTrans("SIMULATION_MARKET_MENU_QUESTION"));
		
		getInput();
	}
	
	
	private void PrintGetAmount()
	{
		PrintLineDashed();
		System.out.println(" " + controller.getTrans("SIMULATION_MARKET_MENU_QUESTION_2"));
	}
	
	public void PrintStorageError()
	{
		PrintLineDotted();
		System.out.println(" " + controller.getTrans("SIMULATION_MARKET_MENU_ERROR_STORAGE"));
		PrintLineDotted();
		
		try
		{
			Thread.sleep(800);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	public void PrintCashError()
	{
		PrintLineDotted();
		System.out.println(" " + controller.getTrans("SIMULATION_MARKET_MENU_ERROR_CASH"));
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
		else if(input >= 1 && input <= 6)
		{
			PrintGetAmount();
			
			int amount = -1;
			try
			{	
				PrintInput();
				amount = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
			}
			
			if(amount < 0)
			{
				PrintInvalidInput();
			}
			
			BuyProductResponse response = ((ControllerSimulationMarketMenu) controller).buyProduct(input, amount);
			
			if(response == BuyProductResponse.NotEnoughMoney)
			{
				PrintCashError();
			}
			
			if(response == BuyProductResponse.NotEnoughStorage)
			{
				PrintStorageError();
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
