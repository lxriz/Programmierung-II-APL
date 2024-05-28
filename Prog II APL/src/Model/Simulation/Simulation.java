package Model.Simulation;

import java.util.List;
import java.util.Random;
import Model.Simulation.Products.*;


public class Simulation 
{
    /**
     * Represents a single day in the simulation with specific weather conditions
     * and customer interactions.
     */
    public class Day
    {
        // 0 - Rainy
        // 1 - Cloudy
        // 2 - Sunny
        public final int weather;
        public Market market;
        public final int countCustomers;
        private static Random r = new Random();

        /**
         * Constructs a new Day with random weather and customer count based on the weather.
         */
        public Day()
        {
            this.weather = (int)(r.nextInt(3));
            market = new Market(this.weather);
            countCustomers = r.nextInt(20, (int)(40+10*weather));
        }

        /**
         * Simulates the interaction with the next customer.
         * @return an array with the product id and transaction result.
         */
        public int[] nextCustomer()
        {
            /** Response [product_id, transaction] */
            
            Customer customer = new Customer(weather);
            
            /** The choice represents the int value in the array. */
            // 0 - Cigarettes
            // 1 - Fries
            // 2 - Gum
            // 3 - IceCream
            // 4 - Lemonade
            // 5 - Newspaper
            int choice = customer.chooseProcduct();
            choice++;
                        
            enum CustomerAction
            {
                NotInStock,
                TooExpensive,
                Bought
            }
            
            switch(choice)
            {
            case 1:
                if(kiosk.countProduct("PRODUCT_NAME_CIGARETTES") > 0)
                {
                    if(customer.willBuy(market.cigarettesPrice, kiosk.getPrice(choice)))
                    {
                        kiosk.addCash(kiosk.getPrice(choice));
                        kiosk.removeFromStorage("PRODUCT_NAME_CIGARETTES");
                        return new int[]{choice, CustomerAction.Bought.ordinal()};
                    }
                    return new int[]{choice, CustomerAction.TooExpensive.ordinal()};
                }
                return new int[]{choice, CustomerAction.NotInStock.ordinal()};
                
            case 2:
                if(kiosk.countProduct("PRODUCT_NAME_FRIES") > 0)
                {
                    if(customer.willBuy(market.friesPrice, kiosk.getPrice(choice)))
                    {
                        kiosk.addCash(kiosk.getPrice(choice));
                        kiosk.removeFromStorage("PRODUCT_NAME_FRIES");
                        return new int[]{choice, CustomerAction.Bought.ordinal()};
                    }
                    return new int[]{choice, CustomerAction.TooExpensive.ordinal()};
                }    
                return new int[]{choice, CustomerAction.NotInStock.ordinal()};
                
            case 3:
                if(kiosk.countProduct("PRODUCT_NAME_GUM") > 0)
                {
                    if(customer.willBuy(market.gumPrice, kiosk.getPrice(choice)))
                    {
                        kiosk.addCash(kiosk.getPrice(choice));
                        kiosk.removeFromStorage("PRODUCT_NAME_GUM");
                        return new int[]{choice, CustomerAction.Bought.ordinal()};
                    }
                    return new int[]{choice, CustomerAction.TooExpensive.ordinal()};
                }        
                return new int[]{choice, CustomerAction.NotInStock.ordinal()};
                
            case 4:
                if(kiosk.countProduct("PRODUCT_NAME_ICE_CREAM") > 0)
                {
                    if(customer.willBuy(market.iceCreamPrice, kiosk.getPrice(choice)))
                    {
                        kiosk.addCash(kiosk.getPrice(choice));
                        kiosk.removeFromStorage("PRODUCT_NAME_ICE_CREAM");
                        return new int[]{choice, CustomerAction.Bought.ordinal()};
                    }
                    return new int[]{choice, CustomerAction.TooExpensive.ordinal()};
                }
                return new int[]{choice, CustomerAction.NotInStock.ordinal()};
                
            case 5:
                if(kiosk.countProduct("PRODUCT_NAME_LEMONADE") > 0)
                {
                    if(customer.willBuy(market.lemonadePrice, kiosk.getPrice(choice)))
                    {
                        kiosk.addCash(kiosk.getPrice(choice));
                        kiosk.removeFromStorage("PRODUCT_NAME_LEMONADE");
                        return new int[]{choice, CustomerAction.Bought.ordinal()};
                    }
                    return new int[]{choice, CustomerAction.TooExpensive.ordinal()};
                }
                return new int[]{choice, CustomerAction.NotInStock.ordinal()};
                
            case 6:
                if(kiosk.countProduct("PRODUCT_NAME_NEWSPAPER") > 0)
                {
                    if(customer.willBuy(market.newspaperPrice, kiosk.getPrice(choice)))
                    {
                        kiosk.addCash(kiosk.getPrice(choice));
                        kiosk.removeFromStorage("PRODUCT_NAME_NEWSPAPER");
                        return new int[]{choice, CustomerAction.Bought.ordinal()};
                    }
                    return new int[]{choice, CustomerAction.TooExpensive.ordinal()};
                }
                return new int[]{choice, CustomerAction.NotInStock.ordinal()};
            }
            
            return new int[]{-1, -1};
        }
    }
    
