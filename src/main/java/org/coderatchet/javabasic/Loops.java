package org.coderatchet.javabasic;

public class Loops {
	public static void main(String[] args) {
		char[] arr = new char[10];		
		
		// for
		for(int i = 0;i < arr.length;i++) {
			arr[i] = '0';
			System.out.println("howdy");			
		}

		// foreach
		for(char a: arr){
			System.out.println(a);
		}
		
		// while
		int j = 0;
		while (true) {
			//do something
			if(++j > 10) break;
			System.out.println("J be like: " + j);
		}
		
		// do while
		do {
			System.out.println("but i'm like totally here.");
		} while (false);
	}
}
