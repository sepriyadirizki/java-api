package com.bootcamp.rekening.config.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bootcamp.rekening.dao.CustomerDao;
import com.bootcamp.rekening.exception.EntityNotFoundException;
import com.bootcamp.rekening.model.Customer;



@Service
public class DefaultUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return mockUser(username);
	}
	
	private UserDetails mockUser(String username) {
		try {
			Customer customer = customerDao.getByEmail(username);
			if (customer == null) {
				throw new EntityNotFoundException("99", "failed");
			}
			return new User(customer.getEmail(), String.format("{noop}%s", customer.getPassword()), getAuthority());
		} catch (EntityNotFoundException e) {
			throw new UsernameNotFoundException("invalid username or password");
		}
	}
	
	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}