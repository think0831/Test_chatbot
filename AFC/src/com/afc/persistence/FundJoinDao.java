package com.afc.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.afc.domain.FundJoin;

@Repository
public class FundJoinDao {
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

	private List<FundJoin> select(String query) {
		Connection conn = new DBconnecter().getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<FundJoin> list = new ArrayList<FundJoin>();

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				FundJoin fundjoin = new FundJoin();
				fundjoin.setJoinNumber(resultSet.getInt("JOIN_NUMBER"));
				fundjoin.setFundNumber(resultSet.getInt("FUND_NUMBER"));
				fundjoin.setMemberNumber(resultSet.getInt("MEMBER_NUMBER"));
				fundjoin.setJoinDate(resultSet.getString("JOIN_DATE"));

				list.add(fundjoin);
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

	public FundJoin view(int joinNumber) {
		String query = "SELECT JOIN_NUMBER, FUND_NUMBER, MEMBER_NUMBER, TO_CHAR(JOIN_DATE, 'YYYY/MM/DD') "
				+ "FROM FUND_JOIN WHERE FUND_JOIN = '" + joinNumber + "'";
		return select(query).get(0);

	}

	public int add(FundJoin fundjoin) {
		String query = "INSERT INTO FUND_JOIN (JOIN_NUMBER, FUND_NUMBER, MEMBER_NUMBER, JOIN_DATE) "
				+ "VALUES (" 
				+ fundjoin.getJoinNumber() + ","
				+ fundjoin.getFundNumber() + ","
				+ fundjoin.getMemberNumber() + "," 
				+ "SYSDATE)";

		return update(query);
	}

	public int edit(int joinNumber) {
		String query = "UPDATE FUND_JOIN SET JOIN_NUMBER = " + joinNumber;

		return update(query);
	}

	public int remove(int joinNumber) {
		String query = "DELETE FROM FUND_JOIN WHERE JOIN_NUMBER = " + joinNumber;

		return update(query);
	}
}
