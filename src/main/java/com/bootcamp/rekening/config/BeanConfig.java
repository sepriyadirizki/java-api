package com.bootcamp.rekening.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bootcamp.rekening.dao.AccountDao;
import com.bootcamp.rekening.dao.CustomerDao;
import com.bootcamp.rekening.dao.TransactionDao;
import com.bootcamp.rekening.dao.TransactionTypeDao;
import com.bootcamp.rekening.dao.WalletAccountDao;
import com.bootcamp.rekening.dao.WalletDao;
import com.bootcamp.rekening.dao.impl.AccountDaoImpl;
import com.bootcamp.rekening.dao.impl.CustomerDaoImpl;
import com.bootcamp.rekening.dao.impl.TransactionDaoImpl;
import com.bootcamp.rekening.dao.impl.TransactionTypeDaoImpl;
import com.bootcamp.rekening.dao.impl.WalletAccountDaoImpl;
import com.bootcamp.rekening.dao.impl.WalletDaoImpl;
import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Customer;
import com.bootcamp.rekening.model.Transaction;
import com.bootcamp.rekening.model.Wallet;
import com.bootcamp.rekening.repository.AccountRepository;

@Configuration
public class BeanConfig {
	
	@Bean
	public CustomerDao customerDao() {
		return new CustomerDaoImpl();
	}

	@Bean
	public AccountDao accountDao() {
		return new AccountDaoImpl();
	}
	
	@Bean
	public TransactionDao transactionDao() {
		return new TransactionDaoImpl();
	}
	
	@Bean	
	public TransactionTypeDao transactionTypeDao() {
		return new TransactionTypeDaoImpl();
	}
	
	@Bean
	public WalletDao walletDao() {
		return new WalletDaoImpl();
	}
	
	@Bean
	public WalletAccountDao walletAccountDao() {
		return new WalletAccountDaoImpl();
	}
	
	@Bean
	public Customer customer() {
		return new Customer();
	}
	
	@Bean
	public Account account() {
		return new Account();
	}
	
	@Bean
	public Wallet wallet() {
		return new Wallet();
	}
	
	@Bean
	public Transaction transaction() {
		return new Transaction();
	}
	
	  @Bean
	    public WebMvcConfigurerAdapter corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
	            }
	        };
	    }
	}
	

