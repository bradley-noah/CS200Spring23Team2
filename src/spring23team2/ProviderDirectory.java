package spring23team2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * This is a hash map that store Provider records
 * 
 * @author Jahanvi Kathiriya
 * @version 1.0
 */
public class ProviderDirectory {
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
    public static void save(HashMap<Integer, Provider> providerMap) throws FileNotFoundException, IOException{
        Properties properties = new Properties();

        for (HashMap.Entry<Integer, Provider> entry : providerMap.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }

        properties.store(new FileOutputStream("data.properties"), null);
    }
    
}