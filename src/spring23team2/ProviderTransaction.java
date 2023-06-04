
package spring23team2;

public class ProviderTransaction {
	int providerNumber;
	String serviceDate;
	String receivedDate;
	String receivedTime;
	int memberNumber;
	String memberName;
	int serviceCode;
	int fee;
	
	public ProviderTransaction(int providerNumber, String serviceDate, String receivedDate, String receivedTime, int memberNumber, String memberName, int serviceCode, int fee) {
		this.providerNumber = providerNumber;
		this.serviceDate = serviceDate;
		this.receivedDate = receivedDate;
		this.receivedTime = receivedTime;
		this.memberNumber = memberNumber;
		this.memberName = memberName;
		this.serviceCode = serviceCode;
		this.fee = fee;
	}
	
    /**
     * The getProviderNumber function gets the number of the provider 
     * @return providerNumber
     */	
	public int getProviderNumber() {
		return providerNumber;
	}
	
    /**
     * The getServiceCode function gets the service code for the transaction
     * @return serviceCode
     */	
	public int getServiceCode() {
		return serviceCode;
	}
	
    /**
     * The getFee function gets the fee for the transaction
     * @return fee
     */	
	public int getFee() {
		return fee;
	}
	
    /**
     * The getServiceDate function gets the date for the transaction
     * @return serviceDate
     */	
	public String getServiceDate() {
		return serviceDate;
	}
	
    /**
     * The getReceivedTime function gets the time of the transaction
     * @return receivedTime
     */	
	public String getReceivedTime() {
		return receivedTime;
	}

    /**
     * The getReceivedDate function gets the date received for the transaction
     * @return receivedDate
     */
	public String getReceivedDate() {
		return receivedDate;
	}
	
    /**
     * The getMemberNumber function gets the number of the member for the transaction
     * @return memberNumber
     */
	public int getMemberNumber() {
		return memberNumber;
	}
	
    /**
     * The getMemberName function gets the name of the member for the transaction
     * @return memberName
     */
	public String getMemberName() {
		return memberName;
	}
}

