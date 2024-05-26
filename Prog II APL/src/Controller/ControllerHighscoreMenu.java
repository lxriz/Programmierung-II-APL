package Controller;

import Model.*;
 

/**
 * A controller for managing highscore menu interactions in the application.
 * Extends the Controller class.
 */
public class ControllerHighscoreMenu extends Controller
{
	
	private Highscore score;
	
    /**
     * Instantiates a new ControllerHighscoreMenu.
     *
     * @param vm The ViewManager object.
     * @param trans The Translation object.
     */
    public ControllerHighscoreMenu(ViewManager vm, Translation trans)
    {
        super(vm, trans);
        
        score = new Highscore();
    }

    /**
     * Sets the input based on the selected option.
     *
     * @param input The selected input.
     */
    @Override
    public void setInput(int input)
    {
        vm.setInput(input);
    }
    
    public String[][] getScore()
    {
    	return this.score.getScore();
    }
    
    
}

