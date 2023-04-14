package spring23team2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Brandon Nguyen
 * @version 1.0
 *
 * Main Menu Class to verify and direct the user to the desired menu.
 */

public class MainMenu {
	
	boolean authenticated;
	
	public static void main(String[] args) {
		new MainMenu().startup();
	}
	
	//Basic welcome prompt
	public void startup() {
		System.out.println("-----------------------------------");
		System.out.println("|Welcome to Chocoholics Anonymous!|");
		System.out.println("-----------------------------------");
		System.out.println();
		this.prompt();
	}
	
	//prompt to login
	public void prompt() {
		System.out.println("Login Menu");
		System.out.println("Please enter a number to select an option from the menu: ");
		System.out.println("1. Login");
		System.out.println("2. Quit");
		
		@SuppressWarnings("resource")
		
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();

		switch (option) {
			case 2:
				System.out.println("The system is shutting down.");
				System.exit(0);
			
			case 1:
				System.out.println("Enter your User Number: ");
				int userNum = scanner.nextInt();
				
				new UserAuthenticator().main(userNum); //Verify member
				
				if(authenticated) {
					System.out.println("User Verified");
					System.out.println();
					menus();
				} else {
					System.out.println("User Not Verified");					
				}
				
				break;
				
			default:
				System.out.println("Invalid Option");
				this.prompt();
		}
	}
	
	//prompt to select which menu to access
	public void menus() {
		System.out.println("Menu Selection");
		System.out.println("Please enter a number to select an option from the menu: ");
		System.out.println("1. Manager Menu");
		System.out.println("2. Provider Menu");
		System.out.println("3. Operator Menu");
		
		@SuppressWarnings("resource")
		
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		
		switch (option) {
			case 1:
				System.out.println();
				new ManagerMenu().main(null); //start Manager Menu
				break;
				
			case 2:
				System.out.println();
				new ProviderMenu().main(null); //start Provider Menu
				break;
				
			case 3:
				System.out.println();
				new OpMenu().mainMenu(); //start Operator Menu
				break;
				
			default:
				System.out.println("Invalid Option");
				this.menus(); //re-prompt menus options
		}
	}
}