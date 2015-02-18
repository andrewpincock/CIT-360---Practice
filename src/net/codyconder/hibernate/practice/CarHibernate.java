package net.codyconder.hibernate.practice;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarHibernate {
	private List<Car> cars;
	
	public CarHibernate() {
		
	}
	
	public static void main(String[] args) {
		CarHibernate aPracticeSample = new CarHibernate();
		aPracticeSample.addNewCars();
		aPracticeSample.showAllCars();
		aPracticeSample.updateCarData();
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
	
	public void showAllCars() {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query allCarsQuery = session.createQuery("select c from Car as c order by c.id");
		
		cars = allCarsQuery.list();
		
		System.out.println("Number of cars: " + cars.size());
		
		Iterator<Car> iterator = cars.iterator();;
		while(iterator.hasNext()) {
			Car element = iterator.next();
			System.out.println(element.toString());
		}
		
		transaction.commit();
	}
	
	private void updateCarData() {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query singleCarQuery = session.createQuery("select c from Car as c where c.model='Civic'");
		
		Car hondaCivic = (Car)singleCarQuery.uniqueResult();
		
		// Change the color
		hondaCivic.setColor("orange");
		
		session.merge(hondaCivic);
		
		transaction.commit();
		
		showAllCars();
		
	}

}
