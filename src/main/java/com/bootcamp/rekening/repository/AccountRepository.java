package com.bootcamp.rekening.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Customer;

public interface AccountRepository extends JpaRepository<Account, Integer> {
 
	Account findByAcces(String acces);
}
