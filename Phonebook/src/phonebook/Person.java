
package phonebook;

public class Person {
	private String firstName;
	private String lastName;
	private Address address;
	private String phoneNumber;
	
	public String toString() {
		return firstName + " " + lastName + ", " + address.getAll() + ", "
				+ phoneNumber;
	}
	public String getAll() {
		return firstName;
	}
	public Person(String firstName, String lastName, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phone;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
