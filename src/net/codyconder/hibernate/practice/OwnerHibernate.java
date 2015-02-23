package net.codyconder.hibernate.practice;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OwnerHibernate {

	private List<Car> cars;
	
	public OwnerHibernate() {
		
	}
	
	public static void main(String[] args) {
		OwnerHibernate anOwnerSample = new OwnerHibernate();
		anOwnerSample.addOwner();
		anOwnerSample.addCars();
		anOwnerSample.deleteOwner();

	}

	private void addOwner() {
		
		
	}
	
	private void addCars() {
		
		
	}
	
	private void deleteOwner() {
		
		
	}

}
