package net.codyconder.hibernate.working;

import java.util.Scanner;

public class Program {

	/*
	 * Create a program object. This makes it available
	 * to all methods within the class without having
	 * to instantiate it each time you need it.
	 * Same thing for the scanner - this makes it
	 * available throughout the program without having to
	 * create a new one each time.
	 */
	static Program program = new Program();
	OwnerManagement ownerManagement = new OwnerManagement();
	CarManagement carManagement = new CarManagement();
	Scanner userInput = new Scanner(System.in);

	// Program constructor
	public Program() {

	}

	public static void main(String[] args) {
		/* 
		 * Control of the program will flow through the
		 * Main Menu and the sub menus.
		 */
		program.mainMenu();
	}

	/* ************
	 * System Menus
	 * ************/
	
	/*
	 * Main Menu
	 */
	private void mainMenu() {
		Integer selection = null;

		// Print the main menu
		System.out.println();
		System.out.println("Main Menu");
		System.out.println("	1. Owner Management");
		System.out.println("	2. Car Management");
		System.out.println("	3. Quit application");
		System.out.print("Please enter your selection (1-3): ");

		// Attempt to read user input
		try {
			selection = Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException e) {
			// If we don't get an integer, then we need to go back
			// and try again. We can't work with letters in this menu.
			System.out.println();
			System.out.println("Oops! Please enter a number (1-3) to use the system.");
			program.mainMenu();
		}

		switch (selection) {
		case 1:
			// Open the Owner Menu
			program.ownerMenu();
		case 2:
			// Open the Car Menu
			program.carMenu();
		case 3:
			// Exit the program
			System.out.println();
			System.out.println("Have a nice day!");
			System.exit(0);
		default:
			// A number other than 1-3 was entered.
			// Prompt for input again.
			System.out.println();
			System.out.println("Oops! Please enter a number (1-3) to use the system.");
			program.mainMenu();
		}

	}

	/*
	 * Owner Menu
	 */
	private void ownerMenu() {
		Integer selection = null;

		// Print the owner management menu
		System.out.println();
		System.out.println("Owner Management");
		System.out.println("	1. Add Owner");
		System.out.println("	2. List All Owners");
		System.out.println("	3. Update Owner Information");
		System.out.println("	4. List Cars Owned by an Owner");
		System.out.println("	5. Remove Owner");
		System.out.println("	6. Return to Main Menu");
		System.out.print("Please enter your selection (1-6): ");

		// Attempt to read user input
		try {
			selection = Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException e) {
			// If we don't get an integer, then we need to go back
			// and try again. We can't work with letters in this menu.
			System.out.println();
			System.out.println("Oops! Please enter a number (1-6) to use this menu.");
			program.ownerMenu();
		}

		switch (selection) {
		case 1:
			// Call the addOwner method, then return to the owner menu
			ownerManagement.addOwner();
			program.ownerMenu();
		case 2:
			// Call the listOwners method, then return to the owner menu
			ownerManagement.listOwners();
			program.ownerMenu();
		case 3:
			// Call the updateOwnerInformation method, then return to the owner menu
			ownerManagement.updateOwnerInformation();
			program.ownerMenu();
		case 4:
			// Call the listOwnerCars method, then return to the owner menu
			ownerManagement.listOwnerCars();
			program.ownerMenu();
		case 5:
			// Call the removeOwner method, then return to the owner menu
			ownerManagement.removeOwner();
			program.ownerMenu();
		case 6:
			// Return to the Main Menu
			program.mainMenu();
		default:
			// A number other than 1-6 was entered.
			// Prompt for input again.
			System.out.println();
			System.out.println("Oops! Please enter a number (1-6) to use this menu.");
			program.ownerMenu();
		}

	}

	/*
	 * Car Menu
	 */
	private void carMenu() {
		Integer selection = null;

		// Print the owner management menu
		System.out.println();
		System.out.println("Car Management");
		System.out.println("	1. Add Car");
		System.out.println("	2. List All Cars");
		System.out.println("	3. Update Car Information");
		System.out.println("	4. List Cars Owned by an Owner");
		System.out.println("	5. Remove Car");
		System.out.println("	6. Return to Main Menu");
		System.out.print("Please enter your selection (1-6): ");

		// Attempt to read user input
		try {
			selection = Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException e) {
			// If we don't get an integer, then we need to go back
			// and try again. We can't work with letters in this menu.
			System.out.println();
			System.out.println("Oops! Please enter a number (1-6) to use this menu.");
			program.carMenu();
		}

		switch (selection) {
		case 1:
			//Call the addCar method then return to the car menu
			carManagement.addCar();
			program.carMenu();
		case 2:
			//Call the listAllCars method then return to the car menu
			carManagement.listAllCars();
			program.carMenu();
		case 3:
			//Call the updateCarInformation method then return to the car menu
			carManagement.updateCarInformation();
			program.carMenu();
		case 4:
			//Call the listOwnerCars method then return to the car menu
			ownerManagement.listOwnerCars();
			program.carMenu();
		case 5:
			//Call the removeCar method then return to the car menu
			carManagement.removeCar();
			program.carMenu();
		case 6:
			// Return to the main menu
			program.mainMenu();
		default:
			// A number other than 1-6 was entered.
			// Prompt for input again.
			System.out.println();
			System.out.println("Oops! Please enter a number (1-6) to use this menu.");
			program.carMenu();
		}

	}

}
