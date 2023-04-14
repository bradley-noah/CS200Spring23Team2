package spring23team2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;  
import java.io.FileNotFoundException; 

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
		case 1:
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
			System.out.println("Please enter the provider number for the report you would like to request.");
			int provNum = myObj.nextInt();
			boolean isValidProvNum = false;
			for(int i = 0; i < providerNums.size(); i++) {
				if(providerNums.get(i) == provNum) {
					isValidProvNum = true;
				}
			}
			if(isValidProvNum) {
				System.out.print("Generating Provider Report for Provider #" + provNum);
				System.out.println("...");
			}
			else {
				System.out.println("Invalid Provider Number.");
			}
			break;
		
		case 2:
			ArrayList<Integer> memberNums = new ArrayList<Integer>();
			try {
			      File myFile = new File("Members.txt");
			      Scanner myReader = new Scanner(myFile);
			      while (myReader.hasNextInt()) {
			    	  memberNums.add(myReader.nextInt()); 
			    }
			      myReader.close();
			    } 
			catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			System.out.println("Please enter the member number for the report you would like to request.");
			int memberID = myObj.nextInt();
			boolean isValidMemID = false;
			for(int i = 0; i < memberNums.size(); i++) {
				if(memberNums.get(i) == memberID) {
					isValidMemID = true;
				}
			}
			if(isValidMemID) {
				System.out.print("Generating Member Report for Member #" + memberID);
				System.out.println("...");
			}
			else {
				System.out.println("Invalid Member Number.");
			}
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
		
		System.out.println("Exiting System.");
    }
		
}
