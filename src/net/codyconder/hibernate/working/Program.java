package net.codyconder.hibernate.working;

import java.util.Scanner;

public class Program {

	/*
	 * Create a program object. This makes it available
	 * to all methods within the class without having
	 * to instantiate it each time you need it.
	 */
	static Program program = new Program();
	OwnerManagement ownerManagement = new OwnerManagement();
	CarManagement carManagement = new CarManagement();
	Scanner userInput = new Scanner(System.in);
	

	// Program constructor
	public Program() {
	}

	public static void main(String[] args) {
		boolean quitProgram = false;
		while (!quitProgram) {
			/* 
			 * Control of the program will flow through the
			 * Main Menu and the sub menus.
			 */
			quitProgram = program.mainMenu();
		}
	}

	/* ************
	 * System Menus
	 * ************/
	
	/*
	 * Main Menu
	 */
	private boolean mainMenu() {
		boolean quitProgram = false;
		
		while (!quitProgram) {
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
				return false;
			}
			
			switch (selection) {
			case 1:
				// Open the Owner Menu
				program.ownerMenu();
				break;
			case 2:
				// Open the Car Menu
				program.carMenu();
				break;
			case 3:
				// Exit the program
				System.out.println();
				System.out.println("Have a nice day!");
				quitProgram = true;
				return quitProgram;
			default:
				// A number other than 1-3 was entered.
				// Prompt for input again.
				System.out.println();
				System.out.println("Oops! Please enter a number (1-3) to use the system.");
				break;
			}
		}
		
		return quitProgram;

	}

	/*
	 * Owner Menu
	 */
	private void ownerMenu() {
		boolean returnToMainMenu = false;

		while (!returnToMainMenu) {
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
				// Don't do anything. It will fall to the default case.
			}
			
			switch (selection) {
			case 1:
				// Call the addOwner method, then return to the owner menu
				ownerManagement.addOwner();
				break;
			case 2:
				// Call the listOwners method, then return to the owner menu
				ownerManagement.listOwners();
				break;
			case 3:
				// Call the updateOwnerInformation method, then return to the owner menu
				ownerManagement.updateOwnerInformation();
				break;
			case 4:
				// Call the listOwnerCars method, then return to the owner menu
				ownerManagement.listOwnerCars();
				break;
			case 5:
				// Call the removeOwner method, then return to the owner menu
				ownerManagement.removeOwner();
				break;
			case 6:
				// Return to the Main Menu
				returnToMainMenu = true;
				break;
			default:
				// A number other than 1-6 was entered.
				// Prompt for input again.
				System.out.println();
				System.out.println("Oops! Please enter a number (1-6) to use this menu.");
				break;
			}
		}

	}

	/*
	 * Car Menu
	 */
	private void carMenu() {
		boolean returnToMainMenu = false;
		
		while (!returnToMainMenu) {
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
				// Don't do anything. It will fall to the default case.
			}
			
			switch (selection) {
			case 1:
				//Call the addCar method then return to the car menu
				carManagement.addCar();
				break;
			case 2:
				//Call the listAllCars method then return to the car menu
				carManagement.listAllCars();
				break;
			case 3:
				//Call the updateCarInformation method then return to the car menu
				carManagement.updateCarInformation();
				break;
			case 4:
				//Call the listOwnerCars method then return to the car menu
				ownerManagement.listOwnerCars();
				break;
			case 5:
				//Call the removeCar method then return to the car menu
				carManagement.removeCar();
				break;
			case 6:
				// Return to the main menu
				returnToMainMenu = true;
				break;
			default:
				// A number other than 1-6 was entered.
				// Prompt for input again.
				System.out.println();
				System.out.println("Oops! Please enter a number (1-6) to use this menu.");
				break;
			}
		}

	}

}