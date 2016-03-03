package org.coderatchet.oo;

public class HoldenCommodore extends Car {
	
	private String burnoutSound;

	public HoldenCommodore(String burnoutSound) {
		super(new Model("Commodore"), new Manufacturer("Holden"));
		this.burnoutSound = burnoutSound;
	}
	
	@Override
	public Model model() {
		return new Model("I don't listen to anyone, but alas, I am a :" + super.model().getName());
	}
	
	public void doBurnouts() {
		System.out.println("i go " + burnoutSound);
	}
}
