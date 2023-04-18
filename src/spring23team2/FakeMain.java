package spring23team2;

public class FakeMain {
		public static void main(String[] args) {
			ProviderTransactionFiles.loadProviderTransactionMap();
			MemberTransactionFiles.loadMemberTransactionMap();
			ProviderTransactionFiles.insertProviderTransaction(100000002, "April 20", "April 20", "3:00 P.M.", 100000007, "Kiana English", 4012, 50);
			MemberTransactionFiles.insertMemberTransaction(100000007, "April 20", "Irving Fletcher", "Chocolate Mind Expansion");
			ProviderTransactionFiles.save();
			MemberTransactionFiles.save();
		}
}
