package com.bootcamp.rekening.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.rekening.dao.CustomerDao;
import com.bootcamp.rekening.exception.EntityNotFoundException;
import com.bootcamp.rekening.exception.UserException;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.model.dto.CommonRespons;

@RestController
//@CrossOrigin(origins="http://localhost:4300")
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;

	@GetMapping(path = "/cust/{email}")
	public CommonRespons<Customer> getemail(@PathVariable(name = "email") String id) throws EntityNotFoundException {
		
			Customer cust = customerDao.getByEmail(id);
			CommonRespons<Customer> resp = new CommonRespons<>();
			if (cust == null) {
				resp.setResponsCode("99");
				resp.setResponsMessage("Not Found");
			} else {
				resp.setData(cust);
			}
			return resp;
		
	}

	@GetMapping(path = "/custid/{id}")
	public CommonRespons<Customer> getId(@PathVariable(name = "id") String id) throws EntityNotFoundException {
		Customer cust = customerDao.getByid(id);
		CommonRespons<Customer> resp = new CommonRespons<>();
		
			resp.setData(cust);
		
		return resp;
	}

	@PostMapping(path = "/cust")
	public CommonRespons<Customer> postCust(@RequestBody Customer Customer) throws UserException {
		Customer cust = customerDao.save(Customer);
		cust.setFirstName(Customer.getFirstName());
		cust.setLastName(Customer.getLastName());
		cust.setBirthDate(Customer.getBirthDate());
		CommonRespons<Customer> resp = new CommonRespons<>();
			resp.setData(cust);
		return resp;
	}
	
	
	@PostMapping(path = "/login")
	public CommonRespons<Customer> login(@RequestBody Customer customer) throws HttpRequestMethodNotSupportedException {
		CommonRespons<Customer> resp = new CommonRespons<>();
		Customer cust = customerDao.login(customer);
		resp.setData(cust);
		return resp;
	}
	
	@GetMapping(path = "/custs")
	public CommonRespons<List<Customer>> getList() {
		List<Customer> list = new ArrayList<>();
		list = customerDao.getList();
		CommonRespons<List<Customer>> resp = new CommonRespons<>();
		if (list == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(list);
		}
		return resp;
	}
	

	@PutMapping(path = "/cust")
	public CommonRespons<Customer> putCust(@RequestBody Customer Customer) throws UserException  {
		Customer cust = customerDao.update(Customer);
		cust.setCif(Customer.getCif());
		cust.setFirstName(Customer.getFirstName());
		cust.setLastName(Customer.getLastName());
		cust.setBirthDate(Customer.getBirthDate());
		CommonRespons<Customer> resp = new CommonRespons<>();
		if (cust == null) {
			resp.setResponsCode("99");
			resp.setResponsMessage("Not Found");
		} else {
			resp.setData(cust);
		}
		return resp;
	}


}
