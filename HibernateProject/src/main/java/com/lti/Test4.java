package com.lti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//updating the records
public class Test4 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManger : "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Got the EntityTransaction : "+entityTransaction);
		
		entityTransaction.begin();
		
		
		SavingsAccount savObj = entityManager.find(SavingsAccount.class,101); //this will fire the insert query
		System.out.println("Account Number  : "+savObj.getAccountNumber());
		System.out.println("Account Name    : "+savObj.getAccountHolderName());
		System.out.println("Account Balance : "+savObj.getAccountBalance());
		
		//on the attached object, if you call any setter method, means 
		//the attached object is modified... this will trigger the update query on that 
		//object
		
		savObj.setAccountBalance(66000);
		savObj.setAccountHolderName("JULIAN");
		
		entityManager.merge(savObj); // it will fire the update query 
		
		SavingsAccount savObj2 = new SavingsAccount();//detached
		savObj2.setAccountNumber(999);
		savObj2.setAccountHolderName("Mehul");
		savObj2.setAccountBalance(20000);
		entityManager.merge(savObj2); // it will create 
		//a new record if object is not found   saveOrUpdate
		
		
		entityTransaction.commit();
	    System.out.println("object is persisted...");
	     
	    entityManager.close();
	    entityManagerFactory.close();
	    System.out.println("Resources closed....");
		
	}

}
