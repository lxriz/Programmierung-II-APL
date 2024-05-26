package Controller;

import Model.Translation;
import Model.Simulation.Simulation;

public class ControllerSimulationDayMenu extends ControllerSimulation
{
	private int countCustomers = 0;
	
	public ControllerSimulationDayMenu(ViewManager vm, Translation trans, Simulation sim)
	{
		super(vm, trans, sim);
		this.countCustomers = this.sim.getCountCustomers();
	}
	
	
	@Override
	public void setInput(int input)
	{
		if(countCustomers > 0)
		{
			vm.setInput(-1);
		}
		else 
		{
			this.sim.nextDay();
			vm.setSimulation(sim);
			if(checkEnd())
			{
				vm.setInput(1);
			}
			else
			{
				vm.setInput(0);
			}
		}
	}
	
	public boolean checkEnd()
	{
		return sim.checkEndGame();
	}	
	
	public int[] getResponse() 
	{
		this.countCustomers --;
		return this.sim.getResponse();
	}
	
	public int getRemainingCustomers()
	{
		return this.countCustomers;
	}
	
}
