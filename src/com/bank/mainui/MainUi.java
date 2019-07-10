package com.bank.mainui;

import java.util.Scanner;

import javax.xml.bind.ValidationEvent;

import com.bank.dao.Validation;
import com.bank.service.BankServiceClass;
import com.bank.service.BankServiceInterface;



public class MainUi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userName;
		String accountPassword;
		long mobileNumber;
		int amount;
		BankServiceInterface pm = new BankServiceClass();
		Validation validate = new Validation();
		
		
		boolean exitFromApp = false;
		while(!exitFromApp) {
			System.out.println("------------Welcome to Bank--------------");
			System.out.println("Enter 1 for Sign Up\nEnter 2 for Sign In\nEnter 3 for Exit");
			System.out.println("-----------------------------------------");
			int dashboardIp = sc.nextInt();
			sc.nextLine();
			switch(dashboardIp) {
			 	case 1:
			 		 System.out.println("Enter Your name");
			 		 userName = sc.nextLine();
			 		 String updateName = validate.nameCheck(userName);
			 		 System.out.println("Enter account password");
			 		 accountPassword = sc.nextLine();
				 	 String updatePassword = validate.passwordCheck(accountPassword);
				 	 System.out.println("Enter mobile number");
				 	 mobileNumber = sc.nextLong();
				 	 sc.nextLine();
				 	 Long updateMobileNumber = validate.mobileNumberCheck(mobileNumber);
				 	 System.out.println(pm.userAccountCreate(updatePassword,updateName,updateMobileNumber));
				 	 break;
				 	 

			 	 case 2:
			 		 System.out.println("Enter account ID");
			 		 String loggedInAccountId = sc.nextLine();
			 		 System.out.println("Enter account password");
			 		 String loggedInAccountPassword = sc.nextLine();
			 		 int i = pm.SignIn(loggedInAccountId, loggedInAccountPassword);
			 		 boolean returnToDashboard = false;
			 		 if(i == 1) {
			 			System.out.println("success");
			 			while(!returnToDashboard) {
			 				System.out.println("------------------Welcome-----------------");
			 				System.out.println("Enter 1 for Show Balance\nEnter 2 for Deposit");
			 				System.out.println("Enter 3 for withdraw\nEnter 4 for fund transfer\nEnter 5 for print Transaction");
			 				System.out.println("Enter 6 for exit");
			 				System.out.println("--------------------------------------------");
			 				int signInInput = sc.nextInt();
			 				sc.nextLine();
			 				switch(signInInput) {
			 				 	 case 1:
			 				 		 System.out.println(pm.showBalance(loggedInAccountId));
			 				 		 break;
			 				 	 case 2:
			 				 		 System.out.println("Enter amount you want to deposit");
			 				 		 amount = sc.nextInt();
			 				 		 //sc.nextLine();
			 				 		 System.out.println(pm.deposit(loggedInAccountId, amount));
			 				 		 break;
			 				 	 case 3:
			 				 		 System.out.println("Enter amount you want to withdraw");
			 				 		 amount = sc.nextInt();
			 				 		 System.out.println(pm.withDraw(loggedInAccountId, amount));
			 				 		 break;
			 				 	 case 4:
			 				 		 System.out.println("Enter amount you want to Transfer");
			 				 		 amount = sc.nextInt();
			 				 		 sc.nextLine();
			 				 		 System.out.println("Enter account ID user that you want to transfer amount");
			 				 		 String accountId2 = sc.nextLine();
			 				 		 accountId2 = pm.accountIdCheck(accountId2);
			 				 		 System.out.println(pm.fundTransfer(loggedInAccountId, accountId2, amount));
			 				 		 break;
			 				 	 case 5:
			 				 		 pm.printTransactions(loggedInAccountId);
			 				 		 break;
			 				 	 case 6:
			 				 		 returnToDashboard = true ;
			 				 		 break;
			 				 	default:
			 				 		System.out.println("enter valid input");
			 				}
			 			}
			 		 }
			 		 else {
			 			 System.out.println("fail");
			 		 }
			 		 break;
			 	 case 3:
			 		 exitFromApp = true;
			 		 break;
			 	default:
			 		System.out.println("enter valid input");
			}
		}
		System.out.println("Thank You for using application");
		System.exit(1);

	}

}
