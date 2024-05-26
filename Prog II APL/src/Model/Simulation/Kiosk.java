package Model.Simulation;

import java.util.ArrayList;
import java.util.List;
import Model.Simulation.Products.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a kiosk.
 */
public class Kiosk 
{

    /** The amount of cash in the kiosk. */
    private double cash;

    /** The name of the owner of the kiosk. */
    public final String ownerName;

    /** The amount of used storage in the kiosk. */
    private int usedStorage;

    /** The total storage size of the kiosk. */
    public final int storageSize;

    /** The list of products stored in the kiosk. */
    public List<Product> storage;

    /** The starting cash of the kiosk. */
    public final double startCash = 25;

    /** The array of prices for different products. */
    private double[] prices = new double[6];

    /**
     * Constructs a new Kiosk object with the specified owner name and initializes other attributes.
     *
     * @param ownerName The name of the owner of the kiosk.
     */
    public Kiosk(String ownerName) 
    {
        this.ownerName = ownerName;
        this.cash = startCash;
        this.usedStorage = 0;
        this.storageSize = 50;
        this.storage = new ArrayList<>();
    }

    /**
     * Sets the price for a product.
     *
     * @param index The index of the product (1 to 6).
     * @param newPrice The new price for the product.
     * @return True if the price is successfully set, false otherwise.
     */
    public boolean setPrice(int index, double newPrice) 
    {
        index--;
        if (newPrice >= 0 && index >= 0 && index < prices.length)
        {
            prices[index] = newPrice;
            return true;
        }
        return false;
    }

    /**
     * Gets the price of a product.
     *
     * @param index The index of the product (1 to 6).
     * @return The price of the product.
     */
    public double getPrice(int index)
    {
        index--;
        if (index >= 0 && index < prices.length)
        {
            return prices[index];
        }
        return -1;
    }

    /**
     * Checks if the kiosk can pay a given amount of change.
     *
     * @param change The amount of change required.
     * @return True if the kiosk can pay the change, false otherwise.
     */
    public boolean canPay(double change)
    {
        return this.cash - change >= 0;
    }

    /**
     * Adds cash to the kiosk.
     *
     * @param change The amount of cash to add.
     */
    public void addCash(double change)
    {
    	cash += change;
    }

    /**
     * Gets the current amount of cash in the kiosk.
     *
     * @return The amount of cash in the kiosk.
     */
    public double getCash()
    {
        return this.cash;
    }

    /**
     * Counts the number of a specific product in the kiosk's storage.
     *
     * @param name The name of the product to count.
     * @return The number of the specified product in the storage.
     */
    public int countProduct(String name)
    {
        int sum = 0;
        for (Product product : storage)
        {
            if (name.equals(product.name)) 
            {
                sum++;
            }
        }
        return sum;
    }

    /**
     * Checks if the kiosk can store a given number of products.
     *
     * @param toStore The number of products to store.
     * @return True if the kiosk can store the products, false otherwise.
     */
    public boolean canStore(int toStore)
    {
        return this.usedStorage + toStore <= this.storageSize && this.usedStorage + toStore >= 0;
    }

    /**
     * Updates the used storage size of the kiosk.
     *
     * @param toStore The number of products to add or remove from the storage.
     * @return True if the storage size is successfully updated, false otherwise.
     */
    private boolean setStorageSize(int toStore)
    {
        if (canStore(toStore)) 
        {
            usedStorage += toStore;
            return true;
        }
        return false;
    }

    /**
     * Gets the used storage size of the kiosk.
     *
     * @return The used storage size.
     */
    public int getUsedStorageSize()
    {
        return this.usedStorage;
    }

    /**
     * Adds a product to the kiosk's storage.
     *
     * @param product The product to add.
     * @return True if the product is successfully added, false otherwise.
     */
    public boolean addStorage(Product product) 
    {
        if (setStorageSize(product.size))
        {
            storage.add(product);
            return true;
        }
        return false;
    }

    /**
     * Removes a product from the kiosk's storage.
     *
     * @param name The name of the product to remove.
     * @return True if the product is successfully removed, false otherwise.
     */
    public boolean removeFromStorage(String name) 
    {
        for (Product product : storage) {
            if (name.equals(product.name)) {
                if (setStorageSize(-product.size)) {
                    storage.remove(product);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Ages the products in the kiosk's storage by decrementing their expiration days.
     * Removes expired products from the storage.
     */
    /**
     * Ages the products in the kiosk's storage by decrementing their expiration days.
     * Removes expired products from the storage.
     */
    public void ageStorage() 
    {
        for (int i = 0; i < storage.size(); i++) 
        {
            storage.get(i).expiresDays -= 1;

            if (storage.get(i).expiresDays == 0) 
            {
                setStorageSize(-storage.get(i).size);
                storage.remove(storage.get(i));
                i--;
            }
        }
    }

}
