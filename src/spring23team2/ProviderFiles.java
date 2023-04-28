package spring23team2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

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
        Properties prop = new Properties();
        for (Provider provider : providerMap.values()) {
            int providerNumber = provider.getProviderNumber();
            String value = provider.getName() + "," + provider.getAddress() + "," +
            provider.getCity() + "," + provider.getState() + "," + provider.getZip();
            prop.setProperty(Integer.toString(providerNumber), value);
    }
        try {
            FileOutputStream fileOut = new FileOutputStream("src/maps/providerMap.properties");
            prop.store(fileOut, "Provider Map");
            fileOut.close();
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
        Properties prop = new Properties();
        try {
            FileInputStream fileIn = new FileInputStream("src/maps/providerMap.properties");
            prop.load(fileIn);
            fileIn.close();
            for (String key : prop.stringPropertyNames()) {
                String[] values = prop.getProperty(key).split(",");
                String name = values[0];
                String address = values[1];
                String city = values[2];
                String state = values[3];
                int zip = Integer.parseInt(values[4]);
                int providerNumber = Integer.parseInt(key);
                Provider provider = new Provider(name, providerNumber, address, city, state, zip);
                providerMap.put(providerNumber, provider);
            }
            System.out.println("Provider map loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No provider map found. Starting with empty map.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}