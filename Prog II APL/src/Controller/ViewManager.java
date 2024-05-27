package Controller;

import View.*;
import Model.*;
import Model.Simulation.Simulation;


/**
 * The ViewManager class is responsible for managing the different views and their controllers in the application.
 */
public class ViewManager 
{
	/**
	 * The controller managing the current view.
	 */
	public Controller controller;

	/**
	 * The current view being displayed.
	 */
	public View view;

	/**
	 * The simulation instance being used in the view manager.
	 */
	private Simulation sim;

	/**
	 * The input value used for changing views.
	 */
	private int input;

	/**
	 * Indicates whether the application is running.
	 */
	private boolean running = true;

    
	/**
	 * The current view being displayed, represented by an enum.
	 */
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
    
    /**
     * The translation manager used for handling translations in the application.
     */
    public Translation trans;

    
    /**
     * Constructs a ViewManager object and initializes the Translation instance.
     */
    public ViewManager()
    {
        this.trans = new Translation();
    }
    
    /**
     * Initializes the ViewManager, setting the current view to MainMenu and starting the main loop.
     */
    public void init()
    {
        currentView = ViewName.MainMenu;
        this.controller = new ControllerMainMenu(this, trans);
        this.view = new ViewMainMenu(controller);
        
        run();
    }
    
    /**
     * Changes the current view based on the input and the current view.
     * 
     * @param input the input value indicating the view to change to
     */
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
    
    /**
     * Sets the input value for the ViewManager.
     * 
     * @param input the input value
     */
    public void setInput(int input)
    {
        this.input = input;
    }
    
    /**
     * Sets the Simulation instance for the ViewManager.
     * 
     * @param sim the Simulation instance
     */
    public void setSimulation(Simulation sim)
    {
        this.sim = sim;
    }
    
    /**
     * Runs the main loop, continuously printing the current view and changing views based on input.
     */
    public void run()
    {
        while(this.running)
        {
            view.print();        
            changeView(input);
        }
    }

}
