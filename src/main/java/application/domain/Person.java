package application.domain;

public class Person {
	private int personId;
	private String firstName;
	private String lastName;
	
	public Person(int id, String firstName, String lastName) {
		this.personId = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
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
}
