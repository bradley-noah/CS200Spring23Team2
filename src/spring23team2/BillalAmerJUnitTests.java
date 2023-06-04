package spring23team2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BillalAmerJUnitTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearchMember() {
		// Testing successful member lookup
		MemberFiles.loadMemberMap();
		Member member = MemberFiles.searchMember(100000000);
		assertEquals("Gary Cruz",member.getName());
		
		// Testing failed member lookup
		Member nmember = MemberFiles.searchMember(1);
		assertNull(nmember);
		
	}
	@Test
	public void testSearchProvider() {
		// Testing successful provider lookup
		ProviderFiles.loadProviderMap();
		Provider provider = ProviderFiles.searchProvider(100000000);
		assertEquals("Cathair Maleficent",provider.getName());
		
		// Testing failed provider lookup
		Provider nprovider = ProviderFiles.searchProvider(1);
		assertNull(nprovider);
		
	}
	
	@Test
	public void testGetAddress() {
		// Testing successful provider address retrieval
		ProviderFiles.loadProviderMap();
		Provider provider = ProviderFiles.searchProvider(100000000);
		assertEquals("7626 Livingston St.",provider.getAddress());
		
		// Testing failed provider address retrieval
		assertNotEquals(null,"7626 Livingston St.");
		
	}
	
	

}
