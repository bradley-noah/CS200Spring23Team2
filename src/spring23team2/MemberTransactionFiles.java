package spring23team2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * This is a hash map that stores a list of Member Transactions
 * 
 * @author Brandon Nguyen
 * @version 1.0       
 */
public class MemberTransactionFiles {
    public static HashMap<Integer, List<MemberTransaction>> MemberTransactionMap = new HashMap<> ();

    /**
     * Inserts a new member transaction and their corresponding information into a list that goes into the map
     * @param memberNumber
     * @param serviceDat
     * @param providerName
     * @param serviceName
     */
    public static void insertMemberTransaction(int memberNumber, String serviceDate, String MemberName, String serviceName) {
    	MemberTransaction newTransaction = new MemberTransaction(memberNumber, serviceDate, MemberName, serviceName);
    	
    	if (!MemberTransactionMap.containsKey(memberNumber)) {
        	List<MemberTransaction> transactions = new ArrayList<>();
            MemberTransactionMap.put(memberNumber, transactions);
        }
    	
        MemberTransactionMap.get(memberNumber).add(newTransaction);
    }

    /**
     * Searches a provider's info with the given ProviderNumber from the map
     * @param memberNumber
     * Searches a Member's info with the given MemberNumber from the map
     */
    public static List<MemberTransaction> searchMemberTransaction(int memberNumber) {
        if (MemberTransactionMap.containsKey(memberNumber)) {
            return MemberTransactionMap.get(memberNumber);
        }
        else {
            return null;
        }
    }

    /**
     * Writes all data from Map to a file data.properties
     * in progress
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void save() {
    	try {
            FileWriter fileWriter = new FileWriter("MemberTransactionMap.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<Integer, List<MemberTransaction>> entry : MemberTransactionMap.entrySet()) {
            	int MemberNumber = entry.getKey();
    	        List<MemberTransaction> transactions = entry.getValue();
    	        int i = 0;
    	        for (MemberTransaction transaction : transactions) {
    	        	String line;
    	        	if (i == 0) {
    	        		line = MemberNumber + "," + transaction.getServiceDate()+ "," +transaction.getProviderName() + "," + transaction.getServiceName() + ";";
    	        	}
    	        	else {
    	        		line = transaction.getServiceDate()+ "," +transaction.getProviderName() + "," + transaction.getServiceName() + ";";
    	        	}
    	        	bufferedWriter.write(line);
    	        	i++;
    	        }
    	        bufferedWriter.newLine();    	        
            }
            bufferedWriter.close();
            System.out.println("Member Transaction map saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes all data from file to Map
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void loadMemberTransactionMap() {
        MemberTransactionMap.clear();
        try {
        	FileReader fileReader = new FileReader("MemberTransactionMap.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 8) {
                    int MemberNumber = Integer.parseInt(values[0]);
                    MemberTransaction newTransaction = new MemberTransaction(
                            MemberNumber,
                            values[1],
                            values[2],
                            values[3]
                    );
                    if (!MemberTransactionMap.containsKey(MemberNumber)) {
                        List<MemberTransaction> newTransactions = new ArrayList<>();
                        MemberTransactionMap.put(MemberNumber, newTransactions);
                    }
                    MemberTransactionMap.get(MemberNumber).add(newTransaction);
                }
            }
            bufferedReader.close();
            System.out.println("Member Transaction map loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No Member transaction map found. Starting with empty map.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}