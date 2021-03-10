package com.revature.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.revature.pojo.Member;
import com.revature.service.AuthService;

public class RegistrationMenu implements Menu {
	
	private Scanner scan;
	
	private Menu prevMenu;
	
	private Menu nextMenu;
	
	private AuthService authService;
	
	private Menu mainMenu;
	
	public RegistrationMenu() {
		super();
		
	}
	
	public RegistrationMenu(Scanner scan, AuthService authService, Menu mainMenu) {
		this();
		this.setScanner(scan);
		this.setAuthService(authService);
		this.mainMenu = mainMenu;
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

	@Override
	public void display() {
		Member memb = new Member();
		Random random = new Random();
		System.out.println("Let me get to know you a bit");
		System.out.println("What is your online handle?");
		memb.setUsername(scan.nextLine());
		if (!authService.isExistingMember(memb.getUsername())) {
			try {
				List<String> descriptors = Collections.unmodifiableList(Arrays.asList("cool B)","cute ;)","dangerous >:)","quirky :D"));
				System.out.println("I like that, very "+ descriptors.get(random.nextInt(descriptors.size())));
				System.out.println("Tell me a bit about yourself");
				memb.setBio(scan.nextLine());
				System.out.println("Okay heres an easy one, how old are you?");
				memb.setAge(Integer.parseInt(scan.nextLine()));
				System.out.println("Sex? [M/F]");
				memb.setSex(scan.nextLine());
				System.out.println("Where are you, " + memb.getUsername() +"?");
				memb.setLocation(scan.nextLine());
				System.out.println("What are some of your interests? (exit to continue)");
				String interest;
				List<String> interests = new ArrayList<>();
				do {
					interest = scan.nextLine();
					interests.add(interest);
				} while (!interest.equalsIgnoreCase("exit"));
				interests.remove(interests.size()-1);
				//memb.setInterests(interests);
				System.out.println("Finally lets get your password set");
				memb.setSecretword(scan.nextLine());
				authService.registerMember(memb);
				((MainMenu) mainMenu).setActiveMember(authService.authenticateMember(memb));
				nextMenu = mainMenu;
			} catch (Exception e) {
				System.out.println("Error creating user.");
				e.printStackTrace();
				nextMenu = prevMenu;
			}
		} else {
			System.out.println("Are you sure you haven't been here before? (username in database)");
			nextMenu = prevMenu;
		}
	}

}
