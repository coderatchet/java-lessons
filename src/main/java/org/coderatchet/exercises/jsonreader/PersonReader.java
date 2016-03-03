package org.coderatchet.exercises.jsonreader;

// ?
public class PersonReader implements PeopleSource, JSONToPersonTranslator {
	
	// what kind of variables should a json reader have?
	
	public PersonReader(/* what should go here? */) {
		// hint: you can access any file relative to the root dir of this project. i.e. "data/data.json"
	}
	
	@Override
	public Person[] getPeople() {
		// TODO
		return null;
	}

	@Override
	public Person fromJSONObject(String json) {
		// TODO
		return null;
	}
	
	public static void main(String[] args) {
		// call your code from here
	}
	
}
