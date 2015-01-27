package net.codyconder.beans.carbean;

public class OwnerBean {

	private String firstName;
	private String lastName;
	private String gender;

	public OwnerBean() {
		this.firstName = "Not Specified";
		this.lastName = "Not Specified";
		this.gender = "None";
	}

	public OwnerBean(final String aFirstName, final String aLastName,
			final String aGender) {
		this.firstName = aFirstName;
		this.lastName = aLastName;
		this.gender = aGender;
	}

	public void setFirstName(final String aFirstName) {
		this.firstName = aFirstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(final String aLastName) {
		this.lastName = aLastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setGender(final String aGender) {
		this.gender = aGender;
	}

	public String getGender() {
		return this.gender;
	}
}
