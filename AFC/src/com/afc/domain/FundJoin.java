package com.afc.domain;

import java.io.Serializable;

public class FundJoin implements Serializable{
	private int joinNumber;
	private int fundNumber;
    private int memberNumber;
	private String joinDate;
	
	public FundJoin() {
		
	}

	public int getJoinNumber() {
		return joinNumber;
	}

	public void setJoinNumber(int joinNumber) {
		this.joinNumber = joinNumber;
	}

	public int getFundNumber() {
		return fundNumber;
	}

	public void setFundNumber(int fundNumber) {
		this.fundNumber = fundNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

}
