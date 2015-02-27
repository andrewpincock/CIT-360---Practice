package net.codyconder.hibernate.practice;

import java.util.Iterator;
import java.util.List;

import org.hibernate.AssertionFailure;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.hql.internal.ast.QuerySyntaxException;

public class CarHibernate {
	private List<Car> cars;
	
	public CarHibernate() {
		
	}
	
	public static void main(String[] args) {
		CarHibernate aPracticeSample = new CarHibernate();
		aPracticeSample.addNewCars();
		aPracticeSample.nastyInsertions();
		aPracticeSample.showAllCars();
		aPracticeSample.queryNonexistentTable();
		aPracticeSample.updateCarData();
		aPracticeSample.updateToNullData();
		aPracticeSample.deleteCars();
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
	
	public void nastyInsertions() {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		Owner anOwner = new Owner();
		anOwner.setFirstName("Fred");
		anOwner.setLastName("Bobington");
		anOwner.setGender("he-she");
		
		Owner anotherOwner = new Owner();
		anotherOwner.setFirstName(null);
		anotherOwner.setLastName(null);
		anotherOwner.setGender(null);
		
		Car nastyCar = new Car();
		nastyCar.setYear(null);
		nastyCar.setModel(null);
		
		try {
			session.save(anOwner);
		} catch (GenericJDBCException e) {
			System.out.println("Insertion 1 to Owner table failed due to lack of auto-increment in ID column");
		} catch (ConstraintViolationException e) {
			System.out.println("Insertion 1 to Owner table also failed due to a null value.");
		}
		
		try {
			session.save(anotherOwner);
		} catch (GenericJDBCException e) {
			System.out.println("Insertion 1 to Owner table failed due to lack of auto-increment in ID column");
		} catch (ConstraintViolationException e) {
			System.out.println("Insertion 1 to Owner table also failed due to a null value.");
		}
		
		try {
			session.save(nastyCar);
		} catch (ConstraintViolationException e) {
			System.out.println("Insertion to Car table failed due to a null value");
		}
		
		try {
			transaction.commit();
		} catch (AssertionFailure e) {
			System.out.println("Apparently, trying to commit the transaction after a failure isn't a good idea... who knew?!");
			System.out.println("Rolling back transaction...");
			transaction.rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
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
	
	private void queryNonexistentTable() {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			Query nonexistentTableQuery = session.createQuery("select d from Dog as d");
			Car aDog = (Car)nonexistentTableQuery.uniqueResult();
			transaction.commit();
		} catch (QuerySyntaxException e) {
			System.out.println("Dog table does not exist. Oops!");
			transaction.rollback();
		}
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
	
	private void updateToNullData() {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query singleCarQuery = session.createQuery("select c from Car as c where c.model='Civic'");
		
		Car hondaCivic = (Car)singleCarQuery.uniqueResult();
		
		// Change the year to a null value
		hondaCivic.setYear(null);
		
		session.merge(hondaCivic);
		
		try {
			transaction.commit();
		} catch (ConstraintViolationException e) {
			System.out.println("Can't update to a null value. Rolling back.");
			transaction.rollback();
		}
		
		showAllCars();
	}
	
	private void deleteCars() {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		int numCars = cars.size();
		System.out.println("Car count: "+numCars);
		for(int i = 0; i < numCars; i++){
			System.out.println("deleting car "+cars.get(i).getMake()+" "+cars.get(i).getModel()
					+" with ID "+cars.get(i).getId());
			session.delete(cars.get(i));
		}
		transaction.commit();
		
		System.out.println(cars);
		cars.clear();
		
		System.out.println("Car objects cleared.");
		System.out.println(cars);
	}

}
