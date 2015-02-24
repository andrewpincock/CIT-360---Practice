package net.codyconder.hibernate.working;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Model {
	/*
	 * Owner Database Methods
	 */
	public void insertOwner(String firstName, String lastName, String gender) {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Owner newOwner = new Owner(firstName, lastName, gender);

		session.save(newOwner);

		transaction.commit();
	}

	public List<Owner> queryAllOwners() {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Query ownersQuery = session.createQuery("Select o from Owner as o");

		@SuppressWarnings("unchecked")
		List<Owner> ownersList = ownersQuery.list();

		transaction.commit();

		return ownersList;
	}

	public Owner queryOwnerById(Integer anId) {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Query singleOwnerQuery = session.createQuery("Select o from Owner as o where o.id = :anId");
		singleOwnerQuery.setParameter("anId", anId);

		Owner singleOwner = (Owner) singleOwnerQuery.uniqueResult();

		transaction.commit();

		return singleOwner;
	}

	public void mergeOwnerInformation(Owner anOwnerToUpdate) {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Query singleOwnerUpdate = session.createQuery("Select o from Owner as o where o.id = :anId");
		singleOwnerUpdate.setParameter("anId", anOwnerToUpdate.getId());

		session.merge(anOwnerToUpdate);

		transaction.commit();
	}

	public void deleteOwnerFromDatabase(Owner anOwnerToDelete) {
		Session session = DatabaseConnection.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		session.delete(anOwnerToDelete);

		transaction.commit();
	}

	/*
	 * Car Database Methods
	 */
}
