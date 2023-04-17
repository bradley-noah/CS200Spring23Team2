package spring23team2;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Record class, superclass of ProviderRecord and MemberRecord
 * Contains data of a User that constitutes a record
 * 
 * @author Noah Bradley
 *
 */
public class Record {
	String name;
	int number;
	String address;
	String city;
	String state;
	int zip;
	
	/**
	 * Persistently stores the data of the Record in a text file
	 * Needs tweaking
	 * @throws IOException
	 */
	public void setPers() {
		FileOutputStream fOut = null;
		String recordInfo = name + "," + number + "," + address + "," + city + "," + state + "," + zip;
		try {
			File file = new File("spring23team2/src/spring23team2/" + name + "Record.txt");
			fOut = new FileOutputStream(file);
			//Check if file exists, if not create one
			if(!file.exists()) {
				file.createNewFile();
			}
			//converts data to bytes to write into file
			byte[] bytesArr = recordInfo.getBytes();
			fOut.write(bytesArr);
			fOut.flush();
			
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
		try {
			if(fOut != null) fOut.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getName function gets the name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * setName functions assigns the param value to name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getNumber function gets the number
	 * @return number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * setNumber function assigns the param value to number
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * getAddress function gets the address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * setAddress function assigns the param value to address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * getCity function gets the city
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * setCity functions assigns the param value to city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * getState function gets the state
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * setState function assigns the param value to state
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * getZip function gets the zip
	 * @return zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * setZip functions assigns the param value to zip
	 * @param zip
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	
}
