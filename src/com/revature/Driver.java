package com.revature;

import java.util.Scanner;

import com.revature.dao.MemberDao;
import com.revature.dao.MemberDaoKryo;
import com.revature.dao.MemberDaoPostgres;
import com.revature.dao.MessageDao;
import com.revature.dao.MessageDaoPostgres;
import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;
import com.revature.service.ChatService;
import com.revature.service.ChatServiceImpl;
import com.revature.ui.LoginMenu;
import com.revature.ui.MainMenu;
import com.revature.ui.Menu;
import com.revature.ui.RegistrationMenu;
import com.revature.ui.WelcomeMenu;

public class Driver {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		MemberDao memberDao = new MemberDaoPostgres();
		
		AuthService authService = new AuthServiceImpl(memberDao);
		
		MessageDao messageDao = new MessageDaoPostgres();
		
		ChatService chatService = new ChatServiceImpl(messageDao, authService);
		
		Menu mainMenu = new MainMenu(scan, authService, chatService);
		
		Menu registrationMenu = new RegistrationMenu(scan, authService, mainMenu);
		
		Menu loginMenu = new LoginMenu(scan, authService, mainMenu);

		Menu welcomeMenu = new WelcomeMenu(scan, loginMenu, registrationMenu);
		((MainMenu) mainMenu).setPreviousMenu(welcomeMenu);
		((RegistrationMenu) registrationMenu).setPreviousMenu(welcomeMenu);
		((LoginMenu) loginMenu).setPreviousMenu(welcomeMenu);
		
		Menu activeMenu = welcomeMenu;

		do {
			activeMenu.display();
			activeMenu = activeMenu.getNextMenu();
		} while (activeMenu != null);
		
		scan.close();
		System.out.println("Goodbye!");
		
	}
	
}
