package com.bootcamp.rekening.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.rekening.dao.TransactionTypeDao;
import com.bootcamp.rekening.model.TransactionType;
import com.bootcamp.rekening.model.dto.CommonRespons;


@RestController
public class TransactionTypeController {
	
	@Autowired
	private TransactionTypeDao transactionTypeDao;

	@GetMapping(path = "/transType/{id}")
	public CommonRespons<TransactionType> getId(@PathVariable(name = "id") String id) {
		TransactionType transType = transactionTypeDao.getByid(id);
		CommonRespons<TransactionType> resp = new CommonRespons<>();
		if (transType == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(transType);
		}
		return resp;
	}
	
	@GetMapping(path="/transTypes")
	public CommonRespons<List<TransactionType>> getList(){
		List<TransactionType> list = new ArrayList<>();
		list = transactionTypeDao.getList();
			CommonRespons<List<TransactionType>> resp = new CommonRespons<>();
		if (list == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(list);
		}
		return resp;
	}
	
	@PostMapping(path="/transType")
	public CommonRespons<TransactionType> postTransType(@RequestBody TransactionType transactionType) {
		
		TransactionType transType = transactionTypeDao.save(transactionType);
		CommonRespons<TransactionType> resp = new CommonRespons<>();
		if (transType == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(transType);
		}
		return resp;
	}
	
	@PutMapping(path="/transType")
	public CommonRespons<TransactionType> putTransType(@RequestBody TransactionType transactionType) {
		
		TransactionType transType = transactionTypeDao.save(transactionType);
		CommonRespons<TransactionType> resp = new CommonRespons<>();
		if (transType == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(transType);
		}
		return resp;
	}
}
