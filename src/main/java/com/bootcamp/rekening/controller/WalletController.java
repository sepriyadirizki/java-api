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
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.rekening.dao.AccountDao;
import com.bootcamp.rekening.dao.WalletAccountDao;
import com.bootcamp.rekening.dao.WalletDao;
import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.model.Wallet;
import com.bootcamp.rekening.model.WalletAccount;
import com.bootcamp.rekening.model.dto.CommonRespons;

@RestController
public class WalletController {

	@Autowired
	private WalletDao walletDao;

	@Autowired
	private WalletAccountDao walletAccountDao;

	@Autowired
	private AccountDao accountDao;

	@GetMapping(path = "/wlt/{id}")
	public CommonRespons<Wallet> getId(@PathVariable(name = "id") int id) {
		Wallet wlt = walletDao.getByid(id);
		CommonRespons<Wallet> resp = new CommonRespons<>();
		if (wlt == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(wlt);
		}
		return resp;
	}
	
	@DeleteMapping(path = "/wlt/{id}")
	public CommonRespons<Wallet> delById(@PathVariable(name="id") int id){
		Wallet wlt = walletDao.delByid(id);
		CommonRespons<Wallet> resp = new CommonRespons<>();
		resp.setData(wlt);
		return resp;
	}

	@GetMapping(path = "/wlts")
	public CommonRespons<List<Wallet>> getList() {
		List<Wallet> list = new ArrayList<>();
		list = walletDao.getList();
		CommonRespons<List<Wallet>> resp = new CommonRespons<>();
		if (list == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(list);
		}
		return resp;
	}

	@PostMapping(path = "/wlt")
	public CommonRespons<Wallet> postWlt(@RequestBody Wallet wallet) {

		Wallet wlt = walletDao.save(wallet);
		CommonRespons<Wallet> resp = new CommonRespons<>();
		if (wlt == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(wlt);
		}
		return resp;
	}



	@PutMapping(path = "/wlt")
	public CommonRespons<Wallet> putWlt(@RequestBody Wallet wallet) {

		Wallet wlt = walletDao.save(wallet);
		CommonRespons<Wallet> resp = new CommonRespons<>();
		if (wlt == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(wlt);
		}
		return resp;
	}
	
	@GetMapping(path = "/wlts/{cif}")
	public CommonRespons<List<Wallet>> getList(@PathVariable(name = "cif") Customer cif) {
		List<Wallet> list = new ArrayList<>();
		list = walletDao.getListCif(cif);
		CommonRespons<List<Wallet>> resp = new CommonRespons<>();
		if (list == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(list);
		}
		return resp;
	}
}
