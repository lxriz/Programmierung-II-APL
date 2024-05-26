package Controller;

import Model.Translation;
import Model.Simulation.Simulation;
import Model.Simulation.Simulation.BuyProductResponse;

public class ControllerSimulationMarketMenu extends Controller
{
private Simulation sim;
	
	public ControllerSimulationMarketMenu(ViewManager vm, Translation trans, Simulation sim)
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
	
	public BuyProductResponse buyProduct(int id, int amount)
	{
		switch(id)
		{
			case 1:
				return this.sim.buyCigarettes(amount);
			case 2:
				return this.sim.buyFries(amount);
			case 3:
				return this.sim.buyGum(amount);
			case 4:
				return this.sim.buyIceCream(amount);
			case 5:
				return this.sim.buyLemonade(amount);
			case 6:
				return this.sim.buyNewspaper(amount);
		}
		
		return BuyProductResponse.NotEnoughMoney;
	}
	
	public BuyProductResponse buyCigarettes(int amount)
	{
		return this.sim.buyCigarettes(amount);
	}
	
	public BuyProductResponse buyFries(int amount)
	{
	    return this.sim.buyFries(amount);
	}

	public BuyProductResponse buyNewspaper(int amount)
	{
	    return this.sim.buyNewspaper(amount);
	}

	public BuyProductResponse buyGum(int amount)
	{
	    return this.sim.buyGum(amount);
	}

	public BuyProductResponse buyIceCream(int amount)
	{
	    return this.sim.buyIceCream(amount);
	}

	public BuyProductResponse buyLemonade(int amount)
	{
	    return this.sim.buyLemonade(amount);
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
	
	public int getGumSize()
	{
	    return sim.getGumSize();
	}

	public int getFriesSize()
	{
	    return sim.getFriesSize();
	}

	public int getNewspaperSize()
	{
	    return sim.getNewspaperSize();
	}

	public int getLemonadeSize()
	{
	    return sim.getLemonadeSize();
	}

	public int getCigarettesSize()
	{
	    return sim.getCigarettesSize();
	}
	
	public int getIceCreamSize()
	{
	    return sim.getIceCreamSize();
	}
	
	
	public int getIceCreamExpiresDays()
	{
		return sim.getIceCreamExpiresDays();
	}
	
	public int getGumExpiresDays()
	{
	    return sim.getGumExpiresDays();
	}

	public int getFriesExpiresDays()
	{
	    return sim.getFriesExpiresDays();
	}

	public int getNewspaperExpiresDays()
	{
	    return sim.getNewspaperExpiresDays();
	}

	public int getLemonadeExpiresDays()
	{
	    return sim.getLemonadeExpiresDays();
	}

	public int getCigarettesExpiresDays()
	{
	    return sim.getCigarettesExpiresDays();
	}
	
	public double getFriesMarketPrice()
	{
		return sim.getFriesMarketPrice();
	}
	
	public double getIceCreamMarketPrice()
	{
	    return sim.getIceCreamMarketPrice();
	}

	public double getGumMarketPrice()
	{
	    return sim.getGumMarketPrice();
	}

	public double getNewspaperMarketPrice()
	{
	    return sim.getNewspaperMarketPrice();
	}

	public double getLemonadeMarketPrice()
	{
	    return sim.getLemonadeMarketPrice();
	}

	public double getCigarettesMarketPrice()
	{
	    return sim.getCigarettesMarketPrice();
	}


}
