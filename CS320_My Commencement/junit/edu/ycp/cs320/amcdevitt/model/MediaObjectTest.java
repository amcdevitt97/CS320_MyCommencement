package edu.ycp.cs320.amcdevitt.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MediaObjectTest {
	private MediaObject model;
	
	@Before
	public void setUp() {
		 model = new MediaObject();
	}
	
	@Test
	public void testSetUrl() {
		model.setUrl("testing123");
		assertEquals("testing123", model.getUrl());
	}

}
