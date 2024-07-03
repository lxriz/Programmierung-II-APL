package Controller;

/*
 * Author: Loris Leopold Kulke (S87072) 
 * 
 * Version: 1.0
 * 
 * Description:
 * This is a simple Kiosk game simulation.
 * Your goal is to manage a kiosk and earn as much money as possible
 * in two weeks. 
 * 
 * 
 * ToDo:
 * - The simulation parameters like the price variation 
 * are not fully balanced yet. 
 * - With different languages, the UI can be disturbed
 * because of different word lengths. 
 */

/**
 * The main class of the application.
 */
public class Main 
{

    /**
     * The entry point of the application.
     *
     * @param args The command line arguments.
     */
    public void main(String args[]) 
    {
        // Create a new ViewManager instance
        ViewManager vm = new ViewManager();
        
        // Initialize the ViewManager
        vm.init();        
    }
}

