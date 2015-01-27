package net.codyconder.beans.carbean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

/*
 * The qcJSON library is required for this program to function.
 * This can be obtained from https://github.com/yenrab/qcJSON
 */

public class Car {

	public static void main(String[] args) {
		// Create an Owner
		OwnerBean anOwner = new OwnerBean("Cody", "Conder", "male");

		// Create a CarBean
		CarBean aCar = new CarBean(2005, "Honda", "Civic", "silver", anOwner);

		// Print the properties of Cody's Car
		System.out.println(anOwner.getFirstName() + " " + anOwner.getLastName() + " drives a "
				+ aCar.getColor() + " " + aCar.getYear() + " " + aCar.getMake() + " " + aCar.getModel() + ".");

		// Can I print out the details of the owner from the car bean?
		System.out.println("The owner's name was gathered from the car bean: " + 
				aCar.getOwner().getFirstName() + " " + aCar.getOwner().getLastName());

		// Change the properties of Cody's Car
		aCar.setYear(2015);
		aCar.setModel("Accord");
		aCar.setColor("black");

		// Print the new car's properties
		System.out.println("Someday, " + aCar.getOwner().getFirstName() + " will drive a "
				+ aCar.getColor().toLowerCase() + " " + aCar.getYear()
				+ " " + aCar.getMake() + " " + aCar.getModel() + ".");
		
		// Change the owner directly
		anOwner.setFirstName("Fred");
		anOwner.setLastName("Flintstone");
		
		// Change the properties of the car
		aCar.setYear(0);
		aCar.setMake("Podiatrist");
		aCar.setModel("Footmobile");
		aCar.setColor("orange");
		
		// Try printing the information from the car bean (including owner)
		System.out.println(aCar.getOwner().getFirstName() + " " + aCar.getOwner().getLastName() + " drives a model year " +
		aCar.getYear() + " " + aCar.getMake() + " " + aCar.getModel() + ", the color of which is " + aCar.getColor() + ".");
		
		// Can I change the information through the car bean? If so, I probably want to fix that.
		aCar.getOwner().setFirstName("Johnny");
		aCar.getOwner().setLastName("Appleseed");
		
		// Print from the car bean
		System.out.println("The new owner is: " + aCar.getOwner().getFirstName() + " " + aCar.getOwner().getLastName());
		
		// Print from the owner bean
		System.out.println("When printed from the owner bean, the owner's name is: " + anOwner.getFirstName() + " " + anOwner.getLastName());
		
		// Convert the car bean to JSON
		// convertCarToJSON(codysCar);
		// System.out.println("JSON File Created");

		// Import the file as a new object
		// CarBean codysJSONCar = convertJsonToCar("test.json");

		// Print the car's properties as read from the JSON file
//		System.out.println("According to the JSON file, "
//				+ codysJSONCar.getOwner() + " will drive a "
//				+ codysJSONCar.getColor().toLowerCase() + " "
//				+ codysJSONCar.getYear() + " " + codysJSONCar.getMake() + " "
//				+ codysJSONCar.getModel() + ".");
	}

//	private static void convertCarToJSON(CarBean aCar) {
//		File jsonFile = new File("test.json");
//
//		try {
//			FileOutputStream aFileStream = new FileOutputStream(jsonFile);
//			JSONOutputStream jsonOut = new JSONOutputStream(aFileStream);
//			jsonOut.writeObject(aCar);
//			jsonOut.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	private static CarBean convertJsonToCar(String aFileName) {
//		File jsonFile = new File(aFileName);
//		CarBean codysJSONCar = null;
//
//		try {
//			FileInputStream aFileStream = new FileInputStream(jsonFile);
//			JSONInputStream jsonIn = new JSONInputStream(aFileStream);
//			HashMap parsedJSONMap = (HashMap) jsonIn.readObject();
//			codysJSONCar = new CarBean(parsedJSONMap);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return codysJSONCar;
//	}
}
