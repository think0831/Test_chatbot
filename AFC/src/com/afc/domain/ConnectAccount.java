package com.afc.domain;

public class ConnectAccount {
	private int accountNumber;
	private int memberNumber;
	private int fundNumber;
	private int joinNumber;
	private int amount;

	public ConnectAccount() {

	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getFundNumber() {
		return fundNumber;
	}

	public void setFundNumber(int fundNumber) {
		this.fundNumber = fundNumber;
	}

	public int getJoinNumber() {
		return joinNumber;
	}

	public void setJoinNumber(int joinNumber) {
		this.joinNumber = joinNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
