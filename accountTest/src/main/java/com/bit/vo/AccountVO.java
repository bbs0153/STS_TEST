package com.bit.vo;

public class AccountVO {

	private String name;
	private int balance;

	public AccountVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountVO(String name, int balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
