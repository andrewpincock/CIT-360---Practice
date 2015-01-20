package net.codyconder.beans.carbean;

public class CarBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int year;
	private String make;
	private String model;
	private String color;
	private String owner;
	
	// No Arg Constructor
	public CarBean () {
		year = 0;
		make = "";
		model = "";
		color = "";
		owner = "";
	}
	
	public void setYear (final int aYear) {
		this.year = aYear;
	}
	
	public void setMake (final String aMake) {
		this.make = aMake;
	}
	
	public void setModel (final String aModel) {
		this.model = aModel;
	}
	
	public void setColor (final String aColor) {
		this.color = aColor;
	}
	
	public void setOwner (final String anOwner) {
		this.owner = anOwner;
	}
	
	public int getYear() {
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
	
	public String getOwner() {
		return this.owner;
	}
	
}
