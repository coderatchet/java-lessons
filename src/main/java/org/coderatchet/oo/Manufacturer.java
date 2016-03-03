package org.coderatchet.oo;

public class Manufacturer {
	private String name;
	
	public Manufacturer(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}	
}
