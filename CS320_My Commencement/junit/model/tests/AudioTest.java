package model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Audio;

public class AudioTest {
	private Audio model;
	
	@Before
	public void setUp() {
		 model = new Audio();
	}
	
	@Test
	public void testSetUrl() {
		model.setUrl("testing123");
		assertEquals("testing123", model.getUrl());
	}
	
	@Test
	public void testSetHours() {
		model.setHours(1);
		assertEquals(1, model.getHours());
	}
	
	@Test
	public void testSetMinutes() {
		model.setMinutes(1);
		assertEquals(1, model.getMinutes());
	}
	
	@Test
	public void testSetSeconds() {
		model.setSeconds(1);
		assertEquals(1, model.getSeconds());
	}
	
	@Test
	public void testisUploadable() {
		boolean bool = model.isUploadable(0, 0, 0);
		assertEquals(true, bool);
		bool = model.isUploadable(2, 0, 0);
		assertEquals(false, bool);
		bool = model.isUploadable(0, 11, 0);
		assertEquals(false, bool);
		bool = model.isUploadable(0, 0, 31);
		assertEquals(false, bool);
	}

}