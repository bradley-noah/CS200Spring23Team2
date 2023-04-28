package spring23team2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
    	    StringBuilder sb = new StringBuilder();
    	    for (Map.Entry<Integer, List<ProviderTransaction>> entry : ProviderTransactionMap.entrySet()) {
    	        int providerNumber = entry.getKey();
    	        List<ProviderTransaction> transactions = entry.getValue();
    	        for (ProviderTransaction transaction : transactions) {
    	            sb.append(providerNumber).append(",")
    	              .append(transaction.getServiceDate()).append(",")
    	              .append(transaction.getReceivedDate()).append(",")
    	              .append(transaction.getReceivedTime()).append(",")
    	              .append(transaction.getMemberNumber()).append(",")
    	              .append(transaction.getMemberName()).append(",")
    	              .append(transaction.getServiceCode()).append(",")
    	              .append(transaction.getFee()).append("\n");
    	        }
    	    }
    	    try {
    	        FileWriter fileWriter = new FileWriter("src/maps/ProviderTransactionMap.txt");
    	        fileWriter.write(sb.toString());
    	        fileWriter.close();
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
        ProviderTransactionMap.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/maps/ProviderTransactionMap.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 8) {
                    int providerNumber = Integer.parseInt(values[0]);
                    ProviderTransaction newTransaction = new ProviderTransaction(
                            providerNumber,
                            values[1],
                            values[2],
                            values[3],
                            Integer.parseInt(values[4]),
                            values[5],
                            Integer.parseInt(values[6]),
                            Integer.parseInt(values[7])
                    );
                    if (!ProviderTransactionMap.containsKey(providerNumber)) {
                        List<ProviderTransaction> newTransactions = new ArrayList<>();
                        ProviderTransactionMap.put(providerNumber, newTransactions);
                    }
                    ProviderTransactionMap.get(providerNumber).add(newTransaction);
                }
            }
            reader.close();
            System.out.println("Provider Transaction map loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No provider transaction map found. Starting with empty map.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}