    private int currentDay; 
    public final int maxDays;
    public Kiosk kiosk; 
    public Day day;
    
    /**
     * Constructs a new Simulation with a given kiosk.
     * @param kiosk the Kiosk object to be used in the simulation.
     */
    public Simulation(Kiosk kiosk)
    {
        this.kiosk = kiosk;
        this.day = new Day();
        this.currentDay = 1;
        this.maxDays = 14;
    }
    
    /**
     * Enum representing the response of buying a product.
     */
    public enum BuyProductResponse
    {
        Bought, 
        NotEnoughMoney,
        NotEnoughStorage
    }
    
    /**
     * Buys a specified amount of cigarettes.
     * @param amount the amount of cigarettes to buy.
     * @return the response of the purchase attempt.
     */
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
    
    /**
     * Buys a specified amount of fries.
     * @param amount the amount of fries to buy.
     * @return the response of the purchase attempt.
     */
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

    /**
     * Buys a specified amount of newspapers.
     * @param amount the amount of newspapers to buy.
     * @return the response of the purchase attempt.
     */
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

    /**
     * Buys a specified amount of gum.
     * @param amount the amount of gum to buy.
     * @return the response of the purchase attempt.
     */
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

    /**
     * Buys a specified amount of ice cream.
     * @param amount the amount of ice cream to buy.
     * @return the response of the purchase attempt.
     */
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

    /**
     * Buys a specified amount of lemonade.
     * @param amount the amount of lemonade to buy.
     * @return the response of the purchase attempt.
     */
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

    /**
     * Gets the current day in the simulation.
     * @return the current day.
     */
    public int getCurrentDay()
    {
        return this.currentDay;
    }

    /**
     * Gets the weather of the current day.
     * @return the weather as an integer.
     */
    public int getWeather()
    {
        return this.day.weather;
    }

    /**
     * Gets the owner's name of the kiosk.
     * @return the owner's name.
     */
    public String getOwnerName()
    {
        return this.kiosk.ownerName;
    }

    /**
     * Gets the used storage size of the kiosk.
     * @return the used storage size.
     */
    public int getUsedStorageSize()
    {
        return this.kiosk.getUsedStorageSize();
    }

    /**
     * Gets the current cash of the kiosk.
     * @return the current cash.
     */
    public double getCash()
    {
        return this.kiosk.getCash();
    }

    /**
     * Gets the starting cash of the kiosk.
     * @return the starting cash.
     */
    public double getStartCash()
    {
        return this.kiosk.startCash;
    }

    /**
     * Counts the quantity of a specific product in the kiosk.
     * @param product the name of the product.
     * @return the quantity of the product.
     */
    public int countProduct(String product)
    {
        return this.kiosk.countProduct(product);
    }

    /**
     * Gets the maximum storage size of the kiosk.
     * @return the maximum storage size.
     */
    public int getMaxStorageSize()
    {
        return this.kiosk.storageSize;
    }

    /**
     * Gets the maximum number of days for the simulation.
     * @return the maximum number of days.
     */
    public int getMaxDays()
    {
        return this.maxDays;
    }

    /**
     * Checks if the simulation should end.
     * @return true if the simulation should end, false otherwise.
     */
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

    /**
     * Gets the price of a product by its ID.
     * @param id the ID of the product.
     * @return the price of the product.
     */
    public double getPrice(int id)
    {
        return this.kiosk.getPrice(id);
    }

    /**
     * Sets a new price for a product by its ID.
     * @param id the ID of the product.
     * @param newPrice the new price to be set.
     */
    public void setNewPrice(int id, double newPrice)
    {
        this.kiosk.setPrice(id, newPrice);
    }

