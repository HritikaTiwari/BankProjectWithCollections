package com.bank.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.bank.transactions.TransactionStorageClass;
import com.bank.transactions.TransactionStorageInterface;
import com.bank.user.bean.UserBean;

public class DaoClass implements DaoInterface {
	 HashMap<String, UserBean> UserAccountData;
		 public DaoClass() {
		 UserAccountData = new HashMap<String, UserBean>();
		}
	
	UserBean a1;
	TransactionStorageInterface t = new TransactionStorageClass();

	@Override
	public int userAccountCreate(String accountId, UserBean userbean) {
		// TODO Auto-generated method stub
		UserAccountData.put(accountId, userbean);
		return 1;
	}

	@Override
	public String showBalance(String accountId) {

		a1 = UserAccountData.get(accountId);
		return "Balance is " + a1.getBalance();

	}

	@Override
	public String Deposit(String accountId, int amount) {

		a1 = UserAccountData.get(accountId);
		a1.setBalance(a1.getBalance() + amount);
		t.makeTransaction("Deposit", amount);
		return "After deopsit user balance is " + a1.getBalance();
	}

	@Override
	public String withDraw(String accountId, int amount) {
		a1 = UserAccountData.get(accountId);
		a1.setBalance(a1.getBalance() - amount);
		t.makeTransaction("WithDraw", amount);
		return "After withdraw user balance is " + a1.getBalance();
	}

	@Override
	public int SignIn(String accountId, String accountPassword) {
		if (UserAccountData.containsKey(accountId)) {
			a1 = UserAccountData.get(accountId);
			if (a1.getAccountPassword().equals(accountPassword)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
		// return 0;
	}

	@Override
	public String fundTransfer(String sourceAccountId, String destinationAccountId, int amount) {
			a1 = (UserBean) UserAccountData.get(sourceAccountId);
			// System.out.println(a1);
			// System.out.println(a1.getBalance());
			if (a1.getBalance() >= amount) {
				UserBean a2;
				a2 = UserAccountData.get(destinationAccountId);
				a1.setBalance(a1.getBalance() - amount);
				a2.setBalance(a2.getBalance() + amount);
				return "After transfer fund your balance is " + a1.getBalance();
			} else {
				return "You have insufficient amount to transfer";
			}
		
	}

	@Override
	public String getUserAccountDetails(String accountId, String accountPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printTransactions(String accountId) {
		Set s = t.getTransactions(accountId);
		Iterator itr1 = s.iterator();
		while (itr1.hasNext()) {
			Object name = itr1.next();
			System.out.println(name);
		}
	}

	@Override
	public boolean validAccountId(String accountId) {
		System.out.println(accountId);
		System.out.println(UserAccountData.size());
		if (UserAccountData.containsKey(accountId)) {
			return true;
		} else {
			return false;
		}
	}

}
