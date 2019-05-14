package com.bootcamp.rekening.dao;

import java.util.List;

import com.bootcamp.rekening.model.Account;
import com.bootcamp.rekening.model.Wallet;
import com.bootcamp.rekening.model.WalletAccount;

public interface WalletAccountDao {
	
	List<WalletAccount> getList();
	WalletAccount getByid(int id);
	List<WalletAccount> getByAccnumb(int accNumb);
	List<WalletAccount>getByWallet(int wallet);
	WalletAccount save(WalletAccount walletAccount);
	List<WalletAccount> delByid(Wallet id);

}
