package Controller;

import Model.Translation;

import java.util.Locale;

import Model.Highscore;
import Model.Simulation.Simulation;

/**
 * Controller for the end menu of the simulation.
 * Extends the Controller class.
 */
public class ControllerSimulationEndMenu extends ControllerSimulation
{
	private Highscore score;
	
	/**
	 * Constructs a new ControllerSimulationEndMenu object.
	 *
	 * @param vm The ViewManager associated with this controller.
	 * @param trans The Translation object for handling translations.
	 * @param sim The Simulation object representing the simulation.
	 */
	public ControllerSimulationEndMenu(ViewManager vm, Translation trans, Simulation sim)
	{
		super(vm, trans, sim);
		
		this.score = new Highscore();
	}
	
	private String convertDouble(double d)
	{
		return String.format(Locale.US, "%.2f", d);
	}
	
	/**
	 * Sets the input for the ViewManager.
	 *
	 * @param input The input value to be set.
	 */
	@Override
	public void setInput(int input)
	{
		vm.setInput(input);
	}
	
	
	/**
	 * Calculates the profit earned during the simulation.
	 *
	 * @return The profit earned during the simulation.
	 */
	public double getProfit()
	{
		return sim.getCash() - sim.getStartCash();
	}
	
	
	/**
	 * Calculates the profit earned per day during the simulation.
	 *
	 * @return The profit earned per day during the simulation.
	 */
	public double getProfitPerDay()
	{
		return (getProfit())/(double)sim.getMaxDays();
	}
	
	
	/**
	 * Adds the current score to the highscore list.
	 */
	public void addScore()
	{
		String profit = convertDouble(getProfit());
		this.score.getNewScore(new String[] {sim.getOwnerName(), profit});
	}
}

