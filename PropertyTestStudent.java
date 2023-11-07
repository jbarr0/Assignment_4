import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	Property propertyOne,prop2;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property ("McDonalds","Gaithersburg",1500.00,"Jason Barrios");
		prop2 = new Property("School","Silver Spring",10000.24,"MOCO",1,1,5,5);
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	public void testGetPropertyName() {
		assertEquals("McDonalds",propertyOne.getPropertyName());
	}
	@Test
	public void testGetCity()
	{
		assertEquals("Gaithersburg",propertyOne.getCity());
	}
	@Test
	public void testGetRentAmount()
	{
		assertEquals(1500.00,propertyOne.getRentAmount());
	}
	@Test
	public void testGetPlot()
	{
		assertEquals(1,prop2.getPlot().getX());
		assertEquals(5,prop2.getPlot().getWidth());

	}
	@Test
	public void testGetOwmer()
	{
		assertEquals("Jason Barrios",propertyOne.getOwner());
	}
	@Test
	public void testToString()
	{
		assertEquals("McDonalds,Gaithersburg,Jason Barrios,1500.0",propertyOne.toString());
	}
}
