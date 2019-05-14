package com.bootcamp.rekening.dao.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.rekening.dao.TransactionTypeDao;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.model.TransactionType;
import com.bootcamp.rekening.model.Wallet;

public class TransactionTypeDaoImpl implements TransactionTypeDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TransactionType> getList() {
		Query query = em.createQuery("From transactionType");
		return query.getResultList();
	}

	@Override
	public TransactionType getByid(String id) {
		return em.find(TransactionType.class, id);
	}

	@Override
	@Transactional
	public TransactionType save(TransactionType transactionType) {
		String descriptiion = transactionType.getDescription();
		char getChar = descriptiion.charAt(2);
		int number = new Random().nextInt(10+ 99); // membuat random nomer
		String cd = getChar + String.valueOf(number);
		transactionType.setCode(cd);
		TransactionType save = em.merge(transactionType);
		return save;
	}

	@Override
	public TransactionType delByid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
