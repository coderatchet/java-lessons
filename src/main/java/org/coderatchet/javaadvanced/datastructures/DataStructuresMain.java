package org.coderatchet.javaadvanced.datastructures;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.coderatchet.oo.Car;
import org.coderatchet.oo.HoldenCommodore;
import org.coderatchet.oo.Manufacturer;
import org.coderatchet.oo.Model;

public class DataStructuresMain {
	public static void main(String[] args) {
//		enumExample();
//		bitSetExample();
//		vectorExample();
//		stackExample();
//		queueExample();
//		hashTableExample();
		propertiesExample();
	}
	
	public static void enumExample() {
		for(DaysOfWeek day: DaysOfWeek.values()) {
			System.out.println(day + " will be sunny!");
		}
		
		DaysOfWeek monday = DaysOfWeek.valueOf("MONDAY");
		System.out.println("\n\n\\sheesh, it's " + monday + "\n");
		
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
		myFavoriteBits.or(BitSet.valueOf(new byte[] {0b01010101})); 
		
		// binary literal
		// 00001001 or    01010101 and   01010101 xor
		// 01010101       11110000       01101101
		// --------       --------       --------
		// 01011101       01010000       00111000
		
		System.out.println("my favorite bits are: " + myFavoriteBits);
	}
	
	public static void vectorExample() {
		Vector<String> vector = new Vector<>();
		vector.add("Hello, ");
		vector.add("vector ");
		vector.add("world");
		vector.add("!");
		vector.forEach(a -> System.out.print(a)); // like `for (String a: vector) { /* do something with a */ }`
	}
	
	public static void stackExample() {
		Stack<String> stack = new Stack<String>(); // LIFO Last In First Out
		stack.push("!");
		stack.push("world");
		stack.push("stack ");
		stack.push("Hello, ");
		while(!stack.empty()) {
			System.out.print(stack.pop()); // peek if you don't want to remove it but want to see it.
		}
	}
	
	public static void queueExample() {
		Queue<String> queue = new ConcurrentLinkedQueue<>();
		queue.add("Hello, ");
		queue.add("queue ");
		queue.add("world");
		queue.add("!");
		while(!queue.isEmpty()){ // ! means not <condition>
			System.out.print(queue.poll());
		}
	}
	
	public static void hashTableExample() {
		Dictionary<String, Car> cars = new Hashtable<>();
		
		Car holden = new HoldenCommodore("woosh");
		Car truck = new Car(new Model("MEGAMONSTER"), new Manufacturer("IZUZU"));
		
		cars.put(holden.model().getName(), holden);
		cars.put(truck.model().getName(), truck);
		
		Car search = cars.get("MEGAMONSTER");
		System.out.println("got the car: " + search);
	}
	
	public static void propertiesExample() {
		Properties props = new Properties();
		FileWriter writer = null;
		FileReader reader = null;
		try {
			reader = new FileReader("data/props.properties");
			writer = new FileWriter("data/moreProps.properties");
			props.load(reader);
			System.out.println("foo=" + props.get("foo"));
			
			props.setProperty("baz", "foo");
			props.store(writer, "just testing things out");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException ignore) {
				}
			}
			if (null != writer) {
				try {
					writer.close();
				} catch (IOException ignore) {
				}
			}
		}
	}
}
