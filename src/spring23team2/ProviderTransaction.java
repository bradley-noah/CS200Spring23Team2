<<<<<<< HEAD
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
	
	public int getProviderNumber() {
		return providerNumber;
	}
	
	
	public int getServiceCode() {
		return serviceCode;
	}
	
	
	public int getFee() {
		return fee;
	}
	
	
	public String getServiceDate() {
		return serviceDate;
	}
	
	
	public String getReceivedTime() {
		return receivedTime;
	}
	
	public String getReceivedDate() {
		return receivedDate;
	}
	
	public int getMemberNumber() {
		return memberNumber;
	}
	
	public String getMemberName() {
		return memberName;
	}
}
=======
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
	
	public int getProviderNumber() {
		return providerNumber;
	}
	
	
	public int getServiceCode() {
		return serviceCode;
	}
	
	
	public int getFee() {
		return fee;
	}
	
	
	public String getServiceDate() {
		return serviceDate;
	}
	
	
	public String getReceivedTime() {
		return receivedTime;
	}
	
	public String getReceivedDate() {
		return receivedDate;
	}
	
	public int getMemberNumber() {
		return memberNumber;
	}
	
	public String getMemberName() {
		return memberName;
	}
}
>>>>>>> refs/remotes/origin/master
