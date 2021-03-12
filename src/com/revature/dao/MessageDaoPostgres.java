package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pojo.Member;
import com.revature.pojo.Message;
import com.revature.service.AuthService;
import com.revature.util.ConnectionFactoryPostgres;

public class MessageDaoPostgres implements MessageDao {
	
	private Logger log = Logger.getRootLogger();

	public MessageDaoPostgres() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createMessage(Message msg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Message> getMessagesByUsername(String username) {
		log.trace("MessageDaoPostgres.getMessagesByUsername method called");
		
		List<Message> messages = new ArrayList<Message>();

		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "select * from messages where msg_to_username = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Message msg = new Message();
				msg.setMessageId(rs.getInt("msg_id"));;
				msg.setFrom(String.valueOf(rs.getString("msg_from_username")));
				msg.setTo(String.valueOf(rs.getString("msg_to_username")));
				msg.setDateTimeSent(rs.getTimestamp("sent").toLocalDateTime());			
				msg.setSubject(rs.getString("subject"));
				msg.setMessage(rs.getString("msg"));
				messages.add(msg);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messages;
	}

	@Override
	public boolean sendMessage(Message msg) {
		log.trace("MessageDaoPostgres.sendMessage method called");
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		String sql = "insert into messages values (default,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msg.getFrom());
			pstmt.setString(2, msg.getTo());
			pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(msg.getDateTimeSent()));
			pstmt.setString(4, msg.getSubject());
			pstmt.setString(5, msg.getMessage());
			pstmt.execute();
			log.info("row succesfully added to table messages");
			return true;
		} catch (SQLException e) {
			log.error("SQLERROR sending message from "+msg.getFrom()+" to " +msg.getTo());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("MessageDaoPostgres.sendMessage general exception thrown", e);
		}
		return false;
	}

}
