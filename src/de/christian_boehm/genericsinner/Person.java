package de.christian_boehm.genericsinner;

public class Person {
	private String name;

	public Person(String firstName, String lastName) {
		name = firstName + "," + lastName;
	}

	String getFirstName() {
		int index = name.indexOf(',');
		return name.substring(0, index);
	}

	String getLastName() {
		int index = name.indexOf(',');
		return name.substring(index + 1);
	}
}