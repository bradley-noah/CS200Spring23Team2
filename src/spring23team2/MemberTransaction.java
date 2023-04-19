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
	
	public int getMemberNumber() {
		return memberNumber;
	}
	
	public String getServiceDate() {
		return serviceDate;
	}
	
	
	public String getProviderName() {
		return providerName;
	}
	
	public String getServiceName() {
		return serviceName;
	}
}