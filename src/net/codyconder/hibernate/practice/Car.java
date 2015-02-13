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
	private Integer year;
	private String make;
	private String model;
	private String color;
	
	public Integer getYear() {
		return this.year;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getColor() {
		return this.color;
	}
	
}
