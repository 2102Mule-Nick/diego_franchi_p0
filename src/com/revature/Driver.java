package com.revature;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoKryo;
import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;
import com.revature.ui.LoginMenu;
import com.revature.ui.Menu;
import com.revature.ui.RegistrationMenu;
import com.revature.ui.WelcomeMenu;

public class Driver {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		UserDao userDao = new UserDaoKryo();
		
		AuthService authService = new AuthServiceImpl(userDao);
		
		Menu registration = new RegistrationMenu(scan, authService);
		
		Menu login = new LoginMenu(scan, authService);
		
		Menu welcome = new WelcomeMenu(scan, login, registration);
		
		Menu nextMenu = welcome;
	
		//this menu loop will traverse all menus given that they store the next menu correctly
		do {
			nextMenu.display();
			nextMenu = nextMenu.getNextMenu();
		} while (nextMenu != null);
		
	}
	
}
