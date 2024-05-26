package Controller;

import Model.Translation;

/**
 * A controller for managing language selection in the application menu.
 * Extends the Controller class.
 */
public class ControllerLanguageMenu extends Controller 
{

    /**
     * Instantiates a new ControllerLanguageMenu.
     *
     * @param vm The ViewManager object.
     * @param trans The Translation object.
     */
    public ControllerLanguageMenu(ViewManager vm, Translation trans) 
    {
        super(vm, trans);
    }

    /**
     * Sets the input based on the selected option.
     *
     * @param input The selected input.
     */
    @Override
    public void setInput(int input) 
    {
        if (input == 0) 
        {
            vm.setInput(input);
        } 
        else 
        {
            trans.selectLanguage(trans.getSupportedLanguages()[input - 1]);
            vm.setInput(-1);
        }
    }

    /**
     * Gets the supported languages.
     *
     * @return The supported languages.
     */
    public String[] getSupportedLanguages() 
    {
        return trans.getSupportedLanguages();
    }
}

