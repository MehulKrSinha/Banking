package com.lti.daopattern;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.SavingsAccount;

public class SavingsAccountDAOImpl implements SavingsAccountDAO {
	
	EntityManagerFactory entityManagerFactory;
	
	public SavingsAccountDAOImpl() {
		this.entityManagerFactory  = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
		
	}
	
	public void insertSavingsAccount(SavingsAccount ref) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManger : "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("EntityTransaction created : "+entityTransaction);
		entityTransaction.begin();
			System.out.println("Entity Transaction Begin");
			entityManager.persist(ref);
			System.out.println("Object persisted...");
			entityTransaction.commit();
			System.out.println("Entity Transaction commited...");
			entityManager.close();
			System.out.println("Closed");
	}

	public SavingsAccount selectSavingsAccountByAccountNumber(int acno) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManger : "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("EntityTransaction created : "+entityTransaction);
		entityTransaction.begin();
			System.out.println("Entity Transaction Begin");
			SavingsAccount foundObj = entityManager.find(SavingsAccount.class,acno);
			System.out.println("Object found...");
			//entityTransaction.commit();
			//System.out.println("Entity Transaction commited...");
			entityManager.close();
			System.out.println("Closed");
		return foundObj;
	}

	public List<SavingsAccount> selectAllSavingsAccount() {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManger : "+entityManager);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Got the EntityTransaction : "+entityTransaction);
		entityTransaction.begin();
		
		Query myQuery = entityManager.createQuery("from SavingsAccount"); // JPQL
		List<SavingsAccount> mySavingsList = myQuery.getResultList();
		
		entityTransaction.commit();
	    System.out.println("object is persisted...");
	     
	    entityManager.close();
	    System.out.println("Resources closed....");
	
		return mySavingsList;
	}

	public void updateSavingsAccount(SavingsAccount ref) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManger : "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("EntityTransaction created : "+entityTransaction);
		entityTransaction.begin();
			System.out.println("Entity Transaction Begin");
			SavingsAccount foundObj = entityManager.merge(ref);
			System.out.println("Object updated...");
			
			entityTransaction.commit();
			System.out.println("Entitty Transaction commited...");
			entityManager.close();
			System.out.println("Closed");
		
	}

	public void deleteSavingsAccount(SavingsAccount ref) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManger : "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("EntityTransaction created : "+entityTransaction);
		entityTransaction.begin();
		System.out.println("Entity Transaction Begin");
		SavingsAccount foundSavingsAccObj = entityManager.find(SavingsAccount.class,ref.getAccountNumber());

		System.out.println("Object found...");
		entityManager.remove(foundSavingsAccObj);
		System.out.println("Object deleted...");
		entityTransaction.commit();
		System.out.println("Entitty Transaction commited..."); 
		entityManager.close();

	}

}
