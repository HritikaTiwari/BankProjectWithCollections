package com.bank.transactions.service;

import java.util.HashSet;
import java.util.Set;

import com.bank.transactions.TransactionStorageClass;

public class TransactionService implements TransactionServiceI {
	
	TransactionStorageClass transactionService = new TransactionStorageClass();
	
	@Override
	public void storeTransactions(String accountId, HashSet transactions) {
		// TODO Auto-generated method stub
		transactionService.storeTransactions(accountId, transactions);
	}

	

	@Override
	public Set getTransactions(String accountId) {
		// TODO Auto-generated method stub
		
		return transactionService.getTransactions(accountId);
	}



	@Override
	public void makeTransaction(String transactionType, int amount) {
		// TODO Auto-generated method stub
		transactionService.makeTransaction(transactionType,amount);
	}
	
	

}
