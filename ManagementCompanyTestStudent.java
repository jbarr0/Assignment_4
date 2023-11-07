import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {
	Property samProp1,samProp2;
	ManagementCompany managementCo;
	@BeforeEach
	void setUp() throws Exception {
		managementCo = new ManagementCompany("Jason","123123",20);
	}

	@AfterEach
	void tearDown() throws Exception {
		managementCo=null;
	}

	@Test
	public void testAddProperty()
	{
		samProp1 = new Property ("Starbucks","Rockville",1256.00,"Jason Barrios",1,1,6,7);
		assertEquals(0,managementCo.addProperty(samProp1));
		//samProp2 = new Property ("Walmart","Germantown",10000.00,"Citi Bank",0,0,3,3);
		
	
	}
	@Test
	public void testIsPropertyFull()
	{
		samProp1 = new Property ("Starbucks","Rockville",1256.00,"Jason Barrios",1,1,6,7);
		managementCo.addProperty(samProp1);
		assertFalse(managementCo.isPropertiesFull());
	}
	@Test
	public void testGetMgmFeePer()
	{
		assertEquals(20,managementCo.getMgmFeePer());
	}
	@Test
	public void testGetName()
	{
		assertEquals("Jason",managementCo.getName());
	}
	@Test
	public void testGetPlot()
	{

		assertEquals(0,managementCo.getPlot().getX());
		assertEquals(0,managementCo.getPlot().getY());
		assertEquals(10,managementCo.getPlot().getWidth());
		assertEquals(10,managementCo.getPlot().getDepth());

	}
	@Test
	public void testGetProperties()
	{
		
	}
	@Test
	public void testGetPropertiesCount()
	{
		assertEquals(0,managementCo.getPropertiesCount());
	}
	@Test 
	public void testGetTaxID() {
		assertEquals("123123",managementCo.getTaxID());
	}
	@Test
	public void testGetTotalRent()
	{
		samProp1 = new Property ("Starbucks","Rockville",1256.00,"Jason Barrios",1,1,6,7);
		samProp2 = new Property ("Walmart","Germantown",10000.00,"Citi Bank",0,0,3,3);
		managementCo.addProperty(samProp1);
		managementCo.addProperty(samProp2);
		assertEquals(11256.00,managementCo.getTotalRent());
	}
	
	@Test
	public void testIsManagememtFeevalid()
	{
		assertTrue(managementCo.isManagementFeeValid());
	}
	
}
