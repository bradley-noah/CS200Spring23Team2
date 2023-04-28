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
 * This is a hash map that stores a list of Provider Transactions
 * 
 * @author Brandon Nguyen
 * @version 1.0       
 */
public class ProviderTransactionFiles {
    public static HashMap<Integer, List<ProviderTransaction>> ProviderTransactionMap = new HashMap<> ();

    /**
     * Inserts a new provider transaction and corresponding information into a list that gets put into a map
     */
    public static void insertProviderTransaction(int providerNumber, String serviceDate, String receivedDate, String receivedTime, int memberNumber, String memberName, int serviceCode, int fee) {
    	ProviderTransaction newTransaction = new ProviderTransaction(providerNumber,serviceDate, receivedDate, receivedTime, memberNumber, memberName, serviceCode, fee);
    	
    	if (!ProviderTransactionMap.containsKey(providerNumber)) {
        	List<ProviderTransaction> transactions = new ArrayList<>();
            ProviderTransactionMap.put(providerNumber, transactions);
        }
    	
        ProviderTransactionMap.get(providerNumber).add(newTransaction);
    }

    /**
     * Searches a provider's transaction info with the given ProviderNumber from the map
     */
    public static List<ProviderTransaction> searchProviderTransaction(int providerNumber) {
        if (ProviderTransactionMap.containsKey(providerNumber)) {
            return ProviderTransactionMap.get(providerNumber);
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
        for (Map.Entry<Integer, List<ProviderTransaction>> entry : ProviderTransactionMap.entrySet()) {
            int providerNumber = entry.getKey();
            List<ProviderTransaction> transactions = entry.getValue();
            StringBuilder valueBuilder = new StringBuilder();
            for (ProviderTransaction transaction : transactions) {
                valueBuilder.append(transaction.getServiceDate()).append(",")
                            .append(transaction.getReceivedDate()).append(",")
                            .append(transaction.getReceivedTime()).append(",")
                            .append(transaction.getMemberNumber()).append(",")
                            .append(transaction.getMemberName()).append(",")
                            .append(transaction.getServiceCode()).append(",")
                            .append(transaction.getFee()).append("; ");
            }
            String value = valueBuilder.toString();
            prop.setProperty(Integer.toString(providerNumber), value);
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("src/maps/ProviderTransactionMap.properties");
            prop.store(fileOut, "Provider Transaction Map");
            fileOut.close();
            System.out.println("Provider Transaction map saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes all data from file to Map
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void loadProviderTransactionMap() {
        Properties prop = new Properties();
        try {
            FileInputStream fileIn = new FileInputStream("src/maps/ProviderTransactionMap.properties");
            prop.load(fileIn);
            fileIn.close();
            for (String key : prop.stringPropertyNames()) {
            	String[] transactions = prop.getProperty(key).split(";");
                int providerNumber = Integer.parseInt(key);
                for (String transaction : transactions) {
                	String[] values = transaction.trim().split(",");
                	if (values.length == 7) {
                		ProviderTransaction newTransaction = new ProviderTransaction(
                    			providerNumber,
                    			values[0],
                    			values[1],
                    			values[2],
                    			Integer.parseInt(values[3]),
                    			values[4],
                    			Integer.parseInt(values[5]),
                    			Integer.parseInt(values[6])
                    			);
                    	if (!ProviderTransactionMap.containsKey(providerNumber)) {
                    		List<ProviderTransaction> newTransactions = new ArrayList<>();
                    		ProviderTransactionMap.put(providerNumber, newTransactions);
                    	}
                    	ProviderTransactionMap.get(providerNumber).add(newTransaction);
                	}
                }
            }
            System.out.println("Provider Transaction map loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No provider transaction map found. Starting with empty map.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}