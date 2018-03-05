package edu.ycp.cs320.amcdevitt.controller;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.amcdevitt.controller.NumbersController;
import edu.ycp.cs320.amcdevitt.model.Numbers;

public class NumbersControllerTest {
	private Numbers model;
	private NumbersController controller;
	
	@Before
	public void setUp() {
		model = new Numbers();
		controller = new NumbersController();
		model.setFirst(2.0);
		model.setSecond(3.0);
		model.setThird(4.0);
	}
	
	@Test
	public void addTest() {
		double first = model.getFirst();
		double second = model.getSecond();
		double third = model.getThird();
		assertEquals(controller.add(first, second, third),model.getSum(first,second,third));
	}
	
	@Test
	public void multiplyTest() {
		double first = model.getFirst();
		double second = model.getSecond();
		assertEquals(controller.multiply(first, second),model.getProduct(first,second));
	}
}
