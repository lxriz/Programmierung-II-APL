package Controller;

import Model.Translation;

public class ControllerHighscoreMenu extends Controller
{
	public ControllerHighscoreMenu(ViewManager vm, Translation trans)
	{
		super(vm, trans);
	}
	
	 
	@Override
	public void getInput(int input)
	{
		vm.setInput(input);;
	}
}
