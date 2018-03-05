package edu.ycp.cs320.amcdevitt.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.amcdevitt.controller.GuessingGameController;
import edu.ycp.cs320.amcdevitt.model.GuessingGame;

public class GuessingGameControllerTest {
	private GuessingGame model;
	private GuessingGameController controller;
	
	@Before
	public void setUp() {
		model = new GuessingGame();
		controller = new GuessingGameController();
		
		model.setMin(1);
		model.setMax(100);
		
		controller.setModel(model);
	}
	
	@Test
	public void testStartGame(){
		controller.startGame();
		assertEquals(1, model.getMin());
		assertEquals(100, model.getMax());
	}
	
	@Test
	public void testSetNumberFound(){
		controller.setNumberFound();
		assertEquals(model.getMin(),model.getMax());
	}
	
	@Test
	public void testNumberIsLess(){
		int currentGuess = model.getGuess();
		controller.setNumberIsLessThanGuess();
		assertTrue(model.getGuess() < currentGuess);
	}
	
	@Test
	public void testNumberIsGreater() {
		int currentGuess = model.getGuess();
		controller.setNumberIsGreaterThanGuess();
		assertTrue(model.getGuess() > currentGuess);
	}
}
