package com.bootcamp.rekening.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.rekening.dao.AccountDao;
import com.bootcamp.rekening.dao.TransactionDao;
import com.bootcamp.rekening.dao.TransactionTypeDao;
import com.bootcamp.rekening.exception.EntityNotFoundException;
import com.bootcamp.rekening.exception.UserException;
import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.model.Transaction;
import com.bootcamp.rekening.model.TransactionType;
import com.bootcamp.rekening.model.dto.CommonRespons;

;

@RestController
public class TransactionController {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private TransactionTypeDao transactionTypeDao;

	@Autowired
	private Account account;

//	Account account = new Account();

	@GetMapping(path = "/trans/{id}")
	public CommonRespons<Transaction> getId(@PathVariable(name = "id") String id) {
		Transaction trans = transactionDao.getByid(id);
		CommonRespons<Transaction> resp = new CommonRespons<>();
		if (trans == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(trans);
		}
		return resp;
	}

	@GetMapping(path = "/transs/{accNumb}")
	public CommonRespons<List<Transaction>> getList(@PathVariable(name = "accNumb") int accNumb)
			throws HttpRequestMethodNotSupportedException, EntityNotFoundException {
		List<Transaction> list = new ArrayList<>();
		list = transactionDao.getAccNumb(accNumb);
		CommonRespons<List<Transaction>> resp = new CommonRespons<>();
		if (list.isEmpty()) {
			throw new EntityNotFoundException("405", "Account Number Not Found");
		} else {
			resp.setData(list);
		}
		return resp;
	}

	@PostMapping(path = "/trans1")
	public CommonRespons<Transaction> topUp(@RequestBody Transaction transaction) {
		Transaction trans = transactionDao.save(transaction);// untuk save
		TransactionType tType = transactionTypeDao.getByid("T001");
//		trans.setTransactionType(tType.getDescription()); sementara di ganti pake kodenya
		trans.setTransactionType(tType.getCode());
		Account acc = accountDao.plusBalance(trans.getAmount(), trans.getAccountNumberCredit());// untuk update balance
		CommonRespons<Transaction> resp = new CommonRespons<>();
		if (trans == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(trans);
		}
		return resp;
	}

	@PostMapping(path = "/trans2")
	public CommonRespons<Transaction> tarikTunai(@RequestBody Transaction transaction)
			throws EntityNotFoundException, UserException {

		Account getId = accountDao.getByid(transaction.getAccountNumberDebit());
		if (getId.getBalance() - transaction.getAmount() < 50000) {
			throw new EntityNotFoundException("10003", "insufficient balance1");
		} else {
			if (transaction.getAmount() < 50000) {
				throw new UserException("11", "ammount of less than 50000");
			}else if (transaction.getAmount()%50000!=0) {
				throw new UserException("12", "must be a multiple of 50000");
			} else {
				Transaction trans = transactionDao.save(transaction);
				TransactionType tType = transactionTypeDao.getByid("T002");
//				trans.setTransactionType(tType.getDescription());
				trans.setTransactionType(tType.getCode());
				Account acc = accountDao.minBalance(trans.getAmount(), trans.getAccountNumberDebit());
				CommonRespons<Transaction> resp = new CommonRespons<>();
//		if (trans == null) {
//			resp.setResponsCode("99");
//			resp.setResponsMessage("Not Found");
//		} else {
				resp.setData(trans);
//		}
				return resp;
			}
		}
	}

	@PostMapping(path = "/trans3")
	public CommonRespons<Transaction> transfer(@RequestBody Transaction transaction) throws EntityNotFoundException {

		Account getId = accountDao.getByid(transaction.getAccountNumberDebit());
		if (getId.getBalance() - transaction.getAmount() < 50000) {
			throw new EntityNotFoundException("10003", "insufficient balance1");
		} else if (transaction.getAccountNumberCredit() == transaction.getAccountNumberDebit()) {
			throw new EntityNotFoundException("10004", "The account number cannot be the same");
		} else {

			Transaction trans = transactionDao.save(transaction);
			TransactionType tType = transactionTypeDao.getByid("T003");
//			trans.setTransactionType(tType.getDescription());
			trans.setTransactionType(tType.getCode());
			Account acc = accountDao.plusBalance(trans.getAmount(), trans.getAccountNumberCredit());
			Account acc1 = accountDao.minBalance(trans.getAmount(), trans.getAccountNumberDebit());
			CommonRespons<Transaction> resp = new CommonRespons<>();
//			if (trans == null) {
//				resp.setResponsCode("99");
//				resp.setResponsMessage("Not Found");
//			} else {
			resp.setData(trans);
//			}
			return resp;
		}
	}

	@PutMapping(path = "/trans")
	public CommonRespons<Transaction> putTrans(@RequestBody Transaction transaction) {
		Transaction trans = transactionDao.save(transaction);
		CommonRespons<Transaction> resp = new CommonRespons<>();
		if (trans == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(trans);
		}
		return resp;
	}

	@GetMapping(path = "/transs")
	public CommonRespons<List<Transaction>> getList() {
		List<Transaction> list = new ArrayList<>();
		list = transactionDao.getList();
		CommonRespons<List<Transaction>> resp = new CommonRespons<>();
		if (list == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(list);
		}
		return resp;
	}

	@DeleteMapping(path = "/trans/{id}")
	public CommonRespons<Transaction> delById(@PathVariable(name = "id") String id) {
		Transaction trans = transactionDao.delByid(id);
		CommonRespons<Transaction> resp = new CommonRespons<>();
		if (trans == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(trans);
		}
		return resp;
	}
}
