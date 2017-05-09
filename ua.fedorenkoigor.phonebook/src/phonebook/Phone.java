package phonebook;

import java.io.Serializable;

public class Phone implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1610150568723996393L;
	private String phoneNumber;
	private PhoneType phoneType;

	public Phone(String phoneNumber, PhoneType phoneType) {

		this.phoneNumber = phoneNumber;
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	@Override
	public String toString() {
		return phoneType +" - "+ phoneNumber +"\n";
	}

}
