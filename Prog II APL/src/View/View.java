package View;

import Controller.Controller;


/**
 * The abstract View class provides basic functionalities for printing and handling input in the view.
 */
public abstract class View implements InterfaceView
{
	/** The controller associated with the view. */
	public Controller controller;
	
	/**
	 * Instantiates a new View.
	 *
	 * @param controller the controller associated with the view
	 */
	public View(Controller controller)
	{
		this.controller = controller;
	}
	
	
	// - - - - 
	// Helper methods
	
	/** The length of the lines to be printed. */
	static int lineLength = 70;
	
	/**
	 * Prints a solid line.
	 */
	public void PrintLine()
	{
		for(int i = 0; i < lineLength; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	/**
	 * Prints a dashed line.
	 */
	public void PrintLineDashed()
	{
		for(int i = 0; i < lineLength/2; i++)
		{
			System.out.print("- ");
		}
		System.out.println();
	}
	
	/**
	 * Prints a dotted line.
	 */
	public void PrintLineDotted()
	{
		for(int i = 0; i < lineLength; i++)
		{
			System.out.print(".");
		}
		System.out.println();
	}
	
	/**
	 * Prints the input prompt.
	 */
	public void PrintInput()
	{
		PrintLine();
		System.out.println(controller.getTrans("INPUT"));
		System.out.print("> ");
	}
	
	/**
	 * Prints a message indicating invalid input.
	 */
	public void PrintInvalidInput()
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
			// Handle exception
		}
	}

	/**
	 * Clears the console by printing several new lines.
	 */
	public void PrintClearConsole()
	{
		for(int i = 0; i < 25; i++)
		{
			System.out.println();
		}
	}
}

