package net.codyconder.hibernate.practice;

//import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.Query;

public class PracticeSample {
	//private List<Car> cars;
	
	public PracticeSample() {
		
	}
	
	public static void main(String[] args) {
		PracticeSample aPracticeSample = new PracticeSample();
		aPracticeSample.addNewCars();
	}
	
	private void addNewCars() {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		// Create two cars
		Car car1 = new Car();
		car1.setYear("2005");
		car1.setMake("Honda");
		car1.setModel("Civic");
		car1.setColor("silver");
		
		Car car2 = new Car();
		car2.setYear("2015");
		car2.setMake("Honda");
		car2.setModel("Accord");
		car2.setColor("gray");
		
		// Commit the data
		session.save(car1);
		session.save(car2);
		transaction.commit();
		
		// Print out the generated IDs
		System.out.println("Car 1's id is " + car1.getId());
		System.out.println("Car 2's id is " + car2.getId());
	}

}
