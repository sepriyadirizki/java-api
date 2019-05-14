package com.bootcamp.rekening.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bootcamp.rekening.model.Wallet;
import com.bootcamp.rekening.model.WalletAccount;

public interface WalletAccountRepository extends JpaRepository<WalletAccount, Integer>{
	
	WalletAccount findByAccount(Integer account);
	List<WalletAccount> findByWallet(Wallet wallet);
	

}
