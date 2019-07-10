package com.bank.user.bean;

import java.util.Date;

public class Transaction {

	//private String transactionId;
	private Date date;
	private long time;
	private String transactionType;
	private int amount;
	
   public Transaction(String transactionType,int amount) {
		
		this.date =new Date();
		this.time = date.getTime();
		this.transactionType = transactionType;
		this.amount = amount;
	}


//	public String getTransactionId() {
//		return transactionId;
//	}
//
//	public void setTransactionId(String transactionId) {
//		this.transactionId = transactionId;
//	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public long getTime() {
		return time;
	}



	public void setTime(long time) {
		this.time = time;
	}



	public String getTransactionType() {
		return transactionType;
	}



	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	@Override
	public String toString() {
		return " date :" + date + "\n time :" + time + "\n transactionType :" + transactionType ;
	}
	



	
	
	
}
