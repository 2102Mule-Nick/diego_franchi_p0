package com.revature.pojo;

import java.time.LocalDateTime;

public class Message {
	
	private int messageId;
	
	private String from;
	
	private String to;
	
	private LocalDateTime dateTimeSent;
	
	private String subject;
	
	private String message;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String from, String to, LocalDateTime sent, String subject, String message) {
		super();
		this.from = from;
		this.to = to;
		this.dateTimeSent = sent;
		this.subject = subject;
		this.message = message;
	}
	
	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}	

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public LocalDateTime getDateTimeSent() {
		return dateTimeSent;
	}

	public void setDateTimeSent(LocalDateTime sent) {
		this.dateTimeSent = sent;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
