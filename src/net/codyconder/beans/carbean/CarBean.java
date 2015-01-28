package net.codyconder.beans.carbean;

// import java.util.HashMap;

public class CarBean implements java.io.Serializable {

	private static final long serialVersionUID = 3L;
	private int year;
	private String make;
	private String model;
	private String color;
	private OwnerBean owner;

	// No Arg Constructor
	public CarBean() {
		this.year = 0;
		this.make = "";
		this.model = "";
		this.color = "";
		this.owner = new OwnerBean();
	}

	// Full Constructor
	public CarBean(int year, String make, String model, String color,
			OwnerBean owner) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
		this.owner = owner;
	}

	// HashMap Constructor
	// Verify this after implementing the owner bean
	// public CarBean (HashMap aHashMap) {
	// this.year = (int)aHashMap.get("year");
	// this.make = (String)aHashMap.get("make");
	// this.model = (String)aHashMap.get("model");
	// this.color = (String)aHashMap.get("color");
	// this.owner.setFirstName((String)aHashMap.get("firstName"));
	// this.owner.setLastName((String)aHashMap.get("lastName"));
	// this.owner.setGender((String)aHashMap.get("gender"));
	// }

	public void setYear(final int year) {
		this.year = year;
	}

	public void setMake(final String make) {
		this.make = make;
	}

	public void setModel(final String model) {
		this.model = model;
	}

	public void setColor(final String color) {
		this.color = color;
	}

	public void setOwner(final OwnerBean anOwner) {
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

	public OwnerBean getOwner() {
		return this.owner;
	}

}
