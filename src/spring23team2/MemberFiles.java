package spring23team2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * This is a hash map that store Member records
 * 
 * @author Jahanvi Kathiriya
 * @version 1.0
 */
public class MemberFiles {
    public static HashMap<Integer, Member> MemberMap = new HashMap<> ();

    /**
     * Inserts a new Member and their corresponding information into the map
     * @param name
     * @param MemberNumber
     * @param address
     * @param city
     * @param city
     * @param state
     * @param zip
     */
    public static void insertMember(String name, int MemberNumber, String address, String city, String state, int zip) {
        Member newMember = new Member(name, MemberNumber, address, city, state, zip);
        MemberMap.put(MemberNumber, newMember);
    }

    /**
     * Searches a Member's info with the given MemberNumber from the map
     * @param MemberNumber
     * @return Member's Information
     * 
     */
    public static Member searchMember(int MemberNumber) {
        if (MemberMap.containsKey(MemberNumber)) {
            return MemberMap.get(MemberNumber);
        }
        else {
            return null;
        }
    }

    /**
     * Removes a Member and their info with the given MemberNumber from the map
     * @param MemberNumber
     */
    public static void removeMember(int MemberNumber) {
        MemberMap.remove(MemberNumber);
    }

    /**
     * Writes all data from Map to a file data.properties
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void save() {
        Properties prop = new Properties();
        for (Member Member : MemberMap.values()) {
            int MemberNumber = Member.getMemberNumber();
            String value = Member.getName() + "," + Member.getAddress() + "," +
            Member.getCity() + "," + Member.getState() + "," + Member.getZip();
            prop.setProperty(Integer.toString(MemberNumber), value);
    }
        try {
            FileOutputStream fileOut = new FileOutputStream("src/maps/MemberMap.properties");
            prop.store(fileOut, "Member Map");
            fileOut.close();
            System.out.println("Member map saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes all data from file to Map
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void loadMemberMap() {
        Properties prop = new Properties();
        try {
            FileInputStream fileIn = new FileInputStream("src/maps/MemberMap.properties");
            prop.load(fileIn);
            fileIn.close();
            for (String key : prop.stringPropertyNames()) {
                String[] values = prop.getProperty(key).split(",");
                String name = values[0];
                String address = values[1];
                String city = values[2];
                String state = values[3];
                int zip = Integer.parseInt(values[4]);
                int MemberNumber = Integer.parseInt(key);
                Member Member = new Member(name, MemberNumber, address, city, state, zip);
                MemberMap.put(MemberNumber, Member);
            }
            System.out.println("Member map loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No Member map found. Starting with empty map.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}