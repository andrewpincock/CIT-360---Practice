package net.codyconder.beans.carbean;

public class OwnerBean {
	
	private String firstName;
	private String lastName;
	private String gender;
	
	public OwnerBean () {
		this.firstName = "Not Specified";
		this.lastName = "Not Specified";
		this.gender = "None";
	}
	
	public OwnerBean (String aFirstName, String aLastName, String aGender) {
		this.firstName = aFirstName;
		this.lastName = aLastName;
		this.gender = aGender;
	}
	
	public void setFirstName (String aFirstName) {
		this.firstName = aFirstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName (String aLastName) {
		this.lastName = aLastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setGender(String aGender) {
		this.gender = aGender;
	}
	
	public String getGender() {
		return this.gender;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OwnerBean other = (OwnerBean) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
