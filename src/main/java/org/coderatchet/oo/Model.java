package org.coderatchet.oo;

public class Model {
	private String name;
	
	public Model(String name) {
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
