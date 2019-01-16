package com.afc.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.afc.domain.Fund;

public class FundDao {
     //DB����
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
     //VO���� ����Ʈ�� ������ �� ��
	private List<Fund> select(String query){
		Connection conn = new DBconnecter().getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Fund> list = new ArrayList<Fund>(); 
		
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				Fund fund = new Fund();
				fund.setFundNumber(resultSet.getInt("FUND_NUMBER"));
				fund.setFundName(resultSet.getString("FUND_NAME"));
				fund.setFundType(resultSet.getString("FUND_TYPE"));
				fund.setBasePrice(resultSet.getInt("BASE_PRICE"));
				fund.setNav(resultSet.getBigDecimal("NAV"));
				fund.setTam(resultSet.getString("TAM"));
				fund.setFirstFee(resultSet.getInt("FIRST_FEE"));
				fund.setResaleFee(resultSet.getInt("RESALE_FEE"));
				fund.setRepurchase(resultSet.getInt("REPURCHASE"));
				fund.setProfit(resultSet.getInt("PROFIT"));
				fund.setTotalPay(resultSet.getInt("TOTAL_PAY"));
				
				list.add(fund);
								
			}
			resultSet.close();
			statement.close();
			conn.close();
			
		} catch(Exception e) {
			System.out.println(e);
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch(Exception e1) {
				System.out.println(e1);
			}
		}
		
		return list;
		
		}
		
	
		public Fund view(int fundNumber) {
	    	String query = "SELECT FUND_NUMBER, FUND_NAME, FUND_TYPE, BASE_PRICE, NAV|r|n"
	    			+ "TAM, FIRST_FEE, RESALE_FEE, REPURCHASE, PROFIT, TOTAL_PAY"
	    			+ "FROM FUND|r|n" + "WHERE FUNDNUMBER = '" + fundNumber + "'";
	    	
	    	return select(query).get(0);
	   
	    }
		// ���̺� ���� �־��ִ� ��
		public int add(Fund fund) {
			String query = "INSERT INTO FUND" +
		    "(FUND_NUMBER, FUND_NAME, FUND_TYPE, BASE_PRICE, NAV, TAM, FIRST_FEE, RESALE_FEE, REPURCHASE, PROFIT, TOTAL_PAY)"+
			"VALUES" +
		    "("
		    + "" + fund.getFundNumber() + ", "
		    + "'" + fund.getFundName() + "',"
		    +"'" + fund.getFundType() + "',"
		    + "" + fund.getBasePrice() + ","
		    + "" + fund.getNav() + ","
		    + "'" + fund.getTam() + "',"
		    + "" + fund.getFirstFee() + ","
		    + "" + fund.getResaleFee() + ","
		    + "" + fund.getRepurchase() + ","
		    + "" + fund.getProfit() + ","
		    + "" + fund.getTotalPay() + ")";
		    
			
			return update(query); 
		     		
		}
		//
		public int edit(int fundNumber) {
			String query = "UPDATE FUND SET FUND_NUMBER = '"+ fundNumber + "'";
			
			return update(query);
		}
		
		//���� 
		public int remove(int fundNumber) {
			String query = "DELETE FROM FUND WHERE FUND_NUMBER = " + fundNumber + "";
			
			return update(query);
		}
	
	

}
