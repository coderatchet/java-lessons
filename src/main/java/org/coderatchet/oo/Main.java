package org.coderatchet.oo;

public class Main {
	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[3];
		vehicles[0] = new Car(new Model("fordski"), new Manufacturer("Ford"));
		vehicles[1] = new HoldenCommodore("woooooosh");
		vehicles[2] = new DumpTruck();
		
		for(Vehicle v: vehicles) {
			System.out.println("Man: " + v.manufacturer() + " and model: " + v.model());
			if (v instanceof DumpTruck) {
				DumpTruck dt = (DumpTruck) v;
				dt.dumpLoad();
			}
			if (v instanceof HoldenCommodore) {
				HoldenCommodore dt = (HoldenCommodore) v;
				dt.doBurnouts();
			}
		}
	}
}
