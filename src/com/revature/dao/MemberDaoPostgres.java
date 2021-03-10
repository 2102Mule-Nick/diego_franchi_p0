package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.esotericsoftware.kryo.Kryo;
import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.Member;
import com.revature.util.ConnectionFactoryPostgres;

public class MemberDaoPostgres implements MemberDao {
	
	private Logger log = Logger.getRootLogger();

	@Override
	public boolean createMember(Member memb) throws UserNameTaken {
		log.trace("UserDaoPostgres.createMember method called");
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "insert into members (username, secretword, ages, sex, locations, bio) values ('" + 
		memb.getUsername() + "', '" +memb.getSecretword() + "', '" + memb.getAge() + "', '"+memb.getSex() + "', '"+memb.getLocation() + "', '" + memb.getBio() +"');";
		
		log.info(sql);
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Member getMemberByUsername(String username) throws UserNotFound {
		log.trace("UserDaoPostgres.getMemberByUsername method called");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}

		Member memb = null;
		
		String url = "jdbc:postgresql://" + System.getenv("DATE_DB_URL") + ":5432/" + System.getenv("DATE_DB_NAME") + "?currentSchema=" + System.getenv("DATE_DB_SCHEMA");
		
		String usr = System.getenv("DATE_DB_USERNAME");
		
		String password = System.getenv("DATE_DB_PASSWORD");
		
		//log.info("usr : " + usr);
		//log.info("password : " + password);
		
		try (Connection conn = DriverManager.getConnection(url, usr, password);) {
			
			//conn.setSchema(schema);
			
			String sql = "select * from members where username = '" + username + "'";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				log.info("User found in DB");
				memb = new Member();
				memb.setMemberId(rs.getInt("member_id"));
				memb.setUsername(rs.getString("username"));
				memb.setSecretword(rs.getString("secretword"));
				memb.setAge(rs.getInt("ages"));
				memb.setSex(rs.getString("sex"));
				memb.setLocation(rs.getString("locations"));
				memb.setBio(rs.getString("bio"));
			}
			
		} catch (SQLException e) {
			log.error("Failure to connect to DB", e);
		}
		
		return memb;
	}

	@Override
	public List<Member> getAllMembers() {
		
		log.trace("UserDaoPostgres.getAllMembers method called");
		
		List<Member> members = new ArrayList<Member>();

		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "select member_id,username from members";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Member memb = new Member();
				memb.setMemberId(rs.getInt("member_id"));
				memb.setUsername(rs.getString("username"));
				members.add(memb);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;

	}

	@Override
	public void updateMember(Member memb) {
		log.trace("UserDaoPostgres.updateMember method called");

		//originally programmed to only update password, i will extend functionality to update any field in user object (or create new functins for each) 
		
		Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "update members set secretword = ? WHERE username = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, "new_password");
			stmt.setString(2, memb.getUsername());
			stmt.execute();
			log.info("User updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Unsuccessful update");
		}

	}

	@Override
	public boolean removeMember(Member memb) {
		log.trace("UserDaoPostgres.removeMember method called");
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "delete from members " + 
					  "where username = '" + memb.getUsername() + "' and secretword = '" + memb.getSecretword() + "'";
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
