package spring23team2;

import java.util.Scanner;

public class ManagerMenu {
	
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Manager Menu");
		System.out.println("Please enter a number to select an option from the menu:");
		System.out.println("1. Request Provider Report");
		System.out.println("2. Request Member Report");
		System.out.println("3. Request Summary Report");
		System.out.println("4. Request EFT Data Report");
		

		int menuOption = myObj.nextInt();  // Read user input
		System.out.println("You entered: " + menuOption);  // Output user input
		
		switch (menuOption) {
		case 1:
			System.out.println("Please enter the provider number for the report you would like to request.");
			int provNum = myObj.nextInt();
			System.out.println("You entered: " + provNum);  // Output user input
			break;
		
		case 2:
			System.out.println("Please enter the member number for the report you would like to request.");
			int memberNum = myObj.nextInt();
			System.out.println("You entered: " + memberNum);  // Output user input
			break;
			
		case 3:
			System.out.println("Generating Summary Report...");
			break;
			
		case 4:
			System.out.println("Generating EFT Data Report...");
			break;
			
		default:
			System.out.println("Invalid Option");
	    }
    }
		
}
