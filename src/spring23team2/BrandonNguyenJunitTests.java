package spring23team2;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;


public class BrandonNguyenJunitTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMainMenuVerifyOperator() {
		//test for success
		OperatorFiles.loadOperatorMap();
		Operator operator = MainMenu.verifyOperator(100000000);
		assertEquals(operator.name, "Nya Moore");
		
		//test for failure
		Operator fakeOperator = MainMenu.verifyOperator(1);
		assertNull(fakeOperator);
	}
	
	@Test
	public void testManagerVerifyManager() {
		//test for success
		ManagerFiles.loadManagerMap();
		Manager manager = MainMenu.verifyManager(100000000);
		assertEquals(manager.name, "Arlene Graham");
		
		//test for failure
		Operator fakeManager = MainMenu.verifyOperator(1);
		assertNull(fakeManager);
	}
	
	@Test
	public void testGetMemberName() {
		//testing for success
		MemberFiles.loadMemberMap();
		Member member = MemberFiles.searchMember(100000001);
		assertEquals(member.getName(), "Charlee Fitzgerald");
		
		//testing for failure
		assertNotEquals(member,"Gary Cruz");
	}
	

}

