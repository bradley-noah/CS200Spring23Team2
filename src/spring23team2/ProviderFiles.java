package spring23team2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * This is a hash map that store Provider records
 * 
 * @author Jahanvi Kathiriya
 * @version 2.0       fixed save function and added load function
 */
public class ProviderFiles {
    public static HashMap<Integer, Provider> providerMap = new HashMap<> ();

    /**
     * Inserts a new provider and their corresponding information into the map
     */
    public static void insertProvider(String name, int providerNumber, String address, String city, String state, int zip) {
        Provider newProvider = new Provider(name, providerNumber, address, city, state, zip);
        providerMap.put(providerNumber, newProvider);
    }

    /**
     * Searches a provider's info with the given ProviderNumber from the map
     */
    public static Provider searchProvider(int providerNumber) {
        if (providerMap.containsKey(providerNumber)) {
            return providerMap.get(providerNumber);
        }
        else {
            return null;
        }
    }

    /**
     * Removes a provider and their info with the given ProviderNumber from the map
     */
    public static void removeProvider(int providerNumber) {
        providerMap.remove(providerNumber);
    }

    /**
     * Writes all data from Map to a file data.properties
     * in progress
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void save() {
        try {
            FileWriter fileWriter = new FileWriter("providerMap.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Provider provider : providerMap.values()) {
                String line = provider.getProviderNumber() + "," + provider.getName() + "," + provider.getAddress() + "," +
                        provider.getCity() + "," + provider.getState() + "," + provider.getZip();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            System.out.println("Provider map saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes all data from file to Map
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void loadProviderMap() {
    	try {
            FileReader fileReader = new FileReader("providerMap.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                int providerNumber = Integer.parseInt(values[0]);
                String name = values[1];
                String address = values[2];
                String city = values[3];
                String state = values[4];
                int zip = Integer.parseInt(values[5]);
                Provider provider = new Provider(name, providerNumber, address, city, state, zip);
                providerMap.put(providerNumber, provider);
            }
            bufferedReader.close();
            System.out.println("Provider map loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No provider map found. Starting with empty map.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}