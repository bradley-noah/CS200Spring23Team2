package spring23team2;

/**
 * just to test stuff out
*/
public class FakeMain {
	public static void main(String[] args){
        addProviderTransaction.loadProviderTransactionMap();
        addProviderTransaction.insertProviderTransaction(000000002, "May 5", "May 5", "3:00", 000000001, "Charlee Fitzgerald", 213424, 10);
        addProviderTransaction.save();
	}
}
