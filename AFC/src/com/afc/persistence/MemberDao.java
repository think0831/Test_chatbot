package com.afc.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.afc.domain.Member;

@Repository
public class MemberDao {
	private int update(String query) {
		Connection conn = new DBconnecter().getConnection();
		Statement statement = null;
		int result = 0;
		
		try {
			statement = conn.createStatement();
			result = statement.executeUpdate(query);
			statement.close();
			conn.close();
		}catch (Exception e) {
			System.out.println(e);
			try {
				if(statement != null)
				   statement.close();
				if(conn != null)
					conn.close();
			}catch (Exception e1) {
				System.out.println(e1);
			}
		}
		return result;
	}
	private List<Member> select(String query){
		Connection conn = new DBconnecter().getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Member> list = new ArrayList<Member>();
		
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				Member member = new Member();
				member.setMemberNumber(resultSet.getInt("MEMBER_NUMBER"));
				member.setId(resultSet.getString("ID"));
				member.setName(resultSet.getString("NAME"));
				member.setPhone(resultSet.getString("PHONE"));
				member.setPassword(resultSet.getString("PASSWORD"));
				
				list.add(member);
			}
			
			resultSet.close();
			statement.close();
			conn.close();
		}catch (Exception e) {
			System.out.println(e);
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
					
			}catch(Exception e1) {
				System.out.println(e1);
		}
	}
		
	return list;
	}
	
	public Member view(String id) {
		String query = "SELECT MEMBER_NUMBER, ID, NAME, PHONE, PASSWORD "
				+ "FROM MEMBER " + "WHERE ID = '" + id + "'";
		
		Member member;
		
		try {
			member = select(query).get(0);
		} catch(Exception e) {
			member = null;
		}
		return member;
		
	}
	//테이블 값 넣어주는 것
	public int add(Member member) {
		String query = "INSERT INTO MEMBER " +
	    "(MEMBER_NUMBER, ID, NAME, PHONE, PASSWORD) "+
		"VALUES" +
	    "("
	    +"" + member.getMemberNumber() + ","
	    +"'" + member.getId() + "',"
	    +"'" + member.getName() +"',"
	    +"'" + member.getPhone() + "',"
		+"'" + member.getPassword() + "')";  
		
		return update(query);
	}
	
	public int edit(String memberNumber) {
		String query = "UPDATE MEMBER SET MEMBER_NUMBER = '" + memberNumber + "'";
		return update(query);
	}
	
	public int remove(String memberNumber) {
		String query = "DELETE FROM MEMBER WHERE MEMBER_NUMBER = " + memberNumber + "";
		return update(query);
		
	}
}
