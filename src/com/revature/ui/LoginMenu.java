package com.revature.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.exception.InvalidPassword;
import com.revature.exception.UserNotFound;
import com.revature.pojo.Member;
import com.revature.service.AuthService;

public class LoginMenu implements Menu {
	
	private Scanner scan;
	
	private Menu prevMenu;
	
	private Menu nextMenu;
	
	private AuthService authService;
	
	private Menu mainMenu;
	
	private Member memb = new Member();
	
	private Logger log = Logger.getRootLogger();

	public LoginMenu() {
		super();
		
	}
	
	public LoginMenu(Scanner scan, AuthService authService, Menu mainMenu) {
		this();
		this.setScanner(scan);
		this.setAuthService(authService);
		this.mainMenu = mainMenu;
	}
	
	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		// TODO Auto-generated method stub
		this.scan = scan;
	}
	
	@Override
	public Menu getNextMenu() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public Menu getPreviousMenu() {
		// TODO Auto-generated method stub
		return prevMenu;
	}
	
	@Override
	public void setPreviousMenu(Menu prevMenu) {
		this.prevMenu = prevMenu;
	}
	
	public AuthService getAuthService() {
		return this.authService;
	}
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	public Member getMember() {
		return this.memb;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("To continue please enter your screen name");
		memb.setUsername(scan.nextLine());
		System.out.println("Please enter your password");
		memb.setSecretword(scan.nextLine());
		
		try {
			memb = authService.authenticateMember(memb);
			((MainMenu) mainMenu).setActiveMember(memb);
			nextMenu = mainMenu;
			//throw new Error();
		} catch (UserNotFound e) {
			System.out.println("Username does not exist.  Please register an account.");
			nextMenu = prevMenu;
		} catch (InvalidPassword e) {
			log.error("Authentication error, InvalidPassword exception thrown");
			System.out.println("check your password");
			nextMenu = prevMenu;
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong. Please try again later.");
			nextMenu = prevMenu;
		}
	}

}
