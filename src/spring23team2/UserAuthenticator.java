package spring23team2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**

* @author Andrew Carter
* @version 1.0
*
* This is a function that checks the input of the user for verification purposes when attempting to log in.
*
*/

public class UserAuthenticator{
		
	    public boolean main(int userNum){
	        @SuppressWarnings("resource")
				boolean authenticated = true;
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
					authenicated = false;
					
					for(int i = 0; i < providerNums.size(); i++) {
						if(providerNums.get(i) == userNum) {
							System.out.println("User Verified");
							System.out.println();
							authenticated = true;
						}
					}
					return authenticated;
		}
}

