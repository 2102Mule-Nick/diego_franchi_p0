package com.revature.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.revature.pojo.User;
import com.revature.service.AuthService;

public class RegistrationMenu implements Menu {
	
	private Scanner scan;
	
	private Menu prevMenu;
	
	private Menu nextMenu;
	
	private AuthService authService;
	
	public RegistrationMenu() {
		super();
		
	}
	
	public RegistrationMenu(Scanner scan, AuthService authService) {
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
		User user = new User();
		Random random = new Random();
		System.out.println("Let me get to know you a bit");
		System.out.println("What is your online handle?");
		user.setUsername(scan.nextLine());
		if (!authService.isExistingUser(user)) {
			try {
				authService.registerUser(user);
				nextMenu = new LoginMenu();
				List<String> descriptors = Collections.unmodifiableList(Arrays.asList("cool B)","cute ;)","dangerous >:)","quirky :D"));
				System.out.println("I like that, very "+ descriptors.get(random.nextInt(descriptors.size())));
			} catch (Exception e) {
				System.out.println("Username taken, please try again");
				nextMenu = prevMenu;
			}
		} else {
			System.out.println("Username taken, please try again");
			nextMenu = prevMenu;
		}
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
