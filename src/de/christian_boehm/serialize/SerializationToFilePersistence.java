package de.christian_boehm.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationToFilePersistence<T extends AddressBook> implements FullPersistence {
	private final String userHomePath;
	private final File destinationPath;

	public SerializationToFilePersistence() {
		userHomePath = System.getProperty("user.home");
		destinationPath = new File(userHomePath + "/addressbook");
	}

	@Override
	public AddressBook loadbook(String name) throws AddressBookException {
		FileInputStream is = null;
		ObjectInputStream ois = null;

		try {
			File inputDir = getDestDir();
			is = new FileInputStream(inputDir + "/" + name);
			ois = new ObjectInputStream(is);
			AddressBook addressBookfromFile = (AddressBook) ois.readObject();
			return addressBookfromFile;
		} catch (IOException | ClassNotFoundException e) {
			throw new AddressBookException(e.getClass().getName() + ": in " + e.getMessage());
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException ex) {
				throw new AddressBookException(ex.getClass().getName() + ": in " + ex.getMessage());
			}
			try {
				is.close();
			} catch (IOException ex) {
				throw new AddressBookException(ex.getClass().getName() + ": in " + ex.getMessage());
			}
		}
	}



	private void createDestDir() throws IOException {
		if (!destinationPath.exists()) {
			if (!destinationPath.mkdir()) {
				throw new IOException("Can not create destination " + destinationPath);
			} else {
				System.out.println("Directory \"addressbook\" succesfully created!");
			}
		}
	}
	
	private File getDestDir() throws IOException{
		if (!destinationPath.exists()) {
			throw new IOException(destinationPath + " not exists ");
		}
		
		return this.destinationPath;
	}

	@Override
	public void storeBook(AddressBook book, String name) throws AddressBookException {
		// TODO Auto-generated method stub
		
	}
}
