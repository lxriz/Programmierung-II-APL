package Controller;

import Model.Translation;
import Model.Simulation.Simulation;

public class ControllerSimulationMenu extends ControllerSimulation
{
	
	public ControllerSimulationMenu(ViewManager vm, Translation trans, Simulation sim)
	{
		super(vm, trans, sim);
	}
	
	
	@Override
	public void setInput(int input)
	{
		vm.setInput(input);
	}
	
}
