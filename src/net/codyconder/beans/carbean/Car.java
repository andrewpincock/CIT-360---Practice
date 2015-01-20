package net.codyconder.beans.carbean;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Car {

	public static void main(String[] args) {
		// Create a CarBean
		CarBean codysCar = new CarBean();

		// Set properties of Cody's car
		codysCar.setYear(2005);
		codysCar.setMake("Honda");
		codysCar.setModel("Civic");
		codysCar.setColor("silver");
		codysCar.setOwner("Cody");

		// Print the properties of Cody's Car
		System.out.println(codysCar.getOwner() + " drove a " + codysCar.getColor().toLowerCase() + " " + codysCar.getYear() + " " + codysCar.getMake() +  " " + codysCar.getModel() + ".");

		// Change the properties of Cody's Car
		codysCar.setYear(2015);
		codysCar.setModel("Accord");
		codysCar.setColor("black");

		// Print the new car's properties
		System.out.println("Now, " + codysCar.getOwner() + " drives a " + codysCar.getColor().toLowerCase() + " " + codysCar.getYear() + " " + codysCar.getMake() +  " " + codysCar.getModel() + ".");

		// Write the object to a file!
		try {
			PrintWriter outputFile = new PrintWriter("codyscar.csv");
			outputFile.println("Year,Make,Model,Color,Owner");
			outputFile.print(codysCar.getYear() + "," + codysCar.getMake() +"," + codysCar.getModel() + "," + codysCar.getColor() + "," + codysCar.getOwner());
			outputFile.close();
			System.out.println("File successfully written.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}