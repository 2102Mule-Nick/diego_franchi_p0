package com.revature.dao;

import java.util.List;

import com.revature.pojo.Message;

public interface MessageDao {
	
	public boolean createMessage(Message msg);
	
	public List<Message> getMessagesByUsername(String username);
	
	public boolean sendMessage(Message msg);

}
