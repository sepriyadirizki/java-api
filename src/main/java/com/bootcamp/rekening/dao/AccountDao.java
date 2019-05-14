package com.bootcamp.rekening.dao;

import java.util.List;

import com.bootcamp.rekening.exception.EntityNotFoundException;
import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Customer;


public interface AccountDao {

	List<Account> getList();
	List<Account> getListCif(Customer Customer) ;
	Account getByid(int id);
	Account getByAcces(String acces);
	Account save(Account account);
	Account update(Account account);
	Account minBalance(float ammount, int accNumb) throws EntityNotFoundException;
	Account plusBalance(float ammount, int accNumb);

}
