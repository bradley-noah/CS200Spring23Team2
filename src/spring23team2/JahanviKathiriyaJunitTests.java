package spring23team2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JahanviKathiriyaJunitTests {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testGetAddress() {
		//testing for success
		MemberFiles.loadMemberMap();
		Member z = MemberFiles.searchMember(100000001);
		assertEquals(z.getAddress(), "395 W. Littleton Ave.");
		
		//testing for failure
		assertNotEquals(null,"395 W. Littleton Ave.");
	}
	
	@Test
	public void testGetName () {
		//testing for success
		MemberFiles.loadMemberMap();
		Member x = MemberFiles.searchMember(100000001);
		assertEquals(x.getName(), "Charlee Fitzgerald");
		
		//testing for failure
		assertNotEquals(null,"Charlee Fitzgerald");
	}
	
	@Test
	public void testSearchMember() {
		// Testing successful Member lookup
		MemberFiles.loadMemberMap();
		Member Member = MemberFiles.searchMember(100000000);
		assertEquals("Gary Cruz",Member.getName());
		
		// Testing failed Member lookup
		Member nMember = MemberFiles.searchMember(1);
		assertNull(nMember);
		
	}
}
