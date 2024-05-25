package Controller;

import Model.Translation;
import Model.Simulation.Simulation;

public class ControllerSimulationDayMenu extends Controller
{
	private Simulation sim;
	private int countCustomers = 0;
	
	public ControllerSimulationDayMenu(ViewManager vm, Translation trans, Simulation sim)
	{
		super(vm, trans);
		this.sim = sim;
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
			vm.setSimulation(sim);
			vm.setInput(0);
		}
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
	
	public int getWeather()
	{
		return sim.getWeather();
	}
	
	public String getOwnerName()
	{
		return sim.getOwnerName();
	}
	
	public int getCurrentDay()
	{
		return sim.getCurrentDay();
	}
	
	public int getUsedStorageSize()
	{
		return sim.getUsedStorageSize();
	}
	
	public double getCash()
	{
		return sim.getCash();
	}
	
	public int countProduct(String product)
	{
		return sim.countProduct(product);
	}
	
	public int getMaxStorageSize()
	{
		return sim.getMaxStorageSize();
	}
	
	public int getMaxDays()
	{
		return sim.getMaxDays();
	}
}
