package org.coderatchet.javaadvanced.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsMain {
	public static void main(String[] args) {
		collectionExample();
		listExample();
		setAndInevitablySortedSetExample();
		mapExample();
	}

	public static void collectionExample() {
		Collection<String> collection = new ArrayList<>();
		collection.add("something1");
		collection.add("something2");
		collection.add("something3");
		collection.add("something4");
		collection.add("something5");
		collection.add("something6");
		// collection.get(index) not avaiable
		collection.forEach(str -> System.out.println(str));
	}

	public static void listExample() {
		List<String> list = new ArrayList<>();
		list.add("lalala 6");
		list.add("lalala 5");
		list.add("lalala 4");
		list.add("lalala 3");
		list.add("lalala 2");
		list.add("lalala 1");

		list.remove(4);

		System.out.println("item number 2 is: " + list.get(2));
		try {
			System.out.println("item number 5 is: " + list.get(5));
		} catch (Exception e) {
			System.out
					.println("5 is out of bounds! remember? I removed one item");
		}
	}

	public static void setAndInevitablySortedSetExample() {
		Set<String> set = new HashSet<>();

		set.add("c");
		set.add("b");
		set.add("a");
		set.add("c");

		set.forEach(a -> System.out.println(a + " "));
	}

	public static void mapExample() {
		Map<String, String> favoriteRecipes = new HashMap<>();
		favoriteRecipes.put("lemons", "lemonade");
		favoriteRecipes.put("oranges", "marmalade");
		favoriteRecipes.put("strawberries", "strawbalade");
		favoriteRecipes.put("lemons", "lemon meringue"); // overwrites lemons
															// entry

		favoriteRecipes.entrySet().forEach(
				e -> System.out.println("my favorite recipe for " + e.getKey() + " is "
						+ e.getValue()));
	}
}
