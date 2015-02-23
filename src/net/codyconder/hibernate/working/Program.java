package net.codyconder.hibernate.working;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

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
	Scanner userInput = new Scanner(System.in);

	// Program constructor
	public Program() {

	}

	public static void main(String[] args) {
		/* 
		 * Get out of main as quickly as possible
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
			program.addOwner();
			program.ownerMenu();
		case 2:
			// Call the listOwners method, then return to the owner menu
			program.listOwners();
			program.ownerMenu();
		case 3:
			// Call the updateOwnerInformation method, then return to the owner menu
			program.updateOwnerInformation();
			program.ownerMenu();
		case 4:
			// Call the listOwnerCars method, then return to the owner menu
			program.listOwnerCars();
			program.ownerMenu();
		case 5:
			// Call the removeOwner method, then return to the owner menu
			program.removeOwner();
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
			//program.addCar();
			program.carMenu();
		case 2:
			//Call the listAllCars method then return to the car menu
			//program.listAllCars();
			program.carMenu();
		case 3:
			//Call the updateCarInformation method then return to the car menu
			//program.updateCarInformation();
			program.carMenu();
		case 4:
			//Call the listOwnerCars method then return to the car menu
			program.listOwnerCars();
			program.carMenu();
		case 5:
			//Call the removeCar method then return to the car menu
			//program.removeCar();
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
	
	/* ****************
	 * Owner Management
	 * ****************/
	
	/*
	 * addOwner method
	 * This method gathers the information for a new owner object
	 * and then passes it to the insertOwner method for processing.
	 */
	private void addOwner() {
		String firstName;
		String lastName;
		String gender;
		
		System.out.println();
		System.out.print("First Name: ");
		firstName = userInput.nextLine();
		System.out.print("Last Name: ");
		lastName = userInput.nextLine();
		System.out.print("Gender: ");
		gender = userInput.nextLine();
		
		System.out.println("Adding "+firstName+" "+lastName+" to the database.");
		program.insertOwner(firstName, lastName, gender);
		
		System.out.println(firstName+" "+lastName+" successfully added!");
		
	}
	
	/* 
	 * listOwners method
	 * This method calls the queryAllOwners method to gather
	 * owner information from the database.
	 * A table is then printed and displayed to the user.
	 */
	private void listOwners() {
		List<Owner> ownerList = queryAllOwners();
		
		System.out.println();
		System.out.println("Owners in Database");
		System.out.printf("%-5s%-16s%-16s%-20s\n","Id","First Name","Last Name","Gender");
		System.out.printf("%-5s%-16s%-16s%-20s\n","--","----------","---------","------");
		
		Iterator<Owner> ownerIterator = ownerList.iterator();
		
		while(ownerIterator.hasNext()) {
			
			Owner element = ownerIterator.next();
			System.out.printf("%-5s%-16s%-16s%-20s\n",element.getId(),element.getFirstName(),
					element.getLastName(),element.getGender());
			
		}
		
	}
	
	/*
	 * updateOwnerInformation
	 * This method calls the listOwners method to display
	 * a list of owners in the database. The user is then
	 * prompted to enter the ID of the owner they'd like to
	 * update. The database is then queried for that specific
	 * user (queryOwnerByID method). The user is prompted
	 * to update the owner information and the object is passed
	 * to the mergeOwnerInformation method for processing. 
	 */
	private void updateOwnerInformation() {
		Integer selection = null;
		Owner ownerToUpdate;
		program.listOwners();
		
		System.out.print("Enter the ID of the owner you'd like to update: ");
		
		try {
			selection = Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("Oops! Please enter the ID of an owner.");
			program.updateOwnerInformation();
		}
		
		ownerToUpdate = queryOwnerById(selection);
		
		if (ownerToUpdate == null) {
			System.out.println();
			System.out.println("The ID you entered is invalid. Returning to Owner Menu.");
			program.ownerMenu();
		}
		
		System.out.println();
		System.out.println("Updating "+ownerToUpdate.getFirstName()+" "
				+ownerToUpdate.getLastName()+"'s information.");
		System.out.println("To leave the information the same, leave the field blank and press enter.");
		
		System.out.print("First Name: ");
		String firstName = userInput.nextLine();
		System.out.print("Last Name: ");
		String lastName = userInput.nextLine();
		System.out.print("Gender: ");
		String gender = userInput.nextLine();
		
		if(!firstName.isEmpty()) {
			ownerToUpdate.setFirstName(firstName);
		}
		if(!lastName.isEmpty()) {
			ownerToUpdate.setLastName(lastName);
		}
		if(!gender.isEmpty()) {
			ownerToUpdate.setGender(gender);
		}
		
		System.out.println("Updating information for "+ownerToUpdate.getFirstName()+" "+ownerToUpdate.getLastName());
		program.mergeOwnerInformation(ownerToUpdate);
		
		System.out.println("Information successfully updated! Returning to Owner Menu.");
		
	}
	
	private void listOwnerCars() {
		// TODO implement listOwnerCars method
		System.out.println();
		System.out.println("This method is not yet implemented. Returning to Owner Menu.");
	}
	
	private void removeOwner() {
		Integer selection = null;
		Owner ownerToRemove;
		program.listOwners();
		
		System.out.println("Removing an owner will also remove all their cars.");
		System.out.println("WARNING: This action cannot be undone!");
		System.out.print("Enter the ID of the owner you'd like to remove: ");
		
		try {
			selection = Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("Oops! Please enter the ID of an owner.");
			program.removeOwner();
		}
		
		ownerToRemove = queryOwnerById(selection);
		
		if (ownerToRemove == null) {
			System.out.println();
			System.out.println("The ID you entered is invalid. Returning to Owner Menu.");
			program.ownerMenu();
		}
		
		System.out.println("Removing owner "+ownerToRemove.getFirstName()+" "+ownerToRemove.getLastName());
		program.deleteOwnerFromDatabase(ownerToRemove);
		
		System.out.println("Owner successfully deleted! Returning to Owner Menu.");
	}

	/* ****************************
	 * Database Interaction Methods
	 * ****************************/
	
	/*
	 * Owner Database Methods
	 */
	private void insertOwner(String firstName, String lastName, String gender) {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Owner newOwner = new Owner(firstName, lastName, gender);
		
		session.save(newOwner);
		
		transaction.commit();
		
	}
	
	private List<Owner> queryAllOwners() {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query ownersQuery = session.createQuery("Select o from Owner as o");
		
		@SuppressWarnings("unchecked")
		List<Owner> ownersList = ownersQuery.list();
		
		transaction.commit();
		
		return ownersList;
	}
	
	private Owner queryOwnerById(Integer anId) {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query singleOwnerQuery = session.createQuery("Select o from Owner as o where o.id = :anId");
		singleOwnerQuery.setParameter("anId", anId);
		
		Owner singleOwner = (Owner)singleOwnerQuery.uniqueResult();
		
		transaction.commit();
		
		return singleOwner;
	}
	
	private void mergeOwnerInformation (Owner anOwnerToUpdate) {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query singleOwnerUpdate = session.createQuery("Select o from Owner as o where o.id = :anId");
		singleOwnerUpdate.setParameter("anId", anOwnerToUpdate.getId());
		
		session.merge(anOwnerToUpdate);
		
		transaction.commit();
	}
	
	private void deleteOwnerFromDatabase(Owner anOwnerToDelete) {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(anOwnerToDelete);
		
		transaction.commit();
	}
	
	/*
	 * Car Database Methods
	 */

}
