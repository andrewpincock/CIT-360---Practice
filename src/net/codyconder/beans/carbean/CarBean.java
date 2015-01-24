package net.codyconder.beans.carbean;

import java.util.HashMap;

public class CarBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int year;
	private String make;
	private String model;
	private String color;
	private String owner;
	
	// No Arg Constructor
	public CarBean () {
		this.year = 0;
		this.make = "";
		this.model = "";
		this.color = "";
		this.owner = "";
	}
	
	// Full Constructor
	public CarBean (int year, String make, String model, String color, String owner) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
		this.owner = owner;
	}
	
	// HashMap Constructor
	public CarBean (HashMap aHashMap) {
		long longYear = (long)aHashMap.get("year");
		int intYear = (int) longYear;
		this.year = intYear;
		this.make = (String)aHashMap.get("make");
		this.model = (String)aHashMap.get("model");
		this.color = (String)aHashMap.get("color");
		this.owner = (String)aHashMap.get("owner");
	}
	
	public void setYear (final int year) {
		this.year = year;
	}
	
	public void setMake (final String make) {
		this.make = make;
	}
	
	public void setModel (final String model) {
		this.model = model;
	}
	
	public void setColor (final String color) {
		this.color = color;
	}
	
	public void setOwner (final String owner) {
		this.owner = owner;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarBean other = (CarBean) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
}
