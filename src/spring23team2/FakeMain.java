package spring23team2;

public class FakeMain {
		public static void main(String[] args) {
			ProviderTransactionFiles.loadProviderTransactionMap();
			MemberTransactionFiles.loadMemberTransactionMap();
			MemberFiles.loadMemberMap();
			ProviderFiles.loadProviderMap();
			
			ProviderTransactionFiles.insertProviderTransaction(100000001, "April 20", "April 20", "5:00", 100000007, MemberFiles.searchMember(100000007).getName(), 1001, 50);
			ProviderTransactionFiles.insertProviderTransaction(100000001, "April 20", "April 20", "5:00", 100000007, MemberFiles.searchMember(100000007).getName(), 1001, 50);
			ProviderTransactionFiles.insertProviderTransaction(100000002, "April 20", "April 20", "5:00", 100000008, MemberFiles.searchMember(100000008).getName(), 1001, 50);
			
			ProviderReport.createProviderReports();
			
			ProviderFiles.save();
			ProviderTransactionFiles.save();
			MemberFiles.save();
			MemberTransactionFiles.save();
		}
}
