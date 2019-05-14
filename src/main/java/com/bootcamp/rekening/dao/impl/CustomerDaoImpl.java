package com.bootcamp.rekening.dao.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.bootcamp.rekening.dao.CustomerDao;
import com.bootcamp.rekening.exception.EntityNotFoundException;
import com.bootcamp.rekening.exception.UserException;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.repository.CustomerRepository;

public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomerRepository cr;

	@Override
	public List<Customer> getList() {
		Query query = em.createQuery("From customer");
		return query.getResultList();
	}

	@Override
	public Customer getByid(String id) throws EntityNotFoundException {
		if (em.find(Customer.class, id) != null) {
			return em.find(Customer.class, id);
		}
		throw new EntityNotFoundException("405", "Cif Not Found");
	}

	@Override
	public Customer getByEmail(String id) throws EntityNotFoundException   {
		if (cr.findByEmail(id) != null) {
			return cr.findByEmail(id);
		}
		throw new EntityNotFoundException("405", "Email Not Found");
	}

	@Override
	@Transactional
	public Customer save(Customer customer) throws UserException {
		String frstNm = customer.getFirstName();
		char getChar = frstNm.charAt(0);
		int number = new Random().nextInt(1000000 + 9000000); // membuat random nomer
		String cif = getChar + String.valueOf(number);
		customer.setCif(cif);
		
		if (cr.findByEmail(customer.getEmail()) == null) {
			Customer save = em.merge(customer);
			return save;
		}else {
			throw new UserException("11","Email is exist");
		}
		
	}

	@Override
	public Customer login(Customer customer) throws HttpRequestMethodNotSupportedException {

		if (cr.findByEmail(customer.getEmail()) != null) {
			Customer email = cr.findByEmail(customer.getEmail());
			if (customer.getPassword().equals(email.getPassword())) {
				return email;
			}
			throw new HttpRequestMethodNotSupportedException("405", "Wrong Email or password");
		}
		throw new HttpRequestMethodNotSupportedException("405", "Wrong Email or password");
	}

	@Override
	@Transactional
	public Customer update(Customer customer) throws UserException {
		
		Customer save = em.merge(customer);
		return save;
//		
	}



}
