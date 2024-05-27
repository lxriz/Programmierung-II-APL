package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Translation;
import Model.Simulation.Simulation;
import Model.Simulation.Products.Product;


/**
 * The ControllerSimulationStorageMenu class extends ControllerSimulation and manages the storage of products in a simulation.
 */
public class ControllerSimulationStorageMenu extends ControllerSimulation
{
    private List<Product> storage;

    /**
     * Constructs a ControllerSimulationStorageMenu object with the specified ViewManager, Translation, and Simulation.
     * 
     * @param vm the view manager
     * @param trans the translation manager
     * @param sim the simulation instance
     */
    public ControllerSimulationStorageMenu(ViewManager vm, Translation trans, Simulation sim)
    {
        super(vm, trans, sim);
        this.storage = new ArrayList<>(sim.getStorage());
    }

    /**
     * Sets the input value for the view manager.
     * 
     * @param input the input value
     */
    @Override
    public void setInput(int input)
    {
        vm.setInput(input);
    }

    /**
     * Sorts the storage list by expiration dates in ascending order.
     */
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

    /**
     * Sorts the storage list by product names in ascending order.
     */
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

    /**
     * Returns the list of products in storage.
     * 
     * @return the storage list
     */
    public List<Product> getStorage()
    {
        return this.storage;
    }
}

