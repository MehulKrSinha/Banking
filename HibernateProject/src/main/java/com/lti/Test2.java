package com.lti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//finding or viewing a new record
public class Test2 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManger : "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Got the EntityTransaction : "+entityTransaction);
		
		entityTransaction.begin();
		
		
		SavingsAccount savObj = entityManager.find(SavingsAccount.class,103); //this will fire the insert query
		System.out.println("Account Number  : "+savObj.getAccountNumber());
		System.out.println("Account Name    : "+savObj.getAccountHolderName());
		System.out.println("Account Balance : "+savObj.getAccountBalance());
		
		entityTransaction.commit();
	    System.out.println("object is persisted...");
	     
	    entityManager.close();
	    entityManagerFactory.close();
	    System.out.println("Resources closed....");
		
	}

}
