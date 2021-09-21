package com.lti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//removing a record
public class Test3 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManger : "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Got the EntityTransaction : "+entityTransaction);
		
		entityTransaction.begin();
		SavingsAccount savObj1 = entityManager.find(SavingsAccount.class,104); //this will fire the insert query
		entityManager.remove(savObj1);
		
		entityTransaction.commit();
	    System.out.println("object is persisted...");
	     
	    entityManager.close();
	    entityManagerFactory.close();
	    System.out.println("Resources closed....");
		
		
	}

}
