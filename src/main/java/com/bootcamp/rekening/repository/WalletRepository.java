package com.bootcamp.rekening.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.rekening.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer>{
	
//	Wallet findByCif(String cif);

}
