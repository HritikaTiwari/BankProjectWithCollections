package com.bank.transactions.service;

import java.util.HashSet;
import java.util.Set;

public interface TransactionServiceI {

	 void storeTransactions(String accountId,HashSet transactions);
	 void makeTransaction(String transactionType,int amount) ;
	 Set getTransactions(String accountId);
	
}
