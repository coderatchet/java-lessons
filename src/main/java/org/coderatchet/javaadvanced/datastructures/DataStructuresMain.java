package org.coderatchet.javaadvanced.datastructures;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;

public class DataStructuresMain {
	public static void main(String[] args) {
		enumExample();
		bitSetExample();
		vectorExample();
		stackExample();
	}
	
	public static void enumExample() {
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
	
	public static void bitSetExample() {
		BitSet myFavoriteBits = new BitSet(8);
		myFavoriteBits.set(0);
		myFavoriteBits.set(3);
		myFavoriteBits.or(BitSet.valueOf(new byte[] {0b01010101})); // binary literal
		
		System.out.println("my favorite bits are: " + myFavoriteBits);
	}
	
	public static void vectorExample() {
		Vector<String> vector = new Vector<String>();
		vector.add("Hello, ");
		vector.add("vector ");
		vector.add("world");
		vector.add("!");
		vector.forEach(a -> System.out.print(a)); // like `for (String a: vector) { /* do something with a */ }`
	}
	
	public static void stackExample() {
		Stack<String> stack = new Stack<String>();
		stack.push("!");
		stack.push("world");
		stack.push("stack ");
		stack.push("Hello, ");
		while(!stack.empty()) {
			System.out.print(stack.pop());
		}
	}
}
