package spring23team2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class GwynevereDeterdingJunitTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearchDirectory() {
		//test for success
		ProviderDirectory.loadProviderDirectoryMap();
		String x[] = ProviderDirectory.searchDirectory(456789);
		assertEquals(x[0], "Treatment Session");
		assertEquals(x[1], Integer.toString(400));
		
		//test for failure
		String y[] = ProviderDirectory.searchDirectory(-1);
		assertNull(y);
	}
	
	@Test
	public void testManagerMenuGetProvider() {
		//test for success
		ProviderFiles.loadProviderMap();
		Provider x = ManagerMenu.getProvider(100000000);
		assertEquals(x.name, "Cathair Maleficent");
		
		//test for failure
		Provider y = ManagerMenu.getProvider(-1);
		assertNull(y);
	}
	
	@Test
	public void testSearchOperator() {
		//test for success
		OperatorFiles.loadOperatorMap();
		Operator x = OperatorFiles.searchOperator(100000000);
		assertEquals(x.OperatorNumber, 100000000);
		
		//test for failure
		Operator y = OperatorFiles.searchOperator(-1);
		assertNull(y);
	}

}
