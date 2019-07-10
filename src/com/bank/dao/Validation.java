package com.bank.dao;

import java.util.*;
public class  Validation {
	 Scanner sc = new Scanner(System.in);
	 DaoClass db = new DaoClass();
	//TO CHECK THE NAME LENGTH
	public  String nameCheck(String name) {
		while(true) {
			try {
				if(name.length() <= 4 || name.length() > 10) {
					throw new Exception();
				}
				else {
					return name;
				}
			}
			catch(Exception ex) {
				System.out.println("___________________Input Error_______________");
				System.out.println("Please enter username where length is greater than 2 and less than 10.");
				System.out.println("_____________________________________________");
				System.out.println("Enter again");
				name = sc.nextLine();
			}
		}
	}
	// TO CHECK THE PASSWORD LENGTH
	public  String passwordCheck(String password) {
		while(true) {
			try {
				if(password.length() < 6) {
					throw new Exception();
				}
				else {
					return password;
				}
			}
			catch(Exception ex){
				System.out.println("___________________Input Error_______________");
				System.out.println("Enter password length greater than 6");
				System.out.println("_____________________________________________");
				System.out.println("Enter again");
				password = sc.nextLine();
			}
			
		}
	}
	//TO CHECK THE MOBILE NUMBER LENGTH 
	public long mobileNumberCheck(long mobileNumber) {
		while(true) {
			try {
				int length = String.valueOf(mobileNumber).length();
				if(length != 10) {
					throw new Exception();
				}
				else {
					return mobileNumber;
				}
			}
			catch(InputMismatchException exx){
				System.out.println("___________________Input Error_______________");
				System.out.println("Enter valid mobile number(i.e - 10 digit only)");
				System.out.println("_____________________________________________");
				System.out.println("Enter again");
				mobileNumber = sc.nextLong();
				sc.nextLine();
			}
			catch(Exception ex){
				System.out.println("___________________Input Error_______________");
				System.out.println("Enter valid mobile number(i.e - 10 digit only)");
				System.out.println("_____________________________________________");
				System.out.println("Enter again");
				mobileNumber = sc.nextLong();
				sc.nextLine();
			}
			
		}
	}
	// TO CHECK IF THE ACCOUNT IS FOUND OR NOT
	public  boolean accountIdCheck(String accountId) {
		while(true) {
			try {
				if(db.validAccountId(accountId)) {
					return true;
				}
				else {
					throw new Exception();
				}
			}
			catch(Exception e) {
				System.out.println("___________________Input Error_______________");
				System.out.println("Account not found");
				System.out.println("_____________________________________________");
				System.out.println("Enter again");
				accountId = sc.nextLine();
			}
		}
	}
}