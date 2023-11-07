import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	private Plot plot1,plot5,plot2,plot3,plot4;

	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot5 = new Plot(3, 4, 4, 3);
		plot2 = new Plot(0,0,10,10);
		plot3 = new Plot (1,1,2,5);
		plot4 = new Plot (5,3,2,6);
	}

	@AfterEach
	void tearDown() throws Exception {
		plot1 = plot5 = plot2 = null;
	}

	@Test
	public void testToString()
	{
		assertEquals("0,0,10,10",plot2.toString());
	}
	@Test
	public void testOverlaps()
	{
		assertTrue(plot5.overlaps(plot1));
		assertTrue(plot2.overlaps(plot1));
	    assertTrue(plot2.overlaps(plot5));
		assertTrue(plot1.overlaps(plot3));// overlaps corners
		assertTrue(plot1.overlaps(plot4));// overlaps corners
		assertFalse(plot4.overlaps(plot3));// don't overlap

	}
	@Test
	public void testEncompasses()
	{
		assertTrue(plot2.encompasses(plot1));// plot in max plot
		assertFalse(plot2.encompasses(new Plot(10,10,10,10)));// outside main plot
		assertTrue(plot1.encompasses(plot5));
	}
	@Test
	public void testGetX()
	{
		assertEquals(1,plot3.getX());
	}
	@Test
	public void testGetY()
	{
		assertEquals(1,plot3.getY());
	}
	@Test
	public void testGetWidth()
	{
		assertEquals(2,plot3.getWidth());
	}
	@Test
	public void testGetDepth()
	{
		assertEquals(5,plot3.getDepth());
	}

}
