package com.lti.designpattern.basedao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.SavingsAccount;

public class BaseDAOImpl {
	EntityManagerFactory entityManagerFactory ; //line number 21 will initialize it
	
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}	
	
	public BaseDAOImpl() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA"); //this will read the persistence.xml file
	}
	public void persist(Object obj) { //persist is a dummy/userdefined name
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();  	
					entityManager.persist(obj);	
					entityTransaction.commit();
		} finally { entityManager.close(); }

	}
	public <AnyClass> AnyClass find(Class<AnyClass> theClass, Serializable pk ) {
		EntityManager entityManager = null;
		AnyClass foundSavingsAccObj = null;
		try {			
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();  	
			foundSavingsAccObj = entityManager.find(theClass, pk);	
			entityTransaction.commit();
		} finally { entityManager.close(); }
			return foundSavingsAccObj;
	}
	
	public <E> List<E>  findAll(String pojoName) {
		EntityManager entityManager = null;
		
		try {			
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			//entityTransaction.begin();  	
			Query query = entityManager.createQuery(" from "+ pojoName);
			return query.getResultList();
			//entityTransaction.commit();
		} finally { entityManager.close(); }
	}
	
	
	public void merge(Object obj) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();  	
					entityManager.merge(obj);	
					entityTransaction.commit();
		} finally { entityManager.close(); }
		
	}
	public void remove(Object obj) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();  	
					entityManager.remove(obj);	
					entityTransaction.commit();
		} finally { entityManager.close(); }
	}
}
