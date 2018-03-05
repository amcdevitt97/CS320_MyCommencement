package edu.ycp.cs320.amcdevitt.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.amcdevitt.model.GuessingGame;

public class GuessingGameTest {
	private GuessingGame model;
	
	@Before
	public void setUp() {
		model = new GuessingGame();
	}
	
	
	//these two also test "gets" so i won't
	//test for get methods
	@Test
	public void testSetMin() {
		model.setMin(1);
		assertEquals(1, model.getMin());
	}
	@Test
	public void testSetMax() {
		model.setMax(100);
		assertEquals(100, model.getMax());
	}
	@Test
	public void testIsDoneTrue() {
		model.setMin(50);
		model.setMax(50);
		assertTrue(model.isDone());
	}
	@Test
	public void testIsDoneFalse() {
		model.setMin(25);
		model.setMax(75);
		assertFalse(model.isDone());
	}
	@Test
	public void testGetGuess(){
		model.setMax(84);
		model.setMin(25);
		int total = 25 + (84-25)/2;
		assertEquals(total, model.getGuess());
	}
	@Test
	public void testIsLessThan(){
		model.setIsLessThan(43);
		assertEquals(42, model.getMax());
	}
	@Test
	public void testIsGreaterThan(){
		model.setIsGreaterThan(18);
		assertEquals(19, model.getMin());
	}
}
