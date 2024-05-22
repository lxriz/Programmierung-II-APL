package Controller;

import Model.*;

public class ControllerMainMenu extends Controller
{
	public ControllerMainMenu(ViewManager vm, Translation trans)
	{
		super(vm, trans);
	}
	
	
	@Override
	public void getInput(int input)
	{
		vm.setInput(input);
	}
	
}
