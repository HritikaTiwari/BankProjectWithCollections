package com.bank.user.bean;

import java.util.ArrayList;
import java.util.Iterator;

public class UserBean {
	private String AccountId;
	private String AccountPassword;
	private String Name;
	private long MobileNumber;
	private int Balance = 0;
	ArrayList<String> Transaction = new ArrayList<String>();
	
	public String getAccountId() {
		return AccountId;
	}
	public void setAccountId(String accountId) {
		AccountId = accountId;
	}
	public String getAccountPassword() {
		return AccountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		AccountPassword = accountPassword;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getTransaction() {
		String s = "";
		Iterator i = Transaction.iterator();
		while(i.hasNext()) {
			s = s+ "\n"+ (String) i.next();
		}
		return s;
	}
	public void setTransaction(String transaction) {
		Transaction.add(transaction);
	}
	
	
	
	
}
