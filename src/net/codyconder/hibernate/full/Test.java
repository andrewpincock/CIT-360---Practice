package net.codyconder.hibernate.full;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {

	public static void main(String[] args) {
		// Create the owner
		Owner owner1 = new Owner();
		owner1.setFirstName("Cody");
		owner1.setLastName("Conder");
		owner1.setGender("male");
		
		// Create the cars
		Car car1 = new Car(owner1, "2005", "Honda", "Civic", "silver");
		Car car2 = new Car(owner1, "2015", "Honda", "Accord", "grey");
		
		// Add the cars to a set
		Set<Car> codysCars = new HashSet<Car>();
		codysCars.add(car1);
		codysCars.add(car2);
		
		// Assign the set to the owner
		owner1.setCars(codysCars);
		
		// Hibernate magic!
		Session session;
		session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(owner1);
			session.save(car1);
			session.save(car2);
			
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}
