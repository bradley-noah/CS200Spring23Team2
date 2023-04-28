package spring23team2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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
	    	try {
	            FileWriter fileWriter = new FileWriter("providerDirectory.txt");
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            for (Map.Entry<Integer,String[]> entry : ProviderDirectoryMap.entrySet()) {
	            	String[] values = entry.getValue();
	            	String line = entry.getKey() + ","+ values[0] + "," + values[1];
	                bufferedWriter.write(line);
	                bufferedWriter.newLine();
	            }
	            bufferedWriter.close();
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
	    	try {
	            FileReader fileReader = new FileReader("providerMap.txt");
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                String[] values = line.split(",");
	                int Number = Integer.parseInt(values[0]);
	                String[] value = new String[2];
	                value[0] = values[1];
	                value[1] = values[2];
	                ProviderDirectoryMap.put(Number, value);
	            }
	            bufferedReader.close();
	            System.out.println("Provider Directory map loaded successfully.");
	        } catch (FileNotFoundException e) {
	            System.out.println("No Provider Directory map found. Starting with empty map.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
