package net.codyconder.beans.carbean;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// This program will instantiate two owners and four cars.
		// It will then place them into various types of collections.

		// The first owner is Cody Conder, a male
		OwnerBean owner1 = new OwnerBean(1, "Cody", "Conder", "male");

		// The first car is a silver 2005 Honda Civic
		CarBean car1 = new CarBean(2005, "Honda", "Civic", "silver", owner1);
		// The second car is a black 2015 Honda Accord
		CarBean car2 = new CarBean(2015, "Honda", "Accord", "black", owner1);

		// Print the first car and its owner's information
		System.out.println("Car 1 is a " + car1.getColor() + " "
				+ car1.getYear() + " " + car1.getMake() + " " + car1.getModel()
				+ ".");
		System.out.println("Car 1's owner is " + car1.getOwner().getFirstName()
				+ " " + car1.getOwner().getLastName() + ", a "
				+ car1.getOwner().getGender() + ".");

		// Print the second car and its owner's information
		System.out.println("Car 2 is a " + car2.getColor() + " "
				+ car2.getYear() + " " + car2.getMake() + " " + car2.getModel()
				+ ".");
		System.out.println("Car 2's owner is " + car2.getOwner().getFirstName()
				+ " " + car2.getOwner().getLastName() + ", a "
				+ car2.getOwner().getGender() + ".");

		// The second owner is Kymberly Oliver, a female
		OwnerBean owner2 = new OwnerBean(2, "Kymberly", "Oliver", "female");

		// Kymberly's first car is a blue 2005 Ford Escape
		CarBean car3 = new CarBean(2005, "Ford", "Escape", "blue", owner2);
		// Kymberly's second car is a red 1998 Ford F-150
		CarBean car4 = new CarBean(1998, "Ford", "F-150", "red", owner2);

		// Print Kym's first car and its owner's information
		System.out.println("Car 3 is a " + car3.getColor() + " "
				+ car3.getYear() + " " + car3.getMake() + " " + car3.getModel()
				+ ".");
		System.out.println("Car 3's owner is " + car3.getOwner().getFirstName()
				+ " " + car3.getOwner().getLastName() + ", a "
				+ car3.getOwner().getGender() + ".");

		// Print Kym's second car
		// Print the first car and its owner's information
		System.out.println("Car 4 is a " + car4.getColor() + " "
				+ car4.getYear() + " " + car4.getMake() + " " + car4.getModel()
				+ ".");
		System.out.println("Car 4's owner is " + car4.getOwner().getFirstName()
				+ " " + car4.getOwner().getLastName() + ", a "
				+ car4.getOwner().getGender() + ".");

		// Create an array of owners
		ArrayList<OwnerBean> ownerList = new ArrayList<OwnerBean>();
		ownerList.add(owner1);
		ownerList.add(owner2);
		
		// Create an array of cars
		ArrayList<CarBean> carList = new ArrayList<CarBean>();
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		carList.add(car4);

		// Print from the owner array
		System.out.println();
		System.out.println("Now printing information from the owners array.");
		for (OwnerBean o : ownerList) {
			System.out.println(o.getFirstName() + " " + o.getLastName() + ", "
					+ o.getGender());
		}
		
		// Print from the cars array
		System.out.println();
		System.out.println("Now printing information from the cars array.");
		for (CarBean c : carList) {
			System.out.println(c.getColor() + " " + c.getYear()
				+ " " + c.getMake() + " " + c.getModel()
				+ ", driven by " + c.getOwner().getFirstName());
		}

	}

}
