package spring23team2;

/**
 * Service class that represents a ChocAn Service
 * Comprised of the service's name, code, and fee
 * 
 * @author Noah Bradley
 *
 */
public class Service {
	String name;
	int code;
	int fee;
	
	public Service(String name, int code, int fee) {
		this.name = name;
		this.code = code;
		this.fee = fee;
	}

	/**
	 * The getName function gets the name of the service
	 * @return name of the service
	 */
	public String getName() {
		return name;
	}
	/**
	 * The getCode function gets the code of the service
	 * @return code of the service
	 */
	public int getCode() {
		return code;
	}
	/**
	 * The getFee function gets the fee of the service
	 * @return fee of the service
	 */
	public int getFee() {
		return fee;
	}

	
	
}
