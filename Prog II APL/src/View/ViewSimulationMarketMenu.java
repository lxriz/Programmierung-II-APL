package View;

import java.util.Scanner;
import Controller.Controller;
import Controller.ControllerSimulationMarketMenu;


public class ViewSimulationMarketMenu extends View
{	
	public ViewSimulationMarketMenu(Controller controller)
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
	
	
	public void PrintSimulationHeader()
	{			
		String weekday = "";
		String weatherText = "";
		
		// Lookup table weekday
		switch(((ControllerSimulationMarketMenu) controller).getCurrentDay() % 7)
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
		switch(((ControllerSimulationMarketMenu) controller).getWeather())
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
		
		
		PrintSimulationAnimation(((ControllerSimulationMarketMenu) controller).getWeather());
		
		System.out.println("  " + controller.getTrans(weatherText) + "\t\t\t\t" + "[" + ((ControllerSimulationMarketMenu) controller).getOwnerName() + "'s Kiosk]");
		PrintLine();
		System.out.println("  | " + controller.getTrans(weekday) + " |\t\t\t" + controller.getTrans("SIMULATION_HEADER_WEATHER_1") + " " + ((ControllerSimulationMarketMenu) controller).getCurrentDay() + " " + controller.getTrans("SIMULATION_HEADER_WEATHER_2") + " " + ((ControllerSimulationMarketMenu) controller).getMaxDays());
		PrintLineDashed();		
		System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_MONEY") + " |\t\t\t" + formateDouble(((ControllerSimulationMarketMenu) controller).getCash()) + "€");
		PrintLineDashed();
		System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_STORAGE_1") + " |\t\t\t" + ((ControllerSimulationMarketMenu) controller).getUsedStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_2") + " " + ((ControllerSimulationMarketMenu) controller).getMaxStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_3"));
		PrintLine();
		
		System.out.println("    " + ((ControllerSimulationMarketMenu) controller).countProduct("PRODUCT_NAME_CIGARETTES") + " X " + controller.getTrans("PRODUCT_NAME_CIGARETTES"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationMarketMenu) controller).countProduct("PRODUCT_NAME_FRIES") + " X " + controller.getTrans("PRODUCT_NAME_FRIES"));
		PrintLineDashed();		
		System.out.println("    " + ((ControllerSimulationMarketMenu) controller).countProduct("PRODUCT_NAME_GUM") + " X " + controller.getTrans("PRODUCT_NAME_GUM"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationMarketMenu) controller).countProduct("PRODUCT_NAME_ICE_CREAM") + " X " + controller.getTrans("PRODUCT_NAME_ICE_CREAM"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationMarketMenu) controller).countProduct("PRODUCT_NAME_LEMONADE") + " X " + controller.getTrans("PRODUCT_NAME_LEMONADE"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationMarketMenu) controller).countProduct("PRODUCT_NAME_NEWSPAPER") + " X " + controller.getTrans("PRODUCT_NAME_NEWSPAPER"));
		PrintLine();
		
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
				input = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
			}
			
			if(amount < 0)
			{
				PrintInvalidInput();
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
