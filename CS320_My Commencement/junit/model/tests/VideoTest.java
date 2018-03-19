package model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Video;

public class VideoTest {
	private Video model;
	
	@Before
	public void setUp() {
		 model = new Video();
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
		boolean bool = model.isUploadable(0, 0, 0, 0, 0);
		assertEquals(true, bool);
		bool = model.isUploadable(101, 0, 0, 0, 0);
		assertEquals(false, bool);
		bool = model.isUploadable(0, 101, 0, 0, 0);
		assertEquals(false, bool);
		bool = model.isUploadable(0, 0, 2, 0, 0);
		assertEquals(false, bool);
		bool = model.isUploadable(0, 0, 0, 11, 0);
		assertEquals(false, bool);
		bool = model.isUploadable(0, 0, 0, 0, 31);
		assertEquals(false, bool);
	}
	
}