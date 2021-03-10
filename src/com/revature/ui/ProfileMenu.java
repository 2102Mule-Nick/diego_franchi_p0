package com.revature.ui;

import java.util.Scanner;

import com.revature.pojo.Member;
import com.revature.service.AuthService;

public class ProfileMenu implements Menu {
	
	private Scanner scan;
	
	private Menu prevMenu;
	
	private Menu nextMenu;
	
	private Member activeMember;
	
	private AuthService authService;

	public ProfileMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public ProfileMenu(Scanner scan, Member memb, Menu mainMenu) {
		this.scan = scan;
		this.activeMember = memb;
		this.prevMenu = mainMenu;
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

	@Override
	public Menu getNextMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu getPreviousMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setPreviousMenu(Menu prevMenu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		System.out.println("Profile Menu");
		int input;
		do {
			System.out.println("1. Display"); //show/edit/delete
			System.out.println("2. Edit"); //display database
			System.out.println("3. Return"); //read and write messages
			System.out.println("9. Delete"); //
			while (!scan.hasNextInt()) {
				System.out.println("["+scan.next() + "] there is no secret menu");
			}
			input = scan.nextInt();
			switch (input) {
			case 1:
				System.out.println(activeMember.toString());
				break;
			case 2:
				System.out.println("<<>>");
				break;
			case 3:
				//quit
				nextMenu = prevMenu;
				break;
			case 9:
				authService.removeMember(activeMember);
				break;
			default:
				System.out.println("Not an option. Try again.");
				break;
			}
		} while (input != 4);
		
	}

}
