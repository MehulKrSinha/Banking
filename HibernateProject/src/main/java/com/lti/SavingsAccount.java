package com.lti;

import javax.persistence.*;

@Entity //<--declared as an entity, which must have a primary key
@Table(name="savings") //<--table name is savings
public class SavingsAccount {
	
	@Id
	@Column(name="acno")
	private int accountNumber;
	
	@Column(name="acholder")
	private String accountHolderName;
	
	@Column(name="acbal")
	private double accountBalance;

	public int getAccountNumber() {
		return accountNumber;
	}

	@Embedded
	PanCard panCard;  //hasA relation
	
	@Embedded
	Address homeAddress;	//hasA relation	

	public SavingsAccount() {
		super();
		System.out.println("Default constructor called");
	}
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public PanCard getPanCard() {
		return panCard;
	}

	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}



	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
