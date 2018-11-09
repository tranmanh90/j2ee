package com.training.spring.model;

public class BankAccountInfo {

	private Long id;
	private String fullName;
	private double balance;
	
	

	public BankAccountInfo() {
		super();
	}

	public BankAccountInfo(Long id, String fullName, double balance) {
		this.id = id;
		this.fullName = fullName;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("BankAccountInfo [id=");
		builder2.append(id);
		builder2.append(", fullName=");
		builder2.append(fullName);
		builder2.append(", balance=");
		builder2.append(balance);
		builder2.append("]");
		return builder2.toString();
	}
}
