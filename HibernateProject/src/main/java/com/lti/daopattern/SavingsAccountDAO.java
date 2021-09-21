package com.lti.daopattern;
import java.util.List;
import com.lti.SavingsAccount;

public interface SavingsAccountDAO {
	void insertSavingsAccount(SavingsAccount ref);
	SavingsAccount selectSavingsAccountByAccountNumber(int acno);
	List<SavingsAccount> selectAllSavingsAccount();
	void updateSavingsAccount(SavingsAccount ref);
	void deleteSavingsAccount(SavingsAccount ref);
	
}
