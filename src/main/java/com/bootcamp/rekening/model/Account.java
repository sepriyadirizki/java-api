package com.bootcamp.rekening.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity(name = "account")
@Table (name = "account")
public class Account {

	@Id

	@Column(name="account_number")
	private int accountNumber;   
	
	@Column(name="account_name")
	private String accountName;
	
	@Column(name="open_date", insertable=false,updatable=false)
	private String openDate;
	
	@Column(name="Balance")
	private float balance;
	
	@ManyToOne
	@JoinColumn(name="cif")
	private Customer Customer;
	
	@Column(name="acces")
	private String acces;
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}


	public Customer getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer customer) {
		Customer = customer;
	}

	public String getAcces() {
		return acces;
	}

	public void setAcces(String acces) {
		this.acces = acces;
	}


	
	
}
