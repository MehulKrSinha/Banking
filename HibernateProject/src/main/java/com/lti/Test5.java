package com.lti;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
//printing the records in a list
public class Test5 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManger : "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Got the EntityTransaction : "+entityTransaction);
		
		entityTransaction.begin();
		
		Query myQuery = entityManager.createQuery("from SavingsAccount"); // JPQL
		
		List<SavingsAccount> mySavingsList = myQuery.getResultList();
		
		for(SavingsAccount theAccount : mySavingsList ) { //
			
			System.out.println("Account Number  : "+theAccount.getAccountNumber());
			System.out.println("Account Name    : "+theAccount.getAccountHolderName());
			System.out.println("Account Balance : "+theAccount.getAccountBalance());
			System.out.println("--------------------");
		}
		
		entityTransaction.commit();
	    System.out.println("object is persisted...");
	     
	    entityManager.close();
	    entityManagerFactory.close();
	    System.out.println("Resources closed....");
		
	}

}
