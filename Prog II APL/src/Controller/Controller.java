package Controller;

import Model.Translation;


public abstract class Controller implements InterfaceController
{
	public Translation trans;
	public ViewManager vm;
	
	
	public Controller(ViewManager vm, Translation trans)
	{
		this.vm = vm;
		this.trans = trans;
	}
	
	
	public String getTrans(String key)
	{
		return trans.getText(key);
	}
	
}
