package com.afc.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.afc.domain.Fund;

@Repository
public class FundDao {
	// DB����
	private int update(String query) {
		Connection conn = new DBconnecter().getConnection();
		Statement statement = null;
		int result = 0;

		try {
			statement = conn.createStatement();
			result = statement.executeUpdate(query);
			statement.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (Exception e1) {
				System.out.println(e1);
			}

		}
		return result;

	}

	// VO���� ����Ʈ�� ������ �� ��
	private List<Fund> select(String query) {
		Connection conn = new DBconnecter().getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Fund> list = new ArrayList<Fund>();

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Fund fund = new Fund();
				fund.setFundNumber(resultSet.getInt("FUND_NUMBER"));
				fund.setFundName(resultSet.getString("FUND_NAME"));
				fund.setFundType(resultSet.getString("FUND_TYPE"));
				fund.setBasePrice(resultSet.getDouble("BASE_PRICE"));
				fund.setNav(resultSet.getBigDecimal("NAV").toString());
				fund.setTam(resultSet.getString("TAM"));
				fund.setFirstFee(resultSet.getDouble("FIRST_FEE"));
				fund.setResaleFee(resultSet.getDouble("RESALE_FEE"));
				fund.setRepurchase(resultSet.getDouble("REPURCHASE"));
				fund.setProfit(resultSet.getDouble("PROFIT"));
				fund.setTotalPay(resultSet.getDouble("TOTAL_PAY"));

				list.add(fund);

			}
			resultSet.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}

		return list;

	}

	public List<Fund> listAsType(String fundType) {
		String query = "SELECT FUND_NUMBER, FUND_NAME, FUND_TYPE, BASE_PRICE, NAV, TAM, FIRST_FEE, RESALE_FEE, REPURCHASE, PROFIT, TOTAL_PAY "
				+ "FROM FUND " + "WHERE FUND_TYPE <= '" + fundType + "'";

		System.out.println(query);

		List<Fund> list = select(query);
		
		return list;
	}
	
	public List<Fund> listAsMemberNumber(int memberNumber) {
		String query = "SELECT FUND_NUMBER, FUND_NAME, FUND_TYPE, BASE_PRICE, NAV, TAM, FIRST_FEE, RESALE_FEE, REPURCHASE, PROFIT, TOTAL_PAY "
				+ "FROM FUND WHERE FUND_NUMBER = " + memberNumber;

		System.out.println(query);

		List<Fund> list = select(query);
		
		return list;
	}

	public Fund viewFromNumber(int fundNumber) {
		String query = "SELECT FUND_NUMBER, FUND_NAME, FUND_TYPE, BASE_PRICE, NAV, TAM, FIRST_FEE, RESALE_FEE, REPURCHASE, PROFIT, TOTAL_PAY "
				+ "FROM FUND " + "WHERE FUND_NUMBER = " + fundNumber;

		System.out.println(query);

		List<Fund> list = select(query);
		if (list.size() != 0)
			return list.get(0);
		else
			return null;

	}
	
	public Fund viewFromName(String fundName) {
		String query = "SELECT FUND_NUMBER, FUND_NAME, FUND_TYPE, BASE_PRICE, NAV, TAM, FIRST_FEE, RESALE_FEE, REPURCHASE, PROFIT, TOTAL_PAY "
				+ "FROM FUND " + "WHERE FUND_NAME = '" + fundName + "'";

		System.out.println(query);

		List<Fund> list = select(query);
		if (list.size() != 0)
			return list.get(0);
		else
			return null;

	}

	// ���̺� ���� �־��ִ� ��
	public int add(Fund fund) {
		String query = "INSERT INTO FUND"
				+ "(FUND_NUMBER, FUND_NAME, FUND_TYPE, BASE_PRICE, NAV, TAM, FIRST_FEE, RESALE_FEE, REPURCHASE, PROFIT, TOTAL_PAY)"
				+ "VALUES" + "(" + "" + fund.getFundNumber() + ", " + "'" + fund.getFundName() + "'," + "'"
				+ fund.getFundType() + "'," + "" + fund.getBasePrice() + "," + "" + fund.getNav() + "," + "'"
				+ fund.getTam() + "'," + "" + fund.getFirstFee() + "," + "" + fund.getResaleFee() + "," + ""
				+ fund.getRepurchase() + "," + "" + fund.getProfit() + "," + "" + fund.getTotalPay() + ")";

		return update(query);

	}

	//
	public int edit(int fundNumber) {
		String query = "UPDATE FUND SET FUND_NUMBER = '" + fundNumber + "'";

		return update(query);
	}

	// ����
	public int remove(int fundNumber) {
		String query = "DELETE FROM FUND WHERE FUND_NUMBER = " + fundNumber + "";

		return update(query);
	}

}
