package spring23team2;

/**
 * just to test stuff out
*/
public class FakeMain {
	public static void main(String[] args){
        MemberFiles.loadMemberMap();
        MemberFiles.insertMember("j", 1002, "1345 10th Ave 1", "Tuscaloosa", "Alabama", 35404);
        System.out.println(MemberFiles.searchMember(1001).getName());
        MemberFiles.save();
    }
}
