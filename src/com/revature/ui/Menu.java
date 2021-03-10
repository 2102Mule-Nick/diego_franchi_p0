package com.revature.ui;

import java.util.Scanner;

public interface Menu {
	
	public Scanner getScanner();
	
	public void setScanner(Scanner scan);
	
	public Menu getNextMenu();
	
	public Menu getPreviousMenu();
	
	public void setPreviousMenu(Menu prevMenu);
	
	public void display();
	
}
