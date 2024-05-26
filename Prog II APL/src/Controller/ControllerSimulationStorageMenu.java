package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Translation;
import Model.Simulation.Simulation;
import Model.Simulation.Products.Product;

public class ControllerSimulationStorageMenu extends ControllerSimulation
{
	private List<Product> storage;
	
	public ControllerSimulationStorageMenu(ViewManager vm, Translation trans, Simulation sim)
	{
		super(vm, trans, sim);
		this.storage = new ArrayList<>(sim.getStorage());
	}
	
	
	@Override
	public void setInput(int input)
	{
		vm.setInput(input);
	}
	
	public void sortStorageExpired()
	{
		List<Product> sortedList = new ArrayList<>();

		for(Product productunsorted : storage)
		{
			boolean inserted = false;
			for(int i = 0; i<sortedList.size(); i++)
			{
				if(productunsorted.expiresDays <= sortedList.get(i).expiresDays)
				{
					sortedList.add(i, productunsorted);	
					inserted = true;
					break;
				}
			}
			
			if(!inserted)
			{
				sortedList.add(productunsorted);
			}
		}
		
		storage = sortedList;
	}
	
	
	public void sortStorageName()
	{
		List<Product> sortedList = new ArrayList<>();

		for(Product productunsorted : storage)
		{
			boolean inserted = false;
			for(int i = 0; i<sortedList.size(); i++)
			{
				if(getTrans(productunsorted.name).compareTo(getTrans(sortedList.get(i).name)) < 0)
				{
					sortedList.add(i, productunsorted);	
					inserted = true;
					break;
				}
			}
			
			if(!inserted)
			{
				sortedList.add(productunsorted);
			}
		}
		
		storage = sortedList;
	}
	
	public List<Product> getStorage()
	{
		return this.storage;
	}
	
}
