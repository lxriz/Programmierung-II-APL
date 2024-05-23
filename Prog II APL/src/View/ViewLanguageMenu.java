package View;

import java.util.Scanner;

import Controller.Controller;
import Controller.ControllerLanguageMenu;

public class ViewLanguageMenu extends View
{	
	public ViewLanguageMenu(Controller controller)
	{
		super(controller);
	}
	
	
	@Override
	public void print()
	{
		PrintClearConsole();
		
		PrintLine();
		System.out.println(" " + controller.getTrans("LANGUAGE_MENU"));
		PrintLine();
	
		
		String[] languages = ((ControllerLanguageMenu) controller).getSupportedLanguages();
		for(int i = 0; i < languages.length; i++)
		{
			System.out.println(" " + Integer.toString(i+1) + "| " + languages[i]);
		}
		
		System.out.println();
		System.out.println(" 0| " + controller.getTrans("LANGUAGE_MENU_EXIT"));	
		
		
		
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
		
		
		
		if(input >= 0 && input <= ((ControllerLanguageMenu) controller).getSupportedLanguages().length)
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
