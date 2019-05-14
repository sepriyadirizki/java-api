package com.bootcamp.rekening.dao;

import java.util.List;

import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.bootcamp.rekening.model.Transaction;

public interface TransactionDao {

	List<Transaction> getList();
	List<Transaction> getAccNumb(int accNUmb) throws HttpRequestMethodNotSupportedException;
	Transaction getByid(String id);
	Transaction save(Transaction transaction);
	Transaction delByid(String id);
}
