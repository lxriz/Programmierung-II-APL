package Controller;

import Model.Translation;


/**
 * An abstract class that serves as a base for controllers in the application.
 * Implements the InterfaceController interface.
 */
public abstract class Controller implements InterfaceController {

    /** The Translation object for handling translations. */
    public Translation trans;
    
    /** The ViewManager object for managing views. */
    public ViewManager vm;

    /**
     * Constructs a new Controller with the specified ViewManager and Translation objects.
     *
     * @param vm The ViewManager object.
     * @param trans The Translation object.
     */
    public Controller(ViewManager vm, Translation trans) {
        this.vm = vm;
        this.trans = trans;
    }

    /**
     * Gets the translated text for the specified key.
     *
     * @param key The key for translation.
     * @return The translated text, or "* ERROR *" if no translation is found.
     */
    public String getTrans(String key) {
        return trans.getText(key);
    }

}
