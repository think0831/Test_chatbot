package com.afc.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Fund implements Serializable {

	private int fundNumber;
	private String fundName;
	private double basePrice;
	private String fundType;
	private BigDecimal nav;
	private String tam;
	private double firstFee;
	private double resaleFee;
	private double repurchase;
	private double profit;
	private double totalPay;

	public Fund() {

	}

	@Override
	public String toString() {
		return "Fund [fundNumber=" + fundNumber + ", fundName=" + fundName + ", basePrice=" + basePrice + ", fundType="
				+ fundType + ", nav=" + nav + ", tam=" + tam + ", firstFee=" + firstFee + ", resaleFee=" + resaleFee
				+ ", repurchase=" + repurchase + ", profit=" + profit + ", totalPay=" + totalPay + "]";
	}

	public int getFundNumber() {
		return fundNumber;
	}

	public void setFundNumber(int fundNumber) {
		this.fundNumber = fundNumber;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public String getNav() {
		return nav.toString();
	}

	public void setNav(String nav) {
		this.nav = new BigDecimal(nav);
	}

	public String getTam() {
		return tam;
	}

	public void setTam(String tam) {
		this.tam = tam;
	}

	public double getFirstFee() {
		return firstFee;
	}

	public void setFirstFee(double firstFee) {
		this.firstFee = firstFee;
	}

	public double getResaleFee() {
		return resaleFee;
	}

	public void setResaleFee(double resaleFee) {
		this.resaleFee = resaleFee;
	}

	public double getRepurchase() {
		return repurchase;
	}

	public void setRepurchase(double repurchase) {
		this.repurchase = repurchase;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public double getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(double totalPay) {
		this.totalPay = totalPay;
		Object obj;
	}

}
