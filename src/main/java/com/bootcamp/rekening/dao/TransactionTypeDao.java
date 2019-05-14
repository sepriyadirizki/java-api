package com.bootcamp.rekening.dao;

import java.util.List;

import com.bootcamp.rekening.model.TransactionType;



public interface TransactionTypeDao {

	List<TransactionType> getList();
	TransactionType getByid(String id);
	TransactionType save(TransactionType transactionType);
	TransactionType delByid(String id);
}
