package spring23team2;

/**
 * The Manager Class, subclass of User, holds Manager information and contains
 * public getters to access this data safely
 * 
 * @author Noah Bradley
 *
 */
public class Manager {
	String name;
	int managerNumber;
	String address;
	String city;
	String state;
	int zip;
	
	/**
	 * Constructor for Manager
	 * 
	 * @param name
	 * @param managerNumber
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Manager(String name, int managerNumber, String address, String city, String state, int zip) {
		this.name = name;
		this.managerNumber = managerNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	/**
	 * getName method gets the name of the Manager
	 * @return name of Manager
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * getManagerNumber method gets the number of the Manager
	 * @return number of Manager
	 */
	public int getManagerNumber() {
		return managerNumber;
	}

	/**
	 * getAddress method gets the address of the Manager
	 * @return address of Manager
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * getCity method gets the city of the Manager
	 * @return city of Manager
	 */
	public String getCity() {
		return city;
	}

	/**
	 * getState method gets the state of the Manager
	 * @return state of Manager
	 */
	public String getState() {
		return state;
	}

	/**
	 * getZip method gets the zip of the Manager
	 * @return zip of Manager
	 */
	public int getZip() {
		return zip;
	}

	
}
