package com.bootcamp.rekening.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.rekening.dao.AccountDao;
import com.bootcamp.rekening.dao.WalletAccountDao;
import com.bootcamp.rekening.dao.WalletDao;
import com.bootcamp.rekening.exception.EntityNotFoundException;
import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Wallet;
import com.bootcamp.rekening.model.WalletAccount;
import com.bootcamp.rekening.model.dto.CommonRespons;

@RestController
//@CrossOrigin(origins="http://localhost:4300")
public class WalletAccountController {

	@Autowired
	private  WalletAccountDao walletAccountDao;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private WalletDao walletDao;
	
	@Autowired
	private Account account;
	

	@Autowired
	private Wallet wallet;

	@GetMapping(path = "/wltAcc/{id}")
	public CommonRespons<WalletAccount> getId(@PathVariable(name = "id") int id) {
		WalletAccount wltAcc = walletAccountDao.getByid(id);
		CommonRespons<WalletAccount> resp = new CommonRespons<>();
		if (wltAcc == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(wltAcc);
		}
		return resp;
	}
	
	@GetMapping(path = "/wltAccNumb/{accNumb}")
	public CommonRespons<List<WalletAccount>> getAccNumb(@PathVariable(name = "accNumb") int accNumb) throws EntityNotFoundException {
		List<WalletAccount> wltAcc = walletAccountDao.getByAccnumb(accNumb);
		CommonRespons<List<WalletAccount>> resp = new CommonRespons<>();
		if (wltAcc.isEmpty()) {
			throw new EntityNotFoundException("405", "Account Number Not Found");
		} else {
			resp.setData(wltAcc);
		}
		return resp;
	}
	
	@GetMapping(path = "/wltId/{wltId}")
	public CommonRespons<List<WalletAccount>> getByWalletS(@PathVariable(name = "wltId") int wltId) throws EntityNotFoundException {
		List<WalletAccount> wltAcc = walletAccountDao.getByWallet(wltId);
		CommonRespons<List<WalletAccount>> resp = new CommonRespons<>();
		if (wltAcc.isEmpty()) {
			throw new EntityNotFoundException("405", "Wallet Id Not Found");
		} else {
			resp.setData(wltAcc);
		}
		return resp;
	}
	
//	@DeleteMapping(path = "/wltacc/{id}")
//	public CommonRespons<List<WalletAccount> > delById(@PathVariable(name="id") int id){
//		wallet = walletDao.getByid(id);
//		List<WalletAccount> wltAcc = walletAccountDao.delByid(wallet);
//		CommonRespons<List<WalletAccount> > resp = new CommonRespons<>();
//		resp.setData(wltAcc);
//		return resp;
//	}
	
	@GetMapping(path="/wltAccs")
	public CommonRespons<List<WalletAccount>> getList() throws EntityNotFoundException{
		List<WalletAccount> list = new ArrayList<>();
		list = walletAccountDao.getList();
			CommonRespons<List<WalletAccount>> resp = new CommonRespons<>();
		if (list.isEmpty()) {
			throw new EntityNotFoundException("405", "Cif Not Found");
		} else {
			resp.setData(list);
		}
		return resp;
	}
	
	@PostMapping(path="/wltAcc")
	public CommonRespons<WalletAccount> postWltAcc(@RequestBody WalletAccount walletAccount) {
		
		WalletAccount wltAcc = walletAccountDao.save(walletAccount);
		CommonRespons<WalletAccount> resp = new CommonRespons<>();
		if (wltAcc == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(wltAcc);
		}
		return resp;
	}
	
	@PutMapping(path="/wltAcc")
	public CommonRespons<WalletAccount> putWltAcc(@RequestBody WalletAccount walletAccount) {
		
		WalletAccount wltAcc = walletAccountDao.save(walletAccount);
		CommonRespons<WalletAccount> resp = new CommonRespons<>();
		if (wltAcc == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(wltAcc);
		}
		return resp;
	}
}
