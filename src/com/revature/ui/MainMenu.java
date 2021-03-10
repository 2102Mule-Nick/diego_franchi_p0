package com.revature.ui;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.revature.pojo.Member;
import com.revature.pojo.Message;
import com.revature.service.AuthService;
import com.revature.service.ChatService;

public class MainMenu implements Menu {
	
	private Scanner scan;
	
	private Menu prevMenu;
	
	private Menu nextMenu;
	
	private Member activeMember;
	
	private AuthService authService;
	
	private ChatService chatService;

	public MainMenu() {
		super();
	}
	
	public MainMenu(Scanner scan, AuthService authService, ChatService chatService) {
		this.scan = scan;
		this.authService = authService;
		this.chatService = chatService;
	}
	
	@Override
	public Menu getNextMenu() {
		// TODO Auto-generated method stub
		return this.nextMenu;
	}

	@Override
	public Menu getPreviousMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setPreviousMenu(Menu prevMenu) {
		this.prevMenu = prevMenu;
	}

	@Override
	public void display() {
		System.out.println("Welcome!");
		System.out.println("1. Profile"); //show/edit/delete
		System.out.println("2. Browse"); //display database
		System.out.println("3. Inbox"); //read and write messages
		System.out.println("4. Chat");
		System.out.println("5. Logout"); //
		int input;
		do {
			while (!scan.hasNextInt()) {
				System.out.println("["+scan.next() + "] there is no secret menu");
			}
			input = scan.nextInt();
			switch (input) {
			case 1:
				System.out.println(activeMember.toString());
				//nextMenu = new ProfileMenu(scan, activeMember);
				break;
			case 2:
				for (Member memb : authService.getAllMembers()) {
					System.out.println(String.valueOf(memb.getMemberId())+" "+memb.getUsername());
				}
				//get all user objects and syso fields
				break;
			case 3:
				for (Message msg : chatService.getMessages(activeMember)) {
					System.out.println("SENT: "+msg.getDateTimeSent().toString() + " SUBJECT: " + msg.getSubject()+" MESSAGE: "+msg.getMessage());
				}
				;
				//get
				break;
			case 4:
				Message msg = new Message();
				msg.setFrom(activeMember.getUsername());
				System.out.println("To: ");//to;
				msg.setTo(scan.nextLine());
				System.out.println("Subject: ");//subject;
				msg.setSubject(scan.nextLine());
				System.out.println("Message: ");//message;
				msg.setMessage(scan.nextLine());
				msg.setDateTimeSent(LocalDateTime.now());
				chatService.sendMessage(msg);
				break;
			case 5:
				//quit
				nextMenu = prevMenu;
				break;
			default:
				System.out.println("Not an option. Try again.");
				break;
			}
		} while (input != 4);
		
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScanner(Scanner scan) {
		// TODO Auto-generated method stub

	}
	
	public void setActiveMember(Member memb) {
		this.activeMember = memb;
	}

}
