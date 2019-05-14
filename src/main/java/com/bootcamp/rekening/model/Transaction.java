package com.bootcamp.rekening.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "transaction")
@Table (name = "transaction")
public class Transaction {
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="date", insertable=false,updatable=false)
	private String date;
	
	@Column(name="account_number_debit")
	private int accountNumberDebit;
	
	@Column(name="account_number_credit")
	private int accountNumberCredit;
	
	@Column(name="amount")
	private float amount;
		
	
	@Column(name="transaction_type")
	private String transactionType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAccountNumberDebit() {
		return accountNumberDebit;
	}

	public void setAccountNumberDebit(int accountNumberDebit) {
		this.accountNumberDebit = accountNumberDebit;
	}

	public int getAccountNumberCredit() {
		return accountNumberCredit;
	}

	public void setAccountNumberCredit(int accountNumberCredit) {
		this.accountNumberCredit = accountNumberCredit;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	

	
	
	
}
