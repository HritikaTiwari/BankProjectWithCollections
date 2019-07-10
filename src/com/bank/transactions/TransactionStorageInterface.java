package com.bank.transactions;

import java.util.HashSet;
import java.util.Set;

public interface TransactionStorageInterface {
	 void storeTransactions(String accountId,HashSet transactions);
	 void makeTransaction(String transactionType,int amount) ;
	 Set getTransactions(String accountId);
}
