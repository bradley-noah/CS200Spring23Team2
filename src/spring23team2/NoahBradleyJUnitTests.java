package spring23team2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NoahBradleyJUnitTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetState() {
		//testing for success
		OperatorFiles.loadOperatorMap();
		Operator operator = OperatorFiles.searchOperator(100000004);
		assertEquals("Tennessee", operator.getState());
		
		//testing for failure
		Operator wrongOperator = OperatorFiles.searchOperator(100000001);
		assertNotEquals("Tennessee", wrongOperator.getState());
		}
	
	@Test
	public void testGetZip() {
		//testing for success
		OperatorFiles.loadOperatorMap();
		Operator operator = OperatorFiles.searchOperator(100000005);
		assertEquals(34787, operator.getZip());
		
		//testing for failure
		Operator wrongOperator = OperatorFiles.searchOperator(100000001);
		assertNotEquals(34787, wrongOperator.getZip());
		}
	
	@Test
	public void testGetOperatorNumber() {
		//testing for success
		OperatorFiles.loadOperatorMap();
		Operator operator = OperatorFiles.searchOperator(100000003);
		assertEquals(100000003, operator.getOperatorNumber());
		
		//testing for failure
		Operator wrongOperator = OperatorFiles.searchOperator(100000005);
		assertNotEquals(100000003, wrongOperator.getOperatorNumber());
	}
	

}
