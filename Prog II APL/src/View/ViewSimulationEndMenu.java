package View;

import java.util.Scanner;

import Controller.Controller;
import Controller.ControllerSimulationEndMenu;
import Model.Simulation.Simulation;

public class ViewSimulationEndMenu extends View
{	
	public ViewSimulationEndMenu(Controller controller)
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
		PrintLine();
		System.out.println();
		System.out.println(" " + controller.getTrans("SIMULATION_END_GAME_GAME_OVER"));
		System.out.println();
		PrintLine();
		System.out.println("  " + controller.getTrans("SIMULATION_END_GAME_PROFIT") + ": " + formateDouble((((ControllerSimulationEndMenu) controller).getCash()-((ControllerSimulationEndMenu) controller).getStartCash())) + "€");
		PrintLineDotted();
		System.out.println("  " + controller.getTrans("SIMULATION_END_GAME_PROFIT_PER_DAY") + ": " + formateDouble((((ControllerSimulationEndMenu) controller).getCash()-((ControllerSimulationEndMenu) controller).getStartCash())/((double)((ControllerSimulationEndMenu) controller).getMaxDays())) + "€");
		PrintLine();
		System.out.println();
		System.out.println("  " + controller.getTrans("SIMULATION_END_GAME_SAVE_HIGHSCORE"));
		PrintLine();
		System.out.println(" 1| " + controller.getTrans("SIMULATION_END_GAME_SAVE_HIGHSCORE_YES"));
		System.out.println(" 2| " + controller.getTrans("SIMULATION_END_GAME_SAVE_HIGHSCORE_NO"));
			
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
	
		
		if(input >= 1 && input <= 2)
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
