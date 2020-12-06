package de.christian_boehm.serialize;

import java.io.Serializable;

public class ArrayListAddressBook implements Serializable, AddressBook{
	private java.util.ArrayList<Person> persons;
	
	public ArrayListAddressBook(int initialCapacity) {
		initialCapacity = initialCapacity < 1 ? 1 : initialCapacity;
		persons = new java.util.ArrayList<Person>(initialCapacity);
	}

	public void addPerson(Person person) {
		persons.add(person);
	}

	public void print() {
		for (Person person : persons) {
			System.out.println(person.getName());
		}
		
	}

}
