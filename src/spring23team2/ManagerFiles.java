package spring23team2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * This is a hash map that store Manager records
 * 
 * @author Jahanvi Kathiriya
 * @version 1.0
 */
public class ManagerFiles {
    public static HashMap<Integer, Manager> ManagerMap = new HashMap<> ();

    /**
     * Inserts a new Manager and their corresponding information into the map
     * @param name
     * @param ManagerNumber
     * @param address
     * @param city
     * @param city
     * @param state
     * @param zip
     */
    public static void insertManager(String name, int ManagerNumber, String address, String city, String state, int zip) {
        Manager newManager = new Manager(name, ManagerNumber, address, city, state, zip);
        ManagerMap.put(ManagerNumber, newManager);
    }

    /**
     * Searches a Manager's info with the given ManagerNumber from the map
     * @param ManagerNumber
     */
    public static Manager searchManager(int ManagerNumber) {
        if (ManagerMap.containsKey(ManagerNumber)) {
            return ManagerMap.get(ManagerNumber);
        }
        else {
            return null;
        }
    }

    /**
     * Removes a Manager and their info with the given ManagerNumber from the map
     * @param ManagerNumber
     */
    public static void removeManager(int ManagerNumber) {
        ManagerMap.remove(ManagerNumber);
    }

    /**
     * Writes all data from Map to a file data.properties
     * 
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void save() {
        Properties prop = new Properties();
        for (Manager Manager : ManagerMap.values()) {
            int ManagerNumber = Manager.getManagerNumber();
            String value = Manager.getName() + "," + Manager.getAddress() + "," +
            Manager.getCity() + "," + Manager.getState() + "," + Manager.getZip();
            prop.setProperty(Integer.toString(ManagerNumber), value);
    }
        try {
            FileOutputStream fileOut = new FileOutputStream("ManagerMap.properties");
            prop.store(fileOut, "Manager Map");
            fileOut.close();
            System.out.println("Manager map saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes all data from file to Map
     * 
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void loadManagerMap() {
        Properties prop = new Properties();
        try {
            FileInputStream fileIn = new FileInputStream("ManagerMap.properties");
            prop.load(fileIn);
            fileIn.close();
            for (String key : prop.stringPropertyNames()) {
                String[] values = prop.getProperty(key).split(",");
                String name = values[0];
                String address = values[1];
                String city = values[2];
                String state = values[3];
                int zip = Integer.parseInt(values[4]);
                int ManagerNumber = Integer.parseInt(key);
                Manager Manager = new Manager(name, ManagerNumber, address, city, state, zip);
                ManagerMap.put(ManagerNumber, Manager);
            }
            System.out.println("Manager map loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No Manager map found. Starting with empty map.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}