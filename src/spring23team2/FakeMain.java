package spring23team2;

public class FakeMain {
		public static void main(String[] args) {
			ProviderTransactionFiles.loadProviderTransactionMap();
			MemberTransactionFiles.loadMemberTransactionMap();
			MemberFiles.loadMemberMap();
			ProviderFiles.loadProviderMap();
			
			MemberTransactionFiles.insertMemberTransaction(100000007, "April 20", "Irving Fletcher", "Chocolate Mind Expansion");
			MemberTransactionFiles.insertMemberTransaction(100000008, "April 21", "Irving Fletcher", "Chocolate Mind Expansion");
			MemberTransactionFiles.insertMemberTransaction(100000007, "April 20", "Heidi Mendoza", "Chocolate Mind Expansion");
			ProviderTransactionFiles.insertProviderTransaction(100000002, "April 20", "April 20", "6:00", 100000007, "Kiana English", 1001, 50);
			ProviderTransactionFiles.insertProviderTransaction(100000002, "April 21", "April 21", "5:00", 100000008, "Damaris Acevedo", 1001, 50);
			ProviderTransactionFiles.insertProviderTransaction(100000004, "April 20", "April 21", "4:00", 100000007, "Kiana English", 1001, 50);
			SummaryReport.createSummaryReports();
			
			ProviderFiles.save();
			ProviderTransactionFiles.save();
			MemberFiles.save();
			MemberTransactionFiles.save();
		}
}
