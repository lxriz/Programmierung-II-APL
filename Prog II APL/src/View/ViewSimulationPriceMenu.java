package View;

import java.util.Scanner;

import Controller.ControllerSimulationPriceMenu;
import Controller.Controller;

public class ViewSimulationPriceMenu extends View
{
	public ViewSimulationPriceMenu(Controller controller)
	{
		super(controller);
	}
	
	public String formateDouble(double d)
	{
		return String.format("%.2f", d);
	}
	
	
	private void PrintSimulationAnimation(int weather)
	{
		switch(weather)
		{
			case 0:
				// RAINY
				System.out.println("\t\t/\t    /      /      /   / ");
				System.out.println("\t\t/\t / _____/___      /");
				System.out.println("\t/\t\t  /         \\       /   /");
				System.out.println("\t\t/\t  |   ___   |            /");
				System.out.println("\t\t/\t  |  |___|  | /        /");
				System.out.println("\t/\t\t/ |_________|       /");
				break;
			case 1:
				// CLOUDY
				System.out.println("\t\t\t               \t ooOoo");
				System.out.println("\t\t\t   _________   \toOOooOoOoo");
				System.out.println("\t\t\t  /         \\ \t ooOOooo");
				System.out.println("\t\t\t  |   ___   |");
				System.out.println("\t\t\t  |  |___|  |");
				System.out.println("\t\t\t  |_________|");
				break;
			case 2:
				// SUNNY
				System.out.println("\t\t\t               \t \\|/");
				System.out.println("\t\t\t   _________   \t-ooo-");
				System.out.println("\t\t\t  /         \\ \t /|\\");
				System.out.println("\t\t\t  |   ___   |");
				System.out.println("\t\t\t  |  |___|  |");
				System.out.println("\t\t\t  |_________|");
				break;
				
		}
	}
	
	
	private void PrintSimulationHeader()
	{			
		String weekday = "";
		String weatherText = "";
		
		// Lookup table weekday
		switch(((ControllerSimulationPriceMenu) controller).getCurrentDay() % 7)
		{
			case 0:
				weekday = "DAY_7";
				break;
			case 1:
				weekday = "DAY_1";
				break;
			case 2:
				weekday = "DAY_2";
				break;
			case 3:
				weekday = "DAY_3";
				break;
			case 4:
				weekday = "DAY_4";
				break;
			case 5:
				weekday = "DAY_5";
				break;
			case 6:
				weekday = "DAY_6";
				break;
		}
		
		// Lookup table weather
		switch(((ControllerSimulationPriceMenu) controller).getWeather())
		{
			case 0:
				weatherText = "WEATHER_RAINY";
				break;
			case 1:
				weatherText = "WEATHER_CLOUDY";
				break;
			case 2:
				weatherText = "WEATHER_SUNNY";
				break;
		}
		
		
		PrintSimulationAnimation(((ControllerSimulationPriceMenu) controller).getWeather());
		
		System.out.println("  " + controller.getTrans(weatherText) + "\t\t\t\t" + "[" + ((ControllerSimulationPriceMenu) controller).getOwnerName() + "'s Kiosk]");
		PrintLine();
		System.out.println("  | " + controller.getTrans(weekday) + " |\t\t\t" + controller.getTrans("SIMULATION_HEADER_WEATHER_1") + " " + ((ControllerSimulationPriceMenu) controller).getCurrentDay() + " " + controller.getTrans("SIMULATION_HEADER_WEATHER_2") + " " + ((ControllerSimulationPriceMenu) controller).getMaxDays());
		PrintLineDashed();		
		System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_MONEY") + " |\t\t\t" + formateDouble(((ControllerSimulationPriceMenu) controller).getCash()) + "€");
		PrintLineDashed();
		System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_STORAGE_1") + " |\t\t\t" + ((ControllerSimulationPriceMenu) controller).getUsedStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_2") + " " + ((ControllerSimulationPriceMenu) controller).getMaxStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_3"));
		PrintLine();
		
		System.out.println("    " + ((ControllerSimulationPriceMenu) controller).countProduct("PRODUCT_NAME_CIGARETTES") + " X " + controller.getTrans("PRODUCT_NAME_CIGARETTES"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationPriceMenu) controller).countProduct("PRODUCT_NAME_FRIES") + " X " + controller.getTrans("PRODUCT_NAME_FRIES"));
		PrintLineDashed();		
		System.out.println("    " + ((ControllerSimulationPriceMenu) controller).countProduct("PRODUCT_NAME_GUM") + " X " + controller.getTrans("PRODUCT_NAME_GUM"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationPriceMenu) controller).countProduct("PRODUCT_NAME_ICE_CREAM") + " X " + controller.getTrans("PRODUCT_NAME_ICE_CREAM"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationPriceMenu) controller).countProduct("PRODUCT_NAME_LEMONADE") + " X " + controller.getTrans("PRODUCT_NAME_LEMONADE"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationPriceMenu) controller).countProduct("PRODUCT_NAME_NEWSPAPER") + " X " + controller.getTrans("PRODUCT_NAME_NEWSPAPER"));
		PrintLine();
		
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
