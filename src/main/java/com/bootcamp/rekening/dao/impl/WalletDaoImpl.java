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
import com.bootcamp.rekening.dao.WalletDao;
import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.model.Wallet;
import com.bootcamp.rekening.model.WalletAccount;

public class WalletDaoImpl implements WalletDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Wallet> getList() {
		Query query = em.createQuery("From wallet");
		return query.getResultList();
	}

	@Override
	public Wallet getByid(int id) {
		return em.find(Wallet.class, id);
	}

	@Override
	@Transactional
	public Wallet save(Wallet wallet) {
		int number = new Random().nextInt(1000000 + 9000000); // membuat random nomer
		wallet.setId(number);
//		wallet.setDescription("terdaftar");
		Wallet save = em.merge(wallet);
		return save;
	}

	@Override
	@Transactional
	public Wallet delByid(int id) {
		Wallet wlt =  em.find(Wallet.class, id);
		em.remove(wlt);
		return wlt;
	}

	@Override
	public List<Wallet> getListCif(Customer cif) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Wallet> query = builder.createQuery(Wallet.class);
		Root<Wallet> root = query.from(Wallet.class);
		query.select(root).where(builder.equal(root.get("cif"), cif));

		Query q = em.createQuery(query);
	
		return q.getResultList();
	
	}

}
