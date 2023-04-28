package spring23team2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
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
     */
    public static void insertMemberTransaction(int memberNumber, String serviceDate, String providerName, String serviceName) {
    	MemberTransaction newTransaction = new MemberTransaction(memberNumber, serviceDate, providerName, serviceName);
    	
    	if (!MemberTransactionMap.containsKey(memberNumber)) {
        	List<MemberTransaction> transactions = new ArrayList<>();
            MemberTransactionMap.put(memberNumber, transactions);
        }
    	
        MemberTransactionMap.get(memberNumber).add(newTransaction);
    }

    /**
     * Searches a provider's info with the given ProviderNumber from the map
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
        Properties prop = new Properties();
        for (Map.Entry<Integer, List<MemberTransaction>> entry : MemberTransactionMap.entrySet()) {
            int memberNumber = entry.getKey();
            List<MemberTransaction> transactions = entry.getValue();
            StringBuilder valueBuilder = new StringBuilder();
            for (MemberTransaction transaction : transactions) {
                valueBuilder.append(transaction.getServiceDate()).append(",")
                            .append(transaction.getProviderName()).append(",")
                            .append(transaction.getServiceName()).append("; ");
            }
            String value = valueBuilder.toString();
            prop.setProperty(Integer.toString(memberNumber), value);
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("MemberTransactionMap.properties");
            prop.store(fileOut, "Member Transaction Map");
            fileOut.close();
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
        Properties prop = new Properties();
        try {
            FileInputStream fileIn = new FileInputStream("MemberTransactionMap.properties");
            prop.load(fileIn);
            fileIn.close();
            for (String key : prop.stringPropertyNames()) {
            	String[] transactions = prop.getProperty(key).split(";");
                int memberNumber = Integer.parseInt(key);
                for (String transaction : transactions) {
                	String[] values = transaction.trim().split(",");
                	if (values.length == 3) {
                		MemberTransaction newTransaction = new MemberTransaction(
                    			memberNumber,
                    			values[0],
                    			values[1],
                    			values[2]
                    			);
                    	if (!MemberTransactionMap.containsKey(memberNumber)) {
                    		List<MemberTransaction> newTransactions = new ArrayList<>();
                    		MemberTransactionMap.put(memberNumber, newTransactions);
                    	}
                    	MemberTransactionMap.get(memberNumber).add(newTransaction);
                	}
                }
            }
            System.out.println("Member Transaction map loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No member transaction map found. Starting with empty map.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}