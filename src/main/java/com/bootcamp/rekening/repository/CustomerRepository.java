package com.bootcamp.rekening.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bootcamp.rekening.model.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, String>{

	Customer findByEmail(String email);
	
//	@Query(countByid)
//	Integer countByid(long post_email);
//	final String countByid= "SELECT COUNT(email) FROM customer email where email.post_email =?1";
}