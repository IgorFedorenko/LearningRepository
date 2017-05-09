package phonebook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;




public class PhoneBookDirector implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<Person> persons = new TreeSet<Person>();

	public String addNewPerson(Person person) {
		if (persons.add(person))
			return "ok";
		else
			return "контакт с таким именем уже есть!";

	}

	public PhoneBookDirector() {
		try{
			FileInputStream fis = new FileInputStream("phonebook.out");
	        ObjectInputStream oin = new ObjectInputStream(fis);
	        PhoneBookDirector  phoneBook = (PhoneBookDirector) oin.readObject();
	        persons=phoneBook.persons;
	        oin.close();
		}
		catch (IOException e){
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] getPersons() {
		String[] strArr = new String[persons.size()];
		int i = 0;
		for (Person person : persons) {
			strArr[i] = person.getName();
		}

		return strArr;
	}

	public ArrayList<Person> getPersonByName(String name) {
		ArrayList<Person> searchPersons = new ArrayList<>();
		for (Person person : persons) {
			if (person.getName().toLowerCase().contains(name.toLowerCase())) {
				searchPersons.add(person);
			}
		}

		return searchPersons;
	}
	public void exit(PhoneBookDirector phoneBook) {
		try{
		 FileOutputStream fos = new FileOutputStream("phonebook.out");
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(phoneBook);
	        oos.flush();
	        oos.close();
		}
		catch (IOException e){
			System.out.println(e);
		}
	}

	public ArrayList<Person> getPersonByNumber(String text) {
		ArrayList<Person> searchPersons = new ArrayList<>();
		for (Person person : persons) {
			ArrayList<Phone> phones =person.getPhones();
			for (Phone phone : phones) {
				if (phone.getPhoneNumber().contains(text)) {
					searchPersons.add(person);
					break;
				}
			}
		}

		return searchPersons;
	}
}
