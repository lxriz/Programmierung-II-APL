package View;

import Controller.Controller;
import Controller.ControllerSimulationDayMenu;


public class ViewSimulationDayMenu extends View
{

	public ViewSimulationDayMenu(Controller controller)
	{
		super(controller);
	}
	
	public String formateDouble(double d)
	{
		return String.format("%.2f", d);
	}
	
	private String PrintStartDayMenuHelper(int response)
	{
		switch(response)
		{
			case 0:
				return controller.getTrans("SIMULATION_START_DAY_CUSTOMER_RESPONSE_SOLD_OUT");

			case 1:
				return controller.getTrans("SIMULATION_START_DAY_CUSTOMER_RESPONSE_TOO_EXPENSIVE");

			case 2:
				return controller.getTrans("SIMULATION_START_DAY_CUSTOMER_RESPONSE_BOUGHT");		
		}
		
		return "";
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
		switch(((ControllerSimulationDayMenu) controller).getCurrentDay() % 7)
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
		switch(((ControllerSimulationDayMenu) controller).getWeather())
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
		
		
		PrintSimulationAnimation(((ControllerSimulationDayMenu) controller).getWeather());
		
		System.out.println("  " + controller.getTrans(weatherText) + "\t\t\t\t" + "[" + ((ControllerSimulationDayMenu) controller).getOwnerName() + "'s Kiosk]");
		PrintLine();
		System.out.println("  | " + controller.getTrans(weekday) + " |\t\t\t" + controller.getTrans("SIMULATION_HEADER_WEATHER_1") + " " + ((ControllerSimulationDayMenu) controller).getCurrentDay() + " " + controller.getTrans("SIMULATION_HEADER_WEATHER_2") + " " + ((ControllerSimulationDayMenu) controller).getMaxDays());
		PrintLineDashed();		
		System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_MONEY") + " |\t\t\t" + formateDouble(((ControllerSimulationDayMenu) controller).getCash()) + "€");
		PrintLineDashed();
		System.out.println("  | " + controller.getTrans("SIMULATION_HEADER_STORAGE_1") + " |\t\t\t" + ((ControllerSimulationDayMenu) controller).getUsedStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_2") + " " + ((ControllerSimulationDayMenu) controller).getMaxStorageSize() + " " + controller.getTrans("SIMULATION_HEADER_STORAGE_3"));
		PrintLine();
		
		System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_CIGARETTES") + " X " + controller.getTrans("PRODUCT_NAME_CIGARETTES"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_FRIES") + " X " + controller.getTrans("PRODUCT_NAME_FRIES"));
		PrintLineDashed();		
		System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_GUM") + " X " + controller.getTrans("PRODUCT_NAME_GUM"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_ICE_CREAM") + " X " + controller.getTrans("PRODUCT_NAME_ICE_CREAM"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_LEMONADE") + " X " + controller.getTrans("PRODUCT_NAME_LEMONADE"));
		PrintLineDashed();
		System.out.println("    " + ((ControllerSimulationDayMenu) controller).countProduct("PRODUCT_NAME_NEWSPAPER") + " X " + controller.getTrans("PRODUCT_NAME_NEWSPAPER"));
		PrintLine();
		
	}
	
	public void print()
	{
		int[] response = ((ControllerSimulationDayMenu) controller).getResponse();

		PrintClearConsole();
		PrintSimulationHeader();
		
		
		switch(response[1])
		{
			case 1:
				System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + controller.getTrans("PRODUCT_NAME_CIGARETTES") + ": " + PrintStartDayMenuHelper(response[2]));
				break;
				
			case 2:
				System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " +controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + controller.getTrans("PRODUCT_NAME_FRIES") + ": " + PrintStartDayMenuHelper(response[2]));
				break;
				
			case 3:
				System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + controller.getTrans("PRODUCT_NAME_GUM") + ": " + PrintStartDayMenuHelper(response[2]));
				break;
				
			case 4:
				System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + controller.getTrans("PRODUCT_NAME_ICE_CREAM") + ": " + PrintStartDayMenuHelper(response[2]));
				break;
				
			case 5:
				System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + controller.getTrans("PRODUCT_NAME_LEMONADE") + ": " + PrintStartDayMenuHelper(response[2]));
				break;
				
			case 6:
				System.out.println(" " + ((ControllerSimulationDayMenu) controller).getRemainingCustomers() + " " + controller.getTrans("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + controller.getTrans("PRODUCT_NAME_NEWSPAPER") + ": " + PrintStartDayMenuHelper(response[2]));
				break;
		}
		
		PrintLine();
		
		try
		{
			Thread.sleep(400);
		}
		catch(Exception e)
		{
			
		}
		
		getInput();
	}
	
	
	@Override 
	public void getInput()
	{
		controller.setInput(-1);
		
	}
}
