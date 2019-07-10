package com.bank.dao;

import com.bank.user.bean.UserBean;

public interface DaoInterface {
	
	int userAccountCreate(String accountId,UserBean userbean);
	int SignIn(String accountId,String accountPassword);
	String showBalance(String accountId);
	String Deposit(String accountId,int amount);
	String withDraw(String accountId,int amount);
	String fundTransfer(String sourceAccountId,String destinationAccountId,int amount);
	String getUserAccountDetails(String accountId,String accountPassword);
	void printTransactions(String accountId);
	boolean validAccountId(String accountId);
	
}
