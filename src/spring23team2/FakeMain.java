package spring23team2;

public class FakeMain {
		public static void main(String[] args) {
			//ProviderTransactionFiles.loadProviderTransactionMap();
			MemberTransactionFiles.loadMemberTransactionMap();
			MemberFiles.loadMemberMap();
			
			MemberTransactionFiles.insertMemberTransaction(100000007, "April 20", "Irving Fletcher", "Chocolate Mind Expansion");
			MemberTransactionFiles.insertMemberTransaction(100000007, "April 21", "Irving Fletcher", "Chocolate Mind Expansion");
			MemberTransactionFiles.insertMemberTransaction(100000008, "April 21", "Irving Fletcher", "Chocolate Mind Expansion");
			MemberReport.createMemberReports();
			
			//ProviderTransactionFiles.save();
			MemberFiles.save();
			MemberTransactionFiles.save();
		}
}
