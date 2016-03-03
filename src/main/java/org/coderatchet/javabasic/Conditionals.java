package org.coderatchet.javabasic;

public class Conditionals {
	public static void main(String[] args) {
		String value = "something";
		switch (value) {
		case "something":
			System.out.println("found a string man");
			System.out.println("another thing");
			break;
		case "not something":
			System.out.println("I shouldn't be something man");
			break;
		default:
			break;
		}
	}
}
