package Controller;

import Model.Translation;

public class ControllerLanguageMenu extends Controller
{
	public ControllerLanguageMenu(ViewManager vm, Translation trans)
	{
		super(vm, trans);
	}
	
	
	@Override
	public void setInput(int input)
	{
		if(input == 0)
		{
			vm.setInput(input);
		}
		else
		{
			trans.selectLanguage(trans.getSuppoertedLanguages()[input-1]);
			vm.setInput(-1);
		}
	}
	
	
	public String[] getSupportedLanguages()
	{
		return trans.getSuppoertedLanguages();
	}
}
