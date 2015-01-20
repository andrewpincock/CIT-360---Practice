package net.codyconder.conversions;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner ConsoleInput = new Scanner(System.in);

		// Define our variables
		String month = null;
		int monthNumber = -1;
		int day = 0;
		int year = 0;
		boolean validMonth = false;
		boolean validDay = false;
		boolean validYear = false;

		// Print description
		System.out.println("This program will tell you what day of the week a particular date fell on.");

		// Get & convert month
		while (!validMonth) {
			try {
				System.out.print("Month (Full Month): ");
				month = ConsoleInput.next();
				monthNumber = convertMonthToInt(month);
				if (monthNumber >= 0 && monthNumber <= 11) validMonth = true;
			} catch (Exception e) {
				System.out.println("Oops! Please check your spelling!");
			}
		}

		// Get day
		while (!validDay) {
			try {
				System.out.print("Day: ");
				day = ConsoleInput.nextInt();
				// Validate that the day could've occurred in the month
				if ((monthNumber == 0 || monthNumber == 2 || monthNumber == 4 || monthNumber == 6 || monthNumber == 7 || monthNumber == 9 || monthNumber == 11) && (day < 1 || day > 31)) {
					System.out.println ("Please enter a valid number between 1 and 31");
				}
				else if ((monthNumber == 3 || monthNumber == 5 || monthNumber == 8 || monthNumber == 10) && (day < 1 || day > 30)) {
					System.out.println ("Please enter a valid number between 1 and 30");
				}
				else if (monthNumber == 1 && (day < 1 || day > 29)) {
					System.out.println ("Please enter a valid number between 1 and 29");
				} else validDay = true;
			} catch (Exception InputMismatchException) {
				System.out.println("Please enter a number.");
				ConsoleInput.next();
			}
		}

		// Get year
		while (!validYear) {
			try {
				System.out.print("Year: ");
				year = ConsoleInput.nextInt();
				validYear = true;
			} catch (Exception InputMismatchException) {
				System.out.println("Please enter a number.");
				ConsoleInput.next();
			}
		}

		// Set the date objects
		GregorianCalendar userDate = new GregorianCalendar(year, monthNumber, day);
		GregorianCalendar now = new GregorianCalendar();

		// Print the date
		month = month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
		if (userDate.compareTo(now) > 0) {
			System.out.println(month + " " + day + ", " + year + " will be a " + convertDayToString(userDate.get(Calendar.DAY_OF_WEEK)) + ".");
		}
		if (userDate.compareTo(now) < 0) {
			System.out.println(month + " " + day + ", " + year + " was a " + convertDayToString(userDate.get(Calendar.DAY_OF_WEEK)) + ".");
		}
		// Close the scanner
		ConsoleInput.close();
	}

	private static int convertMonthToInt (String monthInput) throws Exception {
		monthInput = monthInput.toUpperCase();
		if (monthInput.equals("JANUARY")) {
			return 0;
		}
		if (monthInput.equals("FEBRUARY")) {
			return 1;
		}
		if (monthInput.equals("MARCH")) {
			return 2;
		}
		if (monthInput.equals("APRIL")) {
			return 3;
		}
		if (monthInput.equals("MAY")) {
			return 4;
		}
		if (monthInput.equals("JUNE")) {
			return 5;
		}
		if (monthInput.equals("JULY")) {
			return 6;
		}
		if (monthInput.equals("AUGUST")) {
			return 7;
		}
		if (monthInput.equals("SEPTEMBER")) {
			return 8;
		}
		if (monthInput.equals("OCTOBER")) {
			return 9;
		}
		if (monthInput.equals("NOVEMBER")) {
			return 10;
		}
		if (monthInput.equals("DECEMBER")) {
			return 11;
		}
		else {
			Exception e = new Exception();
			throw e;
		}
	}

	private static String convertDayToString (int dayInput) {
		String returnDate = "";
		if (dayInput == 1) {
			returnDate = "Sunday";
			return returnDate;
		}
		if (dayInput == 2) {
			returnDate = "Monday";
			return returnDate;
		}
		if (dayInput == 3) {
			returnDate = "Tuesday";
			return returnDate;
		}
		if (dayInput == 4) {
			returnDate = "Wednesday";
			return returnDate;
		}
		if (dayInput == 5) {
			returnDate = "Thursday";
			return returnDate;
		}
		if (dayInput == 6) {
			returnDate = "Friday";
			return returnDate;
		}
		if (dayInput == 7) {
			returnDate = "Saturday";
			return returnDate;
		}
		else return returnDate;
	}
}
