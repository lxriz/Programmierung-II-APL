package Controller;

import Model.Translation;
import Model.Simulation.Simulation;

public class ControllerSimulationEndMenu extends Controller
{
	private Simulation sim;

	public ControllerSimulationEndMenu(ViewManager vm, Translation trans, Simulation sim)
	{
		super(vm, trans);
		this.sim = sim;
	}
	
	 
	@Override
	public void setInput(int input)
	{
		vm.setInput(input);
	}
	
	public double getStartCash()
	{
		return sim.getStartCash();
	}
	
	public double getCash()
	{
		return sim.getCash();
	}
	
	public int getMaxDays()
	{
		return sim.getMaxDays();
	}
	

}
