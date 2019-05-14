package com.bootcamp.rekening.dao;

import java.util.List;

import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.model.Wallet;

public interface WalletDao {
	
	List<Wallet> getList();
	Wallet getByid(int id);
	Wallet save(Wallet wallet);
	Wallet delByid(int id);
	List<Wallet> getListCif(Customer cif) ;

}
