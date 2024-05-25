package View;

import java.util.Scanner;

import Controller.Controller;
import Controller.ControllerSimulationStorageMenu;
import Model.Simulation.Products.*;

public class ViewSimulationStorageMenu extends View
{
	
	public ViewSimulationStorageMenu(Controller controller)
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
		switch(((ControllerSimulationStorageMenu) controller).getCurrentDay() % 7)
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
		switch(((ControllerSimulationStorageMenu) controller).getWeather())
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
		
		
		PrintSimulationAnimation(((ControllerSimulationStorageMenu) controller).getWeather());
		
		System.out.println("  " + controller.getTrans(weatherText) + "\t\t\t\t" + "[" + ((ControllerSimulationStorageMenu) controller).getOwnerName() + "'s Kiosk]");
		PrintLine();
		System.out.println("  | " + controller.getTrans(weekday) + " |\t\t\t" + controller.getTrans("SIMULATION_HEADER_WEATHER_1") + " " + ((ControllerSimulationStorageMenu) controller).getCurrentDay() + " " + controller.getTrans("SIMULATION_HEADER_WEATHER_2") + " " + ((ControllerSimulationStorageMenu) controller).getMaxDays());
		PrintLineDashed();		
		System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_MONEY") + " |\t\t\t" + formateDouble(((ControllerSimulationStorageMenu) controller).getCash()) + "€");
		PrintLineDashed();
		System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_STORAGE_1") + " |\t\t\t" + ((ControllerSimulationStorageMenu) controller).getUsedStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_2") + " " + ((ControllerSimulationStorageMenu) controller).getMaxStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_3"));
		PrintLine();
		
		System.out.println("    " + ((ControllerSimulationStorageMenu) controller).countProduct("PRODUCT_NAME_CIGARETTES") + " X " + controller.getTrans("PRODUCT_NAME_CIGARETTES"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationStorageMenu) controller).countProduct("PRODUCT_NAME_FRIES") + " X " + controller.getTrans("PRODUCT_NAME_FRIES"));
		PrintLineDashed();		
		System.out.println("    " + ((ControllerSimulationStorageMenu) controller).countProduct("PRODUCT_NAME_GUM") + " X " + controller.getTrans("PRODUCT_NAME_GUM"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationStorageMenu) controller).countProduct("PRODUCT_NAME_ICE_CREAM") + " X " + controller.getTrans("PRODUCT_NAME_ICE_CREAM"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationStorageMenu) controller).countProduct("PRODUCT_NAME_LEMONADE") + " X " + controller.getTrans("PRODUCT_NAME_LEMONADE"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationStorageMenu) controller).countProduct("PRODUCT_NAME_NEWSPAPER") + " X " + controller.getTrans("PRODUCT_NAME_NEWSPAPER"));
		PrintLine();
		
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
			System.out.println("    " + controller.getTrans(product.name) + "\t\t" + product.size + "\t" + product.expiresDays + " "+ "" + controller.getTrans("SIMULATION_STORAGE_MENU_DAY") + "\t\t" + formateDouble(product.buyPrice) + "€");
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
