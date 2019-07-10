package com.bank.transactions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.bank.user.bean.Transaction;

public class TransactionStorageClass implements TransactionStorageInterface {

	Transaction t1;
	HashMap<String,HashSet> transaction = new HashMap<String,HashSet>();
	
	 HashSet  transactions=new HashSet(); 
	 
	 public void makeTransaction(String transactionType,int amount) 
	 {
	    t1 = new Transaction(transactionType, amount);
	    transactions.add(t1);
	 }

	@Override
	public void storeTransactions(String accountId,HashSet transactions) {
		// TODO Auto-generated method stub
	    transaction.put(accountId,transactions);
	}

	@Override
	public Set getTransactions(String accountId) {
		
		// TODO Auto-generated method stub
		storeTransactions(accountId,transactions);
		return transaction.get(accountId);
	}


}
