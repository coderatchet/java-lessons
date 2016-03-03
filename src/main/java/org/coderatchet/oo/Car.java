package org.coderatchet.oo;

public class Car extends Vehicle {
	private Model model;
	private Manufacturer manufacturer;
	
	public Car(Model model, Manufacturer manufacturer) {
		this.model = model;
		this.manufacturer = manufacturer;
	}

	@Override
	public Model model() {
		return model;
	}

	@Override
	public Manufacturer manufacturer() {
		return manufacturer;
	}
}
