package Controller;

import View.*;
import Model.*;
import Model.Simulation.Simulation;


public class ViewManager 
{
	public Controller controller;
	public View view;
	
	private Simulation sim;
	
	private int input;
	
	private ViewName currentView;
	private enum ViewName
	{
		MainMenu,
		LanguageMenu,
		HighscoreMenu,
		EnterUsernameMenu
		
	}
	
	
	public Translation trans;
	
	
	public ViewManager()
	{
		this.trans = new Translation();
	}
	
	
	public void init()
	{
		currentView = ViewName.MainMenu;
		this.controller = new ControllerMainMenu(this, trans);
		this.view = new ViewMainMenu(controller);
		run();
	}
	
	
	public void changeView(int input)
	{
		switch(currentView)
		{
			case MainMenu:
				switch(input)
				{
					case -1:
						run();
						break;
					case 0:
						// Exits Program
						break;
					case 1:
						// Starts Game
						currentView = ViewName.EnterUsernameMenu;
						this.controller = new ControllerEnterUsernameMenu(this, trans);
						this.view = new ViewEnterUsernameMenu(controller);
						run();
						break;
					case 2:
						// Language Menu
						currentView = ViewName.LanguageMenu;
						this.controller = new ControllerLanguageMenu(this, trans);
						this.view = new ViewLanguageMenu(controller);
						run();
						break;
					case 3:
						// Highscore Menu
						currentView = ViewName.HighscoreMenu;
						this.controller = new ControllerHighscoreMenu(this, trans);
						this.view = new ViewHighscoreMenu(controller);
						run();
						break;
				}
				break;
				
			case LanguageMenu:
				switch(input)
				{
					case -1:
						run();
						break;
					case 0:
						currentView = ViewName.MainMenu;
						this.controller = new ControllerMainMenu(this, trans);
						this.view = new ViewMainMenu(controller);
						run();
						break;
				}
				break;
			
			case HighscoreMenu:
				switch(input)
				{
					case -1:
						run();
						break;
					case 0:
						currentView = ViewName.MainMenu;
						this.controller = new ControllerMainMenu(this, trans);
						this.view = new ViewMainMenu(controller);
						run();
						break;
				}
				
				break;
		}
	}
	
	
	public void setInput(int input)
	{
		this.input = input;
	}
	
	
	public void setSimulation(Simulation sim)
	{
		this.sim = sim;
	}
	
	
	public void run()
	{
		view.print();		
		changeView(input);
	}
}
