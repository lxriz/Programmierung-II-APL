package View;

import java.util.Scanner;

import Controller.Controller;
import Controller.ControllerHighscoreMenu;

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
	
		String[][] score = ((ControllerHighscoreMenu) controller).getScore();
		
		if(score == null)
		{
			System.out.println(" ERROR ");
		}
		else
		{
			int i = 1;
			for(String[] entry : score)
			{
				if(entry[0] == null)
				{
					entry[0] = " - ";
					entry[1] = " - ";
				}
				System.out.println(" " + i + ". | " + entry[1] + " - " + entry[0]);
				i++;
			}
		}
		
		
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
