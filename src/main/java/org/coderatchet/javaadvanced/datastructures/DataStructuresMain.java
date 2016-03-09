package org.coderatchet.javaadvanced.datastructures;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class DataStructuresMain {
	public static void main(String[] args) {
		daysOfWeekExample();
	}
	
	public static void daysOfWeekExample() {
		for(DaysOfWeek day: DaysOfWeek.values()) {
			System.out.println(day + " will be sunny!");
		}
		Vector<DaysOfWeek> vector = new Vector<DaysOfWeek>(Arrays.asList(DaysOfWeek.values()));
		Enumeration<DaysOfWeek> itr = vector.elements();
		System.out.println("\nThe days are:");
		while(itr.hasMoreElements()) {
			System.out.println("  * " + itr.nextElement());
		}
	}
}
