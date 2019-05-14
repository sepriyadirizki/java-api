package com.bootcamp.rekening.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.rekening.dao.AccountDao;
import com.bootcamp.rekening.dao.CustomerDao;
import com.bootcamp.rekening.exception.EntityNotFoundException;
import com.bootcamp.rekening.exception.UserException;
import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.model.dto.CommonRespons;

@RestController
public class AccountController {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private Customer customer;

	@GetMapping(path = "/accounts/{cif}")
//	@GetMapping(path = "/cust/{cif}/accs")
	public List<Account> getCif(@PathVariable(name = "cif") String cif) throws EntityNotFoundException {
		customer = customerDao.getByid(cif);
		return accountDao.getListCif(customer);
	}

//	@GetMapping(path = "/accs/{cif}")
//	public CommonRespons<List<Account>> getList(@PathVariable(name = "cif") Customer cif) {
//		List<Account> list = new ArrayList<>();
//		list = accountDao.getListCif(cif);
//		CommonRespons<List<Account>> resp = new CommonRespons<>();
//		if (list == null) {
//			resp.setResponsCode("99");
//			resp.setResponsMessage("Not Found");
//		} else {
//			resp.setData(list);
//		}
//		return resp;
//	}

	@GetMapping(path = "/acc/{id}")
	public CommonRespons<Account> getId(@PathVariable(name = "id") int id) throws EntityNotFoundException {

		Account acc = accountDao.getByid(id);
		CommonRespons<Account> resp = new CommonRespons<>();
		if (acc == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(acc);
		}
		return resp;

	}

	@GetMapping(path = "/account/{acces}")

	public CommonRespons<Account> getEmail(@PathVariable(name = "acces") String acces) {
		Account acc = accountDao.getByAcces(acces);
		CommonRespons<Account> resp = new CommonRespons<>();
		if (acc == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(acc);
		}
		return resp;
	}

	@PostMapping(path = "/acc")
	public CommonRespons<Account> postAcc(@RequestBody Account account) throws UserException {

	
//		Customer cif = customerDao.getByid(account.getCif().toString());
		if (account.getBalance() != 150000 ) {
			throw new UserException("11", "Minimum balance 50000 or 150000");
		} else {
			Account acc = accountDao.save(account);
			CommonRespons<Account> resp = new CommonRespons<>();
//		if (cif == null) {
//			resp.setResponsCode("99");
//			resp.setResponsMessage("Cif Not Found");
//		} else {
			if (acc == null) {
				resp.setResponsCode("99");
				resp.setResponsMessage("Not Found");
			} else {
				resp.setData(acc);
			}
//		}
			return resp;
		}
	}

	@PutMapping(path = "/acc")
	public CommonRespons<Account> putAcc(@RequestBody Account account) {
		Account acc = accountDao.update(account);

		acc.setAccountName(account.getAccountName());
		acc.setBalance(account.getBalance());
		acc.setCustomer(account.getCustomer());
		acc.setAcces(account.getAcces());
		CommonRespons<Account> resp = new CommonRespons<>();
		if (acc == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(acc);
		}
		return resp;
	}

	@GetMapping(path = "/accs")
	public CommonRespons<List<Account>> getList() {
		List<Account> list = new ArrayList<>();
		list = accountDao.getList();
		CommonRespons<List<Account>> resp = new CommonRespons<>();
		if (list == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(list);
		}
		return resp;
	}

}
