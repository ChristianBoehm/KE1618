package de.christian_boehm.genericsinner;

public class LinkedListAddressBook {
	private LinkedList1618Improved<Person> personList;

	public LinkedListAddressBook() {
		personList = new LinkedList1618Improved<Person>();
	}

	public void addPerson(Person p) {
		personList.addLast(p);
	}

	Person getPersonByLastName(String lastName) {
		LinkedList1618Improved<Person>.ListIterator iterator = personList.listIterator();
		while (iterator.hasNext()) {
			Person p = iterator.next();
			if (p.getLastName().equals(lastName))
				return p;
		}
		throw new java.util.NoSuchElementException();
	}
}