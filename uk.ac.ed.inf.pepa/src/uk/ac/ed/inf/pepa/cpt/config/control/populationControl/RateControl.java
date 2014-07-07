package uk.ac.ed.inf.pepa.cpt.config.control.populationControl;

import uk.ac.ed.inf.pepa.cpt.config.control.PopulationControl;
import uk.ac.ed.inf.pepa.cpt.config.lists.RateList;

public class RateControl extends PopulationControl {

	private RateList myRateList;

	public RateControl(RateList componentList) {
		this.myRateList = componentList;
	}
	
	public String[] getKeys(){
		return this.myRateList.getYKeys();
	}
	
	public String[] getXKeys(String component){
		return this.myRateList.getXKeys(component);
	}
	
	public boolean setValue(String component, String key, String value){
		return this.myRateList.setValue(component, key, value);
	}
	
	public String getValue(String component, String key){
		return this.myRateList.getValue(component, key);
	}
	
	public boolean validate(){
		return this.myRateList.valid();
	}

	@Override
	public String getType(String key, String attribute) {
		return this.myRateList.getType(key, attribute);
	}

}