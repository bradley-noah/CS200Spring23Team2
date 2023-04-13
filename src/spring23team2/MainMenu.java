package spring23team2;

import java.util.Scanner;

public class MainMenu {
	
	public static void main(String[] args) {
		new MainMenu().startup();
	}
	
	public void startup() {
		System.out.println("Welcome to Chocoholics Anonymous!");
		System.out.println("Enter a l to login, or q to quit.");
		
		@SuppressWarnings("resource")
		
		Scanner scanner = new Scanner(System.in);
		String option = scanner.next();
		
		switch (option) {
			case "q":
				System.out.println("The system is shutting down.");
				System.exit(0);
			
			case "l":
				System.out.println("Enter your User Number: ");
				int userNum = scanner.nextInt();
				System.out.println("Your User Number is " + userNum);
				break;
				
			default:
				System.out.println("Invalid Option");
				startup();
		}
	}
}

