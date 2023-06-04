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
        try {
            FileWriter fileWriter = new FileWriter("MemberMap.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Member Member : MemberMap.values()) {
                String line = Member.getMemberNumber() + "," + Member.getName() + "," + Member.getAddress() + "," +
                        Member.getCity() + "," + Member.getState() + "," + Member.getZip();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
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
    	try {
            FileReader fileReader = new FileReader("MemberMap.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                int MemberNumber = Integer.parseInt(values[0]);
                String name = values[1];
                String address = values[2];
                String city = values[3];
                String state = values[4];
                int zip = Integer.parseInt(values[5]);
                Member Member = new Member(name, MemberNumber, address, city, state, zip);
                MemberMap.put(MemberNumber, Member);
            }
            bufferedReader.close();
            System.out.println("Member map loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No Member map found. Starting with empty map.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}