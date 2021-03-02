package com.revature.ui;

import java.util.Scanner;

public interface Menu {
	
	public Menu getNextMenu();
	
	public Menu getPreviousMenu();
	
	public void display();
	
	public Scanner getScanner();
	
	public void setScanner(Scanner scan);
}
