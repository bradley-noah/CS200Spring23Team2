package spring23team2;

public class MemberTransaction {
	int memberNumber;
	String serviceDate;
	String providerName;
	String serviceName;
	
	public MemberTransaction(int memberNumber, String serviceDate, String providerName, String serviceName) {
		this.memberNumber = memberNumber;
		this.serviceDate = serviceDate;
		this.providerName = providerName;
		this.serviceName = serviceName;
	}
	
    /**
     * The getMemberNumber function gets the number of the member for the transaction
     * @return memberNumber
     */
	public int getMemberNumber() {
		return memberNumber;
	}
	
    /**
     * The getServiceDate function gets the date of the transaction
     * @return serviceDate
     */
	public String getServiceDate() {
		return serviceDate;
	}
	
    /**
     * The getProviderName function gets the name of the provider for the transaction
     * @return providerName
     */
	public String getProviderName() {
		return providerName;
	}
	
    /**
     * The getServiceName function gets the name of the service
     * @return serviceName
     */
	public String getServiceName() {
		return serviceName;
	}
}