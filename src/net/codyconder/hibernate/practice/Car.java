package net.codyconder.hibernate.practice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue
	private Integer id;
	private String year;
	private String make;
	private String model;
	private String color;
	
	public Car () {
		
	}
	
	public String toString() {
		return "Car: [id=" + id + ", year=" + year + ", make=" + make 
				+ ", model=" + model + ", color=" + color + "]";
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer anId) {
		this.id = anId;
	}
	
	public void setYear(String aYear) {
		this.year = aYear;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public void setMake(String aMake) {
		this.make = aMake;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public void setModel(String aModel) {
		this.model = aModel;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setColor(String aColor) {
		this.color = aColor;
	}
	
	public String getColor() {
		return this.color;
	}
	
}
