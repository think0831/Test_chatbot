package com.afc.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.afc.domain.ConnectAccount;


public class ConnectAccountDao {
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
	private List<ConnectAccount> select(String query){
		Connection conn = new DBconnecter().getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<ConnectAccount> list = new ArrayList<ConnectAccount>(); 
		
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				ConnectAccount ca = new ConnectAccount();
				ca.setAccountNumber(resultSet.getInt("ACCOUNT_NUMBER"));
				ca.setJoinNumber(resultSet.getInt("MEMBER_NUMBER"));
				ca.setAccountNumber(resultSet.getInt("FUND_NUMBER"));
				ca.setJoinNumber(resultSet.getInt("JOIN_NUMBER"));
				ca.setJoinNumber(resultSet.getInt("AMOUNT"));
				
				list.add(ca);
			}
			resultSet.close();
			statement.close();
			conn.close();
						
		}catch(Exception e) {
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
	public ConnectAccount view(int accountNumber) {
		String query = "SELECT ACCOUNT_NUMBER, MEMBER_NUMBER, FUND_NUMBER, JOIN_NUMBER, AMOUNT " 
	              + "FROM CONNECT_ACCOUNT " + "WHERE ACCOUNT_NUMBER = '" + accountNumber + "'";
		
		return select(query).get(0);
	
		
	}
	public int add(ConnectAccount ac) {
		String query = "INSERT INTO CONNECT_ACCOUNT" +
	    "(ACCOUNT_NUMBER, MEMBER_NUMBER, FUND_NUMBER, JOIN_NUMBER, AMOUNT)"+
		"VALUES" +
	    "("
		+ "" + ac.getAccountNumber() + ","
		+ "" + ac.getMemberNumber() + ","
		+ "" + ac.getFundNumber() + ","
		+ "" + ac.getJoinNumber() + ","
		+ "" + ac.getAmount() +"')";
		
		return update(query);
	}
	
	public int remove(int accountNumber) {
		String query = "UPDATE CONNECT_ACCOUNT SET ACCOUNT_NUMBER = " + accountNumber + "";
		
		return update(query);
	}



}
