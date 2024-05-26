package Model.Simulation;

import java.util.List;
import java.util.Random;
import Model.Simulation.Products.*;


public class Simulation 
{
	public class Day
	{
		// 0 - Rainy
		// 1 - Cloudy
		// 2 - Sunny
		public final int weather;
		public Market market;
		
		
		public final int countCustomers;
		
		private static Random r = new Random();
		
		
		public Day()
		{
			this.weather = (int)(r.nextInt(3));
			market = new Market(this.weather);
			countCustomers = r.nextInt(15, (int)(35+35*0.15*weather));
		}
		
		
		public int[] nextCustomer()
		{
				// Respone - [age, product_id, transaction]
				// 0 - sold out
				// 1 - too expensive
				// 2 - bought
			
				Customer customer = new Customer(weather);
				int choice = customer.chooseProcduct();
				
				choice++;
								
				switch(choice)
				{
					case 1:
						if(kiosk.countProduct("PRODUCT_NAME_CIGARETTES") > 0)
						{
							if(customer.willBuy(market.cigarettesPrice, kiosk.getPrice(choice)))
							{
								kiosk.addCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_CIGARETTES");
								return new int[]{customer.age, choice, 2};
							}
							return new int[]{customer.age, choice, 1};
						}
						return new int[]{customer.age, choice, 0};
						
					case 2:
						if(kiosk.countProduct("PRODUCT_NAME_FRIES") > 0)
						{
							if(customer.willBuy(market.friesPrice, kiosk.getPrice(choice)))
							{
								kiosk.addCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_FRIES");
								return new int[]{customer.age, choice, 2};
							}
							return new int[]{customer.age, choice, 1};
						}	
						return new int[]{customer.age, choice, 0};
						
					case 3:
						if(kiosk.countProduct("PRODUCT_NAME_GUM") > 0)
						{
							if(customer.willBuy(market.gumPrice, kiosk.getPrice(choice)))
							{
								kiosk.addCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_GUM");
								return new int[]{customer.age, choice, 2};
							}
							return new int[]{customer.age, choice, 1};
						}		
						return new int[]{customer.age, choice, 0};
						
					case 4:
						if(kiosk.countProduct("PRODUCT_NAME_ICE_CREAM") > 0)
						{
							if(customer.willBuy(market.iceCreamPrice, kiosk.getPrice(choice)))
							{
								kiosk.addCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_ICE_CREAM");
								return new int[]{customer.age, choice, 2};
							}
							return new int[]{customer.age, choice, 1};
						}
						return new int[]{customer.age, choice, 0};
						
					case 5:
						if(kiosk.countProduct("PRODUCT_NAME_LEMONADE") > 0)
						{
							if(customer.willBuy(market.lemonadePrice, kiosk.getPrice(choice)))
							{
								kiosk.addCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_LEMONADE");
								return new int[]{customer.age, choice, 2};
							}
							return new int[]{customer.age, choice, 1};
						}
						return new int[]{customer.age, choice, 0};
						
					case 6:
						if(kiosk.countProduct("PRODUCT_NAME_NEWSPAPER") > 0)
						{
							if(customer.willBuy(market.newspaperPrice, kiosk.getPrice(choice)))
							{
								kiosk.addCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_NEWSPAPER");
								return new int[]{customer.age, choice, 2};
							}
							return new int[]{customer.age, choice, 1};
						}
						return new int[]{customer.age, choice, 0};
				}
				
			
			return new int[]{customer.age, 0, -1};
		}
	}
	
	
	private int currentDay; 
	public final int maxDays;
	
	public Kiosk kiosk; 
	public Day day;
	
	
	public Simulation(Kiosk kiosk)
	{
		this.kiosk = kiosk;
		this.day = new Day();
		
		this.currentDay = 1;
		this.maxDays = 2;
	}
	
	
	
	public enum BuyProductResponse
	{
		Bought, 
		NotEnoughMoney,
		NotEnoughStorage
	}
	
	public BuyProductResponse buyCigarettes(int amount)
	{
		if(!kiosk.canStore(amount*this.day.market.cigarettes.size))
		{
			return BuyProductResponse.NotEnoughStorage;
		}
		
		if(!kiosk.canPay(amount*this.day.market.cigarettesPrice))
		{
			return BuyProductResponse.NotEnoughMoney;
		}
		
		for(int i = 0; i < amount; i++)
		{
			kiosk.addStorage(new Cigarettes(this.day.market.cigarettesPrice));
	        kiosk.addCash(-this.day.market.cigarettesPrice);

		}
		
		return BuyProductResponse.Bought;
	}
	
	public BuyProductResponse buyFries(int amount)
	{
	    if(!kiosk.canStore(amount * this.day.market.fries.size))
	    {
	        return BuyProductResponse.NotEnoughStorage;
	    }

	    if(!kiosk.canPay(amount * this.day.market.friesPrice))
	    {
	        return BuyProductResponse.NotEnoughMoney;
	    }

	    for(int i = 0; i < amount; i++)
	    {
	        kiosk.addStorage(new Fries(this.day.market.friesPrice));
	        kiosk.addCash(-this.day.market.friesPrice);

	    }

	    return BuyProductResponse.Bought;
	}

	public BuyProductResponse buyNewspaper(int amount)
	{
	    if(!kiosk.canStore(amount * this.day.market.newspaper.size))
	    {
	        return BuyProductResponse.NotEnoughStorage;
	    }

	    if(!kiosk.canPay(amount * this.day.market.newspaperPrice))
	    {
	        return BuyProductResponse.NotEnoughMoney;
	    }

	    for(int i = 0; i < amount; i++)
	    {
	        kiosk.addStorage(new Newspaper(this.day.market.newspaperPrice));
	        kiosk.addCash(-this.day.market.newspaperPrice);

	    }

	    return BuyProductResponse.Bought;
	}

