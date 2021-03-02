package com.revature.ui;

import java.util.Scanner;

import com.revature.service.AuthService;

public class LoginMenu implements Menu {
	
	private Scanner scan;
	
	private Menu prevMenu;
	
	private Menu nextMenu;
	
	private AuthService authService;

	public LoginMenu() {
		super();
		
	}
	
	public LoginMenu(Scanner scan, AuthService authService) {
		this();
		this.setScanner(scan);
		this.setAuthService(authService);
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
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Please enter name and password");
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
	
	public AuthService getAuthService() {
		return this.authService;
	}
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

}
