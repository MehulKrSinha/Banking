package com.lti.daopattern;

import com.lti.SavingsAccount;

public class SavingsAccountDAOTest {

	public static void main(String[] args) {
		SavingsAccountDAO savAccDAO = new SavingsAccountDAOImpl();
		
		SavingsAccount savObj = new SavingsAccount();
		savObj.setAccountNumber(113);
		savObj.setAccountHolderName("Mehul");
		savObj.setAccountBalance(12000);
		savAccDAO.insertSavingsAccount(savObj);
		
	}

}
