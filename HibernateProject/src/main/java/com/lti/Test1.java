package com.lti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//inserting a new record
public class Test1 {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManger : "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Got the EntityTransaction : "+entityTransaction);
		
		entityTransaction.begin();
			
		SavingsAccount savObj = new SavingsAccount();
			savObj.setAccountNumber(104);
			savObj.setAccountHolderName("Jane");
			savObj.setAccountBalance(8000);
		
		entityManager.persist(savObj);//create the object
	    
		
		entityTransaction.commit();
	    System.out.println("object is persisted...");
	     
	    entityManager.close();
	    entityManagerFactory.close();
	    System.out.println("Resources closed....");
		
	}

}
