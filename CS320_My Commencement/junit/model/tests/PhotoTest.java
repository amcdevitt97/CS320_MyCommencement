package model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Photo;

public class PhotoTest {
	private Photo model;
	
	@Before
	public void setUp() {
		 model = new Photo();
	}
	
	@Test
	public void testSetUrl() {
		model.setUrl("testing123");
		assertEquals("testing123", model.getUrl());
	}
	
	@Test
	public void testSetLength() {
		model.setLength(1);
		assertEquals(1, model.getLength());
	}
	
	@Test
	public void testSetWidth() {
		model.setWidth(1);
		assertEquals(1, model.getWidth());
	}
	
	@Test
	public void testisUploadable() {
		boolean bool = model.isUploadable(10, 10);
		assertEquals(true, bool);
		bool = model.isUploadable(101, 10);
		assertEquals(false, bool);
		bool = model.isUploadable(10, 101);
		assertEquals(false, bool);
	}

}