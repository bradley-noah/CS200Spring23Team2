package spring23team2;

public class FakeMain {
		public static void main(String[] args) {
			ProviderTransactionFiles.loadProviderTransactionMap();
			MemberTransactionFiles.loadMemberTransactionMap();
			MemberFiles.loadMemberMap();
			ProviderFiles.loadProviderMap();
			
			SummaryReport.createSummaryReports();
			
			ProviderFiles.save();
			ProviderTransactionFiles.save();
			MemberFiles.save();
			MemberTransactionFiles.save();
		}
}
