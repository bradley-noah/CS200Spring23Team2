package spring23team2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ZacharySimpsonJunitTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetCity() {
		//success
		MemberFiles.loadMemberMap();
		Member successMember = ProviderMenu.getMember(100000005);
		assertEquals("Winter Garden", successMember.getCity());
		
		//failure
		Member failMember = ProviderMenu.getMember(100000005);
		assertNotEquals("New York", failMember.getState());
		}
	
	@Test
	public void testGetName() {
		//success
		MemberFiles.loadMemberMap();
		Member successMember = ProviderMenu.getMember(100000001);
		assertEquals("Charlee Fitzgerald", successMember.getName());
		
		//failure
		Member failMember = ProviderMenu.getMember(100000001);
		assertNotEquals("Damaris Acevedo", failMember.getName());
		}
	
	@Test
	public void testGetServiceData() {
		//success
		ProviderDirectory.loadProviderDirectoryMap();
		String[] serviceDataSuccess = ProviderMenu.getService(100003);
		assertEquals("Dietitian Session", serviceDataSuccess[0]);
		assertEquals("350", serviceDataSuccess[1]);
		
		//failure
		String[] serviceDataFail = ProviderMenu.getService(100003);
		assertNotEquals("Consultation", serviceDataFail[0]);
		assertNotEquals("100", serviceDataFail[1]);
	}
	

}
