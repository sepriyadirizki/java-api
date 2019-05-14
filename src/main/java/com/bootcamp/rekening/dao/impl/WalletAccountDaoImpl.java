package com.bootcamp.rekening.dao.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.rekening.dao.WalletAccountDao;
import com.bootcamp.rekening.dao.WalletDao;
import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Wallet;
import com.bootcamp.rekening.model.WalletAccount;
import com.bootcamp.rekening.repository.WalletAccountRepository;

public class WalletAccountDaoImpl implements WalletAccountDao {
	

	@Autowired
	private WalletDao walletDao;
	
	@Autowired
	private WalletAccountRepository cr;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<WalletAccount> getList() {
		Query query = em.createQuery("From walletAccount");
		return query.getResultList();
	}

	@Override
	public WalletAccount getByid(int id) {
		return em.find(WalletAccount.class, id);
	}

	@Override
	public List<WalletAccount> getByAccnumb(int accNumb) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<WalletAccount> query = builder.createQuery(WalletAccount.class);
		Root<WalletAccount> root = query.from(WalletAccount.class);

		query.select(root).where(builder.equal(root.get("account"), accNumb));

		Query q = em.createQuery(query);
	
		return q.getResultList();
	}
		
	@Override
	@Transactional
	public WalletAccount save(WalletAccount walletAccount) {
//		int number = new Random().nextInt(1000000 + 9000000); // membuat random nomer
//		walletAccount.setWallet(number);
		WalletAccount save = em.merge(walletAccount);
		return save;
	}

//	@Override
//	@Transactional
	public List<WalletAccount>  delByid(Wallet id) {
//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<WalletAccount> query = builder.createQuery(WalletAccount.class);
//		Root<WalletAccount> root = query.from(WalletAccount.class);
//		query.select(root).where(builder.equal(root.get("wallet"), id));
//		Query q = em.createQuery(query);
//		em.remove(q);
//		return (WalletAccount) q.getSingleResult();
		
		List<WalletAccount> wlt =  cr.findByWallet(id);
		em.remove(wlt);
		return wlt;
	}

	@Override
	public List<WalletAccount> getByWallet(int wallet) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<WalletAccount> query = builder.createQuery(WalletAccount.class);
		Root<WalletAccount> root = query.from(WalletAccount.class);

		query.select(root).where(builder.equal(root.get("wallet"), wallet));

		Query q = em.createQuery(query);
	
		return q.getResultList();
	}


}
