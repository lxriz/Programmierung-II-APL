package Controller;

import Model.Translation;
import Model.Simulation.Simulation;

public class ControllerSimulationPriceMenu extends Controller
{
	private Simulation sim;
	
	public ControllerSimulationPriceMenu(ViewManager vm, Translation trans, Simulation sim)
	{
		super(vm, trans);
		this.sim = sim;
	}
	
	
	@Override
	public void setInput(int input)
	{	
		vm.setSimulation(sim);
		vm.setInput(input);
	}
	
	
	public double getPrice(int id)
	{
		return sim.getPrice(id);
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
	
	public void setNewPrice(int id, double newPrice)
	{
		sim.setNewPrice(id, newPrice);
	}

}
