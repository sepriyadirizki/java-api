package com.bootcamp.rekening.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.rekening.dao.AccountDao;
import com.bootcamp.rekening.dao.TransactionDao;
import com.bootcamp.rekening.dao.TransactionTypeDao;
import com.bootcamp.rekening.exception.EntityNotFoundException;
import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.model.Transaction;
import com.bootcamp.rekening.model.TransactionType;
import com.bootcamp.rekening.model.Wallet;
import com.bootcamp.rekening.repository.AccountRepository;
import com.bootcamp.rekening.repository.CustomerRepository;

@SuppressWarnings("unused")
public class AccountDaoImpl implements AccountDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private AccountRepository cr;
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private TransactionTypeDao transactionTypeDao;
	
	@Autowired
	private Transaction trans;
	
//	Transaction trans = new Transaction();

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getList() {
		Query query = em.createQuery("From account");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getListCif(Customer Customer) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Account> query = builder.createQuery(Account.class);
		Root<Account> root = query.from(Account.class);
		query.select(root).where(builder.equal(root.get("Customer"), Customer));

		Query q = em.createQuery(query);
	
		return q.getResultList();
	}

	@Override
	public Account getByid(int id) {
		Account account = em.find(Account.class, id);
		
		return account;
	}



	@Override
	@Transactional
	public Account save(Account account) {
		int number = new Random().nextInt(100000000 + 900000000); // membuat random nomer
		int acces = new Random().nextInt(100000 + 900000); // membuat random acces
		String acs = String.valueOf(acces);
		account.setAccountNumber(number);
		account.setAcces(acs);
		TransactionType tType = transactionTypeDao.getByid("T004");
		trans.setAccountNumberCredit(number);
		trans.setAmount(account.getBalance());
		trans.setTransactionType(tType.getCode());
		transactionDao.save(trans);		
		Account save = em.merge(account);
		return save;
	}

	@Override
	@Transactional
	public Account update(Account account) {
		Account save = em.merge(account);
		return save;
	}

	@Override
	@Transactional
	public Account minBalance(float ammount, int accNumb) throws EntityNotFoundException {
		Account balance = em.find(Account.class, accNumb);
		float oldBallance = balance.getBalance();
		if(oldBallance - ammount < 50000) {
			throw new EntityNotFoundException("10003", "insufficient balance");
		}else {
			balance.setBalance(oldBallance - ammount);
			Account save = em.merge(balance);
			return save;
		}
		
	}

	@Override
	@Transactional
	public Account plusBalance(float ammount, int accNumb) {
		Account balance = em.find(Account.class, accNumb);
		float oldBallance = balance.getBalance();
		balance.setBalance(oldBallance + ammount);
		Account save = em.merge(balance);
		return save;

	}



	@Override
	public Account getByAcces(String acces) {
		return 	cr.findByAcces(acces);
	}



}
