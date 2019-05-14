package com.bootcamp.rekening.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "wallet_account")
@Table (name = "wallet_account")
public class WalletAccount {

	@Id
	@Column(name = "id")
	private int id;
	
    @ManyToOne
	@JoinColumn(name="account_number")
	private Account account;

    @ManyToOne
	@JoinColumn(name="wallet_id")
	private Wallet wallet;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
    
    
	
	
}
