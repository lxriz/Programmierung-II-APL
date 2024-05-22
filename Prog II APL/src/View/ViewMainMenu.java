package View;

import java.util.Scanner;

import Controller.Controller;


public class ViewMainMenu extends View
{
	public ViewMainMenu(Controller controller)
	{
		super(controller);
	}
	
	
	@Override
	public void print()
	{
		PrintClearConsole();

		PrintLine();
		System.out.println(" " + controller.getTrans("MAIN_MENU"));
		PrintLine();
		
		System.out.println(" 1| " + controller.getTrans("MAIN_MENU_START"));
		System.out.println(" 2| " + controller.getTrans("MAIN_MENU_CHANGE_LANGUAGE"));
		System.out.println(" 3| " + controller.getTrans("MAIN_MENU_SEE_SCORE"));
		System.out.println();
		System.out.println(" 0| " + controller.getTrans("MAIN_MENU_EXIT"));
		
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
		
		
		
		if(input >= 0 && input <= 3)
		{
			controller.getInput(input);
		}
		else
		{
			PrintInvalidInput();
			print();
		} 
	}
}
