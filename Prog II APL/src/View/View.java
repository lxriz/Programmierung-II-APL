package View;

import Controller.Controller;


public abstract class View implements InterfaceView
{
	public Controller controller;
	
	public View(Controller controller)
	{
		this.controller = controller;
	}
	
	
	// - - - - 
	// Helper methods
	
	static int lineLength = 70;
	
	public void PrintLine()
	{
		for(int i = 0; i < lineLength; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	
	public void PrintLineDashed()
	{
		for(int i = 0; i < lineLength/2; i++)
		{
			System.out.print("- ");
		}
		System.out.println();
	}
	
	
	public void PrintLineDotted()
	{
		for(int i = 0; i < lineLength; i++)
		{
			System.out.print(".");
		}
		System.out.println();
	}
	
	
	public void PrintInput()
	{
		PrintLine();
		System.out.println(controller.getTrans("INPUT"));
		System.out.print("> ");
	}
	
	
	public void PrintInvalidInput( )
	{
		PrintLineDotted();
		System.out.println(" " + controller.getTrans("INVALID_INPUT"));
		PrintLineDotted();
		
		try
		{
			Thread.sleep(800);
		}
		catch(Exception e)
		{
			
		}
	}

	
	public void PrintClearConsole()
	{
		for(int i = 0; i < 25; i++)
		{
			System.out.println();
		}
	}
}
