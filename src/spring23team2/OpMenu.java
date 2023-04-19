package spring23team2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class OpMenu {

	public static void mainMenu() { 												//   Initialization of main menu class. First instance of cases/options.
		Scanner scanner = new Scanner (System.in);
		System.out.println("");
		System.out.println("ChocAn™ Operator Menu");
		System.out.println("---------------------");
		System.out.println("");
		System.out.println("Please input a number corresponding to one of the following menu options:");
		System.out.println("");
		System.out.println("1.) Add Member");
		System.out.println("2.) Delete Member");
		System.out.println("3.) Update Member");
		System.out.println("4.) Add Provider");
		System.out.println("5.) Delete Provider");
		System.out.println("6.) Update Provider");
		System.out.println("7.) Exit");
		
		int option = scanner.nextInt();
		
		switch(option) {
			
		
		
			
		case 1:  																			//   First case: adding member.
			String mName;
			String mPhone;
			String mAddress;
			String mCity;
			String mState;
			String mZip;
			System.out.println("");
			System.out.print("Enter name of new member (no spaces):  ");
			mName = scanner.next();
			System.out.print("Enter phone number of new member (no spaces):  ");
			mPhone = scanner.next();
			System.out.print("Enter address of new member (no spaces):  ");
			mAddress = scanner.next();
			System.out.print("Enter city of new member (no spaces):  ");
			mCity = scanner.next();
			System.out.print("Enter state of new member (no spaces):  ");
			mState = scanner.next();
			System.out.print("Enter ZIP code of new member (no spaces):  ");
			mZip = scanner.next();
			System.out.println("");
			System.out.println("CONFIRM new member: ");
			System.out.println("");
			System.out.println("Name: " + mName);
			System.out.println("Phone number: " + mPhone);
			System.out.println("Address: " + mAddress);
			System.out.println("City: " + mCity);
			System.out.println("State: " + mState);
			System.out.println("ZIP: " + mZip);
			System.out.println("");
			System.out.println("1.) Confirm");
			System.out.println("2.) Cancel");	
			System.out.println("");
			int option2 = scanner.nextInt();  							// Allows operator to confirm the addition of new member or quit.
			switch(option2) {
			case 2:														// Case: exiting from within function.
				System.out.println("");
				System.out.println("Exiting...");
				System.out.println("");
				break;
			case 1:														// Case: successfully added.
				System.out.println("");
				System.out.println("Member added.");
				System.out.println("");
			
			}
			break;														// Automatically exit at end of function.
			
			
			
			
			
		case 2:     													 //      Second case: deleting member.
			ArrayList<Integer> mNums = new ArrayList<Integer>();      	//   Reads from databse of members, populates an array with entries.
			try {
			      File myFile = new File("Members.txt");
			      Scanner fscanner = new Scanner(myFile);
			      while (fscanner.hasNextInt()) {
			    	  mNums.add(fscanner.nextInt()); 
			      }
			      fscanner.close();
				  }
			catch (FileNotFoundException e) {
				  System.out.println("An error occurred.");
				  e.printStackTrace();
				}
			System.out.print("Enter number of member to delete:  ");
			System.out.println("");
			int mNum = scanner.nextInt();
			boolean isValidMNum = false;
			for(int i = 0; i < mNums.size(); i++) {						// Checks whether inputted member number exists in previously populated array.
				if(mNums.get(i) == mNum) {
					isValidMNum = true;
				}
			}
			if(isValidMNum) {
				System.out.println("Member " + mNum + " deleted.");
				System.out.println("");
			}
			else {
				System.out.println("Invalid member number.");
			}
			break;														// Automatically exit at end of function.
			
			
			
			
		case 3:    															//     Third case: updating member.
			ArrayList<Integer> mNums2 = new ArrayList<Integer>();			// Reads from database of members, populates an array with entries.
			try {
			      File myFile = new File("Members.txt");
			      Scanner fscanner = new Scanner(myFile);
			      while (fscanner.hasNextInt()) {
			    	  mNums2.add(fscanner.nextInt()); 
			      }
			      fscanner.close();
				  }
			catch (FileNotFoundException e) {
				  System.out.println("An error occurred.");
				  e.printStackTrace();
				}
			System.out.println("");
			System.out.print("Enter number of member to update:  ");
			int mNum2 = scanner.nextInt();
			boolean isValidMemNum = false;
			for(int i = 0; i < mNums2.size(); i++) {						// Checks whether inputted member number exists in previously populated array.
				if(mNums2.get(i) == mNum2) {
					isValidMemNum = true;
				}
			}
			if(isValidMemNum) {
				System.out.println("");
				System.out.println("Select field to update.");
				System.out.println("");
				System.out.println("1.) Name");
				System.out.println("2.) Phone number");
				System.out.println("3.) Address");
				System.out.println("4.) City");
				System.out.println("5.) State");
				System.out.println("6.) ZIP");
				System.out.println("");
				String plcehldr = scanner.next();
				System.out.println("");
				System.out.print("Enter updated information: ");
				String plcehldr2 = scanner.next();
				System.out.println("");
				System.out.print("Member info updated.");
				System.out.println("");
				break;															// Automatically exit at end of function.
				
			}
			else {
				System.out.println("Invalid member number.");
				break;
			}
			
			
			
			
			
		case 4:     															// Fourth case: adding provider.
			String pName;
			String pPhone;
			String pAddress;
			String pCity;
			String pState;
			String pZip;
			System.out.println("");
			System.out.print("Enter name of new provider (no spaces):  ");
			pName = scanner.next();
			System.out.print("Enter phone number of new provider (no spaces):  ");
			pPhone = scanner.next();
			System.out.print("Enter address of new provider (no spaces):  ");
			pAddress = scanner.next();
			System.out.print("Enter city of new provider (no spaces):  ");
			pCity = scanner.next();
			System.out.print("Enter state of new provider (no spaces):  ");
			pState = scanner.next();
			System.out.print("Enter ZIP code of new provider (no spaces):  ");
			pZip = scanner.next();
			System.out.println("");
			System.out.println("CONFIRM new provider: ");
			System.out.println("");
			System.out.println("Name: " + pName);
			System.out.println("Phone number: " + pPhone);
			System.out.println("Address: " + pAddress);
			System.out.println("City: " + pCity);
			System.out.println("State: " + pState);
			System.out.println("ZIP: " + pZip);
			System.out.println("");
			System.out.println("1.) Confirm");
			System.out.println("2.) Cancel");	
			System.out.println("");
			int option3 = scanner.nextInt();								// Allows operator to choose whether to confirm the addition of new provider or quit.
			switch(option3) {
			case 2:															// Case: exiting from within function.
				System.out.println("");
				System.out.println("Exiting...");
				System.out.println("");
				break;
			case 1:															// Case: successfully added.
				System.out.println("");
				System.out.println("Provider added.");
				System.out.println("");
			}
							
			break;															// Automatically exit at end of function.
			
			
			
			
			
		case 5:      															// Fifth case: deleting provider.
			ArrayList<Integer> pNums = new ArrayList<Integer>();				// Reads from databse of providers, populates an array with entries.
			try {
			      File myFile = new File("Providers.txt");
			      Scanner fscanner = new Scanner(myFile);
			      while (fscanner.hasNextInt()) {
			    	  pNums.add(fscanner.nextInt()); 
			      }
			      fscanner.close();
				  }
			catch (FileNotFoundException e) {
				  System.out.println("An error occurred.");
				  e.printStackTrace();
				}
			System.out.print("Enter number of provider to delete:  ");
			System.out.println("");
			int pNum = scanner.nextInt();
			boolean isValidPNum = false;
			for(int i = 0; i < pNums.size(); i++) {								// Checks whether inputted provider number exists in previously populated array.
				if(pNums.get(i) == pNum) {
					isValidPNum = true;
				}
			}
			if(isValidPNum) {
				System.out.println("Provider " + pNum + " deleted.");
				System.out.println("");
			}
			else {
				System.out.println("Invalid member number.");
			}
			break;																	// Automatically exit at end of function.
			
			
		
		
			
			
		case 6:   																 //    Sixth case: updating provider.
			ArrayList<Integer> pNums2 = new ArrayList<Integer>();  				// Reads from databse of providers, populates an array with entries.
			try {
			      File myFile = new File("Providers.txt");
			      Scanner fscanner = new Scanner(myFile);
			      while (fscanner.hasNextInt()) {
			    	  pNums2.add(fscanner.nextInt()); 
			      }
			      fscanner.close();
				  }
			catch (FileNotFoundException e) {
				  System.out.println("An error occurred.");
				  e.printStackTrace();
				}
			System.out.println("");
			System.out.print("Enter number of provider to update:  ");
			int pNum2 = scanner.nextInt();
			boolean isValidProvNum = false;
			for(int i = 0; i < pNums2.size(); i++) {							// Checks whether inputted provider number exists in previously populated array.
				if(pNums2.get(i) == pNum2) {
					isValidProvNum = true;
				}
			}
			if(isValidProvNum) {
				System.out.println("");
				System.out.println("Select field to update.");
				System.out.println("");
				System.out.println("1.) Name");
				System.out.println("2.) Phone number");
				System.out.println("3.) Address");
				System.out.println("4.) City");
				System.out.println("5.) State");
				System.out.println("6.) ZIP");
				System.out.println("");
				String plcehldr = scanner.next();
				System.out.println("");
				System.out.print("Enter updated information: ");
				String plcehldr2 = scanner.next();
				System.out.println("");
				System.out.print("Provider info updated.");
				System.out.println("");
				
			}
			else {
				System.out.println("Invalid provider number.");
				break;																	// Automatically exit at end of function.
			}
			
			
			
			
			
		case 7:    																		//     Seventh case: exiting menu.
			System.out.println("Exiting...");
			break;																	// 		Successfully exit.
			
		default:  																	//     Default case: throw error if invalid option selected.
			System.out.println("Invalid option. Exiting...");
			break;
			
		}
	}
	public static void main(String[] args) { 										// Runs main operator menu.
		mainMenu();
	}
 
}