package com.bootcamp.rekening.dao;

import java.util.List;

import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.bootcamp.rekening.exception.EntityNotFoundException;
import com.bootcamp.rekening.exception.UserException;
import com.bootcamp.rekening.model.Customer;
public interface CustomerDao {

	List<Customer> getList();
	Customer getByid(String id) throws EntityNotFoundException ;
	Customer getByEmail(String id) throws EntityNotFoundException;
	Customer save(Customer customer) throws UserException;
	Customer login(Customer customer) throws HttpRequestMethodNotSupportedException;
	Customer update(Customer customer) throws UserException;

	
}
