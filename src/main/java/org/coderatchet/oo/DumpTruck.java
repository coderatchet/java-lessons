package org.coderatchet.oo;

public class DumpTruck extends Vehicle {

	@Override
	public Model model() {
		return new Model("dumpomatic 5000");
	}

	@Override
	public Manufacturer manufacturer() {
		return new Manufacturer("Dumpalot inc.");
	}
	
	public void dumpLoad(){ 
		System.out.println("dumpin");
	}

}
