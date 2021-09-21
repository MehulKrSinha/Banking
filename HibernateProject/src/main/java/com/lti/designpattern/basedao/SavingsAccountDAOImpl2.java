package com.lti.designpattern.basedao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.SavingsAccount;
//DATABASE, HIBERNATE<- ECLIPSE STS-> SPRING, POSTMAN, VSCODE

public class SavingsAccountDAOImpl2 extends BaseDAOImpl implements SavingsAccountDAO {
	
	public void insertSavingsAccount(SavingsAccount ref) {
		// TODO Auto-generated method stub
		super.persist(ref);
	}

	public SavingsAccount selectSavingsAccountByAccountNumber(int acno) {
		return super.find(SavingsAccount.class, acno);
	}

	public List<SavingsAccount> selectAllSavingsAccounts() {
				return super.findAll("SavingsAccount");
		
	}

	public void updateSavingsAccount(SavingsAccount ref) {
			super.merge(ref);
	}

	public void deleteSavingsAccount(SavingsAccount ref) {
			super.remove(ref);
	}

}
