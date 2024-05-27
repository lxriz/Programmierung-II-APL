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
	private boolean running = true;
	
	private ViewName currentView;
	private enum ViewName
	{
		MainMenu,
		LanguageMenu,
		HighscoreMenu,
		EnterUsernameMenu,
		SimulationMenu,
		SimulationPriceMenu,
		SimulationMarketMenu,
		SimulationStorageMenu,
		SimulationDayMenu,
		SimulationEndMenu
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
					case 0:
						this.running = false;
						break;
					case 1:
						currentView = ViewName.EnterUsernameMenu;
						this.controller = new ControllerEnterUsernameMenu(this, trans);
						this.view = new ViewEnterUsernameMenu(controller);
						break;
					case 2:
						currentView = ViewName.LanguageMenu;
						this.controller = new ControllerLanguageMenu(this, trans);
						this.view = new ViewLanguageMenu(controller);
						break;
					case 3:
						currentView = ViewName.HighscoreMenu;
						this.controller = new ControllerHighscoreMenu(this, trans);
						this.view = new ViewHighscoreMenu(controller);
						break;
				}
				break;
				
			case LanguageMenu:
				switch(input)
				{
					case 0:
						currentView = ViewName.MainMenu;
						this.controller = new ControllerMainMenu(this, trans);
						this.view = new ViewMainMenu(controller);
						break;
				}
				break;
			
			case HighscoreMenu:
				switch(input)
				{
					case 0:
						currentView = ViewName.MainMenu;
						this.controller = new ControllerMainMenu(this, trans);
						this.view = new ViewMainMenu(controller);
						break;
				}
				
				break;
				
			case EnterUsernameMenu:
				switch(input)
				{
					case 0:
						currentView = ViewName.SimulationMenu;
						this.controller = new ControllerSimulationMenu(this, trans, sim);
						this.view = new ViewSimulationMenu(controller);
						break;
				}
				break;
				
			case SimulationMenu:
				switch(input)
				{
					case 0:
						currentView = ViewName.MainMenu;
						this.controller = new ControllerMainMenu(this, trans);
						this.view = new ViewMainMenu(controller);
						break;
						
					case 1:
						currentView = ViewName.SimulationDayMenu;
						this.controller = new ControllerSimulationDayMenu(this, trans, this.sim);
						this.view = new ViewSimulationDayMenu(controller);
						break;
						
					case 2:
						currentView = ViewName.SimulationPriceMenu;
						this.controller = new ControllerSimulationPriceMenu(this, trans, this.sim);
						this.view = new ViewSimulationPriceMenu(controller);
						break;
						
					case 3:
						currentView = ViewName.SimulationStorageMenu;
						this.controller = new ControllerSimulationStorageMenu(this, trans, this.sim);
						this.view = new ViewSimulationStorageMenu(controller);
						break;
					
						
					case 4:
						currentView = ViewName.SimulationMarketMenu;
						this.controller = new ControllerSimulationMarketMenu(this, trans, this.sim);
						this.view = new ViewSimulationMarketMenu(controller);
						break;
				}
				break;
			
			case SimulationPriceMenu:
				switch(input)
				{
					case 0:
						currentView = ViewName.SimulationMenu;
						this.controller = new ControllerSimulationMenu(this, trans, sim);
						this.view = new ViewSimulationMenu(controller);
						break;
				}
				break;
			
			case SimulationMarketMenu:
				switch(input)
				{
					case 0:
						currentView = ViewName.SimulationMenu;
						this.controller = new ControllerSimulationMenu(this, trans, sim);
						this.view = new ViewSimulationMenu(controller);
						break;
				}
				break;
				
			case SimulationStorageMenu:
				switch(input)
				{
					case 0:
						currentView = ViewName.SimulationMenu;
						this.controller = new ControllerSimulationMenu(this, trans, sim);
						this.view = new ViewSimulationMenu(controller);
						break;
				}
				break;
				
			case SimulationDayMenu:
				switch(input)
					{
				case -1:
					run();
					break;
				case 0:
					currentView = ViewName.SimulationMenu;
					this.controller = new ControllerSimulationMenu(this, trans, sim);
					this.view = new ViewSimulationMenu(controller);
					run();
					break;
				case 1:
					currentView = ViewName.SimulationEndMenu;
					this.controller = new ControllerSimulationEndMenu(this, trans, sim);
					this.view = new ViewSimulationEndMenu(controller);
					break;
					}
				break;
				
			case SimulationEndMenu:
				switch(input)
				{
					case 1:
						currentView = ViewName.HighscoreMenu;
						this.controller = new ControllerHighscoreMenu(this, trans);
						this.view = new ViewHighscoreMenu(controller);
						break;
					case 2:
						currentView = ViewName.MainMenu;
						this.controller = new ControllerMainMenu(this, trans);
						this.view = new ViewMainMenu(controller);
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
		while(this.running)
		{
			view.print();		
			changeView(input);
		}
	}
}
