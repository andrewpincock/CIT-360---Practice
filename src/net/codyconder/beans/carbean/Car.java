package net.codyconder.beans.carbean;

public class Car {

	public static void main(String[] args) {
		// Create a CarBean
		CarBean codysCar = new CarBean(2005, "Honda", "Civic", "silver", "Cody");

		// Print the properties of Cody's Car
		System.out.println(codysCar.getOwner() + " currently drives a " + codysCar.getColor().toLowerCase() + 
				" " + codysCar.getYear() + " " + codysCar.getMake() +  " " + codysCar.getModel() + ".");

		// Change the properties of Cody's Car
		codysCar.setYear(2015);
		codysCar.setModel("Accord");
		codysCar.setColor("black");

		// Print the new car's properties
		System.out.println("Someday, " + codysCar.getOwner() + " will drive a " + 
		codysCar.getColor().toLowerCase() + " " + codysCar.getYear() + " " + codysCar.getMake() +  
		" " + codysCar.getModel() + ".");
	}

}