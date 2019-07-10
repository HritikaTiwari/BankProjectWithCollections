package com.bank.service;

public interface BankServiceInterface {
	String userAccountCreate(String accountPassword,String userName,long mobileNumber);
	int SignIn(String accountId,String accountPassword);
	String showBalance(String accountId);
	String deposit(String accountId,int amount);
	String withDraw(String accountId,int amount);
	String fundTransfer(String sourceAccountId,String destinationAccountId,int amount);
	String getUserAccountDetails(String accountId,String accountPassword);
	void printTransactions(String accountId);
	String accountIdCheck(String accountId);
}
