package de.christian_boehm.serialize;

public interface FullPersistence {
	AddressBook loadbook(String name) throws AddressBookException;
	
	void storeBook(AddressBook book, String name) throws AddressBookException;
}
