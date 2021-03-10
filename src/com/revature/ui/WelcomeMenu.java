package com.revature.ui;

import java.util.Scanner;

public class WelcomeMenu implements Menu {

	private Scanner scan;
	
	private Menu loginMenu;
	
	private Menu registrationMenu;
	
	private Menu nextMenu;
	
	private Menu prevMenu;
	
	public WelcomeMenu() {
		super();
		System.out.println("       .....           .....\r\n" + 
				"   ,ad8PPPP88b,     ,d88PPPP8ba,\r\n" + 
				"  d8P\"      \"Y8b, ,d8P\"      \"Y8b\r\n" + 
				" dP'           \"8a8\"           `Yd\r\n" + 
				" 8(              \"              )8\r\n" + 
				" I8                             8I\r\n" + 
				"  Yb,        Welcome to       ,dP\r\n" + 
				"   \"8a,     cmdate.exe      ,a8\"\r\n" + 
				"     \"8a,                 ,a8\"\r\n" + 
				"       \"Yba             adP\"\r\n" + 
				"         `Y8a         a8P'\r\n" + 
				"           `88,     ,88'\r\n" + 
				"             \"8b   d8\"\r\n" + 
				"              \"8b d8\"\r\n" + 
				"               `888'\r\n" + 
				"                 \"\r\n" + 
				"");
		System.out.println("Command Line Dating for the Desperate\n");
	}

	public WelcomeMenu(Scanner scan, Menu loginMenu, Menu registrationMenu) {
		this();
		this.setScanner(scan);
		this.loginMenu = loginMenu;
		this.registrationMenu = registrationMenu;
	}
	
	@Override
	public Scanner getScanner() {
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}
	
	@Override
	public Menu getNextMenu() {
		return nextMenu;
	}
	
	@Override
	public Menu getPreviousMenu() {
		// TODO Auto-generated method stub
		return prevMenu;
	}
	
	@Override
	public void setPreviousMenu(Menu prevMenu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		System.out.println("Is this your first time here? (y/n/x)");
		String answer = scan.nextLine();
		
		if ("n".equals(answer.toLowerCase())) {
			nextMenu = loginMenu;
		} else if ("y".equals(answer.toLowerCase())) {
			nextMenu = registrationMenu;
		} else if ("x".equals(answer.toLowerCase())){
			nextMenu = null;
		} else {
			System.out.println("Coyness will only get you so far..");
			//redirect user to same welcome menu
			nextMenu = this;
		}
	}


	
}
