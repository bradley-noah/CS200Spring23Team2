package spring23team2;

import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.ArrayList;
import java.util.Scanner;

/**
* @author Gwynevere Deterding
* @version 1.0
*
* This is the user interface for the ChocAn Manager. The ChocAn Manager can request
* a provider report, member report, summary report, or EFT data report to be run.
*
*/

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
		
		switch (menuOption) {
		case 1: // Request Provider Report                                                      
			ArrayList<Integer> providerNums = new ArrayList<Integer>(); // List to store provider numbers read from file
			try {
			      File myFile = new File("Providers.txt");
			      Scanner myReader = new Scanner(myFile);
			      while (myReader.hasNextInt()) { // Read integers from file
			    	  providerNums.add(myReader.nextInt()); // Add each integer to provider number list
			    }
			      myReader.close();
			    } 
			catch (FileNotFoundException e) { // Throws exception if file couldn't be found
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			System.out.println("Please enter the provider number for the report you would like to request.");
			int provNum = myObj.nextInt(); // Read user input
			boolean isValidProvNum = false; // Boolean to check if provider number is in the provider numbers list
			for(int i = 0; i < providerNums.size(); i++) {
				if(providerNums.get(i) == provNum) { // Searches for provider number in provider numbers list
					isValidProvNum = true;
				}
			}
			if(isValidProvNum) { // If provider number is valid, generate the report
				System.out.print("Generating Provider Report for Provider #" + provNum);
				System.out.println("...");
			}
			else { // If provider number is invalid, exit
				System.out.println("Invalid Provider Number.");
			}
			break;
		
		case 2: // Request Member Report
			ArrayList<Integer> memberNums = new ArrayList<Integer>(); // List to store member numbers read from file
			try {
			      File myFile = new File("Members.txt");
			      Scanner myReader = new Scanner(myFile);
			      while (myReader.hasNextInt()) { // Read integers from file
			    	  memberNums.add(myReader.nextInt()); // Add each integer to member number list
			    }
			      myReader.close();
			    } 
			catch (FileNotFoundException e) { // Throws exception if file couldn't be found
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			System.out.println("Please enter the member number for the report you would like to request.");
			int memberID = myObj.nextInt(); // Read user input
			boolean isValidMemID = false; // Boolean to check if member number is in the member numbers list
			for(int i = 0; i < memberNums.size(); i++) {
				if(memberNums.get(i) == memberID) { // Searches for member number in member numbers list
					isValidMemID = true;
				}
			}
			if(isValidMemID) { // If member number is valid, generate the report
				System.out.print("Generating Member Report for Member #" + memberID);
				System.out.println("...");
			}
			else { // If member number is invalid, exit
				System.out.println("Invalid Member Number.");
			}
			break;
			
		case 3: // Request Summary Report
			System.out.println("Generating Summary Report...");
			break;
			
		case 4: // Request EFT Data Report
			System.out.println("Generating EFT Data Report...");
			break;
			
		default: // User selected invalid option
			System.out.println("Invalid Option");
	    }
		
		System.out.println("Exiting System."); // Exits system, should return to main menu
    }
		
}
