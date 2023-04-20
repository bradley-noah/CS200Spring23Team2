package spring23team2;

public class FakeMain {
		public static void main(String[] args) {
			//ProviderTransactionFiles.loadProviderTransactionMap();
			MemberTransactionFiles.loadMemberTransactionMap();
			MemberFiles.loadMemberMap();
			
			MemberReport.createMemberReports();
			
			//ProviderTransactionFiles.save();
			MemberFiles.save();
			MemberTransactionFiles.save();
		}
}
