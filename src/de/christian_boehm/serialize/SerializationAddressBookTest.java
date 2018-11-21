package de.christian_boehm.serialize;

public class SerializationAddressBookTest {

	public static void main(String[] args) {
		
		ArrayListAddressBook myAddressBookSave = new ArrayListAddressBook(5);
		ArrayListAddressBook myAddressBookLoad;
		
		myAddressBookSave.addPerson(new Person("Donald Duck"));
		myAddressBookSave.addPerson(new Person("Daisy Duck"));
		myAddressBookSave.addPerson(new Person("Mickey Mouse"));
		myAddressBookSave.addPerson(new Person("Minnie Mouse"));
		myAddressBookSave.addPerson(new Person("Goofy"));
		
		SerializationToFilePersistence outObj = new SerializationToFilePersistence();
		try {
			outObj.storeBook(myAddressBookSave, "DuckTales");
		} catch (AddressBookException e) {
			System.out.println(e.getMessage());
		}
		
		SerializationToFilePersistence inObj = new SerializationToFilePersistence();
		try {
			myAddressBookLoad = (ArrayListAddressBook) inObj.loadbook("DuckTales");
			myAddressBookLoad.print();
		} catch (AddressBookException e) {
			System.out.println(e.getMessage());
		}
	}

}
