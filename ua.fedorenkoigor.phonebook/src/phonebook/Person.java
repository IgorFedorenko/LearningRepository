package phonebook;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable, Comparable<Person> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -977854885005193751L;
	private String name;
	private String descriprion;
	private ArrayList<Phone> phones = new ArrayList<Phone>();

	public Person(String name, String descriprion) {
		this.name = name;
		this.descriprion = descriprion;
		
	}

	public void addPhone(Phone phone){
		phones.add(phone);
	}
	
	public String getName() {
		return name;
	}

	public String getDescriprion() {
		return descriprion;
	}

	public ArrayList<Phone> getPhones() {
		return phones;
	}

	@Override
	public int compareTo(Person compPerson) {
		
		return this.name.compareTo(compPerson.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Имя - " + name + "\nописание - " + descriprion + "\n телефоны: \n" + phones;
	}

}
