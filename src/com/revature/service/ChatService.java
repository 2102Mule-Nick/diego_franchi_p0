package com.revature.service;

import java.util.List;

import com.revature.pojo.Member;
import com.revature.pojo.Message;

public interface ChatService {
	
	public boolean sendMessage(Message msg);
	
	public List<Message> getMessages(Member memb);
	
}
