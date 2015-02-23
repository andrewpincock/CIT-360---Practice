package net.codyconder.hibernate.practice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	public Owner () {
		
	}
	
	public Owner (String aFirstName, String aLastName, String aGender) {
		this.firstName = aFirstName;
		this.lastName = aLastName;
		this.gender = aGender;
	}
	
	public String toString() {
		return "Owner: [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + "]";
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer anId) {
		this.id = anId;
	}
	
	public void setFirstName(String aName) {
		this.firstName = aName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String aName) {
		this.lastName = aName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public void setGender(String aGender) {
		this.gender = aGender;
	}
	
	public String getGender() {
		return this.gender;
	}
	
}
