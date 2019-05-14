package com.bootcamp.rekening.dao.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.rekening.dao.TransactionDao;
import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.model.Transaction;

public class TransactionDaoImpl implements TransactionDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Transaction> getList() {
		Query query = em.createQuery("From transaction");
		return query.getResultList();
	}

	@Override
	public List<Transaction> getAccNumb(int accNUmb) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Transaction> query = builder.createQuery(Transaction.class);
		Root<Transaction> root = query.from(Transaction.class);
		query.select(root).where(builder.or(builder.equal(root.get("accountNumberDebit"),accNUmb),builder.equal(root.get("accountNumberCredit"),accNUmb)));

		Query q = em.createQuery(query);
		return q.getResultList();
	}

	@Override
	public Transaction getByid(String id) {
		return em.find(Transaction.class, id);
	}

	@Override
	@Transactional
	public Transaction save(Transaction transaction) {
		int number = new Random().nextInt(1000000 + 9000000); // membuat random nomer
		String id = String.valueOf(number);
		transaction.setId(id);
		Transaction save = em.merge(transaction);
		return save;
	}

	@Override
	public Transaction delByid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
