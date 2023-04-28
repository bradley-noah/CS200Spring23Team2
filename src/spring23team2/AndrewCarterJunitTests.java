package spring23team2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class AndrewCarterJunitTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetZip() {
		//testing for success
		ProviderFiles.loadProviderMap();
		Provider y = ProviderFiles.searchProvider(100000001);
		assertEquals(y.getZip(), 11364);
		
		//testing for failure
		Provider y1 = ProviderFiles.searchProvider(-1);
		assertNull(y1);
	}
	
	@Test
	public void testGetState() {
		//testing for success
		ProviderFiles.loadProviderMap();
		Provider z = ProviderFiles.searchProvider(100000001);
		assertEquals(z.getState(), "New York");
		
		//testing for failure
		assertNotEquals(null,"New York");
	}
	
	@Test
	public void testGetCity () {
		//testing for success
		ProviderFiles.loadProviderMap();
		Provider x = ProviderFiles.searchProvider(100000001);
		assertEquals(x.getCity(), "Oakland Gardens");
		
		//testing for failure
		assertNotEquals(null,"Oakland Gardens");
	}

}
