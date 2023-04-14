package spring23team2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MainMenu {
	
	boolean authenticated = true;
	
	public static void main(String[] args) {
		new MainMenu().startup();
	}
	
	public void startup() {
		System.out.println("-----------------------------------");
		System.out.println("|Welcome to Chocoholics Anonymous!|");
		System.out.println("-----------------------------------");
		System.out.println();
		this.prompt();
	}
	
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
				
				ArrayList<Integer> providerNums = new ArrayList<Integer>();
				try {
				      File myFile = new File("Providers.txt");
				      Scanner myReader = new Scanner(myFile);
				      while (myReader.hasNextInt()) {
				    	  providerNums.add(myReader.nextInt()); 
				    }
				      myReader.close();
				    } 
				catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
				
				authenticated = false;
				
				for(int i = 0; i < providerNums.size(); i++) {
					if(providerNums.get(i) == userNum) {
						authenticated = true;
					}
				}
					
				if(authenticated) {
					System.out.println("User Verified");
					System.out.println();
					menues();
				} else {
					System.out.println("User Not Verified");					
				}
				break;
				
			default:
				System.out.println("Invalid Option");
				this.prompt();
		}
	}
	
	public void menues() {
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
				new ManagerMenu().main(null);
				break;
				
			case 2:
				System.out.println();
				//start Provider Menu
				break;
				
			case 3:
				System.out.println();
				//start Operator Menu
				break;
				
			default:
				System.out.println("Invalid Option");
				this.menues();
		}
	}
}