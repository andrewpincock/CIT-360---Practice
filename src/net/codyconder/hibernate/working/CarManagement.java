package net.codyconder.hibernate.working;

import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CarManagement {
	
	Scanner userInput = new Scanner(System.in);
	Model aModel = new Model();
	OwnerManagement ownerManagement = new OwnerManagement();
	
	public CarManagement () {
		
	}
	
	/*
	 * Car management methods
	 */
	
	void addCar () {
		Integer selection = null;
		String year;
		String make;
		String model;
		String color;
		
		ownerManagement.listOwners();
		
		System.out.print("Enter the ID of the owner of the car: ");
		
		try {
			selection = Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("Invalid entry. Returning to Car Menu.");
			return;
		}
		
		Owner theOwner = aModel.queryOwnerById(selection);
		
		if (theOwner == null) {
			System.out.println();
			System.out.println("The ID you entered is invalid. Returning to Car Menu.");
			return;
		}
		
		System.out.println();
		System.out.print("Year: ");
		year = userInput.nextLine();
		System.out.print("Make: ");
		make = userInput.nextLine();
		System.out.print("Model: ");
		model = userInput.nextLine();
		System.out.print("Color: ");
		color = userInput.nextLine();
		
		Car carToInsert = new Car(theOwner,year,make,model,color);
		Set<Car> carSet = new HashSet<Car>();
		carSet.add(carToInsert);
		theOwner.setCars(carSet);
		
		System.out.println("Adding "+theOwner.getFullName()+"'s "+carToInsert.getMake()+" "
				+carToInsert.getModel()+" to the database.");
		aModel.insertCar(carToInsert);
		
		System.out.println("Car successfully added to database!");
	}
	
	void listAllCars () {
		List<Car> carList = aModel.queryAllCars();
		
		System.out.println();
		System.out.println("Cars in Database");
		System.out.printf("%-5s%-20s%-7s%-16s%-18s%-16s\n","ID","Owner","Year","Make","Model","Color");
		System.out.printf("%-5s%-20s%-7s%-16s%-18s%-16s\n","--","-----","----","----","-----","-----");
		
		Iterator<Car> carIterator = carList.iterator();
		
		while(carIterator.hasNext()) {
			
			Car element = carIterator.next();
			System.out.printf("%-5s%-20s%-7s%-18s%-16s%-16s\n",element.getId(),element.getOwnerId().getFullName(),
					element.getYear(),element.getMake(),element.getModel(),element.getColor());
		}
	}
	
	void updateCarInformation () {
		
	}
	
	void removeCar () {
		
	}
	
}
