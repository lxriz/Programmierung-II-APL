package View;

import java.util.Scanner;

import Controller.Controller;

public class ViewHighscoreMenu extends View
{
	public ViewHighscoreMenu(Controller controller)
	{
		super(controller);
	}
	
	
	@Override
	public void print()
	{
		PrintClearConsole();
		
		PrintLine();
		System.out.println(" " + controller.getTrans("HIGHSCORE_MENU"));
		PrintLine();
	
		System.out.println(" TO DO !!! ");
		
		System.out.println();
		System.out.println(" 0| " + controller.getTrans("HIGHSCORE_MENU_EXIT"));	
		
		
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
		else
		{
			PrintInvalidInput();
			controller.setInput(-1);
		} 
	}
}
