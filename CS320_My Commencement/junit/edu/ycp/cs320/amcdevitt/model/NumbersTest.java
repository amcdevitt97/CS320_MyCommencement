package edu.ycp.cs320.amcdevitt.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumbersTest {
	private Numbers model;
	
	@Before
	public void setUp() {
		model = new Numbers();
		model.setFirst(2.0);
		model.setSecond(3.0);
		model.setThird(4.0);
	}
	
	@Test
	public void testGetVals() {
		assertTrue(model.getFirst()==2.0);
		assertTrue(model.getSecond()==3.0);
		assertTrue(model.getThird()==4.0);
	}
	
	@Test
	public void testGetProduct() {
		assertTrue(model.getProduct(2.0, 3.0)==6.0);
	}
	
	@Test
	public void testGetSum() {
		assertTrue(model.getSum(2.0, 3.0, 4.0)==9.0);
	}
}
