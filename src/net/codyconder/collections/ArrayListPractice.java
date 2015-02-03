package net.codyconder.collections;

import java.util.ArrayList;

public class ArrayListPractice {

	public static void main(String[] args) {
		// Create an array list
		ArrayList<String> myArrayList1 = new ArrayList<String>();
		
		// Add some strings to the array list
		myArrayList1.add("Hello");
		myArrayList1.add("world");
		myArrayList1.add("'sup");
		
		// Print some things out from the array list
		System.out.println("The following phrase was printed from myArrayList1: ");
		System.out.println(myArrayList1.get(0) + " " + myArrayList1.get(1) + "! "
				+ myArrayList1.get(2) + "?");
		
		// Line break
		System.out.println("*-----------------------------------------*");
		
		// What happens if we try to call an index that doesn't exist?
		System.out.println("Now, let's try to call an array object that hasn't been created.");
		
		try {
			// Should throw an IndexOutOfBounds Exception
			System.out.println(myArrayList1.get(3));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("[Catch block] Oops! That object doesn't exist! "
					+ "I've hidden the ugly stack trace.");
		}
		
		// Line break
		System.out.println("*-----------------------------------------*");
		System.out.println("Continuing on... the next task was to add "
				+ "something that isn't a string to the array.");
		System.out.println("Unfortunately, Eclipse won't let me without errors, "
				+ "since myArrayList1 has been parameterized.");

	}

}
