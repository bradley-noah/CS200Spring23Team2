package spring23team2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map;

/**
* @author Gwynevere Deterding
* @version 1.0
*
* This is a hash map that stores the Provider Directory
*
*/

public class ProviderDirectory {
	   public static HashMap<Integer, String[]> ProviderDirectoryMap = new HashMap<> ();
	   
	   
	   /**
	     * Searches the Provider Directory for a service code and returns an array
	     * with service name at index 0 and price at index 1
	     */
	   public static String[] searchDirectory(int serviceCode) {
	        if (ProviderDirectoryMap.containsKey(serviceCode)) {
	            return ProviderDirectoryMap.get(serviceCode);
	        }
	        else {
	            return null;
	        }
	    }

	   /**
	     * Writes all data from Map to a file data.properties
	     * @throws IOException
	     * @throws FileNotFoundException
	     */
	    public static void save() {
	        Properties prop = new Properties();
	        for (Map.Entry<Integer,String[]> entry : ProviderDirectoryMap.entrySet()) {
	            int serviceCode = entry.getKey();
	            String[] values = entry.getValue();
	            String data = values[0] + "," + values[1];
	            prop.setProperty(Integer.toString(serviceCode), data);
	    }
	        try {
	            FileOutputStream fileOut = new FileOutputStream("maps/ProviderDirectory.properties");
	            prop.store(fileOut, "Provider Directory Map");
	            fileOut.close();
	            System.out.println("Provider Directory saved successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * Writes all data from file to Map
	     * @throws IOException
	     * @throws FileNotFoundException
	     */
	    public static void loadProviderDirectoryMap() {
	        Properties prop = new Properties();
	        try {
	            FileInputStream fileIn = new FileInputStream("maps/ProviderDirectory.properties");
	            prop.load(fileIn);
	            fileIn.close();
	            for (String key : prop.stringPropertyNames()) {
	                String[] values = prop.getProperty(key).split(",");
	                int serviceCode = Integer.parseInt(key);
	                ProviderDirectoryMap.put(serviceCode, values);
	            }
	            System.out.println("Provider Directory map loaded successfully.");
	        } catch (FileNotFoundException e) {
	            System.out.println("No Provider Directory map found. Starting with empty map.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
