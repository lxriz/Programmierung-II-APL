package Model.Simulation;

import java.util.Random;


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
								kiosk.setCash(kiosk.getPrice(choice));
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
								kiosk.setCash(kiosk.getPrice(choice));
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
								kiosk.setCash(kiosk.getPrice(choice));
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
								kiosk.setCash(kiosk.getPrice(choice));
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
								kiosk.setCash(kiosk.getPrice(choice));
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
								kiosk.setCash(kiosk.getPrice(choice));
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
		this.maxDays = 21;
	}
	
	// GETS
	
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
