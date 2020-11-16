package de.christian_boehm.serialize;

public interface FullPersistence<T extends AddressBook> {
	T loadbook(String name) throws AddressBookException;
	
	void storeBook(T book, String name) throws AddressBookException;
}
