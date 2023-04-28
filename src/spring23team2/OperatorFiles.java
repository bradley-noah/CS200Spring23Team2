package spring23team2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * This is a hash map that store Operator records
 * 
 * @author Jahanvi Kathiriya
 * @version 1.0
 */
public class OperatorFiles {
    public static HashMap<Integer, Operator> OperatorMap = new HashMap<> ();

    /**
     * Inserts a new Operator and their corresponding information into the map
     * @param name
     * @param OperatorNumber
     * @param address
     * @param city
     * @param city
     * @param state
     * @param zip
     */
    public static void insertOperator(String name, int OperatorNumber, String address, String city, String state, int zip) {
        Operator newOperator = new Operator(name, OperatorNumber, address, city, state, zip);
        OperatorMap.put(OperatorNumber, newOperator);
    }

    /**
     * Searches a Operator's info with the given OperatorNumber from the map
     * @param OperatorNumber
     * @return Operator's information
     */
    public static Operator searchOperator(int OperatorNumber) {
        if (OperatorMap.containsKey(OperatorNumber)) {
            return OperatorMap.get(OperatorNumber);
        }
        else {
            return null;
        }
    }

    /**
     * Removes a Operator and their info with the given OperatorNumber from the map
     * @param OperatorNumber
     */
    public static void removeOperator(int OperatorNumber) {
        OperatorMap.remove(OperatorNumber);
    }

    /**
     * Writes all data from Map to a file data.properties
     * 
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void save() {
        try {
            FileWriter fileWriter = new FileWriter("OperatorMap.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Operator Operator : OperatorMap.values()) {
                String line = Operator.getOperatorNumber() + "," + Operator.getName() + "," + Operator.getAddress() + "," +
                        Operator.getCity() + "," + Operator.getState() + "," + Operator.getZip();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            System.out.println("Operator map saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes all data from file to Map
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void loadOperatorMap() {
    	try {
            FileReader fileReader = new FileReader("OperatorMap.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                int OperatorNumber = Integer.parseInt(values[0]);
                String name = values[1];
                String address = values[2];
                String city = values[3];
                String state = values[4];
                int zip = Integer.parseInt(values[5]);
                Operator Operator = new Operator(name, OperatorNumber, address, city, state, zip);
                OperatorMap.put(OperatorNumber, Operator);
            }
            bufferedReader.close();
            System.out.println("Operator map loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No Operator map found. Starting with empty map.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}