    /**
     * Advances the simulation to the next day.
     */
    public void nextDay()
    {
        kiosk.ageStorage();    

        // Day ended
        this.currentDay += 1;
        day = new Day();        
    }

    /**
     * Gets the response of the next customer interaction.
     * @return an array with the product id and transaction result.
     */
    public int[] getResponse()
    {
        return this.day.nextCustomer();
    }

    /**
     * Gets the count of customers for the current day.
     * @return the count of customers.
     */
    public int getCountCustomers()
    {
        return this.day.countCustomers;
    }

    /**
     * Gets the list of products in the kiosk's storage.
     * @return the list of products.
     */
    public List<Product> getStorage()
    {
        return kiosk.storage;
    }

    /**
     * Gets the size of ice cream in the market.
     * @return the size of ice cream.
     */
    public int getIceCreamSize()
    {
        return this.day.market.iceCream.size;
    }

    /**
     * Gets the size of cigarettes in the market.
     * @return the size of cigarettes.
     */
    public int getCigarettesSize()
    {
        return this.day.market.cigarettes.size;
    }

    /**
     * Gets the size of fries in the market.
     * @return the size of fries.
     */
    public int getFriesSize()
    {
        return this.day.market.fries.size;
    }

    /**
     * Gets the size of newspapers in the market.
     * @return the size of newspapers.
     */
    public int getNewspaperSize()
    {
        return this.day.market.newspaper.size;
    }

    /**
     * Gets the size of gum in the market.
     * @return the size of gum.
     */
    public int getGumSize()
    {
        return this.day.market.gum.size;
    }

    /**
     * Gets the size of lemonade in the market.
     * @return the size of lemonade.
     */
    public int getLemonadeSize()
    {
        return this.day.market.lemonade.size;
    }

    /**
     * Gets the expiration days of ice cream in the market.
     * @return the expiration days of ice cream.
     */
    public int getIceCreamExpiresDays()
    {
        return this.day.market.iceCream.expiresDays;
    }

    /**
     * Gets the expiration days of cigarettes in the market.
     * @return the expiration days of cigarettes.
     */
    public int getCigarettesExpiresDays()
    {
        return this.day.market.cigarettes.expiresDays;
    }

    /**
     * Gets the expiration days of gum in the market.
     * @return the expiration days of gum.
     */
    public int getGumExpiresDays()
    {
        return this.day.market.gum.expiresDays;
    }

    /**
     * Gets the expiration days of fries in the market.
     * @return the expiration days of fries.
     */
    public int getFiresExpiresDays()
    {
        return this.day.market.fries.expiresDays;
    }

    /**
     * Gets the expiration days of lemonade in the market.
     * @return the expiration days of lemonade.
     */
    public int getLemonadeExpiresDays()
    {
        return this.day.market.lemonade.expiresDays;
    }

    /**
     * Gets the expiration days of newspapers in the market.
     * @return the expiration days of newspapers.
     */
    public int getNewspaperExpiresDays()
    {
        return this.day.market.newspaper.expiresDays;
    }

    /**
     * Gets the expiration days of fries in the market.
     * @return the expiration days of fries.
     */
    public int getFriesExpiresDays()
    {
        return this.day.market.fries.expiresDays;
    }

    /**
     * Gets the market price of ice cream.
     * @return the market price of ice cream.
     */
    public double getIceCreamMarketPrice()
    {
        return this.day.market.iceCreamPrice;
    }

    /**
     * Gets the market price of gum.
     * @return the market price of gum.
     */
    public double getGumMarketPrice()
    {
        return this.day.market.gumPrice;
    }

    /**
     * Gets the market price of newspapers.
     * @return the market price of newspapers.
     */
    public double getNewspaperMarketPrice()
    {
        return this.day.market.newspaperPrice;
    }

    /**
     * Gets the market price of lemonade.
     * @return the market price of lemonade.
     */
    public double getLemonadeMarketPrice()
    {
        return this.day.market.lemonadePrice;
    }

    /**
     * Gets the market price of cigarettes.
     * @return the market price of cigarettes.
     */
    public double getCigarettesMarketPrice()
    {
        return this.day.market.cigarettesPrice;
    }

    /**
     * Gets the market price of fries.
     * @return the market price of fries.
     */
    public double getFriesMarketPrice()
    {
        return this.day.market.friesPrice;
    }

}

