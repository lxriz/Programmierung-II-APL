package Controller;

import Model.Translation;
import Model.Simulation.*;

public class ControllerEnterUsernameMenu extends Controller
{
	Kiosk kiosk;
	Simulation sim;
	
	public ControllerEnterUsernameMenu(ViewManager vm, Translation trans)
	{
		super(vm, trans);
	}
	
	@Override
	public void setInput(int input)
	{
		vm.setInput(input);
	}
	
	
	public void setUserName(String name)
	{	
		this.kiosk = new Kiosk(name);
		this.sim = new Simulation(kiosk);
	}
}
