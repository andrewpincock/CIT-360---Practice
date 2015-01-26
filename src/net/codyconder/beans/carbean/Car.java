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
		// Create a CarBean
		CarBean codysCar = new CarBean(2005, "Honda", "Civic", "silver", "Cody");

		// Print the properties of Cody's Car
		System.out.println(codysCar.getOwner() + " currently drives a "
				+ codysCar.getColor().toLowerCase() + " " + codysCar.getYear()
				+ " " + codysCar.getMake() + " " + codysCar.getModel() + ".");

		// Change the properties of Cody's Car
		codysCar.setYear(2015);
		codysCar.setModel("Accord");
		codysCar.setColor("black");

		// Print the new car's properties
		System.out.println("Someday, " + codysCar.getOwner() + " will drive a "
				+ codysCar.getColor().toLowerCase() + " " + codysCar.getYear()
				+ " " + codysCar.getMake() + " " + codysCar.getModel() + ".");

		// Convert the car bean to JSON
		convertCarToJSON(codysCar);
		System.out.println("JSON File Created");

		// Import the file as a new object
		CarBean codysJSONCar = convertJsonToCar("test.json");

		// Print the car's properties as read from the JSON file
		System.out.println("According to the JSON file, "
				+ codysJSONCar.getOwner() + " will drive a "
				+ codysJSONCar.getColor().toLowerCase() + " "
				+ codysJSONCar.getYear() + " " + codysJSONCar.getMake() + " "
				+ codysJSONCar.getModel() + ".");
	}

	private static void convertCarToJSON(CarBean aCar) {
		File jsonFile = new File("test.json");

		try {
			FileOutputStream aFileStream = new FileOutputStream(jsonFile);
			JSONOutputStream jsonOut = new JSONOutputStream(aFileStream);
			jsonOut.writeObject(aCar);
			jsonOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static CarBean convertJsonToCar(String aFileName) {
		File jsonFile = new File(aFileName);
		CarBean codysJSONCar = null;

		try {
			FileInputStream aFileStream = new FileInputStream(jsonFile);
			JSONInputStream jsonIn = new JSONInputStream(aFileStream);
			HashMap parsedJSONMap = (HashMap) jsonIn.readObject();
			codysJSONCar = new CarBean(parsedJSONMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return codysJSONCar;
	}
}
