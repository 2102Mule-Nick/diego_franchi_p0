package com.revature.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.MessageDao;
import com.revature.exception.UserNotFound;
import com.revature.pojo.Member;
import com.revature.pojo.Message;

public class ChatServiceImpl implements ChatService {
	
	Logger log = Logger.getRootLogger();
	
	private MessageDao messageDao;
	
	private AuthService authService;

	public ChatServiceImpl() {
		super();
	}
	
	public ChatServiceImpl(MessageDao messageDao, AuthService authService) {
		this.messageDao = messageDao;
		this.authService = authService;
	}

	@Override
	public boolean sendMessage(Message msg) {
		if (!authService.isExistingMember(msg.getTo())) {
			log.error("trying to send to non-existant member");
			return false;
		}
		//add logic to turn msg.from and msg.to from usernames to member_ids
		try {
			msg.setFrom(((AuthServiceImpl) authService).getMemberIdFromUsername(msg.getFrom()));
			msg.setTo(((AuthServiceImpl) authService).getMemberIdFromUsername(msg.getTo()));
			log.info("ChatServiceImpl.sendMessage -> from : "+ msg.getFrom() + " to : " + msg.getTo());
			messageDao.sendMessage(msg);
			return true;
		} catch (UserNotFound e) {
			log.error("ChatServiceImpl.sendMessage threw UserNotFound exception");
			e.printStackTrace();
		} catch (Exception e) {
			log.error("ChatServiceImpl.sendMessage threw general exception");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Message> getMessages(Member memb) {
		log.info("getMessages in ChatServiceImpl called");
		return messageDao.getMessagesByUsername(memb.getUsername());
	}

}
