package com.bank.service;

import com.bank.dao.DaoClass;
import com.bank.user.bean.UserBean;
import java.util.*;
class RandomAccountIdGenerator{
	
	static String generateRandom(String userName,long mobileNumber) {
		String s1 = Long.toString(mobileNumber);
		String name = userName.substring(0,2);
		
		String pass = s1.substring(4,8);
		String accountId = pass+name;
		return accountId;
		
		
	}
	
}




public class BankServiceClass implements BankServiceInterface {
	DaoClass ds = new DaoClass();
	Scanner sc = new Scanner(System.in);
	@Override
	public String userAccountCreate(String accountPassword, String userName, long mobileNumber) {
		// TODO Auto-generated method stub
		UserBean userbean = new UserBean();
		String accountId = RandomAccountIdGenerator.generateRandom(userName, mobileNumber);
		userbean.setAccountId(accountId);
		userbean.setAccountPassword(accountPassword);
		userbean.setMobileNumber(mobileNumber);
		
		int i = ds.userAccountCreate(accountId, userbean);
		//return 0;
		if(i == 1) {
			return "Your Account is created with account ID "+accountId;
		}
		else {
			return "There problem in account creation";
		}
	}
	@Override
	public String showBalance(String accountId) {
		// TODO Auto-generated method stub
		String s = ds.showBalance(accountId);
		return s;
	}
	@Override
	public String deposit(String accountId, int amount) {
		// TODO Auto-generated method stub
		String s = ds.Deposit(accountId, amount);
		return s;
	}
	@Override
	public String withDraw(String accountId, int amount) {
		String s = ds.withDraw(accountId, amount);
		return s;
	}
	@Override
	public String getUserAccountDetails(String accountId, String accountPassword) {
		String s = ds.getUserAccountDetails(accountId, accountPassword);
		return s;
	}
	@Override
	public String fundTransfer(String sourceAccountId, String destinationAccountId,int amount) {
		String s = ds.fundTransfer(sourceAccountId, destinationAccountId, amount);
		return s;
	}
	
	@Override
	public int SignIn(String accountId, String accountPassword) {
		int i = ds.SignIn(accountId, accountPassword);
		if(i == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	@Override
	public void printTransactions(String accountId) {
		// TODO Auto-generated method stub
		ds.printTransactions(accountId);
	}
	@Override
	public String accountIdCheck(String accountId) {
			while(true) {
				try {
					if(ds.validAccountId(accountId)) {
						return accountId;
					}
					else {
						throw new Exception();
					}
				}
				catch(Exception e) {
					System.out.println("Account not found");
					System.out.println("Enter again");
					accountId = sc.nextLine();
				}
			}
		
	}
	
	

}