	public BuyProductResponse buyGum(int amount)
	{
	    if(!kiosk.canStore(amount * this.day.market.gum.size))
	    {
	        return BuyProductResponse.NotEnoughStorage;
	    }

	    if(!kiosk.canPay(amount * this.day.market.gumPrice))
	    {
	        return BuyProductResponse.NotEnoughMoney;
	    }

	    for(int i = 0; i < amount; i++)
	    {
	        kiosk.addStorage(new Gum(this.day.market.gumPrice));
	        kiosk.addCash(-this.day.market.gumPrice);

	    }

	    return BuyProductResponse.Bought;
	}

	public BuyProductResponse buyIceCream(int amount)
	{
	    if(!kiosk.canStore(amount * this.day.market.iceCream.size))
	    {
	        return BuyProductResponse.NotEnoughStorage;
	    }

	    if(!kiosk.canPay(amount * this.day.market.iceCreamPrice))
	    {
	        return BuyProductResponse.NotEnoughMoney;
	    }

	    for(int i = 0; i < amount; i++)
	    {
	        kiosk.addStorage(new IceCream(this.day.market.iceCreamPrice));
	        kiosk.addCash(-this.day.market.iceCreamPrice);

	    }

	    return BuyProductResponse.Bought;
	}

	public BuyProductResponse buyLemonade(int amount)
	{
	    if(!kiosk.canStore(amount * this.day.market.lemonade.size))
	    {
	        return BuyProductResponse.NotEnoughStorage;
	    }

	    if(!kiosk.canPay(amount * this.day.market.lemonadePrice))
	    {
	        return BuyProductResponse.NotEnoughMoney;
	    }

	    for(int i = 0; i < amount; i++)
	    {
	        kiosk.addStorage(new Lemonade(this.day.market.lemonadePrice));
	        kiosk.addCash(-this.day.market.lemonadePrice);
	    }

	    return BuyProductResponse.Bought;
	}

	
	public int getCurrentDay()
	{
		return this.currentDay;
	}
	
	
	public int getWeather()
	{
		return this.day.weather;
	}

	
	public String getOwnerName()
	{
		return this.kiosk.ownerName;
	}
	
	
	public int getUsedStorageSize()
	{
		return this.kiosk.getUsedStorageSize();
	}
	
	public double getCash()
	{
		return this.kiosk.getCash();
	}
	
	public double getStartCash()
	{
		return this.kiosk.startCash;
	}
	
	
	public int countProduct(String product)
	{
		return this.kiosk.countProduct(product);
	}
	
	public int getMaxStorageSize()
	{
		return this.kiosk.storageSize;
	}
	
	public int getMaxDays()
	{
		return this.maxDays;
	}
	
	public boolean checkEndGame()
	{
		if(this.maxDays+1 == this.currentDay)
		{
			return true;
		}
		if(kiosk.getCash() == 0 && kiosk.getUsedStorageSize() == 0)
		{
			return true;
		}
		
		return false;
	}
	
	public double getPrice(int id)
	{
		return this.kiosk.getPrice(id);
	}
	
	
	public void setNewPrice(int id, double newPrice)
	{
		this.kiosk.setPrice(id, newPrice);
	}
	
	
	public void nextDay()
	{
		kiosk.ageStorage();	

		// Day ended
		this.currentDay += 1;
		day = new Day();		
	}
	
	public int[] getResponse()
	{
		return this.day.nextCustomer();
	}
	
	public int getCountCustomers()
	{
		return this.day.countCustomers;
	}
	
	public List<Product> getStorage()
	{
		return kiosk.storage;
	}
	
	public int getIceCreamSize()
	{
		return this.day.market.iceCream.size;
	}
	
	public int getCigarettesSize()
	{
		return this.day.market.cigarettes.size;
	}
	
	public int getFriesSize()
	{
		return this.day.market.fries.size;
	}
	
	public int getNewspaperSize()
	{
		return this.day.market.newspaper.size;
	}
	
	public int getGumSize()
	{
		return this.day.market.gum.size;
	}
	
	public int getLemonadeSize()
	{
		return this.day.market.lemonade.size;
	}
	
	public int getIceCreamExpiresDays()
	{
		return this.day.market.iceCream.expiresDays;
	}
	
	public int getCigarettesExpiresDays()
	{
		return this.day.market.cigarettes.expiresDays;
	}
	
	public int getGumExpiresDays()
	{
		return this.day.market.gum.expiresDays;
	}
	
	public int getFiresExpiresDays()
	{
		return this.day.market.fries.expiresDays;
	}
	
	public int getLemonadeExpiresDays()
	{
		return this.day.market.lemonade.expiresDays;
	}
	
	public int getNewspaperExpiresDays()
	{
	    return this.day.market.newspaper.expiresDays;
	}

	public int getFriesExpiresDays()
	{
	    return this.day.market.fries.expiresDays;
	}
	
	public double getIceCreamMarketPrice()
	{
	    return this.day.market.iceCreamPrice;
	}

	public double getGumMarketPrice()
	{
	    return this.day.market.gumPrice;
	}

	public double getNewspaperMarketPrice()
	{
	    return this.day.market.newspaperPrice;
	}

	public double getLemonadeMarketPrice()
	{
	    return this.day.market.lemonadePrice;
	}

	public double getCigarettesMarketPrice()
	{
	    return this.day.market.cigarettesPrice;
	}

	public double getFriesMarketPrice()
	{
		return this.day.market.friesPrice;
	}
	
}
