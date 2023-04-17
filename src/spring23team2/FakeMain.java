package spring23team2;

/**
 * just to test stuff out
*/
public class FakeMain {
	public static void main(String[] args){
        OperatorFiles.loadOperatorMap();
        OperatorFiles.insertOperator("j", 1002, "1345 10th Ave 1", "Tuscaloosa", "Alabama", 35404);
        OperatorFiles.save();
        
        ManagerFiles.loadManagerMap();
        ManagerFiles.insertManager("j", 1002, "1345 10th Ave 1", "Tuscaloosa", "Alabama", 35404);
        ManagerFiles.save();
        
        ProviderFiles.loadProviderMap();
        ProviderFiles.insertProvider("j", 1002, "1345 10th Ave 1", "Tuscaloosa", "Alabama", 35404);
        ProviderFiles.save();
    }
}
