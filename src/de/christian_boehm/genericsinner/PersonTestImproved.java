package de.christian_boehm.genericsinner;

public class PersonTestImproved {

	public static void main(String[] args) {
		LinkedListAddressBook meinAdressbuch = new LinkedListAddressBook();
		meinAdressbuch.addPerson(new Person("Christian", "Boehm"));
		meinAdressbuch.addPerson(new Person("Heinz", "Erhardt"));
		
		System.out.println(meinAdressbuch.getPersonByLastName("Boehm"));

	}

